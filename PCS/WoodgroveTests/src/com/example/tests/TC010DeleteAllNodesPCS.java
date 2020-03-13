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

public class TC010DeleteAllNodesPCS { 
	public static void main() {
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { TC010DeleteAllNodesPCS.class });
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
  public void testTC010DeleteAllNodesPCS() throws Exception {
	driver.get(baseUrl + "#/login");
	driver.findElement(By.id("pcsusername")).clear();
	driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
	driver.findElement(By.id("pcspass")).clear();
	driver.findElement(By.id("pcspass")).sendKeys("test");  
	driver.findElement(By.id("btnSubmit")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, 30);	
	String link = driver.findElement(By.id("btnHome")).getAttribute("href");  
	
	List <WebElement> tableNode = driver.findElements(By.id("tableNode"));
    System.out.println("Number of elements:" +tableNode.size());
    for (int i=0; i < tableNode.size();i++){
    	WebElement tableNodeID =  tableNode.get(i).findElement(By.id("tableNodeID"));
    	WebElement btnEditNode =  tableNode.get(i).findElement(By.id("btnEditNode"));
    	String nodeName = tableNodeID.getText().toString();   	
    	if(nodeName.equals("nodePRC")) {
    		System.out.println(nodeName);    		
    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
    		btnEditNodeID.click();    		
            List <WebElement> tableGroupNode = driver.findElements(By.id("tableGroupNode"));
            System.out.println("Number of elements:" +tableGroupNode.size());
            for (int j=0; j < tableGroupNode.size();j++){
            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
            	String nodeName2 = tableGroupNodeID.getText().toString();  
            	if(nodeName2.contains("nodePRC")) {
            		System.out.println(nodeName2);
    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
    				btnDeleteNode.click();
            	    new WebDriverWait(driver, 40).until(ExpectedConditions.alertIsPresent());
            	    driver.switchTo().alert().accept(); 
            		break;
            	}    	    	
            }break;
    	} 
    } 	  
 
    	

	tableNode = driver.findElements(By.id("tableNode"));
    System.out.println("Number of elements:" +tableNode.size());
    for (int i=0; i < tableNode.size();i++){
    	WebElement tableNodeID =  tableNode.get(i).findElement(By.id("tableNodeID"));
    	WebElement btnEditNode =  tableNode.get(i).findElement(By.id("btnEditNode"));
    	String nodeName = tableNodeID.getText().toString();   	
    	if(nodeName.equals("nodePFC")) {
    		System.out.println(nodeName);    		
    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
    		btnEditNodeID.click();    		
            List <WebElement> tableGroupNode = driver.findElements(By.id("tableGroupNode"));
            System.out.println("Number of elements:" +tableGroupNode.size());
            for (int j=0; j < tableGroupNode.size();j++){
            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
            	String nodeName2 = tableGroupNodeID.getText().toString();  
            	if(nodeName2.contains("nodePFC")) {
            		System.out.println(nodeName2);
    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
    				btnDeleteNode.click();
            	    new WebDriverWait(driver, 40).until(ExpectedConditions.alertIsPresent());
            	    driver.switchTo().alert().accept(); 
            		break;
            	}    	    	
            }break;
    	} 
    } 
    
    
    
    
//  	//List <WebElement> listOfElements2 = driver.findElements(By.id("tableNode"));
//  	listOfElements = driver.findElements(By.id("tableNode"));  	
//      System.out.println("Number of elements:" +listOfElements.size());
//      for (int i=0; i < listOfElements.size();i++){
//      	WebElement elements =  listOfElements.get(i).findElement(By.id("tableNodeID"));
//      	WebElement elements2 =  listOfElements.get(i).findElement(By.id("btnEditNode"));
//      	String nodeName = elements.getText().toString();   	
//      	if(nodeName.equals("nodePFC")) {
//      		System.out.println(nodeName);
//      		Thread.sleep(5000);
//      		WebElement button = elements2.findElement(By.id("btnEditNodeID"));
//      		Thread.sleep(5000);
//      		button.click();
//      		//5s explicit wait
//      		Thread.sleep(5000);    
//	        //Identify the node in the list on the left and click the delete button
//	        List <WebElement> listOfElements3 = driver.findElements(By.id("tableGroupNode"));
//	        System.out.println("Number of elements:" +listOfElements3.size());
//	        for (int j=0; j < listOfElements3.size();j++){
//	        	WebElement elements3 =  listOfElements3.get(j).findElement(By.id("tableGroupNodeID"));
//	          	String nodeName2 = elements3.getText().toString();  
//	          	if(nodeName2.contains("nodePFC")) {
//	          		System.out.println(nodeName2);
//	          		WebElement button2 = elements3.findElement(By.id("btnDeleteNode"));
//	          		button2.click();
//	          		Thread.sleep(5000); 
//	          	    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
//	          	    driver.switchTo().alert().accept(); 
//	          		break;
//            	}    	    	
//            }break;
//    	} 
//    }
  
    driver.get(link);	 
	
    //Delete nodeIMC
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
    		//5s explicit wait
            Thread.sleep(5000);    
            //Identify the node in the list on the left and click the delete button
            List <WebElement> listOfElements4 = driver.findElements(By.id("tableGroupNode"));
            System.out.println("Number of elements:" +listOfElements4.size());
            for (int j=0; j < listOfElements4.size();j++){
            	WebElement elements3 =  listOfElements4.get(j).findElement(By.id("tableGroupNodeID"));
            	String nodeName2 = elements3.getText().toString();  
            	if(nodeName2.contains("nodeIMC")) {
            		System.out.println(nodeName2);
            		WebElement button2 = elements3.findElement(By.id("btnDeleteNode"));
            		button2.click();
            		Thread.sleep(5000); 
            	    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
            	    driver.switchTo().alert().accept(); 
            		break;
            	}    	    	
            }break;
    	} 
    }
    driver.get(link);	
	
    //Delete nodeTruck
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
    		//5s explicit wait
            Thread.sleep(5000);    
            //Identify the node in the list on the left and click the delete button
            List <WebElement> listOfElements5 = driver.findElements(By.id("tableGroupNode"));
            System.out.println("Number of elements:" +listOfElements5.size());
            for (int j=0; j < listOfElements5.size();j++){
            	WebElement elements3 =  listOfElements5.get(j).findElement(By.id("tableGroupNodeID"));
            	String nodeName2 = elements3.getText().toString();  
            	if(nodeName2.contains("nodeTruck")) {
            		System.out.println(nodeName2);
            		WebElement button2 = elements3.findElement(By.id("btnDeleteNode"));
            		button2.click();
            		Thread.sleep(5000); 
            	    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
            	    driver.switchTo().alert().accept(); 
            		break;
            	}    	    	
            }break;
    	} 
    }    
    driver.get(link);	
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
