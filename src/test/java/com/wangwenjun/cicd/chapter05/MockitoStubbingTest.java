package com.wangwenjun.cicd.chapter05;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoStubbingTest
{
    @Mock
    private List<String> list;

    @Test
    public void testWhenThenReturn()
    {
        when(list.get(0)).thenReturn("Alex");
        assertThat(list.get(0), equalTo("Alex"));
        assertThat(list.get(1), nullValue());
    }

    @Test
    public void testDoReturnWhen()
    {
        doReturn("Alex").when(list).get(0);
        assertThat(list.get(0), equalTo("Alex"));
        assertThat(list.get(1), nullValue());
    }

    @Test
    public void testDoNothingWhen()
    {
        doNothing().when(list).clear();
        list.clear();
        verify(list).clear();
    }

    @Ignore
    @Test
    public void testDoNothingWhen2()
    {
        doNothing().when(list).get(0);
        list.get(0);
    }
}