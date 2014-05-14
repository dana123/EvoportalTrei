package com.steps;

import java.text.ParseException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import com.pages.CalendarPage;
import com.pages.NewVacationRequestPage;

public class NewRequestErrorSteps {

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
		newVacation.checkThatYouReceiveTheErrorMessage(message);
	}

	/**
	 * @param vacationType
	 *            Vacation - 'CO', 'CF', 'CS', 'CM']
	 * @throws ParseException
	 * 
	 */
	@StepGroup
	public void newRequestStep(String vacationType, String message)
			throws ParseException {
		chooseVacationType(vacationType);
		saveRequest();
		checkMessage(message);
	}
}
