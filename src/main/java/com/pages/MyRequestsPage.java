package com.pages;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyRequestsPage extends PageObject {

	@FindBy(css = ".icon-book")
	private WebElement myRequestsLink;

	@FindBy(css="#_evovacation_WAR_EvoVacationportlet_HOLIDAYCheckbox")
	private WebElement holidayCheckBox;

	@FindBy(css="#_evovacation_WAR_EvoVacationportlet_VACATION_WITHOUT_PAYMENTCheckbox")
	private WebElement vacationWithoutPayment;
	
	@FindBy(css="#_evovacation_WAR_EvoVacationportlet_FIFTHCheckbox")
	private WebElement onefiveCheckBox;
	
	@FindBy(css="#_evovacation_WAR_EvoVacationportlet_applyButton")
	private WebElement applyFilterButton;
	
	@FindBy(css=".taglib-search-iterator")
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
	
	public void clickApplyFilterButton() {
		element(applyFilterButton).waitUntilVisible();
		applyFilterButton.click();

	}
	public void checkOneFiveDaysFilter(){
		element(onefiveCheckBox).waitUntilVisible();
		onefiveCheckBox.click();
	}
	
	public boolean checkIfRequestsTableExists(){
		WebElement element = getDriver().findElement(By.cssSelector("span[class='aui-paginator-current-page-report aui-paginator-total']"));
		boolean elementIsDisplayed =  element.isDisplayed();
		Assert.assertTrue("Table is not displayed", elementIsDisplayed);
		return elementIsDisplayed;
	}
	
	

}
