package com.raghu.service;

import java.util.List;

import com.raghu.model.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}
