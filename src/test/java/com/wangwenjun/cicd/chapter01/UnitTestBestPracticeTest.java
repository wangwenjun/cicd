package com.wangwenjun.cicd.chapter01;

import org.junit.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class UnitTestBestPracticeTest
{

    public boolean isZipCode(String zipCode)
    {
        if (null == zipCode || zipCode.isEmpty())
            return false;
        Matcher m = Pattern.compile("\\d{6}").matcher(zipCode);
        return m.matches();
    }

    @Test
    public void testZipCodeWithMutipleConditions()
    {
        assertThat(isZipCode(null), equalTo(false));
        assertThat(isZipCode(""), equalTo(false));
        assertThat(isZipCode("abcdef"), equalTo(false));
    }

    @Test
    public void testZipCodeInvalidNullValue()
    {
        assertThat(isZipCode(null), equalTo(false));
    }

    @Test
    public void testZipCodeInvalidBlackValue()
    {
        assertThat(isZipCode(""), equalTo(false));
    }

    @Test
    public void testZipCodeInvalidNaNValue()
    {
        assertThat(isZipCode("abcdef"), equalTo(false));
    }

    @Test
    public void testZipCodeValid()
    {
        assertThat(isZipCode("100000"), equalTo(true));
    }

    @Test
    public void noAssertion()
    {
        boolean isZipCode = isZipCode("100000");
        System.out.println(isZipCode);
    }

    @Test
    public void noMeaningTest()
    {
        assertThat(true, equalTo(true));
        //or
        assertTrue(true);
    }

    /*@Test
    public void testLoadConf()
    {
        final String conf = "/home/wangwenjun/app/xxx/a.xml";
        boolean loadConfSuccess = true;
        try
        {
            loadConf(conf);
        } catch (IOException e)
        {
            loadConfSuccess = false;
        }
        assertThat(loadConfSuccess, equalTo(false));
    }*/

   /* @Test(expected = IOException.class)
    public void testLoadConf() throws Exception
    {
        final String conf = "/home/wangwenjun/app/xxx/a.xml";
        loadConf(conf);
    }*/

    @Test
    public void testLoadConf()
    {
        final String conf = "/home/wangwenjun/app/xxx/a.xml";
        try
        {
            loadConf(conf);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadConf(String fileName) throws IOException
    {

    }
}
