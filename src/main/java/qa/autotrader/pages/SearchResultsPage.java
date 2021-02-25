package qa.autotrader.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseClass;

public class SearchResultsPage extends BaseClass {
	
	public SearchResultsPage() {
		super();
	}

	By carResultTitles = By.xpath("//h2[@data-cmp='subheading']");
	
	public List<WebElement> getListOfAllSearchResult() {
		return driver.findElements(carResultTitles);
	}
	
	public boolean checkAllResultTitle(String carType) {
		boolean titleContainsExpected = true;
		
		for(WebElement title : getListOfAllSearchResult()) {
			titleContainsExpected = title.getText().toLowerCase().contains(carType.toLowerCase());
			System.out.println("Search Result Car title text is: ===> " +title.getText() );
		}
		return titleContainsExpected;
	}
	
	public int getTotalResultItems() {
		return getListOfAllSearchResult().size();
	}
}
