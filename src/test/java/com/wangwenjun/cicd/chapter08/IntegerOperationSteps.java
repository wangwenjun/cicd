package com.wangwenjun.cicd.chapter08;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IntegerOperationSteps
{

    private IntegerOperation integerOperation;
    private int result;

    @Given("^the a is (\\d+) b is (\\d+)$")
    public void the_a_is_b_is(int arg1, int arg2)
    {
        this.integerOperation = new IntegerOperation(arg1, arg2);
    }

    @When("^execute the add method$")
    public void execute_the_add_method()
    {
        this.result = this.integerOperation.add();
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(int expected)
    {
        assert expected == result;
    }
}