package com.wangwenjun.cicd.chapter05;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;

public class MockWithMockMethodTest
{
    @Test
    public void mockMethod()
    {
        List<String> list = mock(List.class);
        list.add("mockito");
        assertThat(list.size(), is(equalTo(0)));
        assertThat("mockito", not(in(list)));
        list.clear();
    }
}
