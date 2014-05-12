package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.EndUserSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)

public class SearchKeywordLinkTest {

	String keyword, definition;

	@Qualifier
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Test
	public void searching_by_keyword_apple_should_display_the_corresponding_article() {
		endUser.is_the_home_page();
		endUser.looks_for("pear");
		// endUser.scrollToPageMiddle();
		endUser.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
		endUser.starts_search_link();
		endUser.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

	}

}