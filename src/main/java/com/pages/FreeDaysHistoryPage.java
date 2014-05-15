package com.pages;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

public class FreeDaysHistoryPage extends PageObject {

	@FindBy(css = ".nav-list a[href*='menuItem=free-days-history']")
	private WebElement freeDaysHistoryButton;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_applyButton")
	WebElement applyFilters;

	
	// got to history days page
	public void clickFreeDaysHistoryMenu() {
		freeDaysHistoryButton.click();
	}

	// apply the filters
	public void clickOnApplyFilters() {
		applyFilters.click();
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
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"))
				.getText().trim();
		
		int noOfPages = tools.StringUtils.getAllIntegerNumbersFromString(noOfPagesContainer).get(1);
				
		
		for (int i = 0; i < noOfPages; i++) {
			List<WebElement> searchResults = getDriver().findElements(By.cssSelector("table.taglib-search-iterator tr.results-row"));
					
				
			for (WebElement searchResult : searchResults) {
				if ($(searchResult).isCurrentlyVisible()) {
					for (String term : terms) {
						if (!searchResult.getText().toLowerCase()
								.contains(term.toLowerCase())) {
							Assert.fail(String
									.format("The '%s' search result item does not contain '%s'!",
											searchResult.getText(), term));
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
								String.format("(%d of %d)", i + 2, noOfPages)));
				waitABit(2000);
			}
		}
	}

}
