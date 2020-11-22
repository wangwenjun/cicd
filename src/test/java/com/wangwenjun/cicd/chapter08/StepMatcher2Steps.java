package com.wangwenjun.cicd.chapter08;

import io.cucumber.java.en.Given;

public class StepMatcher2Steps
{

    @Given("^use system return result assertion$")
    public void assertion()
    {
        System.out.println("assertion the result.");
    }
}
