package com.qaprosoft.carina.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.gui.components.Car;

public class OldAutoPage extends AbstractPage{
	
	@FindBy(xpath="//option[@value='112']")
	private ExtendedWebElement findTesla;
	
	@FindBy(xpath="//li[@class='body_type-5']")
	private ExtendedWebElement findSUV;
	
	@FindBy(xpath="//*[@name='min-year']/descendant::option[contains(text(),'2019')]")
	private ExtendedWebElement find2019;
	
	@FindBy(xpath="//*[@name='colors_id[]']/descendant::option[contains(text(),'Черный')]")
	private ExtendedWebElement findBlack;
	
	@FindBy(xpath="//tr[@id]")
	private List<Car> cars;

	public OldAutoPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://ab.onliner.by/");
	}

	public List<Car> chooseCar() {
		findTesla.click();
		findSUV.click();
		find2019.click();
		findBlack.click();
		return cars;
	}
}
