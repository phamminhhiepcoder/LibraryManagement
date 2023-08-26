package org.example.dao.impl;

import org.example.dao.BookDao;
import org.example.dao.UserDao;
import org.example.entities.Book;
import org.example.entities.Users;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class BookDaoImpl extends BaseDaoImpl<Book, Integer> implements BookDao {
    private final SessionFactory sessionFactory;

    public BookDaoImpl() {
        super(Book.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }


}
