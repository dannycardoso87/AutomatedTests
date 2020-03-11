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

public class TC009AutoStartNodePCS { 
	public static void main() {
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { TC009AutoStartNodePCS.class });
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
  public void testTC009AutoStartNodePCS() throws Exception {
	driver.get(baseUrl + "#/login");
	driver.findElement(By.id("pcsusername")).clear();
	driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
	driver.findElement(By.id("pcspass")).clear();
	driver.findElement(By.id("pcspass")).sendKeys("test");  
	driver.findElement(By.id("btnSubmit")).click();
	
	//Edit Schedule node
	List <WebElement> listOfElements = driver.findElements(By.id("tableNode"));
    System.out.println("Number of elements:" +listOfElements.size());
    for (int i=0; i < listOfElements.size();i++){
    	System.out.println(i);
    	WebElement elements =  listOfElements.get(i).findElement(By.id("tableNodeID"));
    	WebElement elements2 =  listOfElements.get(i).findElement(By.id("btnEditNode"));
    	String nodeName = elements.getText().toString();       	
    	if(nodeName.equals("nodePRC"))  {
    		System.out.println(nodeName);
    		Thread.sleep(5000); 
    		WebElement button = elements2.findElement(By.id("btnEditNodeID")); 
    		Thread.sleep(5000); 
    		button.click(); 
    		//5s explicit wait 
    		Thread.sleep(5000); 
    		driver.findElement(By.id("Auto")).click();    		
    		driver.findElement(By.id("btnSaveNode")).click();
    		Thread.sleep(5000);
    		new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
    		driver.switchTo().alert().accept(); 
			Thread.sleep(5000);
			driver.findElement(By.className("logo")).click();
			break;
		} 
    }  
    Thread.sleep(10000);
	//Get nodes cycletimes 
	List <WebElement> listOfElements2 = driver.findElements(By.id("tableNode"));
    System.out.println("Number of elements:" +listOfElements2.size());	    
    for (int i=0; i < listOfElements2.size();i++){
    	WebElement elements = listOfElements2.get(i).findElement(By.id("tableNodeID"));
    	String nodeName = elements.getText().toString(); 
    	WebElement elements2 = listOfElements2.get(i).findElement(By.id("cycleTime"));
    	String cycleTime1 = elements2.getText().toString();   
    	System.out.println(cycleTime1); 
    	Thread.sleep(8000);
    	String cycleTime2 = elements2.getText().toString();   
    	System.out.println(cycleTime2); 
    		    	 	
    	//Check nodes status
    	if(nodeName.equals("nodePRC")) {
    		System.out.println(nodeName);
    		if (cycleTime1.equals(cycleTime2)) {
    			System.out.println("Node "+nodeName+" is stoped"); 	    			
			}else {
				System.out.println("Node "+nodeName+" is working");
				fail();
			}    	
    	}		    	
    }		
    
	//Edit Schedule node
	List <WebElement> listOfElements3 = driver.findElements(By.id("tableNode"));
    System.out.println("Number of elements:" +listOfElements3.size());
    for (int i=0; i < listOfElements3.size();i++){
    	System.out.println(i);
    	WebElement elements =  listOfElements3.get(i).findElement(By.id("tableNodeID"));
    	WebElement elements2 =  listOfElements3.get(i).findElement(By.id("btnEditNode"));
    	String nodeName = elements.getText().toString();       	
    	if(nodeName.equals("nodePRC"))  {
    		System.out.println(nodeName);
    		Thread.sleep(5000); 
    		WebElement button = elements2.findElement(By.id("btnEditNodeID")); 
    		Thread.sleep(5000);
    		button.click(); 
    		//5s explicit wait 
    		Thread.sleep(5000); 
    		driver.findElement(By.id("Auto")).click();    		
    		driver.findElement(By.id("btnSaveNode")).click();
    		Thread.sleep(5000);
    		new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
    		driver.switchTo().alert().accept(); 
			Thread.sleep(5000);
			driver.findElement(By.className("logo")).click();
			break;
		} 
    }  
    Thread.sleep(10000);
	//Get nodes cycletimes 
	List <WebElement> listOfElements4 = driver.findElements(By.id("tableNode"));
    System.out.println("Number of elements:" +listOfElements4.size());	    
    for (int i=0; i < listOfElements4.size();i++){
    	WebElement elements = listOfElements4.get(i).findElement(By.id("tableNodeID"));
    	String nodeName = elements.getText().toString(); 
    	WebElement elements2 = listOfElements4.get(i).findElement(By.id("cycleTime"));
    	String cycleTime1 = elements2.getText().toString();   
    	System.out.println(cycleTime1); 
    	Thread.sleep(8000);
    	String cycleTime2 = elements2.getText().toString();   
    	System.out.println(cycleTime2); 
    		    	 	
    	//Check nodes status
    	if(nodeName.equals("nodePRC")) {
    		System.out.println(nodeName);
    		if (cycleTime1.equals(cycleTime2)) {
    			System.out.println("Node "+nodeName+" is stoped"); 	
    			fail();
			}else {
				System.out.println("Node "+nodeName+" is working");				
			}    	
    	}		    	
    }	     
        	
    //5s explicit wait
    Thread.sleep(8000);
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
