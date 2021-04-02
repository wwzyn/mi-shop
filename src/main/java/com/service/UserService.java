package com.service;

import com.entity.User;

public interface UserService {
    boolean findUserByUserName(String username);

    int addUser(User user);

    User SelectUserByCode(String code);

    User findUserByUserNameAndPassword(String username, String password);
}
