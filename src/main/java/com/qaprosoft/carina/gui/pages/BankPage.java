package com.qaprosoft.carina.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class BankPage extends AbstractPage {

	@FindBy(xpath="//span[@class='text'and contains(text(),'Доллар США')]//..//..//..//td[@class='curCours align-right']/descendant::div")
	private ExtendedWebElement trueRateNBRB;

	public BankPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://nbrb.by/statistics/rates/ratesdaily.asp");
	}
	
	public String getTrueRateNBRB() {
		return trueRateNBRB.getElement().getText();
	}

}
