package com;

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
public class NewRequestTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	LogInSteps logInSteps;

	@Steps
	NewRequestSteps newRequestSteps;

	@Steps
	NewRequestSteps newSpecialRequestSteps;

	@Steps
	ChooseNewRequestMenuStep newRequestMenuSteps;

	@Steps
	CalendarSteps calendarStep;

	@Steps
	MyRequestsSteps myRequestsSteps;

	@Test
	public void newRequestPart1() throws Exception {
		logInSteps.logIn("horatiuencian", "Jungla123");

		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(3, 4, 2014, 3, 4, 2014);
		newRequestSteps.newRequestStep("CO",
				"Your request completed successfully.", false);
		String vacationId = newRequestSteps.getVacationId();
		System.out.print(vacationId);

	}

	@Test
	public void newRequestPart2() throws Exception {
		logInSteps.logIn("horatiuencian", "Jungla123");

		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(2, 4, 2014, 2, 4, 2014);
		newRequestSteps.newSpecialRequestStep("CS", "Child birth",
				"Your request completed successfully.", false);
		String vacationId = newRequestSteps.getVacationId();
		System.out.print(vacationId);
		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(2, 4, 2014, 2, 4, 2014);

		newRequestSteps.newSpecialRequestStep("CS", "Child birth",
				"Your request failed to complete.", true);

		myRequestsSteps.clickMyRequestsPage();

		newRequestSteps.goToRequest(vacationId);

	}

}
