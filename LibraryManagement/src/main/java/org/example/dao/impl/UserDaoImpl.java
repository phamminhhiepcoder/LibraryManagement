package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.entities.User;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl() {
        super(User.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            User user = query.uniqueResult();

            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
