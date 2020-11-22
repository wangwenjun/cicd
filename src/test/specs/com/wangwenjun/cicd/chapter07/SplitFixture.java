package com.wangwenjun.cicd.chapter07;

import org.concordion.api.ConcordionResources;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@ConcordionResources(value = {"concordion.css"})
public class SplitFixture
{
    private FullNameSplit fullNameSplit;

    @Before
    public void setUp()
    {
        this.fullNameSplit = new FullNameSplit();
    }

    public Result split(String fullName)
    {
        String[] names = fullNameSplit.split(fullName);
        Result result = new Result(names[0], names[1]);

        return result;
    }

    class Result
    {
        public String firstName = "TODO";
        public String lastName = "TODO";

        public Result(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;

        }
    }
}
