package tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

// import pageObjects.DashboardPage;
import userDefinedMethods.JiraUserLibrary;
import pageObjects.DashboardPage;
import pageObjects.LogoutPage;



public class JiraCreateNewIssue extends JiraUserLibrary {
//  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String bugSummary = "New Bug Create";

  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://automation18.atlassian.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
// This test is to create a new bug using Jira
  @Test
  public void testJiraCreateNewIssues() throws Exception {
    driver.get(baseUrl + "login");    
    jira_login();
    create_new_bug();
    
//    LoginPage.login_email_Address(driver).sendKeys("bala.ravindran18@gmail.com");
//    LoginPage.login_password(driver).sendKeys("BabaMyLord09");
//    LoginPage.login_login(driver).click();
//    DashboardPage.projects(driver).click();
//    DashboardPage.projects_adt(driver).click();
  
    
//    driver.findElement(By.id("username")).clear();
//    driver.findElement(By.id("username")).sendKeys("bala.ravindran18@gmail.com");
//    driver.findElement(By.id("password")).clear();
//    driver.findElement(By.id("password")).sendKeys("BabaMyLord09");
//    driver.findElement(By.id("login")).click();
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if (isElementPresent(By.id("browse_link"))) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }
//
//    driver.findElement(By.id("browse_link")).click();
//    DashboardPage.projects(driver).click();
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if (isElementPresent(By.id("admin_main_proj_link_lnk"))) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }

//    driver.findElement(By.id("admin_main_proj_link_lnk")).click();
//    DashboardPage.projects_adt(driver).click();
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if (isElementPresent(By.id("create_link"))) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }

//    driver.findElement(By.id("create_link")).click();
//    DashboardPage.create_bug(driver).click();
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if (isElementPresent(By.id("issuetype-field"))) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }

//    driver.findElement(By.id("issuetype-field")).click();
//    driver.findElement(By.id("issuetype-field")).clear();
//    driver.findElement(By.id("issuetype-field")).sendKeys("Task");
    DashboardPage.select_issuetype(driver).click();
    DashboardPage.select_issuetype(driver).clear();
    DashboardPage.select_issuetype(driver).sendKeys("Bug");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("summary"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    
    DashboardPage.type_issuesummary(driver).click();
    DashboardPage.type_issuesummary(driver).clear();
    DashboardPage.type_issuesummary(driver).sendKeys(bugSummary);
//    driver.findElement(By.id("summary")).click();
//    driver.findElement(By.id("summary")).clear();
//    driver.findElement(By.id("summary")).sendKeys(bugSummary);
//    driver.findElement(By.id("description")).clear();
//    driver.findElement(By.id("description")).sendKeys("New FF Version");
    DashboardPage.type_issuedescription(driver).clear();
    DashboardPage.type_issuedescription(driver).sendKeys("New FF Version");
    
//    driver.findElement(By.id("priority-field")).click();
//    driver.findElement(By.id("priority-field")).clear();
//    driver.findElement(By.id("priority-field")).sendKeys("High");
    DashboardPage.select_priority(driver).click();
    DashboardPage.select_priority(driver).clear();
    DashboardPage.select_priority(driver).sendKeys("High");   
//    driver.findElement(By.id("assign-to-me-trigger")).click();
    DashboardPage.assign_issuetome(driver).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("create-issue-submit"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

//    driver.findElement(By.id("create-issue-submit")).click();
    DashboardPage.submit_newissue(driver).click();
    
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
//    driver.findElement(By.id("header-details-user-fullname")).click();
    LogoutPage.select_user(driver).click();
    LogoutPage.select_logout(driver).click();
    LogoutPage.confirm_logout(driver).click();
    LogoutPage.return_tologin(driver).click();
   
//    driver.findElement(By.id("log_out")).click();
//    driver.findElement(By.id("logout")).click();
//    driver.findElement(By.cssSelector("button.aui-button.aui-button-link")).click();
    
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

