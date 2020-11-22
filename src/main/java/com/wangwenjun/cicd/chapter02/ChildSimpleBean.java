package com.wangwenjun.cicd.chapter02;

public class ChildSimpleBean extends SimpleBean
{

    private String address;

    public ChildSimpleBean(String name, int age, String address)
    {
        super(name, age);
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
