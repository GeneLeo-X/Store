package com.lixiuchun.web.service.impl;


import com.lixiuchun.web.dao.UserDao;
import com.lixiuchun.web.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(){
        userDao = new UserDao();
    }
    /**
     * 检查用户名是否已经存在
     * @param username
     * @return
     */
    @Override
    public Integer getIsExitUser(String username) {

        return userDao.getIsExitUser(username);
    }
}
