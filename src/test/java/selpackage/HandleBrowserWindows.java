package selpackage;

/*
 * 1) How To Handle Browser Windows in Selenium WebDriver?
   2) What is the Difference between getWindowHandle() & getWindowHandles() methods?
   3) How To Switch between Multiple Browser Windows?
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args)  {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	 
	 driver.get("https://opensource-demo.orangehrmlive.com/");    //Parent Window
	 
	 //get the id of browser window    //getWindowHandle() //getWindowHandles()
	 
	/* String windowID = driver.getWindowHandle();   // return ID of the single browser window
	 System.out.println(windowID);                  //CDwindow-29C66DE2C4029675B37767511AFBA45A
	*/
	 
	 driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();   // open another browser widow -child window
	 Set<String> windowIDs = driver.getWindowHandles();   // Id's of multiple browser windows
	 
	 // First method  - Iterator()....................
	 
	 /* Iterator<String>  itID =  windowIDs.iterator();
	 String parentWindowID = itID.next();
	 String childWindowID = itID.next();
	 System.out.println("Parent Window ID :" +parentWindowID);
	 System.out.println("Child Window ID :" +childWindowID);    */
		
	 //Second method - list collection (Array List)..............
	 
	 List<String> windowsIDList = new ArrayList<String>(windowIDs); //converting set to list
	 
	 
	 /*String parentWindowID = windowsIDList.get(0);  // parent window ID
	 String childWindowID = windowsIDList.get(1);   // child window ID
	
	 System.out.println("Parent Window ID :" +parentWindowID);
	 System.out.println("Child Window ID :" +childWindowID);  
			 
	 // How to use Window ID's for switching.......................
	 driver.switchTo().window(parentWindowID);
	 System.out.println("Parent Window Title : " +driver.getTitle());  //OrangeHRM
	 
	 driver.switchTo().window(childWindowID);
	 System.out.println("Child Window Title : " +driver.getTitle());   //OrangeHRM HR Software | Free HR Software | HRMS | HRIS 
	 */
	 
	 //For each loop
	/* for(String winid:windowsIDList)
	 {
		 System.out.println(winid);
		 String title  = driver.switchTo().window(winid).getTitle();
		 System.out.println(title);
	 } */
	 
	 // driver.close(); // Close single browser window driver which pointing ..this case Child window
	 // driver.quit();    //close all browser window
	 
	 for(String winid:windowsIDList)
	 {
		 System.out.println(winid);
		 String title  = driver.switchTo().window(winid).getTitle();
		 if(title.equals("OrangeHRM HR Software | Free HR Software | HRMS | HRIS"))
		 {
			 driver.close();
		 }
	 }
 }

}




