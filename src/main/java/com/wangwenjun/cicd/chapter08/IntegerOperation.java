package com.wangwenjun.cicd.chapter08;

public class IntegerOperation
{
    private final int a;
    private final int b;

    public IntegerOperation(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public int add()
    {
        return a + b;
    }
}