package com.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.pages.DictionaryPage;

public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void starts_search_link() {
        dictionaryPage.link_to_second_page();
    }
    
    @Step
    public void should_see_definition(String definition) {
    	
    	List<String> temp = dictionaryPage.getDefinitions();
    	
    	boolean found = false;
    	for (String i : temp){
    		if (i.contains(definition)) {
    			found = true;
    			break;
    		}
    	}
    	
    	Assert.assertTrue(found);
//        assertThat(dictionaryPage.getDefinitions()).contains(definition);
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

//	public void scrollToPageBottom() {
//		dictionaryPage.evaluateJavascript("window.scrollTo(0,document.body.scrollHeight);");
//		
//	}
//	
//	public void scrollToPageMiddle() {
//		dictionaryPage.evaluateJavascript("window.scrollTo(0,document.body.scrollHeight/2);");
//		
//	}
}