package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pages.FreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

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

//	check if free days history table exists
	@Step
	public void checkHistoryTable(){
		freeDaysHistoryPage.checkIfHistoryTableExists();
	}
	
////	Selects the filters
//	@Step
//	public void selectAFilterType(String vacationType) {
//		switch (vacationType) {
//		case "Anniversary":
//			var = "BONUS_EVOZONCheckbox";
//			break;
//		case "Extra Days":
//			var = "EXTRA_DAYSCheckbox";
//			break;
//		case "Vacation days":
//			var = "COCheckbox";
//			break;
//		case "Vacation Without Payment":
//			var = "CFCheckbox";
//			break;
//
//		}
//		WebElement element = getDriver()
//				.findElement(
//						By.cssSelector(String
//								.format("#_evovacation_WAR_EvoVacationportlet_"
//										+ var)));
//
//		if (!(element.isSelected()))
//			System.out.println(element);
//		element.click();
//	}
//	
	
	
	
	
//	Select's the filters
	@Step
	public void selectFilters(String filter){
		freeDaysHistoryPage.selectAFilterType(filter);
	}
	
	public void checkIfFiltersAreWorking(String... terms){
		freeDaysHistoryPage.verifySearchResultsContainsItem(terms);
	}
	
// Check's if the filters are working correctly
	@StepGroup
	public void checkFilters(){
		clickFreeDaysHistoryMenu();
//		selectFilters("Vacation Days");
//		selectFilters("Extra Days");
//		clickOnApplyFilters();
//		System.out.println("pana la partea cu tabelul");
		checkIfFiltersAreWorking("Added");
//		System.out.println("dupa");
		
	}

}
