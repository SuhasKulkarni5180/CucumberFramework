package com.CucumberBDD.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue="com.CucumberBDD.StepDef",tags="@test",
				plugin= {"com.qmetry.qaf.automation.cucumber.QAFCucumberPlugin","pretty","html:target/HtmlReports/reports.html"} , monochrome=true)

public class CucumberRunner {

}
