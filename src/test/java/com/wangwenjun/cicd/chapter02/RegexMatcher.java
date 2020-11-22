package com.wangwenjun.cicd.chapter02;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher<E extends CharSequence> extends TypeSafeMatcher<String>
{

    private E expected;

    public RegexMatcher(E expected)
    {
        this.expected = expected;
    }

    @Override
    protected boolean matchesSafely(String item)
    {
        String reg = "";
        if (expected instanceof String)
        {
            reg = (String) expected;
        } else if (expected instanceof StringBuffer)
        {
            reg = ((StringBuffer) expected).toString();
        } else if (expected instanceof StringBuilder)
        {
            reg = ((StringBuilder) expected).toString();
        } else
        {
            return false;
        }

        final Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(item);
        return matcher.matches();
    }

    @Override
    public void describeTo(Description description)
    {
        description.appendText("matched the regex: ").appendValue(expected);
    }

    @Override
    public void describeMismatchSafely(String item, Description mismatchDescription)
    {
        mismatchDescription.appendText("String ").appendValue(item).appendText(" missed match regex: ").appendValue(expected);
    }

    public static <T extends CharSequence> RegexMatcher match(T t)
    {
        return new RegexMatcher<T>(t);
    }
}