package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.CalendarPage;
import com.steps.CalendarSteps;
import com.steps.ChooseNewRequestMenuStep;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;
import com.steps.NewRequestSteps;

@RunWith(ThucydidesRunner.class)
public class MyRequestsTest {
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
	
	@Steps
	ChooseNewRequestMenuStep newRequestMenuSteps;
	
	@Steps
	CalendarSteps calendarStep;
	
	@Steps
	NewRequestSteps newRequestSteps;
	
	@Test
	public void testFilter() throws ParseException{
		
		login.logIn("alexandruduminciuc", "alexandru87");
//		newRequestMenuSteps.chooseNewRequestMenu();
//		calendarStep.setDateStep(4,4,2014, 4,4,2014);
//		newRequestSteps.chooseVacationType("CO");
//		newRequestSteps.saveRequest();
//		newRequestMenuSteps.chooseNewRequestMenu();
//		calendarStep.setDateStep(5,4,2014, 5,4,2014);
//		newRequestSteps.chooseVacationType("CO");
//		newRequestSteps.saveRequest();
//		newRequestMenuSteps.chooseNewRequestMenu();
//		calendarStep.setDateStep(16,4,2014, 23,4,2014);
//		newRequestSteps.chooseVacationType("CO");
//		newRequestSteps.saveRequest();
		myRequestsSteps.filterMyRequests("Vacation Without Payment", "1 - 5", "Withdrawn");
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
