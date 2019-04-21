package com.qaprosoft.carina.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.gui.components.Tablet;

public class TabletsPage extends AbstractPage{

	public TabletsPage(WebDriver driver) {
		super(driver);
		setPageURL("/tabletpc");
	}
	
	@FindBy(xpath="//input[@class='fast-search__input']")
	private ExtendedWebElement searchField;
	
	@FindBy(xpath="//div[@class='result__item result__item_product']")
	private List<Tablet> tablets;
	
	//@FindBy(xpath="")
	//private ExtendedWebElement ;
	
	public List<Tablet> tabletSearchResults(String tabletName){
		searchField.type(tabletName);
		return tablets;
	}
	
}