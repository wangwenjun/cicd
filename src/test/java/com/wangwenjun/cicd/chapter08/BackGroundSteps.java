package com.wangwenjun.cicd.chapter08;

import io.cucumber.java8.En;

public class BackGroundSteps implements En
{
    public BackGroundSteps()
    {
        Given("login the www.weibo.com site", () ->
        {
            System.out.println("login the weibo");
        });

        And("the author is {word}", (String author) ->
        {
            System.out.println("The author is: " + author);
        });

        When("edit the post message area", () ->
        {
            System.out.println("edit the post message area.");
        });

        And("the content is {string}", (String content) ->
        {
            System.out.println("The content is: " + content);
        });

        Then("i will see the new post message {string}", (String content) ->
        {
            System.out.println("i will the new post message: " + content);
        });
    }
}
