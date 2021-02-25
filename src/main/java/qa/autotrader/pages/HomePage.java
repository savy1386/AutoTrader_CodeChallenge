package qa.autotrader.pages;

import org.openqa.selenium.By;

import common.BaseClass;

public class HomePage extends BaseClass {

	By locatorBrowseByMake = By.xpath("//button[@title='Browse by Make']");
	By locatorBrowseByStyle = By.xpath("//button[@title='Browse by Style']");
	By locatorAdvancedSearch = By.linkText("Advanced Search");
	By locatorSearchBtn = By.id("search");
	By locatorMakeDD = By.id("makeCode");
	By locatorModelDD = By.name("ModelCode");
	
	public HomePage() {
		super();
	}

	public boolean isBrowseByMakePresent() {
		boolean isPresent = !driver.findElements(locatorBrowseByMake).isEmpty();
		return isPresent;
	}

	public boolean isBrowseByStylePresent() {
		boolean isPresent = !driver.findElements(locatorBrowseByStyle).isEmpty();
		return isPresent;
	}

	public boolean isSearchBtnPresent() {
		boolean isPresent = !driver.findElements(locatorSearchBtn).isEmpty();
		return isPresent;
	}

	public boolean isAdvancedSearchPresent() {
		boolean isPresent = !driver.findElements(locatorAdvancedSearch).isEmpty();
		return isPresent;
	}

	public void clickAdvancedSearch() {
		driver.findElement(locatorAdvancedSearch).click();
	}

	public boolean isMakeDDPresent() {
		boolean isPresent = !driver.findElements(locatorMakeDD).isEmpty();
		return isPresent;
	}

	public boolean isModelDDPresent() {
		boolean isPresent = !driver.findElements(locatorModelDD).isEmpty();
		return isPresent;
	}
}
