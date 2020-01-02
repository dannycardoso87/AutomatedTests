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



public class TC001LoginValidate {

	public static void main(String[] args) {
			TestNG testSuite = new TestNG();
			testSuite.setTestClasses(new Class[] { TC001LoginValidate.class });
			testSuite.run();
		}
	
	
  private WebDriver driver;
  private String baseUrl = "https://192.168.1.202:3003";
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  //private final String pathChromeDriver = "C:\\Users\\Woodgrove\\chromedriver.exe";
  private final String pathChromeDriver = "C:\\Projects\\AutomationTests\\PCS\\WoodgroveTests\\Package\\chromedriver.exe";
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", pathChromeDriver);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    //baseUrl = "https://localhost:3002/#/login";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTC001LoginValidate() throws Exception {
    driver.get(baseUrl + "/#/login");
    driver.findElement(By.id("pcsusername")).clear();
    driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
    driver.findElement(By.id("pcspass")).clear();
    driver.findElement(By.id("pcspass")).sendKeys("test");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
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
