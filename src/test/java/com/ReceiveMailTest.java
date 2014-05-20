package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import tools.ReadMailSample;

import com.pages.CalendarPage;
import com.steps.CalendarSteps;
import com.steps.ChooseNewRequestMenuStep;
import com.steps.LogInSteps;
import com.steps.MyRequestsSteps;
import com.steps.NewRequestSteps;

@RunWith(ThucydidesRunner.class)
public class ReceiveMailTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/home")
	public Pages pages;

	@Steps
	MyRequestsSteps myRequestsSteps;

	@Steps
	CalendarPage RequestVacation;

	@Steps
	LogInSteps login;

	@Steps
	ChooseNewRequestMenuStep newRequestMenuSteps;

	@Steps
	CalendarSteps calendarStep;

	@Steps
	NewRequestSteps newRequestSteps;

	@Steps
	ReadMailSample mail;

	@Test
	public void testMailReceive() throws ParseException {

		
		int startDay = 17;
		int startMonth = 6;
		int startYear = 2014;
		int endDay = 26;
		int endMonth = 6;
		int endYear = 2014;
		login.logIn("alexandruduminciuc", "alexandru87");

		newRequestMenuSteps.chooseNewRequestMenu();
		calendarStep.setDateStep(startMonth, startDay, startYear, endMonth, endDay, endYear);
		newRequestSteps.chooseAVacationType("CO");
		newRequestSteps.saveRequest();
		try {
		    Thread.sleep(5000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		StringBuilder sd1 = new StringBuilder();
		sd1.append(startDay + "/" + startMonth + "/" + startYear + " " + endDay + "/" + endMonth + "/" + endYear);

		System.out.println(sd1);

		String dateIOI = sd1.toString();
		System.out.println(" DateIOI: " + dateIOI);
		mail.setUserName("alexandru.duminciuc@evozon.com");
		mail.setPassword("Duminciuc878@");
		String mailReturn = mail.readLastMail();
		System.out.println(" Mail returnat: " + mailReturn);
		if (dateIOI.contains(mailReturn)) {
			System.out.println("Datele sunt corecte");
		}
		newRequestSteps.withdrawRequest();

		// newRequestSteps.chooseAVacationType("CO");
		// newRequestSteps.saveRequest();

		// newRequestMenuSteps.chooseNewRequestMenu();
		// calendarStep.setDateStep(5,4,2014, 5,4,2014);
		// newRequestSteps.chooseVacationType("CO");
		// newRequestSteps.saveRequest();
		// newRequestMenuSteps.chooseNewRequestMenu();
		// calendarStep.setDateStep(16,4,2014, 23,4,2014);
		// newRequestSteps.chooseVacationType("CO");
		// newRequestSteps.saveRequest();
		// myRequestsSteps.filterMyRequests("Vacation Without Payment", "1 - 5",
		// "Withdrawn");
	}

}
