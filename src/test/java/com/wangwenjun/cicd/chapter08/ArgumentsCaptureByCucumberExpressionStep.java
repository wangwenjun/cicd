package com.wangwenjun.cicd.chapter08;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class ArgumentsCaptureByCucumberExpressionStep
{

    @Given("name is {word}, age is {int} and weight is {float} KG")
    public void captureMultipleArguments(String name, int age, float weight)
    {
        System.out.println(name + ";" + age + ";" + weight);
    }

    @Given("In my wallet have {int} coin(s)")
    public void iHaveCoins(int coins)
    {
        System.out.println("coins:" + coins);
    }

    @Given("deposit/withdraw of {int} yuan in the bank")
    public void bankBusiness(int money)
    {
        System.out.println("money:" + money);
    }


    @Given("BigInteger:{biginteger}, BigDecimal:{bigdecimal},Boolean:{bool},Byte:{byte},Short:{short},Integer:{int},Long:{long},Float:{float},Double:{double} and String: {string}.")
    public void test(BigInteger bigInteger, BigDecimal bigDecimal, boolean bool, byte b, short s, int i, long l, float f, double d, String string)
    {
        assertThat(bigInteger, is(equalTo(BigInteger.valueOf(123L))));
        assertThat(bigDecimal, is(closeTo(new BigDecimal("123"), new BigDecimal("0.5"))));
        assertThat(bool, not(true));
        assertThat(b, is(equalTo((byte) 12)));
        assertThat(s, is(equalTo((short) 64)));
        assertThat(i, is(equalTo(100)));
        assertThat(l, is(equalTo(1000L)));
        assertThat(f, is(equalTo(10.0F)));
        assertThat(d, is(equalTo(100.0D)));
        assertThat(string, is(equalTo("i like cucumber")));
    }

    @ParameterType("true|false")
    public Boolean bool(String type)
    {
        return Boolean.valueOf(type);
    }

    @Given("my name is {profile}KG")
    public void captureProfile(Profile profile)
    {
        assertThat(profile, notNullValue());
        assertThat(profile.getName(), is(equalTo("Alex")));
        assertThat(profile.getAge(), is(equalTo(30)));
        assertThat(profile.weight, is(equalTo(71.5F)));
    }

    @ParameterType("(\\w+), age more than (\\d+) and weight is (\\d+\\.\\d+)")
    public Profile profile(String name, String age, String weight)
    {
        return new Profile(name, Integer.parseInt(age), Float.parseFloat(weight));
    }

    static class Profile
    {
        private final String name;
        private final int age;
        private final float weight;

        public Profile(String name, int age, float weight)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public String getName()
        {
            return name;
        }

        public int getAge()
        {
            return age;
        }

        public float getWeight()
        {
            return weight;
        }
    }
}
