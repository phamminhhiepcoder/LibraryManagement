package org.example.dao;


import org.example.entities.Book;
import org.example.entities.Invoice;

import java.util.Collection;
import java.util.List;

public interface InvoiceDao extends BaseDao<Invoice, Integer>{
    public Collection<Book> getBooksByInvoiceId(Integer invoiceId);
}
