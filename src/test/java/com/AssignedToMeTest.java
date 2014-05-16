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

import com.steps.AssignedToMeSteps;
import com.steps.CalendarSteps;
import com.steps.ChooseNewRequestMenuStep;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;
import com.steps.NewRequestSteps;

@RunWith(ThucydidesRunner.class)
public class AssignedToMeTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	LogInSteps logInSteps;

	@Steps
	public AssignedToMeSteps assignedToMeSteps;

	@Steps
	MyRequestsSteps myRequestsSteps;
	@Steps
	NewRequestSteps newRequestSteps;
	@Steps
	ChooseNewRequestMenuStep newRequestMenuSteps;
	@Steps
	CalendarSteps calendarStep;

	// @Test
	public void approve_requestsTest() throws InterruptedException {
		logInSteps.openPage();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		assignedToMeSteps.accessNewVacation();
		assignedToMeSteps.accessInbox();
		// pmUserSteps.openRequest("2351");
		assignedToMeSteps.clickOnAnEmployeeLink("encian horatiu");
		assignedToMeSteps.approveRequest();
		Thread.sleep(3000);
	}

	// @Test
	public void reject_requestsTest() throws InterruptedException {
		logInSteps.openPage();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		assignedToMeSteps.accessNewVacation();
		assignedToMeSteps.accessInbox();
		// pmUserSteps.openRequest("2351");
		assignedToMeSteps.clickOnAnEmployeeLink("delia tripon");
		assignedToMeSteps.rejectRequest();
		Thread.sleep(3000);
	}

	// @Test
	public void approve_all_requestsTest() {
		logInSteps.openPage();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		assignedToMeSteps.accessNewVacation();
		assignedToMeSteps.accessInbox();
		assignedToMeSteps.sellectAllRequests();
		assignedToMeSteps.approveAllRequests();
	}

	// @Test
	public void reject_all_requestsTest() {
		logInSteps.openPage();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		assignedToMeSteps.accessNewVacation();
		assignedToMeSteps.accessInbox();
		assignedToMeSteps.sellectAllRequests();
		assignedToMeSteps.rejectAllRequests();
	}

	// @Test??
	public void reject_req_navTest() throws InterruptedException {
		logInSteps.openPage();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		assignedToMeSteps.accessNewVacation();
		assignedToMeSteps.accessInbox();
		// pmUser.navigatePaginator();
		assignedToMeSteps.openRequest("2346");
		// pmUser.clickOnAnEmployeeLink("delia tripon");
		// pmUser.rejectRequest();
		Thread.sleep(3000);
	}

	// @Test
	public void create_request_then_rejectTest() throws Exception {
		logInSteps.logIn("horatiuencian", "920X-p0U");
		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(12, 21, 2014, 12, 28, 2014);
		newRequestSteps.newRequestStep("CO",
				"Your request failed to complete.", false);

		// String vacationID = pmUserSteps.clickSave();
		// System.out.println(vacationID);
		String vacactionID = assignedToMeSteps
				.verifyIfRequestIsInTheTableList();
		System.out.println(vacactionID);
		logInSteps.logout();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		assignedToMeSteps.accessNewVacation();
		assignedToMeSteps.accessInbox();
		assignedToMeSteps.rejectRequest2(vacactionID);
		Thread.sleep(3000);

	}

	// @Test
	public void log_outTest() throws Exception {
		logInSteps.logIn("deliatripon", "89H5H0g6");
		logInSteps.logout();
	}

	// @Test
	public void navigate_inboxTest() {
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		assignedToMeSteps.accessNewVacation();
		assignedToMeSteps.accessInbox();
		assignedToMeSteps.clickGoThrowPages();

	}

	@Test
	public void navigate_Employees_pages_approveReqTest() {
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		assignedToMeSteps.accessNewVacation();
		assignedToMeSteps.accessInbox();
		assignedToMeSteps.clickGoThrowPages();
		assignedToMeSteps.clickOnAnEmployeeLink("encian horatiu");
		assignedToMeSteps.approveRequest();

	}
}
