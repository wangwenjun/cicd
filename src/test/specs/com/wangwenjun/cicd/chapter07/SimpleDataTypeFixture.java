package com.wangwenjun.cicd.chapter07;

import org.concordion.api.ConcordionResources;
import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
@FullOGNL
@RunWith(ConcordionRunner.class)
@ConcordionResources(value = {"concordion.css"})
public class SimpleDataTypeFixture
{

    public int getInt()
    {
        return 10;
    }

    public String getString()
    {
        return "Hello";
    }

    public String[] getArray()
    {
        return new String[]{"Hello", "World"};
    }


    public Simple getPOJO()
    {
        return new Simple("Alex");
    }

    public static class Simple
    {
        private final String name;

        public Simple(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }
    }
}
