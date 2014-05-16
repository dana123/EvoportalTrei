package com.steps;

import java.text.ParseException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import com.pages.CalendarPage;
import com.pages.NewVacationRequestPage;

public class NewRequestSteps {

	NewVacationRequestPage newVacation;
	CalendarPage calendar;

	@Step
	public void chooseAVacationType(String vacationType) {
		newVacation.selectVacationType(vacationType);
	}

	@Step
	public void saveRequest() {
		newVacation.saveNewRequestButton();
	}

	@Step
	public void checkMessage(String message) {
		newVacation.checkThatYouReceiveTheSuccesMessage(message);
	}

	@Step
	public void checkErrorMessage(String message) {
		newVacation.checkThatYouReceiveTheErrorMessage(message);
	}

	@Step
	public void withdrawRequest() {
		newVacation.withdrawRequestButton();
	}

	@Step
	public String getVacationId() {
		return newVacation.getVacationId();
	}

	@Step
	public void goToRequest(String vacationId) {
		newVacation.goToRequest(vacationId);
	}

	@Step
	public void logOut() {
		newVacation.clickLogout();
	}

	@Step
	public void inboxMenu() {
		newVacation.clickInbox();
	}
	
	@Step
	 public void click_dropDown(String value) throws Exception {
	  newVacation.click_a_special_vacation(value);
	  Thread.sleep(4000);
	 }

	/**
	 * public void
	 * 
	 * @param vacationType
	 *            Vacation - 'CO', 'CF', 'CS', 'CM']
	 * @throws Exception 
	 * 
	 */
	@StepGroup
	public void newRequestStep(String vacationType, String value, String message,
			boolean error) throws Exception {
		chooseAVacationType(vacationType);
		click_dropDown(value);
		saveRequest();
		if (error) {
			checkErrorMessage(message);
		} else {
			checkMessage(message);
		}
//		 withdrawRequest();
//		logOut();
	}
}
