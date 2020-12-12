package com.wangwenjun.cicd.chapter05;

public class UserService
{
    private UserDao userDao;

    public UserService(UserDao userDao)
    {
        this.userDao = userDao;
    }

    public int saveOrUpdate(User user)
    {
        return this.userDao.merge(user);
    }

    public int deleteUser(User user)
    {
        user.setUsername(user.getUsername().toUpperCase());
        return this.userDao.deleteUser(user);
    }
}
