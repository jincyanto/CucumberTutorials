package com.jincy.cucumber.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FeatureStepDefinitions {

    WebDriver driver;


    @Given("^I open the browser$")
    public void i_open_browser(){
        System.setProperty("webdriver.chrome.driver","/Users/jincyanto/Downloads/chromedriver");
        driver=new ChromeDriver();
    }

    @Then("^I open the Amazon$")
    public void i_open_the_amazon(){
        driver.navigate().to("https://www.amazon.com");
    }

    @Then("^Login Button should exist$")
    public void login_button_should_exist(){
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
    }

   @Then("^I open (.*) website$")
    public void i_open_website(String website){
        driver.navigate().to("https://www."+website+".com");

   }


}
