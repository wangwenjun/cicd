package com.wangwenjun.cicd.chapter02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class JunitAssertionVsHamcrestTest
{

    private List<String> names;

    @Before
    public void setUp()
    {
        names = Arrays.asList("Alex", "Jeffrey", "Alice", "John", "Jack", "Wangwenjun");
    }

    @Ignore
    @Test
    public void junitAssertionFailure()
    {
        Assert.assertTrue(names.contains("Tina"));
    }

    @Ignore
    @Test
    public void assertThatFailure()
    {
        assertThat(names, hasItem("Tina"));
    }

    @Test
    public void assertThatAny()
    {
        assertThat("Hello", anyOf(is("Hello"), equalTo("Hello"), containsString("llo"), endsWith("LLO")));
    }

    @Ignore
    @Test
    public void assertThatAll()
    {
        assertThat("Hello", allOf(is("Hello"), equalTo("Hello"), containsString("llo"), endsWith("LLO")));
    }

    @Ignore
    @Test
    public void hamcrestMoreReadability()
    {
        Assert.assertEquals(10, 4 + 6);
        assertThat(4 + 6, is(equalTo(10)));

        Assert.assertNotEquals(10, 4 + 7);
        assertThat(4 + 7, is(not(equalTo(10))));
    }

}
