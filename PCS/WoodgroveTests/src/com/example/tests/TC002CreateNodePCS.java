package src.com.example.tests;

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

public class TC002CreateNodePCS {
	public static void main() {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC002CreateNodePCS.class });
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
  public void testTC002CreateNode() throws Exception {
	driver.get(baseUrl + "#/login");
    driver.findElement(By.id("pcsusername")).clear();
    driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
    driver.findElement(By.id("pcspass")).clear();
    driver.findElement(By.id("pcspass")).sendKeys("test");
    //Login
    driver.findElement(By.id("btnSubmit")).click();
    //Click the Add button to creat a new node "nodetest"
    driver.findElement(By.id("btnCreateNode")).click();    
    //5s explicit wait
    Thread.sleep(5000);
    //Find the phrase "Node id cannot be empty."
    assertEquals(driver.findElement(By.id("nodeMsgModal")).getText(), "Node id cannot be empty.");
    //Clear input
    driver.findElement(By.id("newNodeForm")).clear();
    //Input node name
    driver.findElement(By.id("newNodeForm")).sendKeys("nodetest1");
    //5s explicit wait
    Thread.sleep(5000);
    //Click the Submit button
    driver.findElement(By.id("btnSubmitNewNode")).click();
    //30s explicit wait and close alert
    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();
    
    driver.findElement(By.id("newNodeForm")).clear();
    //Input node name
    driver.findElement(By.id("newNodeForm")).sendKeys("nodetest2");
    //5s explicit wait
    Thread.sleep(5000);
    //Click the Submit button
    driver.findElement(By.id("btnSubmitNewNode")).click();
    //30s explicit wait and close alert
    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();    
    
    driver.findElement(By.id("newNodeForm")).clear();
    //Input node name
    driver.findElement(By.id("newNodeForm")).sendKeys("nodetest3");
    //5s explicit wait
    Thread.sleep(5000);
    //Click the Submit button
    driver.findElement(By.id("btnSubmitNewNode")).click();
    //30s explicit wait and close alert
    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();    
    
    driver.findElement(By.id("newNodeForm")).clear();
    //Input node name
    driver.findElement(By.id("newNodeForm")).sendKeys("nodetest4");
    //5s explicit wait
    Thread.sleep(5000);
    //Click the Submit button
    driver.findElement(By.id("btnSubmitNewNode")).click();
    //30s explicit wait and close alert
    new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();    
        
    //5s explicit wait
    Thread.sleep(5000);   
    //Click cancel button
    driver.findElement(By.id("btnCancelNewNode")).click();
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
