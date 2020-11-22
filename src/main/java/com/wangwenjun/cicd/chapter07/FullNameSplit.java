package com.wangwenjun.cicd.chapter07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullNameSplit
{
    private final static Pattern pattern = Pattern
            .compile("\\s*((?i)miss|ms|mrs|mr|sir)?\\s*([a-zA-Z0-9\\s]+)");

    /**
     * split the full name.
     *
     * @param fullName
     * @return first name and last name
     */
    public String[] split(String fullName)
    {
        String[] result = new String[]{"", ""};
        String temp = ignoreRespectfulName(fullName);
        String[] names = temp.split("\\s+");
        result[0] = names[0].trim();
        if (names.length == 2)
        {
            result[1] = names[1].trim();
        } else
        {
            result[1] = temp.substring(names[0].length()).trim();
        }
        return result;
    }

    private static String ignoreRespectfulName(String fullName)
    {
        Matcher matcher = pattern.matcher(fullName);
        if (matcher.find())
        {
            return matcher.group(2);
        }

        return fullName;
    }
}
