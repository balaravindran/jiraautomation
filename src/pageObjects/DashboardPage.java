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
	
	public static WebElement create_bug (WebDriver driver){
		WebElement element = driver.findElement(By.id("create_link"));		
	return element;
	
	}
	
	public static WebElement select_issuetype (WebDriver driver){
		WebElement element = driver.findElement(By.id("issuetype-field"));		
	return element;
	
	}

	public static WebElement type_issuesummary (WebDriver driver){
		WebElement element = driver.findElement(By.id("summary"));		
	return element;
	
	}
	
	public static WebElement type_issuedescription (WebDriver driver){
		WebElement element = driver.findElement(By.id("description"));		
	return element;
	
	}
	
	public static WebElement select_priority (WebDriver driver){
		WebElement element = driver.findElement(By.id("priority-field"));		
	return element;
	
	}
	
	public static WebElement assign_issuetome (WebDriver driver){
		WebElement element = driver.findElement(By.id("assign-to-me-trigger"));		
	return element;
	
	}
	
	public static WebElement submit_newissue (WebDriver driver){
		WebElement element = driver.findElement(By.id("create-issue-submit"));		
	return element;
	
	}
	
	public static WebElement select_edit (WebDriver driver){
		WebElement element = driver.findElement(By.cssSelector("#edit-issue"));		
	return element;
	
	}
	
	public static WebElement select_editupdate (WebDriver driver){
		WebElement element = driver.findElement(By.id("edit-issue-submit"));		
	return element;
	
	}
}




