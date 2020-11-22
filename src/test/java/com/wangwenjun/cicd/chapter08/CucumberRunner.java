package com.wangwenjun.cicd.chapter08;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", "json:target/cucumber-report/cucumber-report.json",
                "junit:target/cucumber-junit.xml",
                "html:target/site/cucumber-pretty.html"
        },
        features = {
                "classpath:com/wangwenjun/cicd/chapter08"
        },
        glue = {
                "com.wangwenjun.cicd.chapter08"
        },
        dryRun = false,
        tags = "@cicd and @v1.0.0" 
)
public class CucumberRunner
{
}
