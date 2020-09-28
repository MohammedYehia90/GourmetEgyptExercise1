package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BeefAndVealPage {

	WebDriver driver;
	static List<WebElement> specialOfferslist = new ArrayList<WebElement>();



	public BeefAndVealPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSpcialOffersProducts() throws InterruptedException {
		
		// When I try to use below but I fail to get href
//		Thread.sleep(3000);
//		specialOfferslist = driver.findElements(By.cssSelector("div.offer-tag-sp"));
//		System.out.println(specialOfferslist.size());
		
		// I will use Below
		
		WebElement x = driver.findElement(By.cssSelector("ol.products.list.items.product-items"));

		Thread.sleep(3000);
		
		specialOfferslist = x.findElements(By.cssSelector("li"));
		
	}
	
	public void printURLS() {
		
		for (int i = 0; i < specialOfferslist.size(); i++) {
			if((specialOfferslist.get(i).getText().contains("SPECIAL OFFER"))) {
				//System.out.println(items.get(i).getText());
				System.out.println(specialOfferslist.get(i).findElement(By.tagName("a")).getAttribute("href"));
			}
			
		}
		
	}
}

