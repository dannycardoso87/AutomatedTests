package src.com.example.tests;

import org.testng.TestNG;
import org.testng.annotations.*;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 

public class TC001LoginValidatePCS {
		public static void main() {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC001LoginValidatePCS.class });
			testSuite.run();
		}		
				
		private WebDriver driver;
		private String baseUrl;
		private StringBuffer verificationErrors = new StringBuffer(); 
		//Tests local
		private final String pathChromeDriver = "C:\\Projects\\AutomatedTests\\Package\\chromedriver.exe";  
		//Test VM
		//private final String pathChromeDriver =  "C:\\PCSNightlyBuild\\Tests\\chromedriver.exe";    

		@BeforeClass(alwaysRun = true)
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
		
		@Test
		public void testTC001LoginValidate() throws Exception {
			driver.get(baseUrl + "#/login");
			driver.findElement(By.id("pcsusername")).clear();
			driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
			driver.findElement(By.id("pcspass")).clear();
			driver.findElement(By.id("pcspass")).sendKeys("test2");
			//Submit
			driver.findElement(By.id("btnSubmit")).click();
		    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
		    driver.switchTo().alert().accept();
		    driver.findElement(By.id("pcspass")).clear();
		    driver.findElement(By.id("pcspass")).sendKeys("test");
		    //Submit
		    driver.findElement(By.id("btnSubmit")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnLogout")));
		    element.click();
		 }
		
		  @AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
			driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }
}
