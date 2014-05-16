package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.FreeDaysHistoryPage;

@SuppressWarnings("serial")
public class FreeDaysHistorySteps extends ScenarioSteps {

	String var;
	FreeDaysHistoryPage freeDaysHistoryPage;

	@Step
	public void clickFreeDaysHistoryMenu() {
		freeDaysHistoryPage.clickFreeDaysHistoryMenu();
	}

	@Step
	public void clickOnApplyFilters() {
		freeDaysHistoryPage.clickOnApplyFilters();
	}

	// check if free days history table exists
	@Step
	public void checkHistoryTable() {
		freeDaysHistoryPage.checkIfHistoryTableExists();
	}

	// Select's the filters
	@Step
	public void selectFilters(String filter) {
		freeDaysHistoryPage.selectAFilterType(filter);
	}

//	check if the table contains the given element - from the filter 
	public void checkIfFiltersAreWorking(String... terms) {
		freeDaysHistoryPage.verifySearchResultsContainsItem(terms);
	}

	// Check's if the filters are working correctly
	@StepGroup
	public void checkFilters() {
		clickFreeDaysHistoryMenu();
		 selectFilters("Anniversary");
//		 selectFilters("Extra Days");
		 clickOnApplyFilters();
		// System.out.println("pana la partea cu tabelul");
//		checkIfFiltersAreWorking("Vacation Without Payment");
		// System.out.println("dupa");

	}

}
