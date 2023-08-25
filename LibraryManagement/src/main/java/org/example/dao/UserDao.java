package org.example.dao;

import org.example.entities.Users;

public interface UserDao extends BaseDao<Users, Integer>{
    public boolean checkLogin(String username, String password);

}
