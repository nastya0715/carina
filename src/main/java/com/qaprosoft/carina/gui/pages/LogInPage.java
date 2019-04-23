package com.qaprosoft.carina.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LogInPage extends AbstractPage{
	
	@FindBy(xpath="//input[@placeholder='Ник или e-mail']")
	private ExtendedWebElement username;
	
	@FindBy(xpath="//input[@placeholder='Пароль']")
	private ExtendedWebElement password;
	
	@FindBy(xpath="//button[@type='submit' and contains(text(),'Войти')]")
	private ExtendedWebElement enterButton;
	
	@FindBy(linkText="Зарегистрироваться на Onliner")
	private ExtendedWebElement registrationButton;
	
	@FindBy(linkText="Я не помню пароль")
	private ExtendedWebElement forgotPassButton;
	
	@FindBy(xpath="//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']")
	private ExtendedWebElement wrongPass;

	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	public String userLogIn(String usernameInput, String passwordInput) {
		username.type(usernameInput);
		password.type(passwordInput);
		enterButton.click();
		enterButton.pause(5);
		return wrongPass.getElement().getText();
	}
	
	public RegitrationPage registrationUser() {
		registrationButton.click();
		return new RegitrationPage(driver);
	}	
}
