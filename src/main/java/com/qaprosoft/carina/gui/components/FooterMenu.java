package com.qaprosoft.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.gui.pages.TabletsPage;

public class FooterMenu extends AbstractUIObject {

	@FindBy(linkText="Мобильные телефоны")
	private ExtendedWebElement mobilePhoneLink;
	
	@FindBy(linkText="Ноутбуки")
	private ExtendedWebElement laptopsLink;
	
	@FindBy(linkText="Автомобильные шины")
	private ExtendedWebElement carTiresLink;
	
	@FindBy(linkText="Наушники и гарнитуры")
	private ExtendedWebElement hedphonesAndHeadsetsLink;
	
	@FindBy(linkText="Планшеты")
	private ExtendedWebElement tabletsLink;
	
	@FindBy(linkText="Умные часы и браслеты")
	private ExtendedWebElement smartWatchesAndBraceletsLink;
	
	@FindBy(linkText="Видеокарты")
	private ExtendedWebElement videoCardsLink;
	
	@FindBy(linkText="Моторные масла")
	private ExtendedWebElement motorsOilsLink;	
	
	@FindBy(linkText="Фотоаппараты")
	private ExtendedWebElement camerasLink;
	
	@FindBy(linkText="Процессоры")
	private ExtendedWebElement processorsLink;
	
	@FindBy(linkText="Мониторы")
	private ExtendedWebElement monitorsLink;
	
	@FindBy(linkText="Наручные часы")
	private ExtendedWebElement wristWatchLink;
	

	public FooterMenu(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	
	public TabletsPage openTabletsPage() {
		tabletsLink.click();
		return new TabletsPage(driver);
	}
	
}
