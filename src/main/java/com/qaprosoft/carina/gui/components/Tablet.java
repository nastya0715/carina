package com.qaprosoft.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class Tablet extends AbstractUIObject{

	public Tablet(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	
	@FindBy(xpath="//a[@class='product__title-link']")
	private ExtendedWebElement tabletTitle;
	
	public String readTabletTitle () {
		return tabletTitle.getElement().getText();
		
	}

}
