package steps;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import data.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pages.HomePage;
import pages.SubsectionPage;

public class StepsDefinition {

	WebDriver chrome;
	Random rand = new Random();
	int index = rand.nextInt(10);

	@Given("User in on home page")
	public void user_in_on_home_page() {

		WebDriverManager.chromedriver().setup();	
		chrome = new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.navigate().to("https://www.gourmetegypt.com/");
	}

	@When("User hover on SeaFood category from categories page")
	public void user_hover_on_sea_food_category_from_categories_page() {
		ExcelReader readData = new ExcelReader();
		try {
			Object[][] getLocators = readData.retreiveExceldata();
			HomePage home = new HomePage(chrome);
			home.clickOnCategories((String)getLocators[0][0],(String)getLocators[1][0],(String)getLocators[2][0],(String)getLocators[3][0]);
		} catch (IOException e) {
			System.out.println("Error Occurred in Excel File");
		}

	}

	@When("User select specific SeaFood type randomly")
	public void user_select_specific_sea_food_type_randomly() {
		HomePage home = new HomePage(chrome);
		home.selectRandomSeaFood(index);
	}

	@When("User select available all dishes and add them to cart")
	public void user_select_available_all_dishes_and_add_them_to_cart() {
		ExcelReader readData = new ExcelReader();
		try {
			Object[][] getLocators = readData.retreiveExceldata();
			SubsectionPage page = new SubsectionPage(chrome);
			page.getAllAvailableFoodInCart((String)getLocators[4][0],(String)getLocators[5][0],(String)getLocators[6][0],
					(String)getLocators[7][0],(String)getLocators[8][0],(String)getLocators[9][0],
					(String)getLocators[10][0],(String)getLocators[11][0],(String)getLocators[12][0],(String)getLocators[13][0],
					(String)getLocators[14][0],(String)getLocators[15][0],(String)getLocators[16][0],(String)getLocators[17][0]);

		} catch (IOException e) {
			System.out.println("Error in Excel File");
		}
	}

	@Then("User open Cart and check Total price is right")
	public void user_open_cart_and_check_total_price_is_right() {
		ExcelReader readData = new ExcelReader();
		Object[][] getLocators;
		try {
			getLocators = readData.retreiveExceldata();
			SubsectionPage page = new SubsectionPage(chrome);
			String TotalPrice = page.checkTotalPrice((String)getLocators[18][0]);
			Assert.assertEquals(TotalPrice, chrome.findElement(By.xpath((String)getLocators[19][0])).getText().toString());
			chrome.quit();
		} catch (IOException e) {
			System.out.println("Error occured in Excel File");
		}

	}
}
