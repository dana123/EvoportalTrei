package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
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

	@FindBy(css = ".portlet-msg-success")
	private WebElement succesMessage;

	@FindBy(css = ".portlet-msg-error:nth-child(1)")
	private WebElement errorMessage;

	@FindBy(css = ".aui-button-input")
	private WebElement withdraw;
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

	// public void checkThatYouReceiveTheErrorMessage(String message) {
	//
	// }
	public void checkThatYouReceiveTheErrorMessage2(String message) {
		String elementText = getDriver()
				.findElement(
						By.cssSelector("#mainVacationContent >#createVacation form >.portlet-msg-error"))
				.getText().trim();
		if (!elementText.toLowerCase().contains(message.toLowerCase())) {
			Assert.fail(String.format("Thef containerf does not contain message!",
					message));
			System.out.println(message);
		}
	}
	public void checkThatYouReceiveTheErrorMessage(String message) {
		String elementText = getDriver()
				.findElement(
						By.cssSelector(".portlet-body >.portlet-msg-error"))
						.getText().trim();
		if (!elementText.toLowerCase().contains(message.toLowerCase())) {
			Assert.fail(String.format("Thef containerf does not contain message!",
					message));
			System.out.println(message);
		}
	}
	public void checkThatYouReceiveTheSuccesMessage(String message1) {
		String elementText = getDriver()
				.findElement(
						By.cssSelector(".portlet-msg-success"))
						.getText().trim();
		if (!elementText.toLowerCase().contains(message1.toLowerCase())) {
			Assert.fail(String.format("Thef container does not contain message!",
					message1));
			System.out.println(message1);
		}
	}

//	public void checkErrorMessage(String error) {
//		saveNewRequest.getCssValue(error);
//	}

	public void saveNewRequestButton() {
		saveNewRequest.click();
	}
	public void withdrawRequestButton() {
		withdraw.click();
	}
}
