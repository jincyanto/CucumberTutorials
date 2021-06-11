package com.jincy.cucumber.stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

   @Then("^I search (.*)$")
    public void i_search_google(String text){
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(text);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
   }

   @Then("^I open the Url$")
   public void i_open_url(){
       driver.navigate().to("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
   }

   @Then("^I slide$")
   public void i_slide(){
       WebElement slider =  driver.findElement(By.xpath("//*[@id=\"slider3\"]/div/input"));
       Actions move = new Actions(driver);
       move.moveToElement(slider).clickAndHold().moveByOffset(13,0).release().perform();
   }


   @AfterStep
    public void afterStep(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshot");

   }

   @After
    public void closeBrowser(){
        driver.quit();
   }

}
