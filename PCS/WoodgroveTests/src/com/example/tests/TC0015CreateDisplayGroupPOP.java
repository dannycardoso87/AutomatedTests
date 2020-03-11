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

public class TC0015CreateDisplayGroupPOP {
	
		public static void main() {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC0015CreateDisplayGroupPOP.class });
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
		public void testTC0015CreateDisplayGroupPOP() throws Exception {
			driver.get(baseUrlPOP);
			driver.findElement(By.id("pcsusername")).clear();
			driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
			driver.findElement(By.id("pcspass")).clear();
			driver.findElement(By.id("pcspass")).sendKeys("test");
		
			WebDriverWait waitBtnSubmit = new WebDriverWait(driver, 10);
			WebElement btnSubmit = waitBtnSubmit.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmit")));
			btnSubmit.click();			
			
			WebDriverWait waitBtnSidebarCam = new WebDriverWait(driver, 10);
			WebElement btnSidebarCam = waitBtnSidebarCam.until(ExpectedConditions.elementToBeClickable(By.id("btnSidebarGroup")));
			btnSidebarCam.click();
			
			//Try to save a group with no information
			driver.findElement(By.id("btnNewGroup")).click();
			driver.findElement(By.id("btnSaveGroup")).click();
			WebElement text = driver.findElement(By.id("msgGroupUnsaved"));
		    Boolean m = new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(text,"Groups Edited - Unsaved"));
		    if(m.equals(true)) {
		    	System.out.println("Groups Edited - Unsaved");
		    }			
			//Save a group with display view
			driver.findElement(By.id("groupName")).clear();
			driver.findElement(By.id("groupName")).sendKeys("Display");
    		driver.findElement(By.id("viewType")).click();
    		driver.findElement(By.id("viewType")).sendKeys(" Display ");
    		driver.findElement(By.id("viewType")).click();
			driver.findElement(By.id("groupSearchCam")).clear();
			driver.findElement(By.id("groupSearchCam")).sendKeys("PFC");			
			
			List <WebElement> listOfElements = driver.findElements(By.id("tableSearchCameras"));
		    System.out.println("Number of elements:" +listOfElements.size());
		    if(listOfElements.isEmpty()) {
		    	System.out.println("Number of elements:" +listOfElements.size());
		    	fail();
		    }
		    for (int i=0; i < listOfElements.size();i++){
		    	WebElement searchCamera =  listOfElements.get(i).findElement(By.id("searchCamera"));
		    	String nameCamera = searchCamera.getText().toString();	
		    	WebElement btnAddSearchCamera = listOfElements.get(i).findElement(By.id("btnAddSearchCamera"));
		    	if(nameCamera.equals("add_circle\n" + "nodePFC")) {
		    		System.out.println(nameCamera);
		    		btnAddSearchCamera.click();
		    		break;
		    	}else {
		    		System.out.println("Didn't find the button");
		    		fail();
		    	}
		    }
		    
		    driver.findElement(By.id("groupSearchCam")).clear();
			driver.findElement(By.id("groupSearchCam")).sendKeys("PRC");			
			
			List <WebElement> listOfElements2 = driver.findElements(By.id("tableSearchCameras"));
		    System.out.println("Number of elements:" +listOfElements2.size());
		    if(listOfElements2.isEmpty()) {
		    	System.out.println("Number of elements:" +listOfElements2.size());
		    	fail();
		    }
		    for (int i=0; i < listOfElements2.size();i++){
		    	WebElement searchCamera =  listOfElements2.get(i).findElement(By.id("searchCamera"));
		    	String nameCamera = searchCamera.getText().toString();	
		    	WebElement btnAddSearchCamera = listOfElements2.get(i).findElement(By.id("btnAddSearchCamera"));
		    	if(nameCamera.equals("add_circle\n" + "nodePRC")) {
		    		System.out.println(nameCamera);
		    		btnAddSearchCamera.click();
		    		break;
		    	}else {
		    		System.out.println("Didn't find the button");
		    		fail();
		    	}
		    }

			WebDriverWait waitBtnSaveCam = new WebDriverWait(driver, 10);
			WebElement btnSaveCam = waitBtnSaveCam.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveGroup")));
			btnSaveCam.click();			
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
