package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pages.FreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class FreeDaysHistorySteps extends ScenarioSteps {

	String var;
	FreeDaysHistoryPage freeDaysHistoryPage;

	@Step
	public void clickFreeDaysHistoryMenu() {
		freeDaysHistoryPage.clickFreeDaysHistoryMenu();
	}

	@Step
	public void selectCheckButton(String... terms) {
		freeDaysHistoryPage.clickOnCheckButton(terms);
	}

	@Step
	public void clickOnApplyFilters() {
		freeDaysHistoryPage.clickOnApplyFilters();
	}

	@Step
	public void clickAniversaryCheckBox() {
		freeDaysHistoryPage.clickAniversaryCheckBox();
	}

	@Step
	public void selectAFilterType(String vacationType) {
		switch (vacationType) {
		case "Anniversary":
			var = "BONUS_EVOZONCheckbox";
			break;
		case "Extra Days":
			var = "EXTRA_DAYSCheckbox";
			break;
		case "Vacation days":
			var = "COCheckbox";
			break;
		case "Vacation Without Payment":
			var = "CFCheckbox";
			break;

		}
		WebElement element = getDriver().findElement(By.cssSelector(String.format("#_evovacation_WAR_EvoVacationportlet_"+ var)));
		
		if (!(element.isSelected()))
			System.out.println(element);
		element.click();
	}

	
}
