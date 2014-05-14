package com.steps;

import net.thucydides.core.annotations.Step;

import com.pages.NewVacationRequestPage;

public class ChooseNewRequestMenuStep {
	
	NewVacationRequestPage newVacation;
	
	@Step
	public void chooseNewRequestMenu() {
		newVacation.clickNewVacation();
	}

}
