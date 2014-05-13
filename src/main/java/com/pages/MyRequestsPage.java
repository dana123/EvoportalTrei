package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

public class MyRequestsPage extends PageObject {

	@FindBy(css = ".icon-book")
	private WebElement myRequestsLink;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_HOLIDAYCheckbox")
	private WebElement holidayCheckBox;

	public void clickMyRequestsPage() {
		element(myRequestsLink).waitUntilVisible();
		myRequestsLink.click();

	}

	public void clickHolidayCheckBox() {
		element(holidayCheckBox).waitUntilVisible();
		holidayCheckBox.click();

	}

}
