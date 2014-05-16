package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.WebElement;

public class LogInPage extends PageObject {

	@FindBy(css = "#sign-in")
	private WebElement signInButton;

	@FindBy(css = "#_58_login")
	private WebElement userNameField;

	@FindBy(css = "#_58_password")
	private WebElement passwordField;

	@FindBy(css = ".aui-button-input.aui-button-input-submit")
	private WebElement logInButton;

	@FindBy(css = "a[href*='new-vacation']")
	private WebElement newVacationMenu;

	 @FindBy(css = "a[href='/c/portal/logout']")
		private WebElementFacade logoutLink;
	
	
	 public void clickLogout() {
		 logoutLink.click();
		}
	
	// click on sign in
	public void clickSignIn() {
		element(signInButton).waitUntilVisible();
		signInButton.click();
	}

	public void inputUserName(String user) {
		element(userNameField).waitUntilVisible();
		userNameField.sendKeys(user);
	}

	public void inputPassword(String pass) {
		element(passwordField).waitUntilVisible();
		passwordField.sendKeys(pass);
	}

	public void clickLogIn() {
		element(logInButton).waitUntilVisible();
		logInButton.click();
	}

	public void clickNewVacationMenu() {
		element(newVacationMenu).waitUntilVisible();
		newVacationMenu.click();
	}

}
