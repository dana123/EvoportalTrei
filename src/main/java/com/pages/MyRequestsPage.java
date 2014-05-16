package com.pages;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	@FindBy(css = "table.taglib-search-iterator tr.results-row")
	private WebElement row;

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

	public void selectAVacationStatus(String... terms) {

		String var = null;
		for (String status : terms) {

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
			case "1 - 5":
				var = "FIFTHCheckbox";
				break;
			case "6 - 10":
				var = "TENTHCheckbox";
				break;
			case "11 - 20":
				var = "TWENTIETHCheckbox";
				break;
			case "21 - 50":
				var = "FIFTIETHCheckbox";
				break;
			case "51 +":
				var = "RESTCheckbox";
				break;
			case "Holiday":
				var = "HOLIDAYCheckbox";
				break;
			case "Vacation Without Payment":
				var = "VACATION_WITHOUT_PAYMENTCheckbox";
				break;
			case "Special Vacation":
				var = "SPECIAL_VACATIONCheckbox";
				break;
			case "Sick Leave":
				var = "SICK_LEAVECheckbox";
				break;

			}
			WebElement element = getDriver().findElement(
					By.cssSelector(String
							.format("#_evovacation_WAR_EvoVacationportlet_"
									+ var)));

			if (!(element.isSelected()))
				System.out.println(element);
			element.click();
		}
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

	public void verifySearchResultsContainsItem(String... terms) {
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"))
				.getText().trim();
		System.out.println(noOfPagesContainer);
		int noOfPages = tools.StringUtils.getAllIntegerNumbersFromString(
				noOfPagesContainer).get(1);
		System.out.println(noOfPages);
		for (int i = 0; i < noOfPages; i++) {
			List<WebElement> searchResults = getDriver().findElements(By.cssSelector("table.taglib-search-iterator"));
			System.out.println("size: " + searchResults.size());

			for (WebElement searchResult : searchResults) {
				System.out.println("element text: " + searchResult.getText());

				if ($(searchResult).isCurrentlyVisible()) {
					for (String term : terms) {

						if (term.contains("-")) {
							String daysRange = term;
							System.out.println(daysRange);
							daysRange.trim();
							System.out.println(" " + daysRange);
							int lowLimit = tools.StringUtils
									.getAllIntegerNumbersFromString(daysRange)
									.get(0);
							int highLimit = tools.StringUtils
									.getAllIntegerNumbersFromString(daysRange)
									.get(1);
							String days = searchResult.findElement(
									By.cssSelector("td:nth-child(3)"))
									.getText();
							int dayNo = Integer.parseInt(days);
							System.out.println(dayNo);
							if (!(dayNo >= lowLimit && dayNo <= highLimit)) {
							} else {

								if (!searchResult.getText().toLowerCase()

								.contains(term.toLowerCase())) {
									Assert.fail(String
											.format("The '%s' search result item does not contain '%s'!",
													searchResult.getText(),
													term));
								}
							}
						}
					}
				}
				if (i < noOfPages - 1) {
					getDriver()
							.findElement(
									By.cssSelector("div.page-links > a.aui-paginator-link.aui-paginator-next-link"))
							.click();
					waitFor(ExpectedConditions
							.textToBePresentInElement(
									By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"),
									String.format("(%d of %d)", i + 2,
											noOfPages)));
					waitABit(2000);
				}

			}

			// boolean foundInTable = true;
			// List<WebElement> tableElements = getDriver()
			// .findElements(
			// By.cssSelector("td[class*='col-my.request.column.header.status'] a[href*='vacationId']"));
			// for (WebElement tableElement : tableElements) {
			// if
			// (!(tableElement.getText().toString().equalsIgnoreCase(status))) {
			// foundInTable = false;
			// break;
			// }
			// Assert.assertTrue("The filter is not working", foundInTable);

			// }
		}
	}
}
