package com.wangwenjun.cicd.chapter05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.in;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentCaptorAnnotationTest
{
    @Spy
    private UserDao userDao = new UserDao();
    @Captor
    private ArgumentCaptor<User> captor;
    private UserService userService;

    @Before
    public void init()
    {
        this.userService = new UserService(this.userDao);
    }

    @Test
    public void testDeleteUser()
    {
        doReturn(1).when(userDao).deleteUser(any(User.class));
        userService.deleteUser(new User("alex"));
        verify(userDao).deleteUser(captor.capture());
        User user = captor.getValue();
        assertThat(user.getUsername(), equalTo("ALEX"));
    }

    @Test
    public void testDeleteMultipleUser()
    {
        doReturn(1).when(userDao).deleteUser(any(User.class));

        userService.deleteUser(new User("alex"));
        userService.deleteUser(new User("wangwenjun"));

        verify(userDao, atLeastOnce()).deleteUser(captor.capture());
        List<User> users = captor.getAllValues();
        assertThat(users.get(0).getUsername(), in(new String[]{"ALEX", "WANGWENJUN"}));
        assertThat(users.get(1).getUsername(), in(new String[]{"ALEX", "WANGWENJUN"}));
    }

    @After
    public void clean()
    {
        reset(userDao);
    }
}
