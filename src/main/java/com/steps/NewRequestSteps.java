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
	public void chooseNewRequestMenu() {
		newVacation.clickNewVacation();
	}

	@Step
	public void chooseVacationType(String vacationType) {
		newVacation.selectVacationType(vacationType);

	}

	@Step
	public void saveRequest() {
		newVacation.saveNewRequestButton();
	}

	@Step
	public void enterStartDate() {
		newVacation.enterStartDate();
	}

	@Step
	public void setStartDate(int month, int day, int year)
			throws ParseException {
		calendar.setDate(month, day, year);
	}
	
	@Step
	public void enterEndDate() {
		newVacation.enterEndDate();
	}
	
	@Step
	public void setEndDate(int month1, int day1, int year1)
			throws ParseException {
		calendar.setDate(month1, day1, year1);
	}

	// @Step
	// public void addComment(String comment) {
	// newVacation.clickAddComment(comment);
	// }

	/**
	 * @param vacationType
	 *            Vacation - 'CO', 'CF', 'CS', 'CM']
	 * @throws ParseException
	 * 
	 */
	@StepGroup
	public void newRequestStep(int month, int day, int year, int month1, int day1, int year1,
			String vacationType, String comment) throws ParseException {
		chooseNewRequestMenu();
		enterStartDate();
		setStartDate(month, day, year);
		enterEndDate();
		setEndDate(month1, day1, year1);
		chooseVacationType(vacationType);
		saveRequest();
	}
}
