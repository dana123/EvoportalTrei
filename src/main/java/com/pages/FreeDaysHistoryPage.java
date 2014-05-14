package com.pages;

import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}
