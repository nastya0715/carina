package com.qaprosoft.carina.gui.services;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.gui.pages.HomePage;
import com.qaprosoft.carina.gui.pages.LogInPage;

public class LogInService extends AbstractPage{
	
	public LogInService(WebDriver driver) {
		super(driver);
	}

	public LogInPage getLogInPage() {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
		
		LogInPage loginPage = homePage.getLogInMenu().openLogInLink();
		Assert.assertTrue(loginPage.isPageOpened(),"LogIn page is not opened!");
		return loginPage;
	}

}
