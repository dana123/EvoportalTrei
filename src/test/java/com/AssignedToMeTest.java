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
import com.steps.LogInSteps;

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

	@Test
	public void reject_req() throws InterruptedException {
		logInSteps.openPage();
		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
		pmUserSteps.accessNewVacation();
		pmUserSteps.accessInbox();
//		pmUserSteps.openRequest("2351");
		pmUserSteps.clickOnAnEmployeeLink("encian horatiu");
//		pmUserSteps.rejectRequest();
		Thread.sleep(3000);
	}

	// @Test
//	public void approve_all_requests() {
//		logInSteps.openPage();
//		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
//		pmUserSteps.accessNewVacation();
//		pmUserSteps.accessInbox();
//		pmUserSteps.sellectAllRequests();
//		pmUserSteps.approveAllRequests();
//	}

	// @Test
//	public void reject_req_nav() throws InterruptedException {
//		logInSteps.openPage();
//		logInSteps.logIn("evoportalpmtrei", "FWMnE7n2");
//		pmUserSteps.accessNewVacation();
//		pmUserSteps.accessInbox();
//		// pmUser.navigatePaginator();
//		pmUserSteps.openRequest("2346");
//		// pmUser.clickOnAnEmployeeLink("delia tripon");
//		// pmUser.rejectRequest();
//		Thread.sleep(3000);
//	}

}
