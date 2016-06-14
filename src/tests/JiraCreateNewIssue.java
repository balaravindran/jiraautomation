package tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    //	Enter Data and Submit
    DashboardPage.select_issuetype(driver).click();
    DashboardPage.select_issuetype(driver).clear();
    DashboardPage.select_issuetype(driver).sendKeys("Bug");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("summary"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    
    DashboardPage.type_issuesummary(driver).click();
    DashboardPage.type_issuesummary(driver).sendKeys(bugSummary);
    DashboardPage.type_issuedescription(driver).clear();
    DashboardPage.type_issuedescription(driver).sendKeys("New FF Version");
    DashboardPage.select_priority(driver).click();
    DashboardPage.select_priority(driver).clear();
    DashboardPage.select_priority(driver).sendKeys("High");   
    DashboardPage.assign_issuetome(driver).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("create-issue-submit"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    DashboardPage.submit_newissue(driver).click();
    
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

