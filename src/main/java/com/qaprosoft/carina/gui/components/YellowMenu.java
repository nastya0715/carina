package com.qaprosoft.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.gui.pages.OldAutoPage;
import com.qaprosoft.carina.gui.pages.RatePage;

public class YellowMenu extends AbstractUIObject {
	
	@FindBy(linkText="Автобарахолка")
	private ExtendedWebElement oldAutoLink;
	
	@FindBy(xpath="//*[@id='currency-informer']")
	private ExtendedWebElement rateLink;

	public YellowMenu(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	
	public OldAutoPage openOldAutoPage() {
		oldAutoLink.click();
		return new OldAutoPage(driver);
	}
	
	public RatePage openRatePage() {
		rateLink.click();
		return new RatePage(driver);
	}

}
