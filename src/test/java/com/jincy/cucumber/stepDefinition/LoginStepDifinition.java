package com.jincy.cucumber.stepDefinition;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDifinition {

    WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver","/Users/jincyanto/Downloads/chromedriver");
        driver=new ChromeDriver();
    }

    @Then("^Open automation website$")
    public void i_open_website() {
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    @Then("^Login Button should be present$")
    public void login_button_should_be_present() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
    }

    @Then("^I input the username$")
    public void i_input_the_username() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("janedoe@gmail.com");
    }

    @Then("^I input the password$")
    public void i_input_the_password() {
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("password1232");
    }

    @Then("^I click on the login button$")
    public void i_click_on_the_login_button() {
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");

    }
}