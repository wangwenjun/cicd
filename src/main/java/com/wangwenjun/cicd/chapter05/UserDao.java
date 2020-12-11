package com.wangwenjun.cicd.chapter05;

public class UserDao
{
    public boolean exist(User user)
    {
        throw new RuntimeException();
    }

    public int saveUser(User user)
    {
        throw new RuntimeException();
    }

    public int updateUser(User user)
    {
        throw new RuntimeException();
    }

    public int merge(User user)
    {
        if (exist(user))
        {
            return this.updateUser(user);
        }

        return this.saveUser(user);
    }
}