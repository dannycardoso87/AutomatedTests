package src.com.example.tests;

import org.testng.TestNG;
//import org.testng.TestNG;
import org.testng.annotations.*;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class RegressionTestPCS extends SuiteTestPCS {
	
	public static void main(String[] args) {
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { RegressionTestPCS.class });
		testSuite.run();
	}		

	public static WebDriver driver;
	public static String baseUrl;
	public static String urlCamera;
	public static String usernameCamera;
	public static String passwordCamera;
	public static StringBuffer verificationErrors = new StringBuffer(); 
	public final String pathChromeDriver = "C:\\Projects\\AutomatedTests\\Package\\chromedriver.exe";  	
	public static String nodeName1;
	public static String nodeName2;
	public static String nodeName3;
	public static String nodeName4;
	public static String nodeName5;
	

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "https://localhost:3002/"; 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		urlCamera = "C:\\Users\\Danielly Cardoso\\OneDrive - Woodgrove Technologies Inc\\Desktop\\nodefiles\\PFC1\\raw_images"; 
		usernameCamera = "axis";
		passwordCamera = "root";
		nodeName1 = "nodePRC";
		nodeName2 = "nodePFC";
		nodeName3 = "nodeIMC";
		nodeName4 = "nodeTruck";
		nodeName5 = "node";		
	}
	
	@Test (priority=1)	
	public void TC001loginValidatePCS() throws Exception	{
		loginValidatePCS();			
	}
	
	@Test (priority=2, dependsOnMethods = { "TC001loginValidatePCS" })
	public void TC002createNodePCS() throws Exception	{
		createNodePCS();			
	}
	
	@Test (priority=3, dependsOnMethods = { "TC002createNodePCS" })
	public void TC003createExistingNode() throws Exception	{
		createExistingNode();			
	}
	
	@Test (priority=4, dependsOnMethods = { "TC003createExistingNode" })
	public void TC004deleteNode() throws Exception	{
		deleteNode();			
	}
		
	@Test (priority=5, dependsOnMethods = { "TC004deleteNode" })
	public void TC005editNode() throws Exception	{
		editNode();			
	}
	
	@Test (priority=6, dependsOnMethods = { "TC005editNode" })
	public void TC006statusCheck() throws Exception	{
		statusCheck();			
	}
	
	@Test (priority=7, dependsOnMethods = { "TC006statusCheck" })
	public void TC007stopSchedulerAllNodes() throws Exception{
		stopSchedulerAllNodes();
	}	
	
	@Test (priority=8, dependsOnMethods = { "TC007stopSchedulerAllNodes" })
	public void TC008setGlobalUnitMeasure() throws Exception {
		setGlobalUnitMeasure();	
	}
	
	@Test (priority=9, dependsOnMethods = { "TC008setGlobalUnitMeasure" })
	public void TC009statusCheck() throws Exception	{
//		statusCheck();			
	}
	
	@Test (priority=10, dependsOnMethods = { "TC009statusCheck" })
	public void TC010getSnapshot() throws Exception {
//		getSnapshot();			
	}

	@Test (priority=11, dependsOnMethods = { "TC010getSnapshot" })
	public void TC0011setCycleTime() throws Exception {
//		setCycleTime();	
	}	
	
	@Test (priority=12, dependsOnMethods = { "TC0011setCycleTime" })
	public void TC012deleteAllNodes() throws Exception{
		deleteAllNodes();			
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
