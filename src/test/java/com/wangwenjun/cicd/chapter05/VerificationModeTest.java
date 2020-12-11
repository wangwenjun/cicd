package com.wangwenjun.cicd.chapter05;

import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.only;

public class VerificationModeTest
{
    @Test
    public void testVerificationMode()
    {
        List<String> list = mock(List.class);
        list.add("Hello");
        verify(list, only()).add(argThat(s -> s.length() >= 5));
        verify(list, never()).clear();
        verify(list, atLeast(1)).add(anyString());
        verify(list, atLeastOnce()).add(anyString());
        verify(list, atMost(5)).add(anyString());
        verify(list, atMostOnce()).add(anyString());
    }

    @Test
    public void testVerifyInteractions()
    {
        List<String> list = mock(List.class);
        List<String> list2 = mock(List.class);
        list.add("Hello");
        verifyNoInteractions(list2);
        //list.clear();
        verify(list).add(anyString());
        verifyNoMoreInteractions(list);
    }
}
