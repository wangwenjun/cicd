package com.wangwenjun.cicd.chapter07;

import org.concordion.api.ConcordionResources;
import org.concordion.api.MultiValueResult;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@ConcordionResources(value = {"concordion.css"})
public class ListFullNameSplitFixture
{
    private FullNameSplit fullNameSplit;

    @Before
    public void setUp()
    {
        this.fullNameSplit = new FullNameSplit();
    }

    public MultiValueResult split(String fullName)
    {
        final String[] names = fullNameSplit.split(fullName);
        MultiValueResult result = new MultiValueResult();
        return result.with("firstName", names[0]).with("secondName", names[1]);
    }
}
