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

	/**
	 * @param vacationType
	 *            Vacation - 'CO', 'CF', 'CS', 'CM']
	 * @throws ParseException
	 * 
	 */
	@StepGroup
	public void newRequestStep(String vacationType)
			throws ParseException {
		chooseVacationType(vacationType);
		saveRequest();
	}
}
