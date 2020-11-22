package com.wangwenjun.cicd.chapter07;

import org.concordion.api.ConcordionResources;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@ConcordionResources(value = {"concordion.css"})
public class NullValueAssertFixture
{
    public String getValue()
    {
        return null;
    }
}
