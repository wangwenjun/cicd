package com.wangwenjun.cicd.chapter05;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoStubbingTest
{
    @Mock
    private List<String> list;

    private Answer<String> answer = invocation ->
    {
        Integer argument = invocation.getArgument(0, Integer.class);
        return "Alex:" + argument;
    };

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

    @Test
    public void testWhenThenThrow()
    {
        when(list.get(0)).thenThrow(RuntimeException.class);
        when(list.get(1)).thenThrow(new RuntimeException());
        try
        {
            list.get(0);
            fail("should not process to here");
        } catch (Exception e)
        {
            assertThat(e, instanceOf(RuntimeException.class));
        }

        try
        {
            list.get(1);
            fail("should not process to here");
        } catch (Exception e)
        {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void testDoThrowWhen()
    {
        doThrow(RuntimeException.class).when(list).clear();
        doThrow(RuntimeException.class).when(list).get(0);

        try
        {
            list.get(0);
            fail("should not process to here");
        } catch (Exception e)
        {
            assertThat(e, instanceOf(RuntimeException.class));
        }

        try
        {
            list.clear();
            fail("should not process to here");
        } catch (Exception e)
        {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Ignore
    @Test
    public void testThrowCheckedException()
    {
        doThrow(Exception.class).when(list).get(0);
        list.get(0);
    }

    @Test
    public void testPreAnswer()
    {
        when(list.get(0)).thenReturn("Alex");
        when(list.get(1)).thenReturn("Wang");
        assertThat(list.get(0), equalTo("Alex"));
        assertThat(list.get(1), equalTo("Wang"));
    }

    @Test
    public void testWhenThenAnswer()
    {
        when(list.get(anyInt())).thenAnswer(answer);
        assertThat(list.get(0), is(equalTo("Alex:0")));
        assertThat(list.get(1), is(equalTo("Alex:1")));
        assertThat(list.get(100), is(equalTo("Alex:100")));
    }

    @Test
    public void testDoAnswerWhen()
    {
        doAnswer(answer).when(list).get(anyInt());
        assertThat(list.get(0), is(equalTo("Alex:0")));
        assertThat(list.get(1), is(equalTo("Alex:1")));
        assertThat(list.get(100), is(equalTo("Alex:100")));
    }

    @Test
    public void testWhenThenReturnMultipleValues()
    {
        //when(list.get(0)).thenReturn("Hello", "Mockito", "Alex");
        doReturn("Hello", "Mockito", "Alex").when(list).get(0);
        assertThat(list.get(0), is(equalTo("Hello")));
        assertThat(list.get(0), is(equalTo("Mockito")));
        assertThat(list.get(0), is(equalTo("Alex")));
        assertThat(list.get(0), is(equalTo("Alex")));
    }

    @Test
    public void testWhenThenReturnMultipleValues2()
    {
        when(list.get(0)).thenReturn("Hello");
        when(list.get(0)).thenReturn("Mockito");
        when(list.get(0)).thenReturn("Alex");
        assertThat(list.get(0), is(equalTo("Alex")));
        assertThat(list.get(0), is(equalTo("Alex")));
        assertThat(list.get(0), is(equalTo("Alex")));
        assertThat(list.get(0), is(equalTo("Alex")));
    }

    @Test
    public void testIteratorStyle()
    {
        when(list.get(0)).thenReturn("Hello")
                .thenAnswer(answer)
                .thenThrow(RuntimeException.class)
                .thenReturn("Mockito");
        assertThat(list.get(0), is(equalTo("Hello")));
        assertThat(list.get(0), is(equalTo("Alex:0")));
        try
        {
            list.get(0);
            fail("should not process to here");
        } catch (Exception e)
        {
            assertThat(e, instanceOf(RuntimeException.class));
        }
        assertThat(list.get(0), is(equalTo("Mockito")));
        assertThat(list.get(0), is(equalTo("Mockito")));
    }

    @Test
    public void testIteratorStyle2()
    {
        doReturn("Hello")
                .doAnswer(answer)
                .doThrow(RuntimeException.class)
                .doReturn("Mockito").when(list).get(0);
        assertThat(list.get(0), is(equalTo("Hello")));
        assertThat(list.get(0), is(equalTo("Alex:0")));
        try
        {
            list.get(0);
            fail("should not process to here");
        } catch (Exception e)
        {
            assertThat(e, instanceOf(RuntimeException.class));
        }
        assertThat(list.get(0), is(equalTo("Mockito")));
        assertThat(list.get(0), is(equalTo("Mockito")));
    }
}