package com;

import java.text.ParseException;

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
import com.steps.NewRequestSteps;

@Story(Application.Authentication.LogIn.class)
@RunWith(ThucydidesRunner.class)
public class NewRequestTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	LogInSteps logInSteps;

	@Steps
	NewRequestSteps newRequestSteps;

	@Test
	public void newRequest() throws ParseException {
		logInSteps.logIn("horatiuencian", "920X-p0U");
		newRequestSteps.newRequestStep(4, 6, 2014, 4,7,2014, "CM", "neata");
	}
}
