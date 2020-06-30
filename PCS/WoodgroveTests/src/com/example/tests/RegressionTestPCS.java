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
	public static String baseUrlPCS;
	public static String baseUrlPOP;
	public static String urlCamera;
	public static String usernameCamera;
	public static String passwordCamera;
	public static StringBuffer verificationErrors = new StringBuffer(); 
	//Test eclipse
	//public final String pathChromeDriver = "C:\\Projects\\AutomatedTests\\Package\\chromedriver.exe";  	
	//Test VM
	private final String pathChromeDriver =  "C:\\PCSNightlyBuild\\Tests\\chromedriver.exe";    
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
		baseUrlPCS = "https://localhost:3002/"; 		
		baseUrlPOP = "https://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Test eclipse
		//urlCamera = "C:\\Users\\Danielly Cardoso\\Documentos\\Woodgrove\\PCS\\Arquivos de config para teste\\PRC\\raw_images"; 
		//Test VM
		urlCamera = "C:\\Users\\Woodgrove\\Desktop\\Test\\Images"; 
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
		createNode();			
	}
	
	@Test (priority=3, dependsOnMethods = { "TC002createNodePCS" })
	public void TC003createExistingNodePCS() throws Exception	{
		createExistingNode();			
	}
	
	@Test (priority=4, dependsOnMethods = { "TC003createExistingNodePCS" })
	public void TC004deleteNodePCS() throws Exception	{
		deleteNode();			
	}
		
	@Test (priority=5, dependsOnMethods = { "TC004deleteNodePCS" })
	public void TC005editNodePCS() throws Exception	{
		editNode();			
	}
	
	@Test (priority=6, dependsOnMethods = { "TC005editNodePCS" })
	public void TC006statusCheckPCS() throws Exception	{
		statusCheck();			
	}
	
	@Test (priority=7, dependsOnMethods = { "TC006statusCheckPCS" })
	public void TC007setSchedulerAllNodesPCS() throws Exception{
		setSchedulerAllNodes();
	}	
	
	@Test (priority=8, dependsOnMethods = { "TC007setSchedulerAllNodesPCS" })
	public void TC008setGlobalUnitMeasurePCS() throws Exception {
		//setGlobalUnitMeasureToCm();	
	}
	
	@Test (priority=9, dependsOnMethods = { "TC008setGlobalUnitMeasurePCS" })
	public void TC009statusCheckPCS() throws Exception	{
		//statusCheckAfterSetGlobalUnitMeasure();			
	}
	
	@Test (priority=10, dependsOnMethods = { "TC009statusCheckPCS" })
	public void TC010getSnapshotPCS() throws Exception {
		//getSnapshot();			
	}
	
	@Test (priority=11, dependsOnMethods = { "TC010getSnapshotPCS" })
	public void TC011setAlarmPCS() throws Exception {
		//setAlarm();			
	}	
	
	@Test (priority=12, dependsOnMethods = { "TC011setAlarmPCS" })
	public void TC012saveAndApplyMultipleNodePCS() throws Exception {
		//saveAndApplyMultipleNode();		
	}		
	
	@Test (priority=13, dependsOnMethods = { "TC012saveAndApplyMultipleNodePCS" })
	public void TC013setCycleTimePCS() throws Exception {
		//setCycleTime();	
	}	
	
	@Test (priority=14, dependsOnMethods = { "TC013setCycleTimePCS" })
	public void TC014setScheduleTypePCS() throws Exception{
		//setScheduleType();			
	}
	
	//APC-685
	/*@Test (priority=15, dependsOnMethods = { "TC014setScheduleTypePCS" })
	public void TC015setTruckEventPCS() throws Exception{
		setTruckEvent();			
	}*/
	
	//APC-673
	/*@Test (priority=16, dependsOnMethods = { "TC015setTruckEventPCS" })
	public void TC016statusCheckServicePCS() throws Exception{
		statusCheckService();			
	}*/
	
	//APC-673
	/*@Test (priority=17, dependsOnMethods = { "TC015setTruckEventPCS" })
	public void TC017imageTrailPCS() throws Exception{
		imageTrail();			
	}*/
	
	//APC-673
	/*@Test (priority=18, dependsOnMethods = { "TC015setTruckEventPCS" })
	public void TC018automaticExposureAdjustmentsPCS() throws Exception{
		automaticExposureAdjustments();			
	}*/
	
	//APC-673
	/*@Test (priority=19, dependsOnMethods = { "TC015setTruckEventPCS" })
	public void TC019truckEventBurstPCS() throws Exception{
		truckEventBurst();			
	}*/
	
	//APC-673
	/*@Test (priority=20, dependsOnMethods = { "TC015setTruckEventPCS" })
	public void TC020imageBufferTestPCS() throws Exception{
		imageBufferTest();			
	}*/
	
	
	
	
	@Test (priority=15, dependsOnMethods = { "TC014setScheduleTypePCS" })
	public void TC015loginValidatePOP() throws Exception{
	//	loginValidatePOP();			
	}
		
	@Test (priority=16, dependsOnMethods = { "TC015loginValidatePOP" })
	public void TC016checkCamerasPOP() throws Exception{
	//	checkCameras();			
	}
	
	@Test (priority=17, dependsOnMethods = { "TC016checkCamerasPOP" })
	public void TC017createNewCameraPOP() throws Exception{
	//	createNewCamera();			
	}
	
	@Test (priority=18, dependsOnMethods = { "TC017createNewCameraPOP" })
	public void TC018createDisplayGroupPOP() throws Exception{
	//	createDisplayGroup();			
	}
	
	@Test (priority=19, dependsOnMethods = { "TC018createDisplayGroupPOP" })
	public void TC019checkDisplayGroupPOP() throws Exception{
	//	checkDisplayGroup();			
	}
	
	
	
	
	@Test (priority=18, dependsOnMethods = { "TC017createNewCameraPOP" })
	public void TC018deleteAllNodesPCS() throws Exception{
		//deleteAllNodes();			
	}
	
	@Test (priority=19, dependsOnMethods = { "TC018deleteAllNodesPCS" })
	public void TC019setGlobalUnitMeasureToInchesPCS() throws Exception{
		//setGlobalUnitMeasureToInches();			
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
