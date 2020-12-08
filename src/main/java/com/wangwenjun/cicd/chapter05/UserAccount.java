package com.wangwenjun.cicd.chapter05;

public class UserAccount
{
    private String username;
    private String password;
    private String address;

    public UserAccount(String username, String password, String address)
    {
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getAddress()
    {
        return address;
    }
}
