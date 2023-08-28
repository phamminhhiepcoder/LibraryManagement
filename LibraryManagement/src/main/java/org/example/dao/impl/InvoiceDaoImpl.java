package org.example.dao.impl;

import org.example.dao.BookDao;
import org.example.dao.InvoiceDao;
import org.example.entities.Book;
import org.example.entities.Invoice;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InvoiceDaoImpl extends BaseDaoImpl<Invoice, Integer> implements InvoiceDao {
    private final SessionFactory sessionFactory;

    public InvoiceDaoImpl() {
        super(Invoice.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Collection<Book> getBooksByInvoiceId(Integer invoiceId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT b FROM Invoice i JOIN i.books b WHERE i.id = :invoiceId";
            Query<Book> query = session.createQuery(hql, Book.class);
            query.setParameter("invoiceId", invoiceId);
            List<Book> books = query.getResultList();

            // Access the invoices collection within the same session
            for (Book book : books) {
                book.getInvoices().size(); // This initializes the collection
            }

            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


}
