package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.CalendarSteps;
import com.steps.ChooseNewRequestMenuStep;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;
import com.steps.NewRequestSteps;

@Story(Application.Authentication.LogIn.class)
@RunWith(ThucydidesRunner.class)
public class NewRequestAcceptByPMTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	LogInSteps logInSteps;

	@Steps
	NewRequestSteps newRequestSteps;
	
	@Steps
	ChooseNewRequestMenuStep newRequestMenuSteps;
	
	@Steps
	CalendarSteps calendarStep;
	
	@Steps
	MyRequestsSteps myRequestsSteps;

	@Test
	public void newRequestPart1() throws ParseException {
		logInSteps.logIn("horatiuencian", "Jungla123");
		
		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(9,4,2014, 9,4,2014);
		newRequestSteps.newRequestStep( "CS", "Your request completed successfully.", false);
		String vacationId = newRequestSteps.getVacationId();

//		newRequestMenuSteps.chooseNewRequestMenu();
//		calendarStep.setDateStep(4,4,2014, 4,4,2014);
//		newRequestSteps.newRequestStep( "CS", "Your request failed to complete.", true);
		
		//myRequestsSteps.clickMyRequestsPage();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		newRequestSteps.inboxMenu();
		newRequestSteps.goToRequest(vacationId);
//		newRequestSteps.withdrawRequest();
	}

}
