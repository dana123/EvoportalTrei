package com.pages;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("")
public class AssignedToMePage extends PageObject {

	@FindBy(css = "a[href='http://192.168.1.68:9080/web/lt/new-vacation']")
	private WebElementFacade newVacationLink;

	@FindBy(css = ".carousel-slider a[href*='menuItem=inbox']")
	private WebElementFacade inboxLink;

	@FindBy(css = ".aui-button:nth-child(1).aui-button input")
	private WebElementFacade approveButton;

	@FindBy(css = ".aui-button:nth-child(3).aui-button input")
	private WebElementFacade rejectButton;

	@FindBy(css = "td[class='align-left col-2 col-employee-name  valign-middle']")
	private WebElementFacade requestLink;

	@FindBy(name = "_evovacation_WAR_EvoVacationportlet_allRowIds")
	private WebElementFacade checkboxAllRequests;

	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_multipleApproveButton")
	private WebElementFacade multipleApproveButton;

	//@FindBy(css = "._evovacation_WAR_EvoVacationportlet_multipleRejectButton:nth-child(1)")
	@FindBy(css = ".aui-button-input#_evovacation_WAR_EvoVacationportlet_multipleRejectButton")
	private WebElementFacade multipleRejectButton;
	
	 @FindBy(css=".aui-button.aui-button-submit >.aui-button-content input")               
	 private WebElement save;
	 
//	 @FindBy(css = "a[href='/c/portal/logout']")
//		private WebElementFacade logoutLink;
	 
//	 public void clickLogout() {
//		 logoutLink.click();
//		}

		
	public void clickApproveButton() {
		approveButton.click();
	}

	public void clickRejectButton() {
		rejectButton.click();
	}

	public void clickInbox() {
		inboxLink.click();
	}

	public void clickNewVacation() {
		newVacationLink.click();
	}

	public void checkAllRequests() {
		checkboxAllRequests.click();
	}

	public void clickApprovAllRequests() {
		multipleApproveButton.click();
	}
	public void clickRejectAllRequests() {
		multipleRejectButton.click();
		}
	 public void clickSave(){
		   element(save).waitUntilVisible();
		   save.click();}
	public String getVacationId(){
		  String url = getDriver().getCurrentUrl();
		  String[] valueList = url.split("=");
		  return  valueList[valueList.length-1];
		 }
	public void verifyIfRequestIsInTheTableList(String vacationId){
		  getDriver().findElement(By.cssSelector("a[href*=vacation="+vacationId+"']")).click();
		 }

	public void goThrowPages() {
		  String noOfPagesContainer = getDriver()
		    .findElement(
		      By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"))
		    .getText().trim();
		  
		  waitABit(3000);

		  int noOfPages = tools.StringUtils.getAllIntegerNumbersFromString(
		    noOfPagesContainer).get(1);
		  for (int i = 0; i < noOfPages; i++) {
		   if (i < noOfPages - 1 ) {
		    getDriver()
		      .findElement(
		        By.cssSelector("div.page-links > a.aui-paginator-link.aui-paginator-next-link"))
		      .click();
		   
		  waitABit(3000);
		   }}}
	

	public static List<Integer> getAllIntegerNumbersFromString(String text) {
		List<Integer> listOfIntegers = new ArrayList<Integer>();
		String intNumber = "";
		char[] characters = text.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			char ch = characters[i];
			if (Character.isDigit(ch)) {
				intNumber += ch;
				if (i == characters.length - 1) {
					listOfIntegers.add(Integer.parseInt(intNumber));
				}
			} else {
				if (intNumber != "") {
					listOfIntegers.add(Integer.parseInt(intNumber));
					intNumber = "";
				}
			}
		}
		Assert.assertTrue(
				"No matching integer was found in the provided string!",
				listOfIntegers.size() > 0);
		System.out.println(listOfIntegers.size());
		return listOfIntegers;
	}

	public void clickOnAnEmployeeLink(String... employeeName) {
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector("span[class='aui-paginator-current-page-report aui-paginator-total']"))
				.getText().trim();
		int noOfPages = getAllIntegerNumbersFromString(noOfPagesContainer).get(
				2);
		System.out.println(noOfPages);
		boolean foundTerms = false;
		for (int i = 0; i < noOfPages; i++) {
			List<WebElement> searchResults = getDriver()
					.findElements(
							By.cssSelector("td[class='align-left col-2 col-employee-name  valign-middle'] > a"));
			for (WebElement searchResult : searchResults) {
				boolean containsTerms = true;
				$(searchResult).waitUntilVisible();
				for (String term : employeeName) {
					if (!searchResult.getText().toLowerCase()
							.contains(term.toLowerCase())) {
						containsTerms = false;
						break;
					}
				}
				if (containsTerms) {
					foundTerms = true;
					searchResult.click();
					waitABit(2000);
					break;
				}
			}
		
			if (i < (noOfPages - 1) && !foundTerms) {
				getDriver()
						.findElement(
								By.cssSelector("span[class='aui-paginator-link aui-paginator-next-link']"))
						.click();
			} else
				break;
		}
		Assert.assertTrue(
				"No record containing the searched terms was found in the table!",
				foundTerms);
	}

	public void openRequest(String requestID) {
		getDriver().findElement(
				By.cssSelector("a[href*='vacationId=" + requestID + "']"))
				.click();

	}
}
