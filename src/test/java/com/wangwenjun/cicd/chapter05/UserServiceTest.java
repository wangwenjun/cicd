package com.wangwenjun.cicd.chapter05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest
{
    @Spy
    private UserDao userDao = new UserDao();

    private UserService userService;

    @Before
    public void init()
    {
        this.userService = new UserService(this.userDao);
    }

    @Test
    public void testSaveOrUpdateUserForNewUser()
    {
        doReturn(false).when(userDao).exist(isA(User.class));
        doReturn(1).when(userDao).saveUser(isA(User.class));

        final User user = new User();
        int effectResult = userService.saveOrUpdate(user);
        assertThat(effectResult, equalTo(effectResult));

        verify(userDao, times(0)).updateUser(any(User.class));
        verify(userDao, times(1)).saveUser(any(User.class));
    }

    @Test
    public void testSaveOrUpdateUserForExistUser()
    {
        doReturn(true).when(userDao).exist(isA(User.class));
        doReturn(1).when(userDao).updateUser(isA(User.class));

        final User user = new User();
        int effectResult = userService.saveOrUpdate(user);
        assertThat(effectResult, equalTo(effectResult));

        verify(userDao, atMostOnce()).updateUser(any(User.class));
        verify(userDao, never()).saveUser(any(User.class));
    }

    @After
    public void destroy()
    {
        reset(userDao);
    }
}