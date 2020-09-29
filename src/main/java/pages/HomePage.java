package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;
	static List<WebElement> subsections = new ArrayList<WebElement>();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnCategories(String Locator1,String Locator2,String Locator3,String Locator4) {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// Click on Category Button
		driver.findElement(By.xpath(Locator1)).click();

		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

		// Hover on SeaFood Category
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath(Locator2))).build().perform();

		//Get all section under seaFood only
		WebElement x = driver.findElement(By.xpath(Locator3));

		//Thread.sleep(3000);

		// Get all subsections without Parent Section (FISH, SALMON, etc...)
		subsections = x.findElements(By.cssSelector(Locator4));

		//System.out.println(subsections.size());

	}

	public void selectRandomSeaFood(int index) {
		subsections.get(index).click();
	}
}
