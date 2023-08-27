package org.example.dao.impl;

import org.example.dao.BookDao;
import org.example.dao.InvoiceDao;
import org.example.entities.Book;
import org.example.entities.Invoice;
import org.example.utils.HibernateUtils;
import org.hibernate.SessionFactory;

public class InvoiceDaoImpl extends BaseDaoImpl<Invoice, Integer> implements InvoiceDao {
    private final SessionFactory sessionFactory;

    public InvoiceDaoImpl() {
        super(Invoice.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }


}
