package com;

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
import com.steps.NewRequestCommentSteps;

@RunWith(ThucydidesRunner.class)
public class AssignedToMeTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;
	@Steps
	LogInSteps logInSteps;

	@Steps
	public AssignedToMeSteps pmUserSteps;

	@Steps
	MyRequestsSteps myRequestsSteps;
	@Steps
	NewRequestCommentSteps newRequestSteps;
	@Steps
	ChooseNewRequestMenuStep newRequestMenuSteps;
	@Steps
	CalendarSteps calendarStep;

	 //@Test
	 public void approve_req() throws InterruptedException {
	 logInSteps.openPage();
	 logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
	 pmUserSteps.accessNewVacation();
	 pmUserSteps.accessInbox();
	 // pmUserSteps.openRequest("2351");
	 pmUserSteps.clickOnAnEmployeeLink("delia tripon");
	 pmUserSteps.approveRequest();
	 Thread.sleep(3000);
	 }
	// @Test
	 public void reject_req() throws InterruptedException {
	 logInSteps.openPage();
	 logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
	 pmUserSteps.accessNewVacation();
	 pmUserSteps.accessInbox();
	 // pmUserSteps.openRequest("2351");
	 pmUserSteps.clickOnAnEmployeeLink("delia tripon");
	 pmUserSteps.rejectRequest();
	 Thread.sleep(3000);
	 }
	// @Test
	 public void approve_all_requests() {
	 logInSteps.openPage();
	 logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
	 pmUserSteps.accessNewVacation();
	 pmUserSteps.accessInbox();
	 pmUserSteps.sellectAllRequests();
	 pmUserSteps.approveAllRequests();
	 }
	// @Test
	 public void reject_all_requests() {
	 logInSteps.openPage();
	 logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
	 pmUserSteps.accessNewVacation();
	 pmUserSteps.accessInbox();
	 pmUserSteps.sellectAllRequests();
	 pmUserSteps.rejectAllRequests();
	 }

	// @Test??
	 public void reject_req_nav() throws InterruptedException {
	 logInSteps.openPage();
	 logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
	 pmUserSteps.accessNewVacation();
	 pmUserSteps.accessInbox();
	 // pmUser.navigatePaginator();
	 pmUserSteps.openRequest("2346");
	 // pmUser.clickOnAnEmployeeLink("delia tripon");
	 // pmUser.rejectRequest();
	 Thread.sleep(3000);
	 }

	
	@Test
	public void create_request_then_reject() throws Exception {
		logInSteps.logIn("horatiuencian", "Jungla123");
		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(12, 9, 2014, 12, 10, 2014);
		newRequestSteps
				.newRequestComStep("CS", "aaa");

		// String vacationID = pmUserSteps.clickSave();
		// System.out.println(vacationID);
		//String vacactionID = pmUserSteps.verifyIfRequestIsInTheTableList();
		String vacactionID = null;
		System.out.println(vacactionID);
		pmUserSteps.logout();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		pmUserSteps.accessNewVacation();
		pmUserSteps.accessInbox();
		pmUserSteps.clickRequest("encian horatiu");
		pmUserSteps.approveRequest();
//		pmUserSteps.rejectRequest2(vacactionID);
		Thread.sleep(3000);

	}
}
