package stepDefinitions;


import org.junit.Assert;

import common.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import qa.autotrader.pages.AdvancedSearchPage;
import qa.autotrader.pages.HomePage;
import qa.autotrader.pages.SearchResultsPage;

public class AutotraderSearchStepDefs extends BaseClass {

	public AutotraderSearchStepDefs() {
		super();
	}

	@Before
	public void beforeStart() {
		System.out.println("Before start of Test");
	}
	
	@After
	public void afterTest() {
		System.out.println("After Test");
		tearDown();
	}

	@Given("^user is on autotrader home page$")
	public void user_is_on_autotrader_home_page() throws InterruptedException {
		driver.navigate().to("https://www.autotrader.com/");
		driver.manage().deleteAllCookies();
	}

	@Then("^verify expected elements are present$")
	public void verify_expected_elements_are_present() {
		HomePage homePage = new HomePage();

		Assert.assertTrue("Browse By Make Link is Present", homePage.isBrowseByMakePresent());
		Assert.assertTrue("Browse By Make Style Link is Present", homePage.isBrowseByStylePresent());
		Assert.assertTrue("Advanced Search is Present", homePage.isAdvancedSearchPresent());
		Assert.assertTrue("Search button is Present", homePage.isSearchBtnPresent());
		Assert.assertTrue("Make drop down is Present", homePage.isMakeDDPresent());
		Assert.assertTrue("Model drop down is Present", homePage.isModelDDPresent());
	}

	@When("^perform advanced search of \"([^\"]*)\" in zip \"([^\"]*)\" from year \"([^\"]*)\" to year \"([^\"]*)\"$")
	public void perform_advanced_search_of_in_zip_from_year_to_year(String carType, String zip, String startYear, String endYear) {
		HomePage homePage = new HomePage();
		AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
		

		homePage.clickAdvancedSearch();
		advancedSearchPage.setZipCode(zip);

		advancedSearchPage.checkConditionCertified();
		advancedSearchPage.checkStyleConvertible();
		advancedSearchPage.selectStartYear(startYear);
		advancedSearchPage.selectEndYear(endYear);
		advancedSearchPage.selectMake(carType);
		advancedSearchPage.clickSubmitBtn();
	}
	
	@Then("^results should contain searched \"([^\"]*)\" vehicle$")
	public void results_should_contain_searched_vehicle(String carType) {
		SearchResultsPage searchResultsPage = new SearchResultsPage();
		
		System.out.println("Total cars resulted in search is: " + searchResultsPage.getTotalResultItems());

		boolean titleContainsExpectedCarType = searchResultsPage.checkAllResultTitle(carType);
		Assert.assertTrue("Search Result contains "+carType+" as expected", titleContainsExpectedCarType);

	}


}
