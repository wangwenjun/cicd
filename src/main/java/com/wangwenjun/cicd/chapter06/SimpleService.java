package com.wangwenjun.cicd.chapter06;

public class SimpleService
{
    public int count()
    {
        SimpleDao simpleDao = new SimpleDao();
        return simpleDao.getCount();
    }
}
