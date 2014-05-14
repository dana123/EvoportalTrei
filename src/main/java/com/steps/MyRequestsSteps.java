package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.MyRequestsPage;

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
	@Step
	public void checkVacationWithoutPayment(){
		myRequestPage.clickVacationWithoutPayment();
	}
	
	@Step
	public void applyFiltersOnMyRequests(){
		myRequestPage.clickApplyFilterButton();
	}

			
}
