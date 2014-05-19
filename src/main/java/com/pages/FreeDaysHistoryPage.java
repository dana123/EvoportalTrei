package com.pages;

// Author Encian Horatiu
import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FreeDaysHistoryPage extends PageObject {

	String var;

	@FindBy(css = ".nav-list a[href*='menuItem=free-days-history']")
	private WebElement freeDaysHistoryButton;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_applyButton")
	WebElement applyFilters;

	// got to history days page
	public void clickFreeDaysHistoryMenu() {
		freeDaysHistoryButton.click();
	}

	// Select the filters
	public void selectAFilterType(String vacationType) {
		switch (vacationType) {
		case "Anniversary":
			var = "BONUS_EVOZONCheckbox";
			break;
		case "Extra Days":
			var = "EXTRA_DAYSCheckbox";
			break;
		case "Vacation days":
			var = "COCheckbox";
			break;
		case "Vacation Without Payment":
			var = "CFCheckbox";
			break;
		case "11 - 20":
			var = "TWENTIETHCheckbox";
			break;
		case "Added Days":
			var = "ADDED_DAYSCheckbox";
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

	// apply the filters
	public void clickOnApplyFilters() {
		applyFilters.click();
		waitABit(1000);
	}

	// check if free days history table exists
	public void checkIfHistoryTableExists() {
		WebElement element = getDriver().findElement(
				By.cssSelector(".lfr-search-container"));
		boolean isDisplayed = false;

		if (element.isDisplayed()) {
			isDisplayed = true;
		}
		Assert.assertTrue("Table is not displayed", isDisplayed);
	}

	// Check's if the filters are working properly
	public void verifySearchResultsContainsItem(String... terms) {
		boolean found = false;

		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"))
				.getText().trim();

		int noOfPages = tools.StringUtils.getAllIntegerNumbersFromString(
				noOfPagesContainer).get(1);

		System.out.println(noOfPages);

		for (int i = 0; i < noOfPages; i++) {
			List<WebElement> searchResults1 = getDriver().findElements(
					By.cssSelector(".portlet-section-body.results-row"));

			List<WebElement> searchResults3 = getDriver()
					.findElements(
							By.cssSelector(".portlet-section-alternate.results-row.alt"));

			List<WebElement> searchResults = new ArrayList<WebElement>();
			searchResults.addAll(searchResults1);
			searchResults.addAll(searchResults3);

			for (WebElement searchResult : searchResults) {
				System.out.println(searchResult.getText());
			}

			for (WebElement searchResult : searchResults) {
				boolean containsTerms = true;
				System.out.println(searchResult.getText());
				// $(searchResult).waitUntilVisible();

				for (String term : terms) {
					if (searchResult.getText().toLowerCase()
							.contains(term.toLowerCase())) {

						containsTerms = false;
						System.out.println(term + " element found");
						System.out
								.println("THE ELEMENT WAS FOUND!!!!!!!!!!!!!!!!!");
						

					}
					// } It might not be well here must see again
					if (containsTerms) {
						found = true;
						System.out.println(term + " element not found");

					}
				}
			}

			if (i < noOfPages - 1 && !found) {
				getDriver()
						.findElement(
								By.cssSelector("div.page-links > a.aui-paginator-link.aui-paginator-next-link"))
						.click();
				// waitFor(ExpectedConditions
				// .textToBePresentInElement(
				// By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"),
				// String.format("(%d of %d)", i + 2, noOfPages)));
				waitABit(2000);
			}
			// else{
			//
			// break;
			// }
		}
		Assert.assertTrue("Element was not found!", found);
	}

}
