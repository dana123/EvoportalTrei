package com.pages;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewVacationRequestPage extends PageObject {

	@FindBy(css = ".carousel-slider.span3:nth-child(1) ul li:nth-child(2) a")
	private WebElement newVacationRequestMenu;

	@FindBy(css = "input[name='startDate']")
	private WebElement startDateInput;

	@FindBy(css = ".vacationTypeChoice")
	private WebElement vacationTypeList;
	
	@FindBy( css= ".aui-button-input.aui-button-input-submit")
	private WebElement saveNewRequest;
	
	@FindBy( css= ".aui-button-input.aui-button-input-cancel")
	private WebElement cancelNewRequest;
	
	public void clickNewVacation() {
		element(newVacationRequestMenu).waitUntilVisible();
		newVacationRequestMenu.click();
	}

	public void enterStartDate(String startDate) {
		element(startDateInput).waitUntilVisible();
		startDateInput.sendKeys(startDate);
	}

	public void selectAVacationType(String vacationType) {
		boolean found = false;
		List<WebElement> elements = getDriver().findElements(
				By.cssSelector("div[class='vacationTypeChoice']"));
		System.out.println(elements.size());
		for (WebElement element : elements) {
			System.out.println(element.getText());
			if (element.getText().toLowerCase()
					.contains(vacationType.toLowerCase()))
				element.click();
			found = true;
		}

		Assert.assertTrue("The vacation type was not founded", found);

	}
	
	public void saveNewequestButton(){
		saveNewRequest.click();
	}

}
