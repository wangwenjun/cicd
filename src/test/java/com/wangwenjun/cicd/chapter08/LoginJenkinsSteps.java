package com.wangwenjun.cicd.chapter08;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginJenkinsSteps
{
    static
    {
        System.setProperty("webdriver.chrome.driver", "e:\\chromedriver_1.exe");
    }

    private WebDriver driver = null;
    private WebDriverWait wait = null;
    private String url;
    private final By submitButton = By.name("Submit");
    private final By logo = By.className("logo");
    private String account;
    private String password;

    @Given("use the jenkins url {string}")
    public void withJenkinsUrl(String url)
    {
        this.url = url;
    }

    @When("open the jenkins home page")
    public void openHomePage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
        wait = new WebDriverWait(driver, 15);
    }

    @Then("the login button and jenkins logo will be display")
    public void homePageDisplay()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
        assertThat(driver.findElement(submitButton).isDisplayed(), equalTo(true));
        assertThat(driver.findElement(logo).isDisplayed(), equalTo(true));
    }

    @Given("use account {string} with password {string}")
    public void accountAndPassword(String username, String password)
    {
        this.account = username;
        this.password = password;
    }

    @When("click the login button")
    public void loginJenkinsApp()
    {
        driver.findElement(By.id("j_username")).sendKeys(account);
        driver.findElement(By.name("j_password")).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    @Then("the login jenkins action successful")
    public void loginSuccess()
    {
        assertThat(driver.findElement(By.className("task-link")).isDisplayed(), equalTo(true));
    }

    @After("@jenkins")
    public void cleanUp()
    {
        driver.quit();
    }
}