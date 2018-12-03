package com.cg.mobilebilling;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"features"},
		glue= {"com.cg.mobilebilling.stepdefinitions"}
		)
public class TestRunner {
	

}
