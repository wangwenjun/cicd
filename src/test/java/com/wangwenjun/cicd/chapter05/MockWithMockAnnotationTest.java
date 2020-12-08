package com.wangwenjun.cicd.chapter05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class MockWithMockAnnotationTest
{
    @Mock
    private List<String> list;

    @Test
    public void annotationMethod()
    {
        list.add("mockito");
        assertThat(list.size(), is(equalTo(0)));
        assertThat("mockito", not(in(list)));
        list.clear();
    }
}
