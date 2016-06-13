package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public static WebElement login_email_Address (WebDriver driver){
		 WebElement element = driver.findElement(By.id("username"));		
		return element;
		
	}

	public static WebElement login_password (WebDriver driver){
		 WebElement element = driver.findElement(By.id("password"));		
		return element;
		
	}
	
	public static WebElement login_login (WebDriver driver){
		 WebElement element = driver.findElement(By.id("login"));		
		return element;
		
	}
}
