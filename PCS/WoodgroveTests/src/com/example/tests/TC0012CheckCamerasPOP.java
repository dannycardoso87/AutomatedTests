package src.com.example.tests;

import org.testng.TestNG;
import org.testng.annotations.*;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC0012CheckCamerasPOP {
		public static void main() {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC0012CheckCamerasPOP.class });
			testSuite.run();
		}		
				
		private WebDriver driver;
		private String baseUrlPOP;
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
			baseUrlPOP = "https://localhost/";
			//Test local (nightly)
			//baseUrl = "https://192.168.1.202:3003/#/login";    
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test
		public void testTC0012CheckCamerasPOP() throws Exception {
			driver.get(baseUrlPOP);
			driver.findElement(By.id("pcsusername")).clear();
			driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
			driver.findElement(By.id("pcspass")).clear();
			driver.findElement(By.id("pcspass")).sendKeys("test");
			
			WebDriverWait waitbtnSubmit = new WebDriverWait(driver, 10);
			WebElement element = waitbtnSubmit.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmit")));
		    element.click();			
			
			WebDriverWait waitbtnSidebarCam = new WebDriverWait(driver, 10);
			element = waitbtnSidebarCam.until(ExpectedConditions.elementToBeClickable(By.id("btnSidebarCam")));
		    element.click();
			
			List <WebElement> listOfElements = driver.findElements(By.id("tableNameCamera"));
		    if(listOfElements.isEmpty()) {
		    	System.out.println("Number of elements:" +listOfElements.size());
		    	fail();
		    }
		    for (int i=0; i < listOfElements.size();i++){
		    	System.out.println(i);
		    	WebElement element1 = listOfElements.get(i).findElement(By.id("nameCamera"));
		    	String nodeName = element1.getText().toString();    
		    	Thread.sleep(1000); 
		    	WebElement element2 = listOfElements.get(i).findElement(By.id("statusCamera"));
		    	Thread.sleep(1000); 
    	    	String status = element2.getAttribute("ng-reflect-ng-class").toString();
    	    	System.out.println(nodeName);  	
	    		if(status.equals("running") || status.equals("unavailable")) {
	    			System.out.println("Node "+nodeName+" is running.");
	    		}else {
	    			System.out.println("Node "+nodeName+" is not running.");
	    			fail();
	    		}	    	    	    	
		    }	
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
