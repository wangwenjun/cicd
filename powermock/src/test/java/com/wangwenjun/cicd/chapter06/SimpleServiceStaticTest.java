package com.wangwenjun.cicd.chapter06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class SimpleServiceStaticTest
{
    private SimpleService simpleService = new SimpleService();

    @PrepareForTest(SimpleDaoUtils.class)
    @Test
    public void testGetSimpleByName()
    {
        mockStatic(SimpleDaoUtils.class);

        Simple alex = new Simple("Alex", 36);
        when(SimpleDaoUtils.findSimple(anyString())).thenReturn(alex);
        Simple result = simpleService.getSimpleByName("Alex");

        assertThat(result, sameInstance(alex));
        assertThat(result.getUsername(), both(equalTo("Alex"))
                .and(equalTo(alex.getUsername())));
        assertThat(result.getAge(), both(equalTo(36))
                .and(equalTo(alex.getAge())));
    }
}