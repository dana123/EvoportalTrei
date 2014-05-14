package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import com.pages.NewVacationRequestPage;

public class NewRequestSteps {

	NewVacationRequestPage newVacation;

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
		newVacation.saveNewequestButton();
	}

//	@Step
//	public void addComment(String comment) {
//		newVacation.clickAddComment(comment);
//	}

	/**
	 * @param vacationType 
	 * 				Vacation - 'CO', 
	 * 				'CF', 'CS', 'CM']
	 * 	
	 */
	@StepGroup
	public void newRequestStep(String vacationType, String comment) {
		chooseNewRequestMenu();
		chooseVacationType(vacationType);
//		addComment(comment);
		 saveRequest();
	}
}