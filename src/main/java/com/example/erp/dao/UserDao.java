package com.example.erp.dao;


import com.example.erp.bean.Users;

public interface UserDao {
    Users emailVerify(Users user);
    boolean registerUser(Users user);
}
