package src.com.example.tests;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;

public class ConfigFileTest {
	public static void main(String[] args) {
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { ConfigFileTest.class });
		testSuite.run();
	}		
	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
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
	baseUrl = "https://localhost:3002/#/login";
	//Test local (nightly)
	//baseUrl = "https://192.168.1.202:3003/#/login";    
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

  @Test
  public void testConfigFile() throws Exception {
    driver.get(baseUrl + "/#/login");
    driver.findElement(By.id("pcsusername")).clear();
    driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
    driver.findElement(By.id("pcspass")).click();
    driver.findElement(By.id("pcspass")).sendKeys("test");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.xpath("//div[@id='instrument-manager']/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/div/table/tbody/tr[2]/td[6]/button")).click();
    driver.findElement(By.id("description-area")).clear();
    for(int i=0; i<=100000; ++i)
    {
        driver.findElement(By.id("description-area")).sendKeys("a");
        driver.findElement(By.name("savebtn")).click();    	
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

  /*  private boolean isElementPresent(By by) {
  try {
    driver.findElement(by);
    return true;
  } catch (NoSuchElementException e) {
    return false;
  }
}*/

/*  private boolean isAlertPresent() {
  try {
    driver.switchTo().alert();
    return true;
  } catch (NoAlertPresentException e) {
    return false;
  }
}*/

/*  private String closeAlertAndGetItsText() {
  try {
    Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();
    if (acceptNextAlert) {
      alert.accept();
    } else {
      alert.dismiss();
    }
    return alertText;
  } finally {
    acceptNextAlert = true;
  }
}*/
}
