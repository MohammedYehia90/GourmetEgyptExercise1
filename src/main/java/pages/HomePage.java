package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnCategories() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/header/div[1]/span")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/header/div[1]/div[2]/div/div[2]/nav/ul/li[3]/a/span[2]"))).build().perform();

		driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/header/div[1]/div[2]/div/div[2]/nav/ul/li[3]/div[1]/div/div[1]/div/div/div[1]/div[1]/a[1]")).click();

	}
}
