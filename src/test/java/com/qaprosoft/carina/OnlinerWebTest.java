package com.qaprosoft.carina;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.gui.components.Car;
import com.qaprosoft.carina.gui.components.Tablet;
import com.qaprosoft.carina.gui.pages.AfterRegPage;
import com.qaprosoft.carina.gui.pages.BankPage;
import com.qaprosoft.carina.gui.pages.HomePage;
import com.qaprosoft.carina.gui.pages.LogInPage;
import com.qaprosoft.carina.gui.pages.OldAutoPage;
import com.qaprosoft.carina.gui.pages.RatePage;
import com.qaprosoft.carina.gui.pages.RegitrationPage;
import com.qaprosoft.carina.gui.pages.TabletsPage;
import com.qaprosoft.carina.gui.services.LogInService;

public class OnlinerWebTest extends AbstractTest{

	@Test(description="search tablets")
	public void testTabletsSearch () {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
		
		TabletsPage tabletsPage = homePage.getScrollMenu().openTabletsPage();
		Assert.assertTrue(tabletsPage.isPageOpened(), "Tablets page is not opened!");
		
		final String searchTablet = "iPad 2018 32";
		List<Tablet> results = tabletsPage.tabletSearchResults(searchTablet);
		Assert.assertFalse(CollectionUtils.isEmpty(results), "Tablets not found!");
		for(Tablet m: results) {
			 System.out.println(m.readTabletTitle());
			Assert.assertTrue(StringUtils.containsIgnoreCase(m.readTabletTitle(),searchTablet), "Wrong search results!");
		}
	}
	
	@Test(description="loginFail")
	public void testLogIn () {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
		
		LogInPage loginPage = homePage.getLogInMenu().openLogInLink();
		Assert.assertTrue(loginPage.isPageOpened(),"LogIn page is not opened!");
		
		final String usernameInput = "user";
		final String passwordInput = "password";
		String messageWrong = loginPage.userLogIn(usernameInput, passwordInput);
		Assert.assertTrue(messageWrong.equals("Неверный логин или пароль"), "User logged in!");
		
		RegitrationPage registrPage = loginPage.registrationUser();
		final String usernameInputReg = "username";
		String messageUNW = registrPage.newUserNameIncorrect(usernameInputReg);
		Assert.assertTrue(messageUNW.equals("Некорректный e-mail"), "RegUserName write correct!");
		
		final String pass = "pass";
		final String doubPass = "passw";
		String messagePW = registrPage.newUserPassIncorrect(pass, doubPass);
		Assert.assertTrue(messagePW.equals("Пароли не совпадают"), "Passwords are equals!");		
	}

	@Test(dataProvider = "DataProvider", description="auto")
	@XlsDataSourceParameters(path = "xls/oldAutoSearch.xlsx", sheet = "Auto", dsUid = "TUID", dsArgs = "brand, bodyType, color, minYear, maxYear")
	public void testOldAutoSearch (String brand, String bodyType, String color, String minYear, String maxYear) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
		
		OldAutoPage oldAutoPage = homePage.getYellowMenu().openOldAutoPage();
		Assert.assertTrue(oldAutoPage.isPageOpened(),"Old auto page is not opened!");
		ExtendedWebElement chosenColor = oldAutoPage.selectColor(color);
		ExtendedWebElement chosenBodyType =  oldAutoPage.selectBodyType(bodyType);
		ExtendedWebElement chosenMinYear = oldAutoPage.selectMinYear(minYear);
		ExtendedWebElement chosenMaxYear = oldAutoPage.selectMaxYear(maxYear);
		ExtendedWebElement chosenBrand = oldAutoPage.selectBrand(brand);

		List<Car> chosenCars = oldAutoPage.chooseCar(chosenBrand, chosenBodyType, chosenColor, chosenMinYear, chosenMaxYear);
		Assert.assertFalse(CollectionUtils.isEmpty(chosenCars), "Cars not found!");
		for(Car m: chosenCars) {
			Assert.assertTrue(StringUtils.containsIgnoreCase(m.readCarTitle(), brand), "Wrong search results!");
		}
	}
	
	@Test(description="registration")
	public void testNewUser() {
		LogInService logService = new LogInService(getDriver());
		RegitrationPage registrPage = logService.getLogInPage().registrationUser();
		final String usernameInputReg = "username@gh.rm";
		final String pass = "passWORD";
		final String doubPass = "passWORD";
		AfterRegPage arp = registrPage.newUser(usernameInputReg, pass, doubPass);
		Assert.assertTrue(arp.isPageOpened(), "Registration is failed!");
	}
	
	@Test(description="true rates")
	public void testTrueRate() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
		
		RatePage ratePage = homePage.getYellowMenu().openRatePage();
		Assert.assertTrue(ratePage.isPageOpened(),"Rate page is not opened!");
		
		String or = ratePage.getOnlinerRate();
		BankPage openBank = new BankPage(getDriver());
		openBank.open();
		Assert.assertTrue(openBank.isPageOpened(),"Bank page is not opened!");
		String nbr = openBank.getTrueRateNBRB();
		System.err.println(nbr);
		System.err.println(or);
		Assert.assertTrue(or.equals(nbr),"Rates are diffirent!");
	}
		
	@Test(dataProvider = "DP", description="autoDP")
	public void testOldAutoSearchDP (String TUID,String brand, String bodyType, String color, String minYear, String maxYear) {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened!");
		
		OldAutoPage oldAutoPage = homePage.getYellowMenu().openOldAutoPage();
		Assert.assertTrue(oldAutoPage.isPageOpened(),"Old auto page is not opened!");
		ExtendedWebElement chosenColor = oldAutoPage.selectColor(color);
		ExtendedWebElement chosenBodyType =  oldAutoPage.selectBodyType(bodyType);
		ExtendedWebElement chosenMinYear = oldAutoPage.selectMinYear(minYear);
		ExtendedWebElement chosenMaxYear = oldAutoPage.selectMaxYear(maxYear);
		ExtendedWebElement chosenBrand = oldAutoPage.selectBrand(brand);

		List<Car> chosenCars = oldAutoPage.chooseCar(chosenBrand, chosenBodyType, chosenColor, chosenMinYear, chosenMaxYear);
		Assert.assertFalse(CollectionUtils.isEmpty(chosenCars), "Cars not found!");
		for(Car m: chosenCars) {
			Assert.assertTrue(StringUtils.containsIgnoreCase(m.readCarTitle(), brand), "Wrong search results!");
		}
	}
    @DataProvider(parallel = false, name = "DP")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"TUID: Data1", "Tesla", "Внедорожник", "Черный", "2019", "2019"},
                {"TUID: Data2", "Audi", "Седан", "Красный", "2017", "2018"}};
    }

  }