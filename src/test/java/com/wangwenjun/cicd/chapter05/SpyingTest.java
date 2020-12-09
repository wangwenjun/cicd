package com.wangwenjun.cicd.chapter05;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SpyingTest
{
    @Spy
    private LinkedList<String> linkedList = new LinkedList<>();
    private ArrayList<String> arrayList;
    @Spy
    private PartialService partialService = new PartialService();

    @Before
    public void init()
    {
        arrayList = spy(new ArrayList<>());
    }

    @Test
    public void simpleTest()
    {
        this.linkedList.add("Hello");
        this.arrayList.add("Mockito");

        assertThat(linkedList, Matchers.both(Matchers.hasSize(1)).and(Matchers.contains("Hello")));
        assertThat(arrayList, Matchers.both(Matchers.hasSize(1)).and(Matchers.contains("Mockito")));
        this.linkedList.clear();
        this.arrayList.clear();

        assertThat(linkedList, Matchers.both(Matchers.hasSize(0)).and(Matchers.empty()));
        assertThat(arrayList, Matchers.both(Matchers.hasSize(0)).and(Matchers.empty()));
    }

    @Test
    public void spyPartialServiceTest()
    {
        //when(partialService.getExternal()).thenReturn(100);
        doReturn(100).when(partialService).getExternal();
        assertThat(partialService.getRandom(), Matchers.lessThan(100));
        assertThat(partialService.getExternal(), Matchers.equalTo(100));
    }
}