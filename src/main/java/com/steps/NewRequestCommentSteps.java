package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import com.pages.CalendarPage;
import com.pages.NewVacationRequestPage;

public class NewRequestCommentSteps {

	NewVacationRequestPage newVacation;
	CalendarPage calendarPage;

//	@Step
//	public void chooseNewRequestMenu() {
//		newVacation.clickNewVacation();
//	}

	@Step
	public void chooseVacationType(String vacationType) {
		newVacation.selectVacationType(vacationType);

	}

	@Step
	public void addComment() {
		newVacation.clickAddComment();
	}
	
	@Step
	public void typeComment(String com) {
		newVacation.tapeComment(com);
	}

	@Step
	public void saveRequest() {
		newVacation.saveNewRequestButton();
	}

	@StepGroup
	public void newRequestComStep(String vacationType, String com) {
//		chooseNewRequestMenu();
		chooseVacationType(vacationType);
		addComment();
		typeComment(com);
		saveRequest();

	}
	
}
