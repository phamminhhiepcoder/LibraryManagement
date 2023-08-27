package org.example.dao;

import org.example.entities.Book;
import org.example.entities.Role;

public interface RoleDao extends BaseDao<Role, Integer>{
    public Role findByName(String name);
}
