package com.wangwenjun.cicd.chapter05;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InjectMockTest
{
    @Spy
    private UserDao userDao = new UserDao();

    @InjectMocks
    private UserService userService;

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

    @After
    public void destroy()
    {
        reset(userDao);
    }
}
