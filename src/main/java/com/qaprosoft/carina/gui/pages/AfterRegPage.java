package com.qaprosoft.carina.gui.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class AfterRegPage extends AbstractPage{
	
	public AfterRegPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://profile.onliner.by/registration");
	}

}
