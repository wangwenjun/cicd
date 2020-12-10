package com.wangwenjun.cicd.chapter05;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentsMatcherTest
{
    @Mock
    private List<String> list;

    @Test
    public void simpleTest()
    {
        when(list.get(anyInt())).thenReturn("Mockito");
        assertThat(list.get(0), equalTo("Mockito"));
        assertThat(list.get(999), equalTo("Mockito"));
    }

    @Test
    public void composeArgumentsTest()
    {
        when(list.get(AdditionalMatchers.or(
                ArgumentMatchers.eq(1), ArgumentMatchers.eq(2)))
        ).thenReturn("Mockito");

        when(list.get(AdditionalMatchers.and(
                AdditionalMatchers.geq(3), AdditionalMatchers.lt(10))
        )).thenReturn("Powermock");

        when(list.get(intThat(e -> e >= 10))).thenReturn("Alex");

        assertThat(list.get(1), equalTo("Mockito"));
        assertThat(list.get(9), equalTo("Powermock"));
        assertThat(list.get(10), equalTo("Alex"));
    }

    @After
    public void clean()
    {
        reset(list);
    }
}