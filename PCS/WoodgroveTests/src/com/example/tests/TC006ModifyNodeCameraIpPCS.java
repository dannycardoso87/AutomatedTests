package src.com.example.tests;

import java.util.List;
//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;

public class TC006ModifyNodeCameraIpPCS {
	public static void main() {
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { TC006ModifyNodeCameraIpPCS.class });
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
  public void testTC006ModifyNodeCameraIp() throws Exception {
		driver.get(baseUrl + "#/login");
		driver.findElement(By.id("pcsusername")).clear();
		driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
		driver.findElement(By.id("pcspass")).clear();
		driver.findElement(By.id("pcspass")).sendKeys("test");  
		driver.findElement(By.id("btnSubmit")).click();
		
		//Edit nodePFC
		List <WebElement> listOfElements = driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	WebElement elements =  listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();   	
	    	if(nodeName.equals("nodePFC")) {
	    		System.out.println(nodeName);
	    		Thread.sleep(5000);
	    		WebElement button = elements2.findElement(By.id("btnEditNodeID"));
	    		Thread.sleep(5000);
	    		button.click();
	    		break;
	    	}    	    	
	    }
	    Thread.sleep(5000);
	    driver.findElement(By.id("cameraSettings")).click();
		Thread.sleep(5000);
	    driver.findElement(By.id("imputCameraIP")).clear();
	    driver.findElement(By.id("imputCameraIP")).sendKeys("192.168.1.110");
	    Thread.sleep(5000);
	    driver.findElement(By.id("btnImageTest")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.className("full-img"));
	    Thread.sleep(5000);
	    driver.findElement(By.id("btnSaveNode")).click();
	    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    //Click home button
	    driver.findElement(By.id("btnHome")).click();

		//Edit nodePRC
		List <WebElement> listOfElements2 = driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements2.size());
	    for (int i=0; i < listOfElements2.size();i++){
	    	WebElement elements =  listOfElements2.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements2.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();   	
	    	if(nodeName.equals("nodePRC")) {
	    		System.out.println(nodeName);
	    		Thread.sleep(5000);
	    		WebElement button = elements2.findElement(By.id("btnEditNodeID"));
	    		Thread.sleep(5000);
	    		button.click();
	    		break;
	    	}    	    	
	    }
	    Thread.sleep(5000);
	    driver.findElement(By.id("cameraSettings")).click();
		Thread.sleep(5000);
	    driver.findElement(By.id("imputCameraIP")).clear();
	    driver.findElement(By.id("imputCameraIP")).sendKeys("192.168.1.110");
	    Thread.sleep(5000);
	    driver.findElement(By.id("btnImageTest")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.className("full-img"));
	    Thread.sleep(5000);
	    driver.findElement(By.id("btnSaveNode")).click();
	    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    //Click home button
	    driver.findElement(By.id("btnHome")).click();
 
		//Edit nodeTruck
		List <WebElement> listOfElements4 = driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements4.size());
	    for (int i=0; i < listOfElements4.size();i++){
	    	WebElement elements =  listOfElements4.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements4.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();   	
	    	if(nodeName.equals("nodeTruck")) {
	    		System.out.println(nodeName);
	    		Thread.sleep(5000);
	    		WebElement button = elements2.findElement(By.id("btnEditNodeID"));
	    		Thread.sleep(5000);
	    		button.click();
	    		break;
	    	}    	    	
	    }
	    Thread.sleep(5000);
	    driver.findElement(By.id("cameraSettings")).click();
		Thread.sleep(5000);
	    driver.findElement(By.id("imputCameraIP")).clear();
	    driver.findElement(By.id("imputCameraIP")).sendKeys("192.168.1.110");
	    Thread.sleep(5000);
	    driver.findElement(By.id("btnImageTest")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.className("full-img"));
	    Thread.sleep(5000);
	    driver.findElement(By.id("btnSaveNode")).click();
	    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    //Click home button
	    driver.findElement(By.id("btnHome")).click();
	    
		//Edit nodeIMC
		List <WebElement> listOfElements3 = driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements3.size());
	    for (int i=0; i < listOfElements3.size();i++){
	    	WebElement elements =  listOfElements3.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements3.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();   	
	    	if(nodeName.equals("nodeIMC")) {
	    		System.out.println(nodeName);
	    		Thread.sleep(5000);
	    		WebElement button = elements2.findElement(By.id("btnEditNodeID"));
	    		Thread.sleep(5000);
	    		button.click();
	    		break;
	    	}    	    	
	    }
	    Thread.sleep(5000);
	    driver.findElement(By.id("cameraSettings")).click();
		Thread.sleep(5000);
	    driver.findElement(By.id("imputCameraIP")).clear();
	    driver.findElement(By.id("imputCameraIP")).sendKeys("192.168.1.110");
	    Thread.sleep(5000);
//	    driver.findElement(By.className("form-control ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched")).sendKeys("2019-09-11_08-57-56");
//	    driver.findElement(By.id("btnImageTest")).click();
//	    Thread.sleep(5000);
//	    driver.findElement(By.className("full-img"));
//	    Thread.sleep(5000);
	    driver.findElement(By.id("btnSaveNode")).click();
	    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();
	    //Click home button
	    driver.findElement(By.id("btnHome")).click();
	    	    	    
	    //5s explicit wait
	    Thread.sleep(5000);
	    //Click Logout button
	    driver.findElement(By.id("btnLogout")).click();     
	    
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