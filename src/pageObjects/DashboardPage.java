package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	
	public static WebElement projects (WebDriver driver){
	 WebElement element = driver.findElement(By.id("browse_link"));		
	return element;
	
}
public static WebElement projects_adt (WebDriver driver){
	 WebElement element = driver.findElement(By.id("admin_main_proj_link_lnk"));		
	return element;
	
}

}
