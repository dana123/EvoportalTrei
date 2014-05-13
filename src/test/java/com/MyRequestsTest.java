package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;

public class MyRequestsTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	LogInSteps logInSteps;
	
	@Steps
	MyRequestsSteps myRequests;
	
	@Test
	public void filterMyRequests() {
		logInSteps.openPage();
		logInSteps.logIn("alexandruduminciuc", "alexandru87");
		myRequests.clickMyRequestsPage();
		myRequests.checkHolidayCheckBox();
	}
}
