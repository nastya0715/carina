package com.qaprosoft.carina.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.gui.components.Tablet;

public class TabletsPage extends AbstractPage{

	@FindBy(xpath="//input[@class='fast-search__input']")
	private ExtendedWebElement searchField;
	
	@FindBy(xpath="//div[@class='search__content-wrapper']/ul/li[@class]")  
	private List<Tablet> tablets;
	
	public TabletsPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://catalog.onliner.by/tabletpc");
	}
	
	public List<Tablet> tabletSearchResults(String tabletName){
		searchField.type(tabletName);
		return tablets;
	}
	
}
