package selpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest01 {

	public static void main(String[] args) {

		// initiate Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Get URL
		driver.get("https://demo.nopcommerce.com/register");

		System.out.println("Page Title: " + driver.getTitle());
		System.out.println("Page URL: " + driver.getCurrentUrl());
		// System.out.println("Page Source: " +driver.getPageSource());

		// isDisplayed() and isEnabled()

		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("IsDisplayed: " + searchStore.isDisplayed());
		System.out.println("IsEnabled: " + searchStore.isEnabled());

		// isSelected() - radio buttons, check boxes, drop down

		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));

		System.out.println(male.isSelected()); // False
		System.out.println(female.isSelected()); // False

		male.click();
		System.out.println(male.isSelected()); // True
		System.out.println(female.isSelected()); // False

		female.click();
		System.out.println(male.isSelected()); // False
		System.out.println(female.isSelected()); // True
	}
}
