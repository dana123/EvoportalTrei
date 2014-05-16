package com;

/**
 * @author EncianHoratiu
 * 
 */

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

import tools.DateUtils;

import com.requirements.Application;
import com.steps.CalendarSteps;
import com.steps.ChooseNewRequestMenuStep;
import com.steps.FreeDaysHistorySteps;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;
import com.steps.NewRequestSteps;

@Story(Application.Authentication.LogIn.class)
@RunWith(ThucydidesRunner.class)
public class FreeDaysHistoryTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	LogInSteps logInSteps;

	@Steps
	FreeDaysHistorySteps freeDaysHistorySteps;
	
	@Steps
	NewRequestSteps newRequestSteps;
	
	@Steps
	ChooseNewRequestMenuStep newRequestMenuSteps;
	
	@Steps
	CalendarSteps calendarStep;
	
	@Steps
	MyRequestsSteps myRequestsSteps;
	
	

	@Test
	public void filterRequests() throws ParseException {
		logInSteps.openPage();
		logInSteps.logIn("horatiuencian", "Jungla123");
		
		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(8,8,2014, 8,8,2014);
		newRequestSteps.newRequestStep( "CO", "Your request completed successfully.", false);
		
		
		freeDaysHistorySteps.clickFreeDaysHistoryMenu();
		
	    String currentDate =  DateUtils.getCurrentDate();
	    System.out.println("The date is " + currentDate);
	    freeDaysHistorySteps.checkIfTableContains(currentDate);
		
//		String vacationId = newRequestSteps.getVacationId();
		
//		freeDaysHistorySteps.checkFilters();
//	    newRequestSteps.withdrawRequest();
		
	}
}
