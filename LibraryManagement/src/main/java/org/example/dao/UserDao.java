package org.example.dao;

import org.example.entities.User;

public interface UserDao extends BaseDao<User, Integer>{
    public boolean checkLogin(String username, String password);

}
