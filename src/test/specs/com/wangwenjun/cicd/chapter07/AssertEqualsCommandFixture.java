package com.wangwenjun.cicd.chapter07;

import org.concordion.api.ConcordionResources;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@ConcordionResources(value = {"concordion.css"})
public class AssertEqualsCommandFixture
{
    private SimpleSum simpleSum;

    @Before
    public void setUp()
    {
        this.simpleSum = new SimpleSum();
    }

    public int sum(int x, int y)
    {
        return simpleSum.add(x, y);
    }
}
