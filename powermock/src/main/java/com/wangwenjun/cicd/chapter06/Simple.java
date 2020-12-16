package com.wangwenjun.cicd.chapter06;

public class Simple
{
    private final String username;
    private final int age;

    public Simple(String username, int age)
    {
        this.username = username;
        this.age = age;
    }

    public String getUsername()
    {
        return username;
    }

    public int getAge()
    {
        return age;
    }
}
