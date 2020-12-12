package com.wangwenjun.cicd.chapter05;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.reset;

@RunWith(MockitoJUnitRunner.class)
public class BDDMockitoTest
{
    @Mock
    private List<String> list;

    @Test
    public void testMockitoBdd()
    {
        given(list.get(0)).willReturn("Mockito");
        assertThat(list.get(0), equalTo("Mockito"));
        then(list).should(only()).get(0);
    }

    @After
    public void destroy()
    {
        reset(list);
    }
}
