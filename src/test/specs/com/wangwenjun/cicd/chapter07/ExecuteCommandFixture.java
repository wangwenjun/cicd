package com.wangwenjun.cicd.chapter07;

import org.concordion.api.ConcordionResources;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@ConcordionResources(value = {"concordion.css"})
public class ExecuteCommandFixture
{
    private String firstName = "";

    private String secondName = "";

    @After
    public void tearDown()
    {
        this.firstName = "";
        this.secondName = "";
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    public String getFullName()
    {
        return this.firstName + " " + this.secondName;
    }
}