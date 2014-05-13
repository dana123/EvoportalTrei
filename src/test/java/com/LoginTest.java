package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.LogInSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class LoginTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	LogInSteps logInSteps;

	@Test
	public void loginTest() {
		logInSteps.openPage();
		logInSteps.logIn("horatiuencian", "920X-p0U");

	}
}
