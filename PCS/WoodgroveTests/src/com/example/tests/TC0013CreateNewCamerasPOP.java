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

public class TC0013CreateNewCamerasPOP {
		public static void main() {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC0013CreateNewCamerasPOP.class });
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
		public void testTC0013CreateNewCamerasPOP() throws Exception {
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

			driver.findElement(By.id("btnNewCamera")).click();
			WebDriverWait waitBtnSaveCam = new WebDriverWait(driver, 10);
			WebElement btnSaveCam = waitBtnSaveCam.until(ExpectedConditions.elementToBeClickable(By.id("bntSaveCamera")));
			btnSaveCam.click();	
			WebElement text = driver.findElement(By.id("msgCameraUnsaved"));
		    Boolean m = new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(text,"Cameras Edited - Unsaved"));
		    if(m.equals(true)) {
		    	System.out.println("Cameras Edited - Unsaved");
		    }			
			
			driver.findElement(By.id("cameraId")).clear();
			driver.findElement(By.id("cameraId")).sendKeys("nodePFC2");
			driver.findElement(By.id("cameraUsername")).clear();
			driver.findElement(By.id("cameraUsername")).sendKeys("admin");
			driver.findElement(By.id("cameraPassword")).clear();
			driver.findElement(By.id("cameraPassword")).sendKeys("123456");
			driver.findElement(By.id("cameraIpAddress")).clear();
			driver.findElement(By.id("cameraIpAddress")).sendKeys("192.168.1.110");	
			
			waitBtnSaveCam = new WebDriverWait(driver, 10);
			btnSaveCam = waitBtnSaveCam.until(ExpectedConditions.elementToBeClickable(By.id("bntSaveCamera")));
			btnSaveCam.click();		
			
//			driver.findElement(By.id("btnNewCamera")).click();
//			driver.findElement(By.id("cameraId")).clear();
//			driver.findElement(By.id("cameraId")).sendKeys("nodePRC3");
//			driver.findElement(By.id("cameraUsername")).clear();
//			driver.findElement(By.id("cameraUsername")).sendKeys("admin");
//			driver.findElement(By.id("cameraPassword")).clear();
//			driver.findElement(By.id("cameraPassword")).sendKeys("123456");
//			driver.findElement(By.id("cameraIpAddress")).clear();
//			driver.findElement(By.id("cameraIpAddress")).sendKeys("192.168.1.110");	
//		
//			
//			List <WebElement> listOfElements = driver.findElements(By.id("tableCameras"));
//		    System.out.println("Number of elements:" +listOfElements.size());
//		    for (int i=0; i < listOfElements.size();i++){
//		    	WebElement elements = listOfElements.get(i).findElement(By.id("btnSaveCamera"));
//		    	String nodeButton = elements.getAttribute("title").toString();		
//		    	if(nodeButton.equals("Save [nodePRC3]")) {
//		    		System.out.println(nodeButton);
//		    		Thread.sleep(5000);
//		    		elements.click();
//		    		break;
//		    	}  
//		    	fail();
//		    }
			
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
