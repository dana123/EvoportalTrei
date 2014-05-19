package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.MyRequestsPage;

public class MyRequestsSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;

	MyRequestsPage myRequestPage;

	@Steps
	LogInSteps logInSteps;

	@Step
	public void clickMyRequestsPage() {
		myRequestPage.clickMyRequestsPage();
	}

	 @Step
	 public void checkHolidayCheckBox() {
	 myRequestPage.clickHolidayCheckBox();
	 }
	
	 @Step
	 public void checkVacationWithoutPayment() {
	 myRequestPage.clickVacationWithoutPayment();
	 }
	
	 @Step
	 public void checkOneFiveFilter() {
	 myRequestPage.checkOneFiveDaysFilter();
	 }
	
	 @Step
	 public void checkPending() {
	 myRequestPage.clickPendingCheckBox();
	 }
	
	@Step
	public void applyFiltersOnMyRequests() {
		myRequestPage.clickApplyFilterButton();
	}

	@Step
	public int verifyIfTableExists() {
		if (myRequestPage.checkIfRequestsTableExists() == true)
			return 1;
		return 0;
	}

	@StepGroup
	public void filterMyRequests(String... terms) {

		clickMyRequestsPage();

		//applyFiltersOnMyRequests();

		if (verifyIfTableExists() == 1) {

			lookForElement(terms);
		}

	}

	@Step
	public void lookForElement(String... terms) {
		myRequestPage.selectAVacationStatus(terms);
		applyFiltersOnMyRequests();
		
		myRequestPage.verifySearchResultsContainsItem(terms);
	}

	// @Step
	// public void lookForElement(String terms) {
	// // myRequestPage.selectAVacationStatus(terms);
	// // applyFiltersOnMyRequests();
	// myRequestPage.verifyIfTheFilteredTableContainsAVacationsWithOtherStatusThanFilter(terms);
	// }

}
