package com.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tools.DateUtils;
import javax.mail.Folder;

/**
 * @author danapanican
 * 
 */
public class NewVacationRequestMailPage extends PageObject {

//	String currentDate;
	
	
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

	@FindBy(css = "a[href='/c/portal/logout']")
	private WebElementFacade logoutLink;

	@FindBy(css = ".carousel-slider a[href*='menuItem=inbox']")
	private WebElementFacade inboxLink;

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

	public void checkThatYouReceiveTheErrorMessage2(String message) {
		String elementText = getDriver()
				.findElement(
						By.cssSelector("#mainVacationContent >#createVacation form >.portlet-msg-error"))
				.getText().trim();
		if (!elementText.toLowerCase().contains(message.toLowerCase())) {
			Assert.fail(String.format(
					"Thef containerf does not contain message!", message));
			System.out.println(message);
		}
	}

	public void checkThatYouReceiveTheErrorMessage(String message) {
		String elementText = getDriver()
				.findElement(
						By.cssSelector(".portlet-body >.portlet-msg-error"))
				.getText().trim();
		if (!elementText.toLowerCase().contains(message.toLowerCase())) {
			Assert.fail(String.format(
					"Thef containerf does not contain message!", message));
			System.out.println(message);
		}
	}

	public void checkThatYouReceiveTheSuccesMessage(String message1) {
		String elementText = getDriver()
				.findElement(By.cssSelector(".portlet-msg-success")).getText()
				.trim();
		if (!elementText.toLowerCase().contains(message1.toLowerCase())) {
			Assert.fail(String.format(
					"Thef container does not contain message!", message1));
			System.out.println(message1);
		}
	}

	 public void checkErrorMessage(String error) {
	 saveNewRequest.getCssValue(error);
	 }

	public void saveNewRequestButton() {
		saveNewRequest.click();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//		Calendar cal = Calendar.getInstance();
//	    currentDate = dateFormat.format(cal.getTime()).toString();
//	    
		
	}
//github.com/dana123/EvoportalTrei.git
	public void withdrawRequestButton() {
		withdraw.click();
	}

	public String getVacationId() {
		String[] urlList = getDriver().getCurrentUrl().split("=");
		return urlList[urlList.length - 1];
	}

	public void goToRequest(String VacationId) {
		getDriver()
				.get("http://192.168.1.68:9080/web/lt/new-vacation?p_p_auth=nt6olSiz&p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_evovacation_WAR_EvoVacationportlet_menuItem=my-requests&_evovacation_WAR_EvoVacationportlet_myRequestState=view-vacation&_evovacation_WAR_EvoVacationportlet_backMenuItem=my-requests&_evovacation_WAR_EvoVacationportlet_vacationId="
						+ VacationId);
	}

	public void clickLogout() {
		logoutLink.click();
	}

	public void clickInbox() {
		inboxLink.click();
	}
}
