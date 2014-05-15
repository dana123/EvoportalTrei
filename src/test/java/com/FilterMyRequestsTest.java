package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.CalendarPage;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;

@RunWith(ThucydidesRunner.class)
public class FilterMyRequestsTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	MyRequestsSteps myRequestsSteps;
	
	@Steps
	CalendarPage RequestVacation;
	
	@Steps
	LogInSteps login;
	
	@Test
	public void testFilter() {
		
		login.logIn("alexandruduminciuc", "alexandru87");
		myRequestsSteps.filterMyRequests("Pending");
	}
	
//	@Test
//	public void filterMyRequests() {
//		logInSteps.openPage();
//		logInSteps.logIn("alexandruduminciuc", "alexandru87");
//		
//		//New Requests
//		
//		myRequests.clickMyRequestsPage();
//		myRequests.checkHolidayCheckBox();
//		myRequests.checkVacationWithoutPayment();
//		myRequests.checkOneFiveFilter();
//		myRequests.applyFiltersOnMyRequests();
//		if(myRequests.verifyIfTableExists()==1){
//			//cauta corectitudinea datelor
//		}
//		
//		//Cancel or withdraw requests
//		
//	}
}
