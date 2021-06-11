package com.BDD.Runner;



import org.testng.annotations.Test;

import cucumber.api.testng.AbstractTestNGCucumberTests;

import cucumber.api.CucumberOptions;
//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"com.BDD.StepDef"},monochrome=true,
		plugin= {"pretty","html:target/HtmlReports/index.html",
				"json:target/JsonReports/report.json"})
@Test
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
