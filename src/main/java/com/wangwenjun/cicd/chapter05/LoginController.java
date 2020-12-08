package com.wangwenjun.cicd.chapter05;

import javax.servlet.http.HttpServletRequest;

public class LoginController
{
    private AccountService accountService;

    public LoginController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    public String login(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try
        {
            UserAccount account = accountService.auth(username, password);
            if (account == null)
            {
                return "login";
            } else
            {
                return "main";
            }
        } catch (Exception e)
        {
            return "5xx";
        }
    }
}