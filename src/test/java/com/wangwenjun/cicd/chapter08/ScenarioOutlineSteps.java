package com.wangwenjun.cicd.chapter08;

import com.wangwenjun.cicd.chapter07.FullNameSplit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java8.En;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ScenarioOutlineSteps implements En
{
    private FullNameSplit fullNameSplit;

    private String fullName;

    private String[] names;

    @Before("@scenario_outline")
    public void beforeHook()
    {
        this.fullNameSplit = new FullNameSplit();
        System.out.println("------before hook-----");
    }

    public ScenarioOutlineSteps()
    {
        Given("my full name is: {string}", (String fullName) ->
        {
            this.fullName = fullName;

        });

        When("take the full name split function", () ->
        {
            this.names = this.fullNameSplit.split(fullName);
        });

        Then("the first name is {string} and second name is {string}",
                (String firstName, String lastName) ->
                {
                    assertThat(names[0], is(equalTo(firstName)));
                    assertThat(names[1], is(equalTo(lastName)));
                });
    }

    @After("@scenario_outline")
    public void afterHook()
    {
        this.names = null;
        System.out.println("------after hook-----");
    }
}
