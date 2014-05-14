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

	@FindBy(css = ".vacationTypeChoice")
	private WebElement vacationTypeList;

	@FindBy(css = ".aui-button-input.aui-button-input-submit")
	private WebElement saveNewRequest;

	@FindBy(css = ".aui-button-input.aui-button-input-cancel")
	private WebElement cancelNewRequest;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_newVacationComment")
	private WebElement addComent;

//	@FindBy(css = "input[value='CO']")
//	private WebElement vacation;
//
//	@FindBy(css = "input[value='CF']")
//	private WebElement vacationWithoutPayment;
//
//	@FindBy(css = "input[value='CS']")
//	private WebElement vacationSpecial;
//
//	@FindBy(css = "input[value='CM']")
//	private WebElement vacationSick;

	@FindBy(name = "commentContent")
	private WebElement contentComment;

	/**
	 * @param vacationType ['CO', 'CF', 'CS', 'CM']
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

	public void enterStartDate(String startDate) {
		element(startDateInput).waitUntilVisible();
		startDateInput.sendKeys(startDate);
	}

	// public void selectAVacationType(String vacationType) {
	// boolean found = false;
	// List<WebElement> elements = getDriver().findElements(
	// By.cssSelector("div[class='vacationTypeChoice']"));
	// System.out.println(elements.size());
	// for (WebElement element : elements) {
	// System.out.println(element.getText());
	// if (element.getText().toLowerCase()
	// .contains(vacationType.toLowerCase()))
	// element.click();
	// found = true;
	// }
	//
	// Assert.assertTrue("The vacation type was not founded", found);
	//
	// }

//	public void selectAVacationType(String vacationType) {
//		String var;
//		switch (vacationType) {
//		case "Holiday":
//			var = "CO";
//		case "Vacation without payment":
//			var = "CF";
//		case "Special vacation":
//			var = "CS";
//		case "Sick leave":
//			var = "CM";
//			WebElement element = getDriver()
//					.findElement(
//							By.cssSelector(String
//									.format("#_evovacation_WAR_EvoVacationportlet_type_"
//											+ var)));
//			if (!(element.isSelected()))
//				element.click();
//			break;
//		}
//	}

	public void clickAddComment() {
		element(addComent).waitUntilVisible();
		addComent.click();
	}

	public void tapeComment(String com) {
		element(contentComment).waitUntilVisible();
		contentComment.sendKeys(com);
	}

	public void saveNewequestButton() {
		saveNewRequest.click();
	}

}
