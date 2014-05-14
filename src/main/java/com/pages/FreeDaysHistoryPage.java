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

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_BONUS_EVOZONCheckbox")
	private WebElement aniversaryCheckBox;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_COCheckbox")
	private WebElement vacationDaysCheckBox;

	// vacation without-payemnt
	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_CFCheckbox")
	private WebElement vwpCheckBox;
	// 1-5

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_FIFTHCheckbox")
	private WebElement oneToFive;

	// 21-50
	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_FIFTIETHCheckbox")
	private WebElement twentyOneToFiftenCheckBox;

	// all vacation Types
	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_historyTypeALLCheckbox")
	private WebElement allVacationCheckBox;

	// all days number
	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_historyDaysALLCheckbox")
	private WebElement allNumberCheckBox;

	// removed days
	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_REMOVED_DAYSCheckbox")
	private WebElement removedDaysCheckBox;

	@FindBy(id = "_evovacation_WAR_EvoVacationportlet_applyButton")
	WebElement applyFilters;

	public void clickFreeDaysHistoryMenu() {
		freeDaysHistoryButton.click();
	}

	public void clickAniversaryCheckBox(){
		element(aniversaryCheckBox).waitUntilVisible();
		aniversaryCheckBox.click();
	} 
	
	
	

	public void clickOnCheckButton(String... terms) {
		String checkBoxContainer = getDriver()
				.findElement(By.cssSelector(".filter-content-history"))
				.getText().trim();
		System.out.println(checkBoxContainer.toString());

		List<WebElement> searchResults = getDriver().findElements(
				By.cssSelector(".aui-field-contente"));

		System.out.println(searchResults.size());
		for (WebElement searchResult : searchResults) {

			System.out.println(searchResult.getText());
			boolean foundRow = true;
			if ($(searchResult).isPresent()) {
				for (String term : terms) {
					if (!searchResult.getText().toLowerCase()
							.contains(term.toLowerCase())) {
						foundRow = false;
						searchResult.findElement(By
								.cssSelector(".aui-field-content"));
						// searchResult.findElement(By.cssSelector(".aui-field-element.aui-field-label-right input:nth-child(2)")).click();;

					}
				}
			}

		}

	}

	// public void selectCheckButton(String... terms) {
	// System.out.println("x");
	// WebElement element = getTheSearchedCheckButton(terms);
	// System.out.println("y");
	// System.out.println(element.getText());
	// WebElement checkButton = element.findElement(By
	// .cssSelector(".aui-choice-label"));
	//
	// System.out.println(checkButton.getText());
	// System.out.println("z");
	// if (element != null) {
	// checkButton.click();
	// } else {
	// Assert.fail("The checkButton was not found!!!!");
	// }
	// }

	public void clickOnApplyFilters() {
		applyFilters.click();
	}
}
