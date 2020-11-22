package com.wangwenjun.cicd.chapter01;

import junit.framework.TestCase;

public class SimpleTestSuite3Test extends TestCase
{

    @Override
    protected void setUp() throws Exception
    {
        //resource initialize
    }

    public void testFun(){
        //unit test code.
    }

    public void funTest(){
        //this method is not the unit test function
    }

    @Override
    protected void tearDown() throws Exception
    {
        //resource release/destroy
    }
}
