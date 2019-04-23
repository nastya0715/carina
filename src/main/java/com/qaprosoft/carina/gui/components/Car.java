package com.qaprosoft.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class Car extends AbstractUIObject{
	
	@FindBy(xpath="//a/strong")
	private ExtendedWebElement carTitle;

	public Car(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public String readCarTitle () {
		return carTitle.getElement().getText();
	}
}
