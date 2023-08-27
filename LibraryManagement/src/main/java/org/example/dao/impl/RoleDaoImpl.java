package org.example.dao.impl;

import org.example.dao.BookDao;
import org.example.dao.RoleDao;
import org.example.entities.Book;
import org.example.entities.Role;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RoleDaoImpl extends BaseDaoImpl<Role, Integer> implements RoleDao {
    private final SessionFactory sessionFactory;

    public RoleDaoImpl() {
        super(Role.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Role findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Role WHERE name = :name";
            Query<Role> query = session.createQuery(hql, Role.class);
            query.setParameter("name", name);
            return query.uniqueResult();
        } catch (Exception e) {
            // Handle any exceptions here
            e.printStackTrace();
        }
        return null;
    }
}
