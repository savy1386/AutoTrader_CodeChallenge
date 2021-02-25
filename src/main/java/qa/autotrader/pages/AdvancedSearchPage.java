package qa.autotrader.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.BaseClass;

public class AdvancedSearchPage extends BaseClass {
	
	public AdvancedSearchPage() {
		super();
	}
	
	By zipLocator = By.name("zip");
	By conditionCertifiedLocator = By.xpath("//input[@type='checkbox' and @value='CERTIFIED']/parent::label[@class='checkbox']");
	By styleConvertibleLocator = By.xpath("//input[@type='checkbox' and @value='CONVERT']/parent::label[contains(@class,'checkbox')]");
	By startYear = By.xpath("//select[@name='startYear']");
	By endYear = By.xpath("//select[@name='endYear']");
	By make = By.name("makeFilter0");
	By submitBtnLocator = By.xpath("//button[@type='submit']");
	
	public void setZipCode(String zip) {
		driver.findElement(zipLocator).sendKeys(zip);
	}
	
	public void checkConditionCertified() {
		WebElement certifiedCheckBoxElement = driver.findElement(conditionCertifiedLocator);
		
		boolean certifiedCheckboxSelected = (boolean) certifiedCheckBoxElement.isSelected();
		if(!certifiedCheckboxSelected)
			certifiedCheckBoxElement.click();
	}
	
	public void checkStyleConvertible() {
		WebElement styleConvertibleCheckBoxElement = driver.findElement(styleConvertibleLocator);
		boolean styleConvertibleCheckBoxSelected = (boolean) styleConvertibleCheckBoxElement.isSelected();
		
		if(!styleConvertibleCheckBoxSelected)
			styleConvertibleCheckBoxElement.click();
	}
	
	public void selectStartYear(String styear) {
		Select startYearDD = new Select(driver.findElement(startYear));
		startYearDD.selectByValue(styear);
	}
	
	public void selectEndYear(String endyear) {
		Select endYearDD = new Select(driver.findElement(endYear));
		endYearDD.selectByValue(endyear);
	}
	
	public void selectMake(String carMake) {
		Select makeDD = new Select(driver.findElement(make));
		makeDD.selectByValue(carMake);
	}
	
	public void clickSubmitBtn() {
		WebElement submitBtn = driver.findElement(submitBtnLocator);
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", submitBtn);
	}
	
}
