package com.wangwenjun.cicd.chapter08;

import org.junit.Test;

public class CliMain
{
    @Test
    public void printCucumberMain()
    {
        io.cucumber.core.cli.Main.main("--help");
    }
}
