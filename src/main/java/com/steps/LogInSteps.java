package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.LogInPage;

public class LogInSteps extends ScenarioSteps {

	LogInPage logInPage;

	@Step
	public void clickSignIn() {
		logInPage.clickSignIn();

	}

	@Step
	public void openPage() {

		logInPage.open();
	}

	@Step
	public void enterUserName(String user) {
		logInPage.inputUserName(user);

	}

	@Step
	public void enterPassword(String pass) {
		logInPage.inputPassword(pass);
	}

	@Step
	public void clickLogIn() {
		logInPage.clickLogIn();
	}

	@Step
	public void clickNewVacationMenu() {
		logInPage.clickNewVacationMenu();
	}

	// github.com/dana123/EvoportalTrei.git
	@StepGroup
	public void logIn(String user, String pass) {
		openPage();
		clickSignIn();
		enterUserName(user);
		enterPassword(pass);
		clickLogIn();
		clickNewVacationMenu();

		// newRequestMenu();
		// github.com/dana123/EvoportalTrei.git
	}

	// @Step
	// public void newRequestMenu() {
	// logInPage.clickNewVacationMenu();
	// }
}
