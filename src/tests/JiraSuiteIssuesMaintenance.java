package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class JiraSuiteIssuesMaintenance {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testHotelapp() throws Exception {
//		CalledByTestSuite myBT1=new CalledByTestSuite();
		Boolean runMyBatchTest1=true;
		Boolean runMyBatchTest2=true;

//		if(runMyBatchTest1)
//			myBT1.testHotelapp();

//		if(runMyBatchTest2)

//			myBT2.testHotelapp();

	}

	@After
	public void tearDown() throws Exception {

	}

}
