package com.qaprosoft.carina.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class RegitrationPage extends AbstractPage{
	
	@FindBy(xpath="//input[@placeholder='Ваш e-mail']")
	private ExtendedWebElement username;
	
	@FindBy(xpath="//input[@placeholder='Придумайте пароль']")
	private ExtendedWebElement password;
	
	@FindBy(xpath="//input[@placeholder='Повторите пароль']")
	private ExtendedWebElement doublePassword;
	
	@FindBy(xpath="//button[@type='submit' and contains(text(),'Зарегистрироваться')]")
	private ExtendedWebElement registrationButton;
	
	@FindBy(xpath="//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other' and contains(text(),'Пароли не совпадают')]")
	private ExtendedWebElement notEqualPassw;
	
	@FindBy(xpath="//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other' and contains(text(),'Некорректный e-mail')]")
	private ExtendedWebElement emailWrong;
	
	public RegitrationPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://profile.onliner.by/registration");
	}

	public String newUserNameIncorrect(String usernameInput) {
		username.type(usernameInput);
		username.pause(5);
		return emailWrong.getElement().getText();
	}
	
	public String newUserPassIncorrect(String passwordInput, String doublePasswordInput) {
		password.type(passwordInput);
		doublePassword.type(doublePasswordInput);
		password.pause(5);
		return notEqualPassw.getElement().getText();
	 }
	
	public AfterRegPage newUser(String usernameInput,String passwordInput, String doublePasswordInput) {
		username.type(usernameInput);
		password.type(passwordInput);
		doublePassword.type(doublePasswordInput);
		registrationButton.click();
		return new AfterRegPage(driver);
	}
	
		
	public String newUserName(String usernameInput) {
		username.type(usernameInput);
		return emailWrong.getElement().getText();
	}
	
	public String newUserPass(String passwordInput, String doublePasswordInput) {
		password.type(passwordInput);
		doublePassword.type(doublePasswordInput);
		if(passwordInput.equals(doublePasswordInput)); 
		return notEqualPassw.getElement().getText();
	 }
	
		
}
