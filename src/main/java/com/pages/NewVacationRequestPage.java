package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author danapanican
 * 
 */
public class NewVacationRequestPage extends PageObject {

	@FindBy(css = ".carousel-slider.span3:nth-child(1) ul li:nth-child(2) a")
	private WebElement newVacationRequestMenu;

	@FindBy(css = "input[name='startDate']")
	private WebElement startDateInput;

	@FindBy(css = "input[name='endDate']")
	private WebElement endDateInput;

	@FindBy(css = ".vacationTypeChoice")
	private WebElement vacationTypeList;

	@FindBy(css = ".aui-button-input.aui-button-input-submit")
	private WebElement saveNewRequest;

	@FindBy(css = ".aui-button-input.aui-button-input-cancel")
	private WebElement cancelNewRequest;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_newVacationComment")
	private WebElement addComent;

	@FindBy(name = "commentContent")
	private WebElement contentComment;

	/**
	 * @param vacationType
	 *            ['CO', 'CF', 'CS', 'CM']
	 */
	public void selectVacationType(String vacationType) {
		WebElement element = getDriver().findElement(
				By.cssSelector("input[value='" + vacationType + "']"));
		element(element).waitUntilVisible();
		element.click();
	}

	public void clickNewVacation() {
		element(newVacationRequestMenu).waitUntilVisible();
		newVacationRequestMenu.click();
	}

	public void enterStartDate() {
		element(startDateInput).waitUntilVisible();
		startDateInput.click();
	}

	public void enterEndDate() {
		element(endDateInput).waitUntilVisible();
		endDateInput.click();
	}

	public void clickAddComment() {
		element(addComent).waitUntilVisible();
		addComent.click();
	}

	public void tapeComment(String com) {
		element(contentComment).waitUntilVisible();
		contentComment.sendKeys(com);
	}

	public void saveNewRequestButton() {
		saveNewRequest.click();
	}

}
