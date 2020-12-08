package com.wangwenjun.cicd.chapter05;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class MockWithMockitoInitialTest
{
    @Before
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private List<String> list;

    @Test
    public void mockitoOpenMocksMethod()
    {
        list.add("mockito");
        assertThat(list.size(), is(equalTo(0)));
        assertThat("mockito", not(in(list)));
        list.clear();
    }
}