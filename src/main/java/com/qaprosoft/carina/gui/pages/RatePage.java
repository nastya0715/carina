package com.qaprosoft.carina.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class RatePage extends AbstractPage{
	
	@FindBy(xpath="//b[text()='1 USD']//..//..//..//td//p[@class='value fall']/descendant::b")
	private ExtendedWebElement rateNBRB;

	public RatePage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://kurs.onliner.by/");
	}

	public String getOnlinerRate() {
		return rateNBRB.getElement().getText();
	}

	public BankPage getTrueRate() {
		return new BankPage(driver);
	}
}
