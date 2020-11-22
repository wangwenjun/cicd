package com.wangwenjun.cicd.chapter08;

import io.cucumber.java.en.Given;

public class OtherFlexibilityArgumentsCapture
{

    @Given("^I have (\\d+) coins? in my wallet\\.$")
    public void iHaveCoinInWallet(int coins)
    {
        System.out.println(coins);
    }

    @Given("^I have a (?:deposit|withdraw) of (\\d+) yuan in the bank\\.$")
    public void ignoreGroup(int money)
    {
        System.out.println(money);
    }
}
