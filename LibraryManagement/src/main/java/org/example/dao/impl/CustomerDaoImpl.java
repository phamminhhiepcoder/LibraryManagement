package org.example.dao.impl;

import org.example.dao.CustomerDao;
import org.example.dao.UserDao;
import org.example.entities.Customer;
import org.example.entities.Users;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CustomerDaoImpl extends BaseDaoImpl<Customer, Integer> implements CustomerDao {
    private final SessionFactory sessionFactory;

    public CustomerDaoImpl() {
        super(Customer.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

}
