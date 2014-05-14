package com.steps;

import java.text.ParseException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import com.pages.CalendarPage;

public class CalendarSteps {

	CalendarPage calendar;

	@Step
	public void enterStartDate() {
		calendar.enterStartDate();
	}

	@Step
	public void setStartDate(int month, int day, int year)
			throws ParseException {
		calendar.setDate(month, day, year);
	}

	@Step
	public void enterEndDate() {
		calendar.enterEndDate();
	}

	@Step
	public void setEndDate(int month1, int day1, int year1)
			throws ParseException {
		calendar.setDate(month1, day1, year1);
	}

	/**
	 * @param vacationType
	 *            Vacation - 'CO', 'CF', 'CS', 'CM']
	 * @throws ParseException
	 * 
	 */
	@StepGroup
	public void setDateStep(int month, int day, int year, int month1,
			int day1, int year1)
			throws ParseException {
		enterStartDate();
		setStartDate(month, day, year);
		enterEndDate();
		setEndDate(month1, day1, year1);

	}

}
