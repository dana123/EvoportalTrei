package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.apache.bcel.classfile.PMGClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import tools.ReadMailSample;
import tools.ReadPmMailSample;

import com.requirements.Application;
import com.steps.AssignedToMeSteps;
import com.steps.CalendarSteps;
import com.steps.ChooseNewRequestMenuStep;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;
import com.steps.NewRequestSteps;

@Story(Application.Authentication.LogIn.class)
@RunWith(ThucydidesRunner.class)
public class NewRequestPmMailTest {
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

	@Steps
	public AssignedToMeSteps assignedToMeSteps;

	@Steps
	ReadPmMailSample mail;

	@Steps
	ReadMailSample mail2;

	// @Test
	public void newRequestPmMailLinkTest() throws Exception {
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");

		mail.readPmLastMail();

		String link = mail.pmHandelRequests();
		assignedToMeSteps.goToPmURL(link);
		Thread.sleep(3000);
		assignedToMeSteps.rejectRequest();
		Thread.sleep(2000);
		// mail2.readLastMail();

	}

	@Test
	public void newRequestPmMailTest() throws Exception {
		logInSteps.logIn("horatiuencian", "Jungla123");
		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(11, 4, 2014, 11, 5, 2014);
		newRequestSteps.newRequestStep("CS",
				"Your request completed successfully.", false);
		// newRequestSteps.withdrawRequest();
		Thread.sleep(6000);

		mail.readPmLastMail();

		mail.checkContent("4/11/2014", "5/11/2014");

	}
}
