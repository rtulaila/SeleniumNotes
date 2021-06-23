package selpackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");

		/* 1) Select specific check box
		driver.findElement(By.xpath("//input[@id='monday']")).click();
        */
		
		//2) Select all check boxes
		List <WebElement> checkboxes =  driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total no. of checkboxes : "+checkboxes.size());

		/*using for loop
		for(int i=0;i<checkboxes.size();i++) {
			checkboxes.get(i).click();
		}  */

		/*using for...each loop
		for( WebElement chbox:checkboxes)
		{
			chbox.click();
		} */
		
		//3) select multiple check boxes by choice  Monday & Friday
		 for(WebElement  chbox:checkboxes)
		{
			String checkboxname = chbox.getAttribute("id");
			if(checkboxname.equals("monday") || checkboxname.equals("friday"));
			{
			chbox.click();
			}
		}   
		
		/*4) select last 2 check boxes : 7-2 = 5   :  0,1,2,3,4,5,6
		 											  1,2,3,4,5,6,7			
		
		int totalcheckboxes = checkboxes.size();
		for(int i=totalcheckboxes-2; i<totalcheckboxes; i++) {
			checkboxes.get(i).click();
		} */
		
		
		/* 5) select first 2 check boxes : 7-2 = 5   
		int totalcheckboxes = checkboxes.size();
		for(int i=0;i<totalcheckboxes;i++) {
			if(i<2) {
				checkboxes.get(i).click();
			}
		} */
	}
}
