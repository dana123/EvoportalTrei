package com.steps;

import com.pages.MyRequestsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyRequestsSteps extends ScenarioSteps{
	
	MyRequestsPage myRequestPage;
	
	@Step
	public void clickMyRequestsPage(){
		myRequestPage.clickMyRequestsPage();
	}
	
	@Step
	public void checkHolidayCheckBox(){
		myRequestPage.clickHolidayCheckBox();
	}
	
	
}
