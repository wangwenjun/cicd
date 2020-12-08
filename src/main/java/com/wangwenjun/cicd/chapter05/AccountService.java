package com.wangwenjun.cicd.chapter05;

public class AccountService
{

    private AccountDao accountDao;

    public AccountService(AccountDao accountDao)
    {
        this.accountDao = accountDao;
    }

    public UserAccount auth(String username, String password)
    {
        return accountDao.findUserAccount(username, password);
    }
}
