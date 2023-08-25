package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.entities.Users;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserDaoImpl extends BaseDaoImpl<Users, Integer> implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl() {
        super(Users.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Users u WHERE u.username = :username AND u.password = :password";
            Query<Users> query = session.createQuery(hql, Users.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            Users users = query.uniqueResult();

            return users != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
