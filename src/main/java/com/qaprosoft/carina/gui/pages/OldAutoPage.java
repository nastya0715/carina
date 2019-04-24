package com.qaprosoft.carina.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.gui.components.Car;

public class OldAutoPage extends AbstractPage{
	
	@FindBy(xpath="//ul[@class='ofm-forms-checkers body-types']/li/label")
	private List<ExtendedWebElement> bodyTypes;
	
	@FindBy(xpath="//select[@class='manufacture']/option")
	private List<ExtendedWebElement> brands;
	
	@FindBy(xpath="//select[@name='colors_id[]']/option")
	private List<ExtendedWebElement> colors;
	
	@FindBy(xpath="//select[@name='max-price']/option")
	private List<ExtendedWebElement> maxCosts;
	
	@FindBy(xpath="//select[@name='max-year']/option")
	private List<ExtendedWebElement> maxYears;
	
	@FindBy(xpath="//select[@name='min-year']/option")   
	private List<ExtendedWebElement> minYears;
	
	@FindBy(xpath="//a[@class='rub-sign' and contains(text(),'р.')]")
	private ExtendedWebElement currencyType;
	
	@FindBy(xpath="//tr[@id]")
	private List<Car> cars;

	public OldAutoPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL("https://ab.onliner.by/");
	}

	public List<Car> chooseCar(ExtendedWebElement brand, ExtendedWebElement bodyType, ExtendedWebElement color, 
			ExtendedWebElement minYear,	ExtendedWebElement maxYear) {
		brand.click();
		bodyType.click();
		minYear.click();
		maxYear.click();
		color.click();
		return cars;
	}
	
	   public ExtendedWebElement selectBrand(String brandName) {
	        for (ExtendedWebElement brand : brands) {
	            if (brand.getText().contains(brandName)) {
	            	return brand;
	            }
	        } throw new RuntimeException("Unable to find brand" + brandName );
	    }
	   
	  public ExtendedWebElement selectBodyType(String bodyTypeName) {
	        for (ExtendedWebElement bodyType : bodyTypes) {
	            if (bodyType.getText().contains(bodyTypeName)) {
	            	return bodyType;
	            }
	        } throw new RuntimeException("Unable to find body type" + bodyTypeName );
	    }
	   
	   public ExtendedWebElement selectColor(String colorName) {
	        for (ExtendedWebElement color : colors) {
	            if (color.getText().contains(colorName)) {
	            	return color;
	            }
	        } throw new RuntimeException("Unable to find color" + colorName);
	    }
	   
	   public ExtendedWebElement selectMaxYear(String maxYearName) {
	        for (ExtendedWebElement maxYear : maxYears) {
	            if (maxYear.getText().contains(maxYearName)) {
	            	return maxYear;
	            }
	        } throw new RuntimeException("Unable to find max year" + maxYearName );
	    }
	   
	   public ExtendedWebElement selectMinYear(String minYearName) {
	        for (ExtendedWebElement minYear : minYears) {
	            if (minYear.getText().contains(minYearName)) {
	            	return minYear;
	            }
	        } throw new RuntimeException("Unable to find min year" + minYearName );
	    }
	   
	   public ExtendedWebElement selectMaxCost(String maxCostName) {
		   currencyType.click();
	        for (ExtendedWebElement maxCost : maxCosts) {
	            if (maxCost.getText().contains(maxCostName)) {
	            	return maxCost;
	            }
	        } throw new RuntimeException("Unable to find max cost "  + maxCostName );
	    }
	   
	   
}
