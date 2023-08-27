package org.example.dao;

import org.example.entities.Book;
import org.example.entities.Users;

public interface BookDao extends BaseDao<Book, Integer>{
    public Book findByName(String name);
}
