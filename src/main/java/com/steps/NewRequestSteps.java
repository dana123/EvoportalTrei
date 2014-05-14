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
		newVacation.selectAVacationType(vacationType);

	}

	@Step
	public void saveRequest() {
		newVacation.saveNewequestButton();
	}

	@StepGroup
	public void newRequestStep(String vacationType) {
		chooseNewRequestMenu();
		chooseVacationType(vacationType);
		saveRequest();
	}
}
