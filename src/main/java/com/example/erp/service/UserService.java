package com.example.erp.service;

import com.example.erp.bean.Users;
import com.example.erp.dao.UserDao;
import com.example.erp.dao.implementation.UserDaoImpl;

public class UserService {

    static  UserDao userDao = new UserDaoImpl();
    public static Users verifyEmail(Users user){
        return userDao.emailVerify(user);
    }
    public boolean registerUser(Users user){
        return userDao.registerUser(user);
    }

}
