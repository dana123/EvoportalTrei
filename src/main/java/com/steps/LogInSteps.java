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
	public void openPage(){
		
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
	public void clickNewVacation(){
		logInPage.clickNewVacationMenu();
	}
	
	@StepGroup
	public void logIn(String user, String pass){
		clickSignIn();
		enterUserName(user);
		enterPassword(pass); 
		clickLogIn();
		clickNewVacation();
	}
	

}