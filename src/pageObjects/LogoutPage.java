package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	
	public static WebElement select_user (WebDriver driver){
		 WebElement element = driver.findElement(By.id("header-details-user-fullname"));		
		return element;
		
	}
	
	public static WebElement select_logout (WebDriver driver){
		 WebElement element = driver.findElement(By.id("log_out"));		
		return element;
		
	}
	
	public static WebElement confirm_logout (WebDriver driver){
		 WebElement element = driver.findElement(By.id("logout"));		
		return element;
		
	}
	
	public static WebElement return_tologin (WebDriver driver){
		 WebElement element = driver.findElement(By.cssSelector("button.aui-button.aui-button-link"));		
		return element;
		
	}
		
}



