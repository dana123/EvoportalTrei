package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.spi.Elements;

public class MyRequestsPage extends PageObject {

	@FindBy(css = ".icon-book")
	private WebElement myRequestsLink;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_HOLIDAYCheckbox")
	private WebElement holidayCheckBox;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_VACATION_WITHOUT_PAYMENTCheckbox")
	private WebElement vacationWithoutPayment;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_FIFTHCheckbox")
	private WebElement onefiveCheckBox;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_PENDINGCheckbox")
	private WebElement pendingCheckBox;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_applyButton")
	private WebElement applyFilterButton;

	@FindBy(css = ".taglib-search-iterator")
	private WebElement requestsTable;

	public void clickMyRequestsPage() {
		element(myRequestsLink).waitUntilVisible();
		myRequestsLink.click();

	}

	public void clickHolidayCheckBox() {
		element(holidayCheckBox).waitUntilVisible();
		holidayCheckBox.click();

	}

	public void clickVacationWithoutPayment() {
		element(vacationWithoutPayment).waitUntilVisible();
		vacationWithoutPayment.click();

	}

	public void clickPendingCheckBox() {
		element(pendingCheckBox).waitUntilVisible();
		pendingCheckBox.click();

	}

	public void clickApplyFilterButton() {
		element(applyFilterButton).waitUntilVisible();
		applyFilterButton.click();

	}

	public void checkOneFiveDaysFilter() {
		element(onefiveCheckBox).waitUntilVisible();
		onefiveCheckBox.click();
	}

	public boolean checkIfRequestsTableExists() {
		WebElement element = getDriver()
				.findElement(
						By.cssSelector("span[class='aui-paginator-current-page-report aui-paginator-total']"));
		boolean elementIsDisplayed = element.isDisplayed();
		Assert.assertTrue("Table is not displayed", elementIsDisplayed);
		return elementIsDisplayed;
	}

	public void selectAVacationStatus(String status) {

		String var = null;
		switch (status) {
		case "Pending":
			var = "PENDINGCheckbox";
			break;
		case "Approved":
			var = "APPROVEDCheckbox";
			break;
		case "Rejected":
			var = "REJECTEDCheckbox";
			break;
		case "Withdrawn":
			var = "WITHDRAWNCheckbox";
			break;
		case "Canceled":
			var = "CANCELEDCheckbox";
			break;

		}
		WebElement element = getDriver()
				.findElement(
						By.cssSelector(String
								.format("#_evovacation_WAR_EvoVacationportlet_"
										+ var)));

		if (!(element.isSelected()))
			System.out.println(element);
		element.click();
	}

	// boolean found = false;
	// List<WebElement> elements = getDriver()
	// .findElements(
	// By.cssSelector("div[class='aui-column-content  aui-column-content-last column-three-content column-center-content '] div[class='column-content'] label"));
	// for (WebElement element : elements) {
	// System.out.println(element.getCssValue("value") + " " + found);
	// if ((element.getText()).toString().equalsIgnoreCase((status)))
	// {
	// found = true;
	// element.click();
	// System.out.println(" "+found);
	// break;
	// }
	// }
	// Assert.assertTrue("The checkbox was not found", found);

	public void verifyIfTheFilteredTableContainsAVacationsWithOtherStatusThanFilter(
			String status) {

		boolean foundInTable = true;
		List<WebElement> tableElements = getDriver()
				.findElements(
						By.cssSelector("td[class*='col-my.request.column.header.status'] a[href*='vacationId']"));
		for (WebElement tableElement : tableElements) {
			if (!(tableElement.getText().toString().equalsIgnoreCase(status))) {
				foundInTable = false;
				break;
			}
			Assert.assertTrue("The filter is not working", foundInTable);

		}
	}
}
