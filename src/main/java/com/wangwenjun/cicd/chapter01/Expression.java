package com.wangwenjun.cicd.chapter01;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression
{
    enum Operator
    {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");
        private final String opt;
        private static Map<String, Operator> typeMapping = new HashMap<>();

        Operator(String opt)
        {
            this.opt = opt;
        }

        @Override
        public String toString()
        {
            return opt;
        }

        static
        {
            typeMapping.put(ADD.opt, ADD);
            typeMapping.put(SUBTRACT.opt, SUBTRACT);
            typeMapping.put(MULTIPLY.opt, MULTIPLY);
            typeMapping.put(DIVIDE.opt, DIVIDE);
        }

        public static Operator getOperator(String opt)
        {
            return typeMapping.get(opt);
        }
    }

    private final Operator operator;
    private final double left;
    private final double right;

    private final static String regexp = "^(\\d+)([\\+|\\-|\\*|\\/])(\\d+)$";
    private final static Pattern pattern = Pattern.compile(regexp);

    public static Expression of(String expression)
    {
        final Matcher matcher = pattern.matcher(expression);
        if (!matcher.matches())
            throw new IllegalArgumentException("Illegal expression.");

        final Expression exp = of(Operator.getOperator(matcher.group(2)),
                Double.parseDouble(matcher.group(1)),
                Double.parseDouble(matcher.group(3)));

        if (exp.getOperator() == Operator.DIVIDE && exp.getRight() == 0)
            throw new IllegalArgumentException("The divisor cannot be zero. ");

        return exp;

/*
        if (expression.contains("+"))
        {
            String[] data = expression.split("\\+");
            return of(Operator.ADD, Double.parseDouble(data[0]), Double.parseDouble(data[1]));
        } else if (expression.contains("-"))
        {
            String[] data = expression.split("-");
            return of(Operator.SUBTRACT, Double.parseDouble(data[0]), Double.parseDouble(data[1]));
        } else if (expression.contains("*"))
        {
            String[] data = expression.split("\\*");
            return of(Operator.MULTIPLY, Double.parseDouble(data[0]), Double.parseDouble(data[1]));
        } else if (expression.contains("/"))
        {
            String[] data = expression.split("/");
            return of(Operator.DIVIDE, Double.parseDouble(data[0]), Double.parseDouble(data[1]));
        } else
        {
            throw new IllegalArgumentException("Unrecognized operator.");
        }*/
    }

    public static Expression of(Operator operator, double left, double right)
    {
        return new Expression(operator, left, right);
    }

    public Expression(Operator operator, double left, double right)
    {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public Operator getOperator()
    {
        return operator;
    }

    public double getLeft()
    {
        return left;
    }

    public double getRight()
    {
        return right;
    }
}