package com.wangwenjun.cicd.chapter02;

import org.junit.Ignore;
import org.junit.Test;

import static com.wangwenjun.cicd.chapter02.RegexMatcher.match;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegexMatcherTest
{

    @Test
    public void testRegexMatcher()
    {
        assertThat("test zip code", "123456", match("\\d{6}"));
        assertThat("test zip code", "123456", is(match("\\d{6}")));
        assertThat("test zip code", "123456", not(not(match("\\d{6}"))));
        assertThat("test zip code", "123456", match(new StringBuilder("\\d{6}")));
        assertThat("test ip v4 address", "127.0.0.1", match(new StringBuffer("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}")));
    }

    @Ignore
    @Test
    public void testRegexMatcherFailed()
    {
        assertThat("test zip code", "123456", match("\\d{5}"));
    }
}
