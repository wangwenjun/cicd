package com.wangwenjun.cicd.chapter08;


import io.cucumber.java.en.Given;

public class MultipleArgumentCaptureSteps
{
    private String name;
    private int age;
    private float weight;

    @Given("^my.*name is (\\w+), age.* is (\\d+).* and weight is (\\d+\\.*\\d*) KG\\.$")
    public void env(String name, int age, float weight)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
        System.out.printf("name:%s,age:%d,weight:%f\n", this.name, this.age, this.weight);
    }
}
