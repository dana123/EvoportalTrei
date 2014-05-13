package com.steps;

import com.pages.DictionaryPage;
import com.pages.LogInPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.fest.assertions.Assertions.assertThat;

public class LogInSteps extends ScenarioSteps {

	DictionaryPage dictionaryPage;
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
	
	@StepGroup
	public void logIn(String user, String pass){
		clickSignIn();
		enterUserName(user);
		enterPassword(pass); 
		clickLogIn();
	}

}