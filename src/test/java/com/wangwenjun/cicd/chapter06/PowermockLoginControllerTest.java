package com.wangwenjun.cicd.chapter06;

import com.wangwenjun.cicd.chapter05.AccountDao;
import com.wangwenjun.cicd.chapter05.AccountService;
import com.wangwenjun.cicd.chapter05.LoginController;
import com.wangwenjun.cicd.chapter05.UserAccount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(PowerMockRunner.class)
public class PowermockLoginControllerTest
{
    private HttpServletRequest request;
    private AccountDao accountDao;
    private AccountService accountService;
    private LoginController loginController;

    @Before
    public void setUp()
    {
        this.request = mock(HttpServletRequest.class);
        this.accountDao = mock(AccountDao.class);
        this.accountService = new AccountService(accountDao);
        this.loginController = new LoginController(accountService);
    }

    @Test
    public void testAccountAuthSuccess()
    {
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("123456");

        final UserAccount userAccount = new UserAccount("admin", "123456", "China");
        when(accountDao.findUserAccount("admin", "123456")).thenReturn(userAccount);

        String result = loginController.login(request);
        assertThat(result, is(equalTo("main")));
    }

    @Test
    public void testAccountAuthFailed()
    {
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findUserAccount("admin", "123456")).thenReturn(null);

        String result = loginController.login(request);
        assertThat(result, is(equalTo("login")));
    }

    @Test
    public void testAccountAuthError()
    {
        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findUserAccount(anyString(), anyString()))
                .thenThrow(RuntimeException.class);
        String result = loginController.login(request);
        assertThat(result, is(equalTo("5xx")));
    }
}
