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
	public static StringBuffer verificationErrors = new StringBuffer(); 
	public final String pathChromeDriver = "C:\\Projects\\AutomatedTests\\Package\\chromedriver.exe";  	

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "https://localhost:3002/"; 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		urlCamera = "C:\\Users\\Danielly Cardoso\\OneDrive - Woodgrove Technologies Inc\\Desktop\\nodefiles\\PFC1\\raw_images"; 
	}
	
	@Test (priority=1)	
	public void TC001loginValidatePCS() throws Exception	{
		loginValidatePCS();			
	}
	
//	@Test (priority=2, dependsOnMethods = { "TC001loginValidatePCS" })
//	public void TC002createNodePCS() throws Exception	{
//		createNodePCS();			
//	}
	
//	@Test (priority=3, dependsOnMethods = { "TC002createNodePCS" })
//	public void TC003createExistingNode() throws Exception	{
//		createExistingNode();			
//	}
	
//	@Test (priority=4, dependsOnMethods = { "TC003createExistingNode" })
//	public void TC004deleteNode() throws Exception	{
//		deleteNode();			
//	}
		
//	@Test (priority=3, dependsOnMethods = { "TC002createNodePCS" })
//	public void TC005editNode() throws Exception	{
//		editNode();			
//	}
	
//	@Test (priority=5, dependsOnMethods = { "TC001loginValidatePCS" })
//	public void TC006statusCheck() throws Exception	{
//		statusCheck();			
//		System.out.println("statusCheck");
//	}
	
//	@Test (priority=2, dependsOnMethods = { "TC006statusCheck" })
//	public void T007stopSchedulerAllNodes() throws Exception{
//		stopSchedulerAllNodes();
//		System.out.println("stopSchedulerAllNodes");
//	}
	

//	@Test (priority=4, dependsOnMethods = { "TC005editNode" })
//	public void TC008deleteAllNodes() throws Exception	{
//		deleteNodeAllNodes();			
//	}
	
	
	@Test (priority=4, dependsOnMethods = { "TC001loginValidatePCS" })
	public void TC009setGlobalUnitMeasure() throws Exception	{
		setGlobalUnitMeasure();			
	}
	
	@Test (priority=4, dependsOnMethods = { "TC009setGlobalUnitMeasure" })
	public void TC0010getSnapshot() throws Exception	{
		getSnapshot();			
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
