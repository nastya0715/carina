package com.qaprosoft.carina.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.gui.components.FooterMenu;
import com.qaprosoft.carina.gui.components.LogInMenu;
import com.qaprosoft.carina.gui.components.YellowMenu;

public class HomePage extends AbstractPage {
	@FindBy(xpath="//div[@class='project-navigation__flex']")
	private FooterMenu footerMenu;
	
	@FindBy(xpath="//div[@id='userbar']")
	private LogInMenu logInMenu;	
	
	@FindBy(xpath="//div[@class='b-top-menu']")
	private YellowMenu yellowMenu;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public FooterMenu getFooterMenu() {
		return footerMenu;
	}
	
	public LogInMenu getLogInMenu() {
		return logInMenu;
	}
	
	public YellowMenu getYellowMenu() {
		return yellowMenu;
	}
}
