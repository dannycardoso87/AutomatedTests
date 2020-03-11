package src.com.example.tests;

import java.util.List;
//import java.util.Random;
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

public class TC004DeleteNodePCS {
	public static void main() {
		TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { TC004DeleteNodePCS.class });
		testSuite.run();
	}

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	// Tests local
	private final String pathChromeDriver = "C:\\Projects\\AutomatedTests\\Package\\chromedriver.exe";
	// Test VM
	// private final String pathChromeDriver =
	// "C:\\PCSNightlyBuild\\Tests\\chromedriver.exe";
	private String nodeId = "nodetest5";

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Test VM e local
		baseUrl = "https://localhost:3002/";
		// Test local (nightly)
		// baseUrl = "https://192.168.1.202:3003/#/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testTC004DeleteNode() throws Exception {
		// Integer number = new Random().nextInt(11) + 20;
		// nodeId = "node" + number.toString();
		driver.get(baseUrl + "#/login");
		driver.findElement(By.id("pcsusername")).clear();
		driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
		driver.findElement(By.id("pcspass")).clear();
		driver.findElement(By.id("pcspass")).sendKeys("test");
		driver.findElement(By.id("btnSubmit")).click();
		// Create node1
		driver.findElement(By.id("btnCreateNode")).click();
		/*
		 * Thread.sleep(2000);
		 * assertEquals(driver.findElement(By.id("nodeMsgModal")).getText(),
		 * "Node id cannot be empty.");
		 */

		WebElement text = driver.findElement(By.id("nodeMsgModal"));
		Boolean m = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.textToBePresentInElement(text, "Node id cannot be empty."));
		if (m.equals(true)) {
			System.out.println("Node id cannot be empty.");
		}

		driver.findElement(By.id("newNodeForm")).clear();
		driver.findElement(By.id("newNodeForm")).sendKeys("nodetest5");

		/*
		 * //5s explicit wait Thread.sleep(5000); //Click the Submit button
		 * driver.findElement(By.id("btnSubmitNewNode")).click();
		 */
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
		element.click();
		// 30s explicit wait and close alert
		new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		/*
		 * //5s explicit wait Thread.sleep(5000); //Click cancel button
		 * driver.findElement(By.id("btnCancelNewNode")).click();
		 */
		Thread.sleep(1000);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("btnCancelNewNode")));
		element2.click();

		// Identify the inserted node and click on the edit button
		List<WebElement> listOfElements = driver.findElements(By.id("tableNode"));
		System.out.println("Number of elements:" + listOfElements.size());
		for (int i = 0; i < listOfElements.size(); i++) {
			WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
			WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
			String nodeName = elements.getText().toString();
			if (nodeName.equals("nodetest5")) {
				System.out.println(nodeName);
				
				Thread.sleep(5000); 
				WebElement button = elements2.findElement(By.id("btnEditNodeID")); 
				Thread.sleep(5000);
				button.click();
				break;
			}
		}
		// 5s explicit wait
		Thread.sleep(5000);
		// Identify the node in the list on the left and click the delete button
		List<WebElement> listOfElements2 = driver.findElements(By.id("tableGroupNode"));
		System.out.println("Number of elements:" + listOfElements2.size());
		for (int i = 0; i < listOfElements2.size(); i++) {
			WebElement elements3 = listOfElements2.get(i).findElement(By.id("tableGroupNodeID"));
			String nodeName2 = elements3.getText().toString();
			if (nodeName2.equals("nodetest5\nEdit\nStop")) {
				System.out.println(nodeName2);
				Thread.sleep(5000);
				WebElement button = elements3.findElement(By.id("btnDeleteNode"));
				button.click();
				/*
				 * Thread.sleep(1000); WebDriverWait wait4 = new WebDriverWait(driver, 10);
				 * elements3 =
				 * wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnDeleteNode")));
				 * elements3.click();
				 */

				Thread.sleep(5000);
				new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().accept();
				break;
			}
		}


		Thread.sleep(1000);
		wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnLogout")));
		element.click();
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
