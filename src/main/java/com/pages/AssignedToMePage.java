package com.pages;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import tools.ReadPmMailSample;

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
	
	
	
	
	
	
	
	Properties properties = null;
    private Session session = null;
    private Store store = null;
    private Folder inbox = null;
    private String userName = "evoportal.pm3@evozon.com";// provide user name
    private String password = ":gW.343F!8Q..";// provide password
    public String alfa;
    
    
	 public void readLastMail(){
		  
		  int contentInteger;
		  String subject;
		  String subjectText ="You have submitted a new Vacation Request";
		  String StartDate;
		  String ContentStartDate;
		 
		  String EndDate;
		  
		  properties = new Properties();
	      properties.setProperty("mail.host", "mail.evozon.com");
	      properties.setProperty("mail.port", "993");
	      properties.setProperty("mail.transport.protocol", "imaps");
	      session = Session.getInstance(properties,
	              new javax.mail.Authenticator() {
	                  protected PasswordAuthentication getPasswordAuthentication() {
	                      return new PasswordAuthentication(userName, password);
	                  }
	              });
	      try {
	          store = session.getStore("imaps");
	          store.connect();
	          inbox = store.getFolder("INBOX");
	          inbox.open(Folder.READ_ONLY);
	         
	          Message messages[] = inbox.search(new FlagTerm(
	                  new Flags(Flag.SEEN), false));
	          ;
	          System.out.println("Number of mails = " + messages.length);
	         
	              Message message = messages[messages.length-1];
	              Address[] from = message.getFrom();
	              System.out.println("-------------------------------");
	              System.out.println("Date : " + message.getSentDate());
	              System.out.println("From : " + from[0]);
	              System.out.println("Subject: " + message.getSubject());
	              subject = message.getSubject();
//	              System.out.println("Subject is: " + subject);
	              System.out.println("Content :");
	              processMessageBody(message);
	              
	              
	              System.out.println("--------------------------------");
//	              System.out.println(content);

	              
//	              DE AICI E FACUT SA VEDEM DACA E BINE
//	              START DATE STRING
	              StringBuilder sb1 = new StringBuilder();
	              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(0);
	              sb1.append(contentInteger);
	              sb1.append("/");
	              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(1);
	              sb1.append(contentInteger);
	              sb1.append("/");
	              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(2);
	              sb1.append(contentInteger);
	              
	              System.out.println(sb1);
	              
//	              END DATE STRING
	              StringBuilder sb2 = new StringBuilder();
	              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(3);
	              sb2.append(contentInteger);
	              sb2.append("/");
	              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(4);
	              sb2.append(contentInteger);
	              sb2.append("/");
	              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(5);
	              sb2.append(contentInteger);
	              
	              System.out.println(sb2);
	              
	              
	              
	          if(subject.toLowerCase().trim().equals(subjectText.toLowerCase().trim())){
	        	  System.out.println("Subject is good");
	        	  
	        	
	        		  
	        	  
	        	  
	          }
	              
	              
	              
	          inbox.close(true);
	          store.close();
	      } catch (NoSuchProviderException e) {
	          e.printStackTrace();
	      } catch (MessagingException e) {
	          e.printStackTrace();
	      }
	      
	      
	     
	  }
	  
	  
	  public void checkContent(){
	//
	  }
	      
	          

	 public void processMessageBody(Message message) {
	        try {
	            Object content = message.getContent();
	            // check for string
	            // then check for multipart
	            if (content instanceof String) {
	                System.out.println(content);
	                alfa = (String) content;
	            } else if (content instanceof Multipart) {
	                Multipart multiPart = (Multipart) content;
	                procesMultiPart(multiPart);
	            } else if (content instanceof InputStream) {
	                InputStream inStream = (InputStream) content;
	                int ch;
	                while ((ch = inStream.read()) != -1) {
	                    System.out.write(ch);
	                }
	 
	            }
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	 public void procesMultiPart(Multipart content) {
		 
	        try {
	            int multiPartCount = content.getCount();
	            for (int i = 0; i < multiPartCount; i++) {
	                BodyPart bodyPart = content.getBodyPart(i);
	                Object o;
	 
	                o = bodyPart.getContent();
	                if (o instanceof String) {
	                    System.out.println(o);
	                } else if (o instanceof Multipart) {
	                    procesMultiPart((Multipart) o);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
}}