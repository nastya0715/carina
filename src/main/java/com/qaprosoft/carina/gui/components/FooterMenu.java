package com.qaprosoft.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class FooterMenu extends AbstractUIObject {

	public FooterMenu(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	
	@FindBy(linkText="Mobile Phones")
	private ExtendedWebElement mobilePhoneLink;
	
	@FindBy(linkText="Laptops")
	private ExtendedWebElement laptopsLink;
	
	@FindBy(linkText="Car tires")
	private ExtendedWebElement carTiresLink;
	
	@FindBy(linkText="Headphones and headsets")
	private ExtendedWebElement hedphonesAndHeadsetsLink;
	
	@FindBy(linkText="Tablets")
	private ExtendedWebElement tabletsLink;
	
	@FindBy(linkText="Smart watches and bracelets")
	private ExtendedWebElement smartWatchesAndBraceletsLink;
	
	@FindBy(linkText="Video cards")
	private ExtendedWebElement videoCardsLink;
	
	@FindBy(linkText="Motor oils")
	private ExtendedWebElement motorsOilsLink;	
	
	@FindBy(linkText="Cameras")
	private ExtendedWebElement camerasLink;
	
	@FindBy(linkText="Processors")
	private ExtendedWebElement processorsLink;
	
	@FindBy(linkText="Monitors")
	private ExtendedWebElement monitorsLink;
	
	@FindBy(linkText="Wrist watch")
	private ExtendedWebElement wristWatchLink;
	
	
	
}
