package com.wangwenjun.cicd.chapter01;

import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NumericCalculatorTest
{
    private NumericCalculator calculator;

    @Before
    public void setup()
    {
        this.calculator = new NumericCalculator();
    }

    @Test
    public void textEvalAddExpression()
    {
        final String expression = "1+2";
        assertThat(calculator.eval(expression), equalTo(3.0D));
    }

    @Test
    public void textEvalSubtractExpression()
    {
        final String expression = "3-1";
        assertThat(calculator.eval(expression), equalTo(2.0D));
    }

    @Test
    public void textEvalMultiplyExpression()
    {
        final String expression = "3*2";
        assertThat(calculator.eval(expression), equalTo(6.0D));
    }

    @Test
    public void textEvalDivideExpression()
    {
        final String expression = "3/2";
        assertThat(calculator.eval(expression), equalTo(1.5D));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpressionStringBlack()
    {
        calculator.eval("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpressionStringNull()
    {
        calculator.eval(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpressionNoOperator()
    {
        calculator.eval("1?2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpressionNotNumeric()
    {
        calculator.eval("x+y");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpressionInvalid()
    {
        calculator.eval("1+");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpressionDivisorIsZero()
    {
        calculator.eval("1/0");
    }

    @Test
    public void testExp4j()
    {
        net.objecthunter.exp4j.Expression expression = new ExpressionBuilder("(1+2)*10-5/3+40")
                .build();
        double result = expression.evaluate();
        assertThat(result, equalTo(68.33333333333333D));
    }
}