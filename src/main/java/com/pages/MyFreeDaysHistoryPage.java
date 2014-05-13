package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("http://192.168.1.68:9080/home")
public class MyFreeDaysHistoryPage extends PageObject {

	@FindBy(css="#sign-in")
    private WebElementFacade signInButton;
	
	@FindBy(css="#_58_login")
    private WebElementFacade userNameField;
	
	@FindBy(css="#_58_password")
	private WebElementFacade passwordField;
	
	@FindBy(css="#aui_3_4_0_1_256")
	private WebElementFacade logInButton;
}
