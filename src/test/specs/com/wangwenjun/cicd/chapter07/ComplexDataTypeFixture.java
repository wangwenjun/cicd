package com.wangwenjun.cicd.chapter07;

import org.concordion.api.ConcordionResources;
import org.concordion.api.FullOGNL;
import org.concordion.api.MultiValueResult;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FullOGNL
@RunWith(ConcordionRunner.class)
@ConcordionResources(value = {"concordion.css"})
public class ComplexDataTypeFixture
{

    public List<String> getCollection()
    {
        return Arrays.asList("Hello", "World");
    }

    public Map<String, String> getMap()
    {
        return new HashMap<String, String>()
        {
            {
                put("Hello", "World");
                put("Alex", "Wangwenjun");
            }
        };
    }

    public MultiValueResult getMultiValueResult()
    {
        MultiValueResult result = new MultiValueResult();
        return result.with("Hello", "World").with("Alex", "Wangwenjun");
    }
}