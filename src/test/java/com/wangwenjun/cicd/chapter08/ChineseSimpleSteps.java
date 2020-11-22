package com.wangwenjun.cicd.chapter08;

import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChineseSimpleSteps
{
    private int x;
    private int y;
    private int result;

    @假如("^给定一个(\\d+)和(\\d+)$")
    public void 给定一个x和y(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @当("^执行加法运算$")
    public void 执行加法运算()
    {
        this.result = x + y;
    }

    @那么("^结果肯定等于(\\d+)$")
    public void 结果肯定等于(int result)
    {
        assertThat(this.result, equalTo(result));
    }
}
