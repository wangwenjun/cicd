package com.wangwenjun.cicd.chapter05;

import static java.util.concurrent.ThreadLocalRandom.current;

public class PartialService
{
    public int getRandom()
    {
        return current().nextInt(100);
    }

    public int getExternal()
    {
        throw new RuntimeException();
    }
}
