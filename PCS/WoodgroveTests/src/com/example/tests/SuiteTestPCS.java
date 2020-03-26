package src.com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;

//import static org.testng.Assert.fail;

//import org.testng.TestNG;
//import org.testng.annotations.*;

//import static org.testng.Assert.fail;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuiteTestPCS{	
	
	public void loginValidatePCS() throws Exception {
		RegressionTestPCS.driver.get(RegressionTestPCS.baseUrl + "#/login");		
		if (RegressionTestPCS.driver.findElement(By.id("details-button")).isDisplayed()) {
			RegressionTestPCS.driver.findElement(By.id("details-button")).click();
			RegressionTestPCS.driver.findElement(By.id("proceed-link")).click();
		}		
		RegressionTestPCS.driver.findElement(By.id("pcsusername")).clear();
		RegressionTestPCS.driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
		RegressionTestPCS.driver.findElement(By.id("pcspass")).clear();
		RegressionTestPCS.driver.findElement(By.id("pcspass")).sendKeys("test2");
		RegressionTestPCS.driver.findElement(By.id("btnSubmit")).click();
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();
	    RegressionTestPCS.driver.findElement(By.id("pcspass")).clear();
	    RegressionTestPCS.driver.findElement(By.id("pcspass")).sendKeys("test");
	    RegressionTestPCS.driver.findElement(By.id("btnSubmit")).click();
	 }	
	
	public void createNodePCS() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		WebDriverWait waitbtnCreateNode = new WebDriverWait(RegressionTestPCS.driver, 20);
		WebElement btnCreateNode = waitbtnCreateNode.until(ExpectedConditions.elementToBeClickable(By.id("btnCreateNode")));
		btnCreateNode.click();	
		WebElement text = RegressionTestPCS.driver.findElement(By.id("nodeMsgModal"));
	    Boolean m = new WebDriverWait(RegressionTestPCS.driver, 20).until(ExpectedConditions.textToBePresentInElement(text,"Node id cannot be empty."));
	    if(m.equals(true)) {
	    	System.out.println("Node id cannot be empty");
	    }
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys(RegressionTestPCS.nodeName1);
	    WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
	    element.click();
	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys(RegressionTestPCS.nodeName2);
	    wait = new WebDriverWait(RegressionTestPCS.driver, 20);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
	    element.click();
	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();   
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys(RegressionTestPCS.nodeName3);
	    wait = new WebDriverWait(RegressionTestPCS.driver, 20);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
	    element.click();
	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();     
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys(RegressionTestPCS.nodeName4);
	    wait = new WebDriverWait(RegressionTestPCS.driver, 20);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
	    element.click();
	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();     
	    wait = new WebDriverWait(RegressionTestPCS.driver, 20);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCancelNewNode")));
	    element.click();		
		RegressionTestPCS.driver.get(link);
	}	
	
	public void createExistingNode() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		RegressionTestPCS.driver.findElement(By.id("btnCreateNode")).click();	    
	    WebElement text = RegressionTestPCS.driver.findElement(By.id("nodeMsgModal"));
	    Boolean m = new WebDriverWait(RegressionTestPCS.driver, 20).until(ExpectedConditions.textToBePresentInElement(text,"Node id cannot be empty."));
	    if(m.equals(true)) {
	    	System.out.println("Node id cannot be empty.");
	    }	    
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();	
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys(RegressionTestPCS.nodeName1);
	    WebElement text2 = RegressionTestPCS.driver.findElement(By.id("nodeMsgModal"));
	    Boolean m2 = new WebDriverWait(RegressionTestPCS.driver, 20).until(ExpectedConditions.textToBePresentInElement(text2,"Node id already in use."));
	    if(m2.equals(true)) {
	    	System.out.println("Node id already in use.");
	    }
	    WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCancelNewNode")));
	    element.click();
	    
	  }
	
	public void deleteNode() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		RegressionTestPCS.driver.findElement(By.id("btnCreateNode")).click();
		WebElement text = RegressionTestPCS.driver.findElement(By.id("nodeMsgModal"));
		WebElement btnEditNodeID;
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 50);
		
		Boolean m = new WebDriverWait(RegressionTestPCS.driver, 10).until(ExpectedConditions.textToBePresentInElement(text, "Node id cannot be empty."));
		if (m.equals(true)) {
			System.out.println("Node id cannot be empty.");
		}		
		RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
		RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys(RegressionTestPCS.nodeName5);
		Thread.sleep(3000);		
		WebElement btnSubmitNewNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
		btnSubmitNewNode.click();
		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
		RegressionTestPCS.driver.switchTo().alert().accept();
		WebElement btnCancelNewNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCancelNewNode")));
		btnCancelNewNode.click();

		List<WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
		System.out.println("Number of elements:" + listOfElements.size());
		for (int i = 0; i < listOfElements.size(); i++) {
			WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
			WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
			String nodeName = elements.getText().toString();
			if (nodeName.equals(RegressionTestPCS.nodeName5)) {
				System.out.println(nodeName);
				btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
				break;
			}
		}
		
		List<WebElement> listOfElements2 = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
		System.out.println("Number of elements:" + listOfElements2.size());
		for (int i = 0; i < listOfElements2.size(); i++) {
			WebElement elements3 = listOfElements2.get(i).findElement(By.id("tableGroupNodeID"));
			String nodeName2 = elements3.getText().toString();
			if (nodeName2.equals("node\nEdit\nStop")) {
				System.out.println(nodeName2);
				WebElement button = elements3.findElement(By.id("btnDeleteNode"));
				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
				btnDeleteNode.click();
				new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
				RegressionTestPCS.driver.switchTo().alert().accept();
				break;
			}
		}
	}	
	
	public void editNode() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 80);	
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals(RegressionTestPCS.nodeName2))  {
	    		System.out.println(nodeName);	    	
	    		WebDriverWait wait1 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement btnEditNodeID = wait1.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputNodeName = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys(RegressionTestPCS.nodeName2);
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputTypeNode = wait3.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("PFC");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		WebDriverWait wait4 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement btnSaveNode = wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	 
	    		WebDriverWait wait5 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement cameraSettings = wait5.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    	
	    		WebDriverWait wait6 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputCameraIP = wait6.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	
	    		WebDriverWait wait7 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputCameraModel = wait7.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		WebDriverWait wait8 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    	    WebElement btnImageTest = wait8.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		WebDriverWait wait9 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		btnSaveNode = wait9.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
				break;
			}     	
	    }  
		WebDriverWait waitbtnHome2 = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome2 = waitbtnHome2.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link2 = btnHome2.getAttribute("href");
		RegressionTestPCS.driver.get(link2);	
	    
		List <WebElement> listOfElements2 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements2.size());
	    for (int i=0; i < listOfElements2.size();i++){
	    	System.out.println(i);
	    	WebElement elements =  listOfElements2.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements2.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();  
	    	if(nodeName.equals(RegressionTestPCS.nodeName1))  {
	    		System.out.println(nodeName);	    	
	    		WebDriverWait wait1 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement btnEditNodeID = wait1.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();	
	    		WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputNodeName = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys(RegressionTestPCS.nodeName1);
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputTypeNode = wait3.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("PRC");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		WebDriverWait wait4 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement btnSaveNode = wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	
	    		WebDriverWait wait5 = new WebDriverWait(RegressionTestPCS.driver, 80);    		
	    		WebElement cameraSettings = wait5.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    
	    		WebDriverWait wait6 = new WebDriverWait(RegressionTestPCS.driver, 80);		
	    		WebElement imputCameraIP = wait6.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	 
	    		WebDriverWait wait7 = new WebDriverWait(RegressionTestPCS.driver, 80);   		
	    		WebElement imputCameraModel = wait7.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		WebDriverWait wait8 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		btnSaveNode = wait8.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		WebDriverWait wait9 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    	    WebElement btnImageTest = wait9.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		WebDriverWait wait10 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		btnSaveNode = wait10.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();	
				break;
			} 
	    }	     
		WebDriverWait waitbtnHome3 = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome3 = waitbtnHome3.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link3 = btnHome3.getAttribute("href");
		RegressionTestPCS.driver.get(link3);
	    
		List <WebElement> listOfElements3 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements3.size());
	    for (int i=0; i < listOfElements3.size();i++){
	    	System.out.println(i);
	    	WebElement elements =  listOfElements3.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements3.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();  
	    	if(nodeName.equals(RegressionTestPCS.nodeName4))  {
	    		System.out.println(nodeName);	
	    		WebDriverWait wait1 = new WebDriverWait(RegressionTestPCS.driver, 80);    		
	    		WebElement btnEditNodeID = wait1.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 80);	    		
	    		WebElement imputNodeName = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys(RegressionTestPCS.nodeName4);
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		WebElement imputTypeNode = wait3.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("Truck Dump Volume");	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		WebDriverWait wait4 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		WebElement btnSaveNode = wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	  
	    		WebDriverWait wait5 = new WebDriverWait(RegressionTestPCS.driver, 80);  		
	    		WebElement cameraSettings = wait5.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    	
	    		WebDriverWait wait6 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputCameraIP = wait6.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	  
	    		WebDriverWait wait7 = new WebDriverWait(RegressionTestPCS.driver, 80);  		
	    		WebElement imputCameraModel = wait7.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	  
	    		WebDriverWait wait8 = new WebDriverWait(RegressionTestPCS.driver, 80); 
	    		btnSaveNode = wait8.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		WebDriverWait wait9 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    	    WebElement btnImageTest = wait9.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		WebDriverWait wait10 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		wait10.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		WebDriverWait wait11 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		btnSaveNode = wait11.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();	
				break;
			} 
	    }	     
		WebDriverWait waitbtnHome4 = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome4 = waitbtnHome4.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link4 = btnHome4.getAttribute("href");
		RegressionTestPCS.driver.get(link4);
		
		List <WebElement> listOfElements4 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements4.size());
	    for (int i=0; i < listOfElements4.size();i++){
	    	System.out.println(i);
	    	WebElement elements =  listOfElements4.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements4.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();  
	    	if(nodeName.equals(RegressionTestPCS.nodeName3))  {
	    		System.out.println(nodeName);	
	    		WebDriverWait wait1 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement btnEditNodeID = wait1.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputNodeName = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys(RegressionTestPCS.nodeName3);
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputTypeNode = wait3.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("Image Collector");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		WebDriverWait wait4 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement btnSaveNode = wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	  
	    		WebDriverWait wait5 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement cameraSettings = wait5.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    	
	    		WebDriverWait wait6 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement imputCameraIP = wait6.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);
	    		WebDriverWait wait7 = new WebDriverWait(RegressionTestPCS.driver, 80);	    		
	    		WebElement imputCameraModel = wait7.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		WebDriverWait wait8 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		btnSaveNode = wait8.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    	    //Thread.sleep(1000);
	    		WebDriverWait wait9 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    	    WebElement btnImageTest = wait9.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();	
	    		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		WebDriverWait wait10 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		btnSaveNode = wait10.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		RegressionTestPCS.driver.get(link);		
				break;
			} 	
	    }   	
	}	
	
	public void statusCheck() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);			
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
		System.out.println("Number of elements:" +listOfElements.size());	
	    for (int i=0; i < listOfElements.size();i++){
	    	for (int j=0; j <50000; j++) {
	    		if(RegressionTestPCS.driver.findElement(By.id("tableNodeID")).isDisplayed()) {
	    			break;	    			
	    		}	    		
	    	}	    	
	    	Thread.sleep(5000);
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	String nodeName = elements.getText().toString(); 
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("cycleTime"));
	    	String cycleTime1 = elements2.getText().toString(); 
	    	System.out.println(cycleTime1);
	    	String cycleTime2 = null;	    	
	    	for (int j=0; j < 6000;j++) {
	    		elements2 = listOfElements.get(i).findElement(By.id("cycleTime"));
	    		cycleTime2 = elements2.getText().toString(); 
	    		if (!cycleTime1.equals(cycleTime2)) { 
	    			System.out.println(cycleTime2);
	    			break;
	    		}
	    	}   		    		    	
	    	if(nodeName.equals(RegressionTestPCS.nodeName2)) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    			fail();
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
	    	}
	    	if(nodeName.equals(RegressionTestPCS.nodeName1)) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    			fail();
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
	    	}if(nodeName.equals(RegressionTestPCS.nodeName4)) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    			fail();
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
	    	}if(nodeName.equals(RegressionTestPCS.nodeName3)) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    			fail();
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
	    	}		    	
	    }					    
	}
	
	public void stopSchedulerAllNodes() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
			
		WebElement btnStopScheduler;
		WebElement btnStartScheduler;
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 50);
		btnStopScheduler = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnStopScheduler")));
		btnStopScheduler.click();	

	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();
	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	    
	    WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 50);
	    wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("statusDisabled")));
	    assertEquals(RegressionTestPCS.driver.findElement(By.id("statusDisabled")).getText(), "Scheduler - Disabled");
					
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());	    
	    for (int i=0; i < listOfElements.size();i++){
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	String nodeName = elements.getText().toString();   	    	
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("cycleTime"));
	    	String cycleTime1 = elements2.getText().toString(); 
	    	System.out.println(cycleTime1);
	    	String cycleTime2 = "0";	    	
	    	for (int j=0; j < 6000;j++) {
	    		elements2 = listOfElements.get(i).findElement(By.id("cycleTime"));
	    		cycleTime2 = elements2.getText().toString(); 
	    		if (cycleTime1.equals(cycleTime2)) { 
	    			System.out.println(cycleTime2);
	    			break;
	    		}
	    	}  
	    	if(nodeName.equals(RegressionTestPCS.nodeName2)) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped");    			
				}else {
					System.out.println("Node "+nodeName+" is working"); 	  
					fail();
				}
	    	}
	    	if(nodeName.equals(RegressionTestPCS.nodeName1)) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		    			
				}else {
					System.out.println("Node "+nodeName+" is working"); 	
					fail();
				}
	    	}if(nodeName.equals(RegressionTestPCS.nodeName4)) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped");
				}else {
					System.out.println("Node "+nodeName+" is working");
					fail();
				}
	    	}if(nodeName.equals(RegressionTestPCS.nodeName3)) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    		}else {
					System.out.println("Node "+nodeName+" is working"); 	
					fail();
				}
	    	}		    	
	    }
	    WebDriverWait wait4 = new WebDriverWait(RegressionTestPCS.driver, 50);
	    btnStartScheduler = wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnStartScheduler")));
	    btnStartScheduler.click();	
	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();
		assertEquals(RegressionTestPCS.driver.findElement(By.id("statusEnabled")).getText(), "Scheduler - Enabled");	
	   	List <WebElement> listOfElements2 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements2.size());	    
	    for (int i=0; i < listOfElements2.size();i++){
	    	WebElement elements = listOfElements2.get(i).findElement(By.id("tableNodeID"));
	    	String nodeName = elements.getText().toString();
	    	WebElement elements2 = listOfElements2.get(i).findElement(By.id("cycleTime"));
	    	String cycleTime1 = elements2.getText().toString(); 
	    	System.out.println(cycleTime1);
	    	String cycleTime2 = null;	    	
	    	for (int j=0; j < 6000;j++) {
	    		elements2 = listOfElements2.get(i).findElement(By.id("cycleTime"));
	    		cycleTime2 = elements2.getText().toString(); 
	    		if (!cycleTime1.equals(cycleTime2)) { 
	    			System.out.println(cycleTime2);
	    			break;
	    		}
	    	}  
	    	if(nodeName.equals(RegressionTestPCS.nodeName2)) {
				System.out.println(nodeName);
				if (cycleTime1.equals(cycleTime2)) {
					System.out.println("Node "+nodeName+" is stoped"); 		  
					fail("Node "+nodeName+" fail");
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
			}
			if(nodeName.equals(RegressionTestPCS.nodeName1)) {
				System.out.println(nodeName);
				if (cycleTime1.equals(cycleTime2)) {
					System.out.println("Node "+nodeName+" is stoped"); 		  
					fail("Node "+nodeName+" fail");
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
			}if(nodeName.equals(RegressionTestPCS.nodeName4)) {
				System.out.println(nodeName);
				if (cycleTime1.equals(cycleTime2)) {
					System.out.println("Node "+nodeName+" is stoped"); 		  
					fail("Node "+nodeName+" fail");
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
			}if(nodeName.equals(RegressionTestPCS.nodeName3)) {
				System.out.println(nodeName);
				if (cycleTime1.equals(cycleTime2)) {
					System.out.println("Node "+nodeName+" is stoped"); 		  
					fail("Node "+nodeName+" fail");
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
			}		    	
		}	
	}
	
	public void deleteAllNodes() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 80);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");		
		RegressionTestPCS.driver.get(link);	
		
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 50);	
		List <WebElement> tableNode = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +tableNode.size());
	    for (int i=0; i < tableNode.size();i++){
	    	for (int j=0; j< 9000; j++) {
	    		if (tableNode.get(i).findElement(By.id("tableNodeID")).isDisplayed()) {
	    			break;
	    		}	
	    	}
	    	WebElement tableNodeID = tableNode.get(i).findElement(By.id("tableNodeID"));
	    	WebElement btnEditNode = tableNode.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = tableNodeID.getText().toString();   	
	    	if(nodeName.equals(RegressionTestPCS.nodeName1)) {
	    		System.out.println(nodeName);    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
	    		btnEditNodeID.click();    		
	            List <WebElement> tableGroupNode = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
	            System.out.println("Number of elements:" +tableGroupNode.size());
	            for (int j=0; j < tableGroupNode.size();j++){
	            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
	            	String nodeName2 = tableGroupNodeID.getText().toString();  
	            	if(nodeName2.contains(RegressionTestPCS.nodeName1)) {
	            		System.out.println(nodeName2);
	    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
	    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
	    				btnDeleteNode.click();
	            	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	            	    RegressionTestPCS.driver.switchTo().alert().accept(); 
	            		break;
	            	}    	    	
	            }break;
	    	} 
	    } 	
		WebDriverWait waitbtnHome2 = new WebDriverWait(RegressionTestPCS.driver, 80);
		WebElement btnHome2 = waitbtnHome2.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link2 = btnHome2.getAttribute("href");
		RegressionTestPCS.driver.get(link2);	
	    
		tableNode = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +tableNode.size());
	    for (int i=0; i < tableNode.size();i++){
	    	for (int j=0; j< 9000; j++) {
	    		if (tableNode.get(i).findElement(By.id("tableNodeID")).isDisplayed()) {
	    			break;
	    		}	
	    	}
	    	WebElement tableNodeID =  tableNode.get(i).findElement(By.id("tableNodeID"));
	    	WebElement btnEditNode =  tableNode.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = tableNodeID.getText().toString();   	
	    	if(nodeName.equals(RegressionTestPCS.nodeName2)) {
	    		System.out.println(nodeName);    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
	    		btnEditNodeID.click();    		
	            List <WebElement> tableGroupNode = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
	            System.out.println("Number of elements:" +tableGroupNode.size());
	            for (int j=0; j < tableGroupNode.size();j++){
	            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
	            	String nodeName2 = tableGroupNodeID.getText().toString();  
	            	if(nodeName2.contains(RegressionTestPCS.nodeName2)) {
	            		System.out.println(nodeName2);
	    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
	    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
	    				btnDeleteNode.click();
	            	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	            	    RegressionTestPCS.driver.switchTo().alert().accept(); 
	            		break;
	            	}    	    	
	            }break;
	    	} 
	    } 	
		WebDriverWait waitbtnHome3 = new WebDriverWait(RegressionTestPCS.driver, 80);
		WebElement btnHome3 = waitbtnHome3.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link3 = btnHome3.getAttribute("href");
		RegressionTestPCS.driver.get(link3);	
	    
	    tableNode = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +tableNode.size());
	    for (int i=0; i < tableNode.size();i++){
	    	for (int j=0; j< 9000; j++) {
	    		if (tableNode.get(i).findElement(By.id("tableNodeID")).isDisplayed()) {
	    			break;
	    		}	
	    	}
	    	WebElement tableNodeID =  tableNode.get(i).findElement(By.id("tableNodeID"));
	    	WebElement btnEditNode =  tableNode.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = tableNodeID.getText().toString();   	
	    	if(nodeName.equals(RegressionTestPCS.nodeName3)) {
	    		System.out.println(nodeName);    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
	    		btnEditNodeID.click();    		
	            List <WebElement> tableGroupNode = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
	            System.out.println("Number of elements:" +tableGroupNode.size());
	            for (int j=0; j < tableGroupNode.size();j++){
	            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
	            	String nodeName2 = tableGroupNodeID.getText().toString();  
	            	if(nodeName2.contains(RegressionTestPCS.nodeName3)) {
	            		System.out.println(nodeName2);
	    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
	    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
	    				btnDeleteNode.click();
	            	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	            	    RegressionTestPCS.driver.switchTo().alert().accept(); 
	            		break;
	            	}    	    	
	            }break;
	    	} 
	    } 	
		WebDriverWait waitbtnHome4 = new WebDriverWait(RegressionTestPCS.driver, 80);
		WebElement btnHome4 = waitbtnHome4.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link4 = btnHome4.getAttribute("href");
		RegressionTestPCS.driver.get(link4);
		
	    tableNode = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +tableNode.size());
	    for (int i=0; i < tableNode.size();i++){
	    	for (int j=0; j< 9000; j++) {
	    		if (tableNode.get(i).findElement(By.id("tableNodeID")).isDisplayed()) {
	    			break;
	    		}	
	    	}
	    	WebElement tableNodeID =  tableNode.get(i).findElement(By.id("tableNodeID"));
	    	WebElement btnEditNode =  tableNode.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = tableNodeID.getText().toString();   	
	    	if(nodeName.equals(RegressionTestPCS.nodeName4)) {
	    		System.out.println(nodeName);    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
	    		btnEditNodeID.click();    		
	            List <WebElement> tableGroupNode = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
	            System.out.println("Number of elements:" +tableGroupNode.size());
	            for (int j=0; j < tableGroupNode.size();j++){
	            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
	            	String nodeName2 = tableGroupNodeID.getText().toString();  
	            	if(nodeName2.contains(RegressionTestPCS.nodeName4)) {
	            		System.out.println(nodeName2);
	    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
	    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
	    				btnDeleteNode.click();
	            	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	            	    RegressionTestPCS.driver.switchTo().alert().accept(); 
	            		break;
	            	}    	    	
	            }break;
	    	} 
	    } 	
		WebDriverWait waitbtnHome5 = new WebDriverWait(RegressionTestPCS.driver, 80);
		WebElement btnHome5 = waitbtnHome5.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link5 = btnHome5.getAttribute("href");
		RegressionTestPCS.driver.get(link5);
	}		
	
	public void setGlobalUnitMeasure() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 20);	
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSettings")));
		button.click();
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnGlobalVariables")));
		button.click();			
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputUnit")));
		button.click();
		button.sendKeys("cm");	    	
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveAll")));
		button.click();			
		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	
	    
	    System.out.println("setGlobalUnitMeasure");
	}
	
	public void getSnapshot() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 40);	
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSettings")));
		button.click();
		
		//get Snapshot from 2 nodes
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSnapShot")));
		button.click();	
		WebElement imput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputRawImages")));
		imput.clear();
		imput.sendKeys("1");
		imput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputProcessedImages")));
		imput.clear();
		imput.sendKeys("1");
		
		List <WebElement> checkboxNode = RegressionTestPCS.driver.findElements(By.id("checkboxNode"));
	    System.out.println("Number of elements:" +checkboxNode.size());
	    for (int i=0; i < checkboxNode.size();i++){
	    	WebElement checkboxNodeId =  checkboxNode.get(i).findElement(By.id("checkboxNodeId"));
	    	String nodeName = checkboxNodeId.getText().toString();   	
	    	if(nodeName.equals(RegressionTestPCS.nodeName1)) {	
	    		checkboxNodeId.click();	    		 
	    	}
	    	if(nodeName.equals(RegressionTestPCS.nodeName4)) {	
	    		checkboxNodeId.click();	    		
	    	}
	    }
	    button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnTakeSnapshot")));
	    button.click();
	    WebElement pending = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("snapshotPending")));
	    Thread.sleep(15000);
	    pending = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("snapshotMessage")));	          
	    String message = pending.getText();
	    if (!message.contains("complete")){
			fail();
		}
		     
	    //get Snapshot from all nodes
	    imput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputRawImages")));
	    imput.clear();
	    imput.sendKeys("1");
	    imput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputProcessedImages")));
	    imput.clear();
	    imput.sendKeys("2");
	    button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSelectAll")));
	    button.click();
	    button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnTakeSnapshot")));
	    button.click();	      
	    Thread.sleep(15000);
	    button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("snapshotMessage")));	          
	    message = button.getText();
	    if (!message.contains("complete")){
			fail();
		}
		
		/*
		 * select none
		 *  take snapshot
		 * ver alerta
		 * ver se esta carregando (nao deve)
		 * ver se o arquivo foi gerado (nao deve)
		 * close
		*/
	    
	    //get Snapshot from none nodes
	    button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSelectNone")));
	    button.click();
	    button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnTakeSnapshot")));
	    button.click();
	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept(); 	    
	    /* Ticket APC-659 */
//	    Thread.sleep(5000);
//	    button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("snapshotMessage")));	          
//	    message = button.getText();
//	    if (message.contains("complete")){
//			fail();
//		}		  
	    
	    button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCloseSnapshot")));
	    button.click();
	    
	}
	
	public void setCycleTime() throws Exception {			
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 30);
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals(RegressionTestPCS.nodeName2))  {
	    		System.out.println(nodeName);	    	
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		Thread.sleep(1000);
	    		WebElement imputCycleTime = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputCycleTime")));
	    		imputCycleTime.clear();
	    		imputCycleTime.sendKeys("10000");
	    		WebElement btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept();
	    		RegressionTestPCS.driver.get(link);		
				break;
			}     	
	    }  
		
    }
	
}