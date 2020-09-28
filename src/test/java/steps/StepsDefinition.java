package steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import data.ExcelFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BeefAndVealPage;
import pages.HomePage;

public class StepsDefinition {

	WebDriver chrome;

	@Given("User is on home page")
	public void user_is_on_home_page() {
			   
				WebDriverManager.chromedriver().setup();	
				chrome = new ChromeDriver();
				chrome.manage().window().maximize();
				chrome.navigate().to("https://www.gourmetegypt.com/");


	}

	@When("select beef and Veal in meet category from categories menu")
	public void select_beef_and_veal_in_meet_category_from_categories_menu() {
		HomePage home = new HomePage(chrome);
		home.clickOnCategories();

	}

	@When("get list of special offers food in beef and Veal page")
	public void get_list_of_special_offers_food_in_beef_and_veal_page() throws InterruptedException {

		BeefAndVealPage beefpage = new BeefAndVealPage(chrome);
		beefpage.selectSpcialOffersProducts();
	}

	@Then("user print href of special offer of product")
	public void user_print_href_of_special_offer_of_product() {
		BeefAndVealPage beefpage = new BeefAndVealPage(chrome);
		beefpage.printURLS();
		chrome.quit();
	}
}
