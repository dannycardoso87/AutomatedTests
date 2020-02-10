package src.com.example.tests;

import org.testng.TestNG;
import org.testng.annotations.*;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import src.com.example.tests.TC001LoginValidatePCS;


public class TC000RegressionTest {
		public static void main() {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC000RegressionTest.class });
			testSuite.run();
		}		
				
		public WebDriver driver;
		public String baseUrl;
		public StringBuffer verificationErrors = new StringBuffer(); 
		//Tests local
		public final String pathChromeDriver = "C:\\Projects\\AutomatedTests\\Package\\chromedriver.exe";  
		//Test VM
		//private final String pathChromeDriver =  "C:\\PCSNightlyBuild\\Tests\\chromedriver.exe";    
		
		TC001LoginValidatePCS TC001 = new TC001LoginValidatePCS();

		@BeforeMethod(alwaysRun = true)
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", pathChromeDriver);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//Test VM e local 
			baseUrl = "https://localhost:3002/";
			//Test local (nightly)
			//baseUrl = "https://192.168.1.202:3003/#/login";    
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		public void testTC000RegressionTest() throws Exception {			
			TC001.testTC001LoginValidate();						
		}
		
		@AfterMethod(alwaysRun = true)
		public void tearDown() throws Exception {
			driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		}
}
