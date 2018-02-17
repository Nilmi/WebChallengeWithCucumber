package com.straitstimes.webtest.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/straitstimes/webtest/features/Web.feature", //path of the feature file(s)
		glue={"com.straitstimes.webtest.stepdefinitions"}, //the path of the step definition file(s)
		dryRun = false, //to check the mapping is proper between feature file and step definitions file
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		monochrome = true, //display the console output in a proper readable format
		strict = true //it will check if any step is not defined in step definition file
				
)

public class Runner {

}
