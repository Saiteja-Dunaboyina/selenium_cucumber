package com.cucumber.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
		glue = {"com.cucumber.stepdefinitions"},
		monochrome = true,
		plugin = {"pretty" , "html:target/Reports/cucumberReport.html"}
)
public class TestRunner {

}
