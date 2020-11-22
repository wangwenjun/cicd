package com.wangwenjun.cicd.chapter08;


import io.cucumber.java.en.Given;

public class ArgumentCaptureSteps
{

    @Given("^my name is (\\w+)$")
    public void giveName(String name)
    {
        System.out.println(name);
    }

    @Given("^my age is (\\d+)$")
    public void giveAge(int age)
    {
        System.out.println(age);
    }

    @Given("^my weight is ([0-9]+\\.[0-9]+) KG$")
    public void giveWeight(float weight)
    {
        System.out.println(weight);
    }
}
