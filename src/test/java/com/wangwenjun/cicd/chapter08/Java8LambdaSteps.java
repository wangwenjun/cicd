package com.wangwenjun.cicd.chapter08;

import io.cucumber.java8.En;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Java8LambdaSteps implements En
{
    private int money;

    public Java8LambdaSteps()
    {
        Given("I have {int} in my wallet", (Integer budget) ->
        {
            money = budget;
        });

        When("I buy milk with {int}", (Integer price) ->
        {
            money -= price;
        });

        Then("I should have {int} in my wallet", (Integer currentBudget) ->
        {
            assertThat(money, is(equalTo(currentBudget)));
        });
    }
}
