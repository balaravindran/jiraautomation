package userDefinedMethods;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.DashboardPage;

public class JiraUserLibrary {
	public WebDriver driver;

	public void jira_login(){
		
	    LoginPage.login_email_Address(driver).sendKeys("bala.ravindran18@gmail.com");
	    LoginPage.login_password(driver).sendKeys("BabaMyLord09");
	    LoginPage.login_login(driver).click();		

	}
	
	public void create_new_bug(){
	    DashboardPage.projects(driver).click();
	    DashboardPage.projects_adt(driver).click();
	    DashboardPage.create_bug(driver).click();
	    
	}

}
