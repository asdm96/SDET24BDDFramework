package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {".\\src\\test\\java\\features"},
glue= {"stepDefinitions","hook"},
dryRun = false,  // check the stepdefinition whether all the scenario's steps implemented or not
plugin = {"pretty","html:report/cucumberreport.html",
		"json:report/cucumberjsonreport.json"}, //to print the scenario steps in console
monochrome = true, //to remove special characters in console output
tags = "@SmokeTest"	//if we want to execute either smoke or regression test we go for "or" operator
		)	//if we want to execute both end2end and long with regression test we go "and" operator
public class Runner extends AbstractTestNGCucumberTests {

}
