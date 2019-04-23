package com.qaprosoft.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.gui.pages.LogInPage;

public class LogInMenu extends AbstractUIObject{
	
	@FindBy(xpath="//div[@class='auth-bar__item auth-bar__item--text']")
	private ExtendedWebElement logInLink;
	
	@FindBy(linkText="Facebook")
	private ExtendedWebElement facebookLink;
	
	@FindBy(linkText="ВКонтакте")
	private ExtendedWebElement vkLink;
	
	@FindBy(linkText="Google")
	private ExtendedWebElement gmailLink;
	

	public LogInMenu(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	
	public LogInPage openLogInLink() {
		logInLink.click();
		return new LogInPage(driver);
	}
	
	
	
	/*public  openVkLink() {
		vkLink.click();
		return new (driver);
	}
	
	public LogInPage openGmailLink() {
		gmailLink.click();
		return new (driver);
	}*/

}
