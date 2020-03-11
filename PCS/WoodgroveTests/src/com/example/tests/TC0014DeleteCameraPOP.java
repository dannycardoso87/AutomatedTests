package src.com.example.tests;

import org.testng.TestNG;
import java.util.List;
import org.testng.annotations.*;


import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC0014DeleteCameraPOP {
		public static void main() {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC0014DeleteCameraPOP.class });
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
		public void testTC0014DeleteCameraPOP() throws Exception {
			driver.get(baseUrlPOP);
			driver.findElement(By.id("pcsusername")).clear();
			driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
			driver.findElement(By.id("pcspass")).clear();
			driver.findElement(By.id("pcspass")).sendKeys("test");
		
			WebDriverWait waitBtnSubmit = new WebDriverWait(driver, 10);
			WebElement btnSubmit = waitBtnSubmit.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmit")));
			btnSubmit.click();			
			
			WebDriverWait waitBtnSidebarCam = new WebDriverWait(driver, 10);
			WebElement btnSidebarCam = waitBtnSidebarCam.until(ExpectedConditions.elementToBeClickable(By.id("btnSidebarCam")));
			btnSidebarCam.click();			

		    List <WebElement> listOfElements = driver.findElements(By.id("btnDeleteCam"));
		    System.out.println("Number of elements:" +listOfElements.size());
		    if(listOfElements.isEmpty()) {
		    	System.out.println("Number of elements:" +listOfElements.size());
		    	fail();
		    }
		    for (int i=0; i < listOfElements.size();i++){
		    	WebElement btnDeleteCam =  listOfElements.get(i).findElement(By.id("nameBtnDeleteCam"));
		    	String titleBtnCam = btnDeleteCam.getAttribute("title").toString();
		    	if(titleBtnCam.equals("Delete [Camera1]")) {
		    		System.out.println(titleBtnCam);
		    		btnDeleteCam.click();
		    	    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
		    	    driver.switchTo().alert().accept(); 
		    	}else {
		    		System.out.println("Didn't find the camera");
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
