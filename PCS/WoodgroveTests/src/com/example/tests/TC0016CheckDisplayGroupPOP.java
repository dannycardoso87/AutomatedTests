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

public class TC0016CheckDisplayGroupPOP {
	
		public static void main() {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC0016CheckDisplayGroupPOP.class });
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
		public void testTC0016CheckDisplayGroupPOP() throws Exception {
			driver.get(baseUrlPOP);
			driver.findElement(By.id("pcsusername")).clear();
			driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
			driver.findElement(By.id("pcspass")).clear();
			driver.findElement(By.id("pcspass")).sendKeys("test");
		
			WebDriverWait waitBtnSubmit = new WebDriverWait(driver, 10);
			WebElement btnSubmit = waitBtnSubmit.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmit")));
			btnSubmit.click();				
			
			List <WebElement> listOfElements = driver.findElements(By.id("viewGroups"));
		    System.out.println("Number of elements:" +listOfElements.size());
		    for (int i=0; i < listOfElements.size();i++){
		    	WebElement searchView =  listOfElements.get(i).findElement(By.id("nameViewGroup"));
		    	String nameGroup = searchView.getText().toString();	    	
		    	WebElement btnViewGroup =  listOfElements.get(i).findElement(By.id("btnViewGroup"));
		    	if(nameGroup.equals("Display")) {
		    		System.out.println(nameGroup);
		    		btnViewGroup.click();		    		
		    		break;
		    	}    
		    }
		    List <WebElement> listOfElements2 = driver.findElements(By.id("groupDisplay"));
		    System.out.println("Number of elements:" +listOfElements2.size());
		    for (int i=0; i < listOfElements2.size();i++){
		    	WebElement camView =  listOfElements2.get(i).findElement(By.id("nameCamView"));
		    	String nameCamView = camView.getText().toString();	    	
		    	if(nameCamView.equals("nodePFC3")) {
		    		System.out.println(nameCamView);
		    	}else {
		    		fail();
		    	}
		    	if(nameCamView.equals("nodePFC2")) {
		    		System.out.println(nameCamView);
		    	}else {
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
