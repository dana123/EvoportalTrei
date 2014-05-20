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
//	@Step
//	public void logout() {
//		assignedToMePage.clickLogout();
//	}
//	
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
	@Step
	public void rejectRequest2(String vacationId) {
		assignedToMePage.clickRejectButton();
	}
	@Step
	public void approveRequest() {
		assignedToMePage.clickApproveButton();
	}

	@Step
	public void sellectAllRequests() {
		assignedToMePage.checkAllRequests();
	}

	@Step
	public void approveAllRequests() {
		assignedToMePage.clickApprovAllRequests();
	}
	@Step
	public void rejectAllRequests() {
		assignedToMePage.clickRejectAllRequests();
	}
	@Step
	public void openRequest(String requestID) {
		assignedToMePage.openRequest(requestID);
	}
	@Step
       public String verifyIfRequestIsInTheTableList() throws Exception {
		assignedToMePage.clickSave();
	  return assignedToMePage.getVacationId();
	 }
	
	@Step
	 public void clickGoThrowPages(){
		assignedToMePage.goThrowPages();
	 }
	
	//MAIL
//	@Step
//	 public void readPmMail(){
//		assignedToMePage.readLastMail();
//	 }
}
