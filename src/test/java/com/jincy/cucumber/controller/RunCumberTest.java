package com.jincy.cucumber.controller;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/com/jincy/cucumber/BrowswAmazon.feature",
        plugin = "html:target/cucumberreport.html",
        glue = "com.jincy.cucumber.stepDefinition")
public class RunCumberTest {}
