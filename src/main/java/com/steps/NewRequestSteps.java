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
	public void chooseVacationType(String vacationType) {
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
	public void goToRequest(String vacationId){
		newVacation.goToRequest(vacationId);
	}

	/**
	 * @param vacationType
	 *            Vacation - 'CO', 'CF', 'CS', 'CM']
	 * @throws ParseException
	 * 
	 */
	@StepGroup
	public void newRequestStep(String vacationType, String message,
			boolean error) throws ParseException {
		chooseVacationType(vacationType);
		saveRequest();
		if (error) {
			checkErrorMessage(message);
		} else {
			checkMessage(message);
		}
		// withdrawRequest();
	}
}
