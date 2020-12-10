package com.wangwenjun.cicd.chapter05;

import org.mockito.ArgumentMatcher;

public class CustomArgumentMatcher implements ArgumentMatcher<Integer>
{
    private int begin;

    private int end;

    private CustomArgumentMatcher(int begin, int end)
    {
        this.begin = begin;
        this.end = end;
    }

    public static CustomArgumentMatcher closedRange(int begin, int end)
    {
        return new CustomArgumentMatcher(begin, end);
    }

    @Override
    public boolean matches(Integer index)
    {
        return index >= begin && index <= end;
    }

    public String toString()
    {
        return "[The index is range is [" + begin + "," + end + "]";
    }
}
