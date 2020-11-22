package com.wangwenjun.cicd.chapter01;


public class NumericCalculator
{

    public double eval(String expression)
    {
        if (null == expression || expression.isEmpty())
            throw new IllegalArgumentException("the expression can't be null or black.");
        final Expression expr = Expression.of(expression);
        switch (expr.getOperator())
        {
            case ADD:
                return expr.getLeft() + expr.getRight();
            case SUBTRACT:
                return expr.getLeft() - expr.getRight();
            case MULTIPLY:
                return expr.getLeft() * expr.getRight();
            case DIVIDE:
                return expr.getLeft() / expr.getRight();
            default:
                throw new UnsupportedOperationException();
        }
    }

   /* public double eval(String expression)
    {
        final String operation;
        final String[] data;
        if (expression.contains("+"))
        {
            operation = "+";
            data = expression.split("\\+");
        } else if (expression.contains("-"))
        {
            operation = "-";
            data = expression.split("-");
        } else if (expression.contains("*"))
        {
            operation = "*";
            data = expression.split("\\*");
        } else if (expression.contains("/"))
        {
            operation = "/";
            data = expression.split("/");
        } else
            throw new IllegalArgumentException("Unrecognized operator.");
        switch (operation)
        {
            case "+":
                return Double.parseDouble(data[0]) + Double.parseDouble(data[1]);
            case "-":
                return Double.parseDouble(data[0]) - Double.parseDouble(data[1]);
            case "*":
                return Double.parseDouble(data[0]) * Double.parseDouble(data[1]);
            case "/":
                return Double.parseDouble(data[0]) / Double.parseDouble(data[1]);
            default:
                throw new UnsupportedOperationException();
        }
    }*/
}