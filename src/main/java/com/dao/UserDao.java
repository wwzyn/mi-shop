package com.dao;

import com.entity.User;

public interface UserDao {
    boolean findUserByName(String username);

    int addUser(User user);

    User SelectUserByCode(String code);

    void updateUser(User user);

    User findUserByNameAndPassword(String username);
}
