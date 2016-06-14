package tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.LoginPage;
import pageObjects.DashboardPage;
import pageObjects.LogoutPage;


public class JiraEditExistingIssues {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://automation18.atlassian.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJiraEditExistingIssues() throws Exception {
    driver.get(baseUrl + "login");

    //	Login
    LoginPage.login_email_Address(driver).sendKeys("bala.ravindran18@gmail.com");
    LoginPage.login_password(driver).sendKeys("BabaMyLord09");
    LoginPage.login_login(driver).click();		
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("browse_link"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    //	Select Project
    DashboardPage.projects(driver).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("admin_main_proj_link_lnk"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    DashboardPage.projects_adt(driver).click();
    
//  Issue select a row     
//    driver.findElement(By.xpath("//ol/li[3]/a/span")).click();

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("#edit-issue"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    	
    DashboardPage.select_edit(driver).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("description"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Update and Submit
    DashboardPage.type_issuedescription(driver).clear();
    DashboardPage.type_issuedescription(driver).sendKeys("Updated 1st Row");
    DashboardPage.select_editupdate(driver).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("header-details-user-fullname"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    //	Logout
    LogoutPage.select_user(driver).click();
    LogoutPage.select_logout(driver).click();
    LogoutPage.confirm_logout(driver).click();
    LogoutPage.return_tologin(driver).click();
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
