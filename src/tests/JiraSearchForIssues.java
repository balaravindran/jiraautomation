package tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;


public class JiraSearchForIssues {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  private String expectedMessage = "CR0018 - New FF Version Search";
  private String actualMessage;


  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://automation18.atlassian.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJiraSearchForIssues() throws Exception {
    driver.get(baseUrl + "login");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("bala.ravindran18@gmail.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("BabaMyLord09");
    driver.findElement(By.id("login")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("find_link"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("find_link")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("issues_new_search_link_lnk"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("issues_new_search_link_lnk")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("searcher-query"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("searcher-query")).clear();
    driver.findElement(By.id("searcher-query")).sendKeys("search");
    driver.findElement(By.id("searcher-query")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("searcher-query")).sendKeys(Keys.RETURN);
    actualMessage = driver.findElement(By.id("summary-val")).getText();
    // Verify Results
    assertEquals(expectedMessage,actualMessage);
    
    
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

