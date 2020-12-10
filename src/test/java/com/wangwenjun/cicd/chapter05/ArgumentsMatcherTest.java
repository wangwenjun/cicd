package com.wangwenjun.cicd.chapter05;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static com.wangwenjun.cicd.chapter05.CustomArgumentMatcher.closedRange;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentsMatcherTest
{
    @Mock
    private List<String> list;

    @Mock
    private Map<String, String> map;

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

    @Ignore
    @Test
    public void invalidArgumentMatcherTest()
    {
        when(map.getOrDefault(anyString(), "Mockito")).thenReturn("Powermock");
    }

    @Test
    public void testCustomMatcher()
    {
        when(list.get(intThat(closedRange(0, 10)))).thenReturn("Mockito");
        when(list.get(intThat(closedRange(11, 20)))).thenReturn("Powermock");
        when(list.get(intThat(closedRange(30, Integer.MAX_VALUE)))).thenReturn("Alex");

        assertThat(list.get(1), equalTo("Mockito"));
        assertThat(list.get(19), equalTo("Powermock"));
        assertThat(list.get(100), equalTo("Alex"));
    }

    private static <T> HamcrestArgumentMatcher hamcrest(Matcher<T> matcher)
    {
        return new HamcrestArgumentMatcher<>(matcher);
    }

    @Test
    public void testIntegrateHamcrestMatcher1()
    {
        when(list.get(intThat(hamcrest(lessThanOrEqualTo(10))))).thenReturn("Mockito");
        when(list.get(intThat(hamcrest(greaterThanOrEqualTo(11))))).thenReturn("Powermock");
        assertThat(list.get(1), equalTo("Mockito"));
        assertThat(list.get(19), equalTo("Powermock"));
    }

    @Test
    public void testIntegrateHamcrestMatcher2()
    {
        when(list.get(intThat(hamcrest(
                both(lessThanOrEqualTo(10)).and(greaterThanOrEqualTo(0))))
        )).thenReturn("Mockito");

        when(list.get(intThat(hamcrest(
                both(lessThanOrEqualTo(20)).and(greaterThan(10))))
        )).thenReturn("Powermock");

        when(list.get(intThat(hamcrest(greaterThan(20)))))
                .thenReturn("Alex");

        assertThat(list.get(1), equalTo("Mockito"));
        assertThat(list.get(19), equalTo("Powermock"));
        assertThat(list.get(100), equalTo("Alex"));
    }

    @After
    public void clean()
    {
        reset(list, map);
    }
}