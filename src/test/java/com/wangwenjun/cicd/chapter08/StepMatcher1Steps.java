package com.wangwenjun.cicd.chapter08;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;

public class StepMatcher1Steps
{

    @But("^setting the system arguments$")
    public void setting()
    {
        System.out.println("setting method be invoked.");
    }

    @And("^invoke system functions$")
    public void interactive()
    {
        System.out.println("interactive with source system.");
    }
}
