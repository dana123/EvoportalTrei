package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.AssignedToMePage;

/**
 * @author deliatripon
 * 
 */
public class AssignedToMeSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	AssignedToMePage assignedToMePage;

	@Step
	public void accessNewVacation() {
		assignedToMePage.clickNewVacation();
	}
	@Step
	public void accessInbox() {
		assignedToMePage.clickInbox();
	}

	@Step
	public void clickOnAnEmployeeLink(String employeeName) {
		assignedToMePage.clickOnAnEmployeeLink(employeeName);
	}

	@Step
	public void rejectRequest() {
		assignedToMePage.clickRejectButton();
	}
}
