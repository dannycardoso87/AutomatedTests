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
		RegressionTestPCS.driver.get(RegressionTestPCS.baseUrlPCS + "#/login");		
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
	    System.out.println("loginValidatePCS");
	 }	
	
	public void createNode() throws Exception {
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
		System.out.println("createNode");
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
	    System.out.println("createExistingNode");
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
		System.out.println("deleteNode");
	}	
	
	public void editNode() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		
		//WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 80);	
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals(RegressionTestPCS.nodeName2))  {
	    		System.out.println(nodeName);	    	
	    		WebDriverWait wait1 = new WebDriverWait(RegressionTestPCS.driver, 100);	
	    		WebElement btnEditNodeID = wait1.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement inputNodeName = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("inputNodeName")));
	    		inputNodeName.clear();
	    		inputNodeName.sendKeys(RegressionTestPCS.nodeName2);
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement inputTypeNode = wait3.until(ExpectedConditions.elementToBeClickable(By.id("inputTypeNode")));
	    		inputTypeNode.click();
	    		inputTypeNode.sendKeys("PFC");	    	
	    		inputTypeNode.click();	    
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
	    		WebElement inputCameraIP = wait6.until(ExpectedConditions.elementToBeClickable(By.id("inputCameraIP")));
	    		inputCameraIP.clear();
	    		inputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	
	    		WebDriverWait wait7 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement inputCameraModel = wait7.until(ExpectedConditions.elementToBeClickable(By.id("inputCameraModel")));
	    		inputCameraModel.click();
	    		inputCameraModel.sendKeys("Demo (Folder)");	    	
	    		inputCameraModel.click();	
	    		WebDriverWait wait9 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		btnSaveNode = wait9.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		//WebDriverWait wait8 = new WebDriverWait(RegressionTestPCS.driver, 150);	
	    	    //WebElement btnImageTest = wait8.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		//btnImageTest.click();
	    		//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		WebDriverWait wait10 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		btnSaveNode = wait10.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
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
	    		WebElement inputNodeName = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("inputNodeName")));
	    		inputNodeName.clear();
	    		inputNodeName.sendKeys(RegressionTestPCS.nodeName1);
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement inputTypeNode = wait3.until(ExpectedConditions.elementToBeClickable(By.id("inputTypeNode")));
	    		inputTypeNode.click();
	    		inputTypeNode.sendKeys("PRC");	    	
	    		inputTypeNode.click();	    
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
	    		WebElement inputCameraIP = wait6.until(ExpectedConditions.elementToBeClickable(By.id("inputCameraIP")));
	    		inputCameraIP.clear();
	    		inputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	 
	    		WebDriverWait wait7 = new WebDriverWait(RegressionTestPCS.driver, 80);   		
	    		WebElement inputCameraModel = wait7.until(ExpectedConditions.elementToBeClickable(By.id("inputCameraModel")));
	    		inputCameraModel.click();
	    		inputCameraModel.sendKeys("Demo (Folder)");	    	
	    		inputCameraModel.click();	   
	    		WebDriverWait wait8 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		btnSaveNode = wait8.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		//WebDriverWait wait9 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    	    //WebElement btnImageTest = wait9.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		//btnImageTest.click();
	    		//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
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
	    	for (int j=0; j <50000; j++) {
	    		if(RegressionTestPCS.driver.findElement(By.id("btnEditNode")).isDisplayed()) {
	    			break;	    			
	    		}	    		
	    	}	  	    	
	    	WebElement elements2 =  listOfElements3.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();  
	    	if(nodeName.equals(RegressionTestPCS.nodeName4))  {
	    		System.out.println(nodeName);	
	    		WebDriverWait wait1 = new WebDriverWait(RegressionTestPCS.driver, 80);    		
	    		WebElement btnEditNodeID = wait1.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 80);	    		
	    		WebElement inputNodeName = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("inputNodeName")));
	    		inputNodeName.clear();
	    		inputNodeName.sendKeys(RegressionTestPCS.nodeName4);
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		WebElement inputTypeNode = wait3.until(ExpectedConditions.elementToBeClickable(By.id("inputTypeNode")));
	    		inputTypeNode.click();
	    		inputTypeNode.sendKeys("Truck Dump Volume");	
	    		inputTypeNode.click();	    
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
	    		WebElement inputCameraIP = wait6.until(ExpectedConditions.elementToBeClickable(By.id("inputCameraIP")));
	    		inputCameraIP.clear();
	    		inputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	  
	    		WebDriverWait wait7 = new WebDriverWait(RegressionTestPCS.driver, 80);  		
	    		WebElement inputCameraModel = wait7.until(ExpectedConditions.elementToBeClickable(By.id("inputCameraModel")));
	    		inputCameraModel.click();
	    		inputCameraModel.sendKeys("Demo (Folder)");	    	
	    		inputCameraModel.click();	  
	    		WebDriverWait wait8 = new WebDriverWait(RegressionTestPCS.driver, 80); 
	    		btnSaveNode = wait8.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		//WebDriverWait wait9 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    	    //WebElement btnImageTest = wait9.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		//btnImageTest.click();
	    		//WebDriverWait wait10 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		//wait10.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
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
	    		WebElement inputNodeName = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("inputNodeName")));
	    		inputNodeName.clear();
	    		inputNodeName.sendKeys(RegressionTestPCS.nodeName3);
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		WebElement inputTypeNode = wait3.until(ExpectedConditions.elementToBeClickable(By.id("inputTypeNode")));
	    		inputTypeNode.click();
	    		inputTypeNode.sendKeys("Image Collector");	    	
	    		inputTypeNode.click();	    
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
	    		WebElement inputCameraIP = wait6.until(ExpectedConditions.elementToBeClickable(By.id("inputCameraIP")));
	    		inputCameraIP.clear();
	    		inputCameraIP.sendKeys(RegressionTestPCS.urlCamera);
	    		WebDriverWait wait7 = new WebDriverWait(RegressionTestPCS.driver, 80);	    		
	    		WebElement inputCameraModel = wait7.until(ExpectedConditions.elementToBeClickable(By.id("inputCameraModel")));
	    		inputCameraModel.click();
	    		inputCameraModel.sendKeys("Demo (Folder)");	    	
	    		inputCameraModel.click();	   
	    		WebDriverWait wait8 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		btnSaveNode = wait8.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    	    //Thread.sleep(1000);
	    		//WebDriverWait wait9 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    	    //WebElement btnImageTest = wait9.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		//btnImageTest.click();	
	    		//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		WebDriverWait wait10 = new WebDriverWait(RegressionTestPCS.driver, 80);
	    		btnSaveNode = wait10.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		RegressionTestPCS.driver.get(link);		
				break;
			} 	
	    }   	
	    System.out.println("editNode");
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
	    System.out.println("statusCheck");
	}
	
	public void setSchedulerAllNodes() throws Exception {
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
	    System.out.println("setSchedulerAllNodes");
	}
	
	public void deleteAllNodes() throws Exception {
		RegressionTestPCS.driver.get(RegressionTestPCS.baseUrlPCS + "#/login");		
		if (RegressionTestPCS.driver.findElement(By.id("details-button")).isDisplayed()) {
			RegressionTestPCS.driver.findElement(By.id("details-button")).click();
			RegressionTestPCS.driver.findElement(By.id("proceed-link")).click();
		}		
		RegressionTestPCS.driver.findElement(By.id("pcsusername")).clear();
		RegressionTestPCS.driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
		RegressionTestPCS.driver.findElement(By.id("pcspass")).clear();
	    RegressionTestPCS.driver.findElement(By.id("pcspass")).sendKeys("test");
	    RegressionTestPCS.driver.findElement(By.id("btnSubmit")).click();
		
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 80);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");		
		RegressionTestPCS.driver.get(link);	
		
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 50);	
		List <WebElement> tableNode = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +tableNode.size());
	    for (int i=0; i < tableNode.size();i++){
	    	for (int j=0; j< 20000; j++) {
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
	    	for (int j=0; j< 15000; j++) {
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
	    	for (int j=0; j< 15000; j++) {
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
	    	for (int j=0; j< 15000; j++) {
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
		
		System.out.println("deleteAllNodes");
	}		
	
	public void setGlobalUnitMeasureToCm() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 20);	
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSettings")));
		button.click();
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnGlobalVariables")));
		button.click();			
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputUnit")));
		button.click();
		button.sendKeys("cm");	    	
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveAll")));
		button.click();			
		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	
	    
	    WebDriverWait waitbtnHome2 = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome2 = waitbtnHome2.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link2 = btnHome2.getAttribute("href");
		RegressionTestPCS.driver.get(link2);	

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("unitId"), "cm"));
		
	    System.out.println("setGlobalUnitMeasureToCm");
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
		WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputRawImages")));
		input.clear();
		input.sendKeys("1");
		input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputProcessedImages")));
		input.clear();
		input.sendKeys("1");
		
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
	    input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputRawImages")));
	    input.clear();
	    input.sendKeys("1");
	    input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputProcessedImages")));
	    input.clear();
	    input.sendKeys("2");
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
	    //new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    //RegressionTestPCS.driver.switchTo().alert().accept(); 
	    
	    /* Ticket APC-659 */
	    //Thread.sleep(5000);
	    //button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("snapshotMessage")));	          
	    //message = button.getText();
	    //if (message.contains("complete")){
		//	fail();
		//}		  
	    
	    button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCloseSnapshot")));
	    button.click();
	    
	    WebDriverWait waitbtnHome2 = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome2 = waitbtnHome2.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link2 = btnHome2.getAttribute("href");
		RegressionTestPCS.driver.get(link2);	
	    
	    System.out.println("getSnapshot");
	    
	}
	
	public void setCycleTime() throws Exception {			
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 60);
		
		List <WebElement> listOfElements9 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements9.size());
	    for (int i=0; i < listOfElements9.size();i++){
	    	System.out.println(i);
//	    	for (int j=0; j <80000; j++) {
//	    		if(RegressionTestPCS.driver.findElement(By.id("tableNodeID")).isDisplayed()) {
//	    			break;	    			
//	    		}	    		
//	    	}		    	
//			WebDriverWait waitbtnHome2 = new WebDriverWait(RegressionTestPCS.driver, 50);
//			WebElement btnHome2 = waitbtnHome2.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
//			String link2 = btnHome2.getAttribute("href");
//			RegressionTestPCS.driver.get(link2);	
			
	    	WebElement elements = listOfElements9.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements9.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals(RegressionTestPCS.nodeName2))  {
	    		System.out.println(nodeName);	    	
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		Thread.sleep(1000);
	    		WebElement inputCycleTime = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputCycleTime")));
	    		inputCycleTime.clear();
	    		inputCycleTime.sendKeys("10000");
	    		WebElement btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 80).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept();
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 80).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept();	    		
	    		RegressionTestPCS.driver.get(link);		
				break;
			}     	
	    }  
	    System.out.println("setCycleTime");
    }
	
	public void statusCheckAfterSetGlobalUnitMeasure() throws Exception {
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
	    System.out.println("statusCheckAfterSetGlobalUnitMeasure");
	}
	
	public void setGlobalUnitMeasureToInches() throws Exception {
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 90);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 50);	
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSettings")));
		button.click();
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnGlobalVariables")));
		button.click();			
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputUnit")));
		button.click();
		button.sendKeys("inches");	    	
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveAll")));
		button.click();			
		new WebDriverWait(RegressionTestPCS.driver, 60).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	
	    
	    WebDriverWait waitbtnHome2 = new WebDriverWait(RegressionTestPCS.driver, 50);
		WebElement btnHome2 = waitbtnHome2.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link2 = btnHome2.getAttribute("href");
		RegressionTestPCS.driver.get(link2);	

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("unitId"), "inches"));
		
	    System.out.println("setGlobalUnitMeasureToInchies");
	}
	
	public void setScheduleType() throws Exception {			
				
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 90);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 90);
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals(RegressionTestPCS.nodeName1))  {
	    		System.out.println(nodeName);	    	
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		Thread.sleep(1000);
	    		WebElement inputScheduleType = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputScheduleType")));
	    		inputScheduleType.sendKeys("Trigger");
	    		WebElement btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	
	    	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept();
	    		btnSaveNode.click();	
	    	    new WebDriverWait(RegressionTestPCS.driver, 50).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept();
				break;
			}     	
	    }  
	    

	    WebDriverWait waitbtnHome2 = new WebDriverWait(RegressionTestPCS.driver, 80);
		WebElement btnHome2 = waitbtnHome2.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link2 = btnHome2.getAttribute("href");
		RegressionTestPCS.driver.get(link2);	
			
					
		List <WebElement> listOfElements2 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements2.size());	    
	    for (int i=0; i < listOfElements2.size();i++){
	    	WebElement elements = listOfElements2.get(i).findElement(By.id("tableNodeID"));
	    	String nodeName = elements.getText().toString();   	    	
	    	WebElement elements2 = listOfElements2.get(i).findElement(By.id("cycleTime"));
	    	String cycleTime1 = elements2.getText().toString(); 
	    	System.out.println(cycleTime1);
	    	String cycleTime2 = "0";	    	
	    	for (int j=0; j < 6000;j++) {
	    		elements2 = listOfElements2.get(i).findElement(By.id("cycleTime"));
	    		cycleTime2 = elements2.getText().toString(); 
	    		if (cycleTime1.equals(cycleTime2)) { 
	    			System.out.println(cycleTime2);
	    			break;
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
	    	}	   
	    }   
	    
	    System.out.println("setScheduleType");
    }
	
	public void statusCheckService() throws Exception {	
		//APC-673
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 90);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("statusServices"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement elements = listOfElements.get(i).findElement(By.id("serviceId"));
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("statusCollor"));
	    	String serviceId = elements.getText().toString();     
	    	String statusCollor = elements2.getAttribute("id");
	    	if (serviceId.equals("127.0.0.1.ProcessMonitor")){
	    		if (statusCollor.equals("circle-green")) {
	    			System.out.println("Service "+serviceId+" is working"); 
	    		}else {
	    			fail();
	    		}
	    	}
	    }
	    System.out.println("statusCheckService");
	}
	
	public void setTruckEvent() throws Exception {		
		//APC-685
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 90);
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
	    	if(nodeName.equals(RegressionTestPCS.nodeName4))  {
	    		System.out.println(nodeName);	
	    		//...
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		Thread.sleep(1000);
	    		WebElement eventConfig = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("eventConfig")));
	    		eventConfig.click();
	    		WebElement btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 60).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept();
	    		RegressionTestPCS.driver.get(link);		
				break;
			}     	
	    }  
	    System.out.println("setTruckEvent");		
	}	
	
	public void setAlarm() throws Exception {	
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 90);
		WebElement button = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = button.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		
		//create the alarmPFC
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 90);	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSettings")));
		button.click();
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAlarm")));
		button.click();			
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("targetNode")));
		button.sendKeys(RegressionTestPCS.nodeName2);	    	
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNewAlarm")));
		button.click();		
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("nameAlarm")));
		button.clear();		
		button.sendKeys("alarmPFC");	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("limit")));
		button.clear();		
		button.sendKeys("2");	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("tagAlarm")));
		button.sendKeys(".*.out.Heartbeat");
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("OpSelect")));
		button.sendKeys("Equals");	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("saveImageTrail")));
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveAlarm")));
		button.click();	
		new WebDriverWait(RegressionTestPCS.driver, 60).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	
	    		
	    //edit alarmPFC to alarmPFC_updated
	    button = wait.until(ExpectedConditions.elementToBeClickable(By.id("targetNode")));
		button.sendKeys(RegressionTestPCS.nodeName2);	    	
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("alarm")));
		button.sendKeys("alarmPFC");	
		button.click();	
		for (int j=0; j <50000; j++) {
    		if(RegressionTestPCS.driver.findElement(By.id("nameAlarm")).isDisplayed()) {
    			break;	    			
    		}	    		
    	}	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("nameAlarm")));
		button.clear();		
		button.sendKeys("alarmPFC_updated");
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("OpSelect")));
		button.sendKeys("Inside range");	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("low")));
		button.clear();		
		button.sendKeys("1");	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("high")));
		button.clear();		
		button.sendKeys("6");				
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("tagAlarm")));
		button.sendKeys(".*.out.Enabled");		
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("saveImageTrail")));
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveAlarm")));
		button.click();	
		new WebDriverWait(RegressionTestPCS.driver, 60).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	
			
	    //delete alarmPFC_updated
	    button = wait.until(ExpectedConditions.elementToBeClickable(By.id("targetNode")));
		button.sendKeys(RegressionTestPCS.nodeName2);	    	
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("alarm")));
		button.sendKeys("alarmPFC_updated");
		button.click();	
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnDeleteAlarm")));
		button.click();				
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveAlarm")));
		button.click();	
		new WebDriverWait(RegressionTestPCS.driver, 60).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	 
	    
		System.out.println("setAlarm");	
	}	
	
	public void saveAndApplyMultipleNode() throws Exception {	
		WebDriverWait waitbtnHome = new WebDriverWait(RegressionTestPCS.driver, 90);
		WebElement btnHome = waitbtnHome.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link = btnHome.getAttribute("href");
		RegressionTestPCS.driver.get(link);	
		
		//Edit a node field
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 90);
		List <WebElement> listOfElements5 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements5.size());
	    for (int i=0; i < listOfElements5.size();i++){
	    	System.out.println(i);	
	    	WebElement elements0 = listOfElements5.get(i).findElement(By.id("tableNodeID"));	    	
	    	WebElement elements1 = listOfElements5.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements0.getText().toString();       	
	    	if(nodeName.equals(RegressionTestPCS.nodeName2))  {
	    		System.out.println(nodeName);	    	
	    		wait = new WebDriverWait(RegressionTestPCS.driver, 90);	
	    		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(elements1));
	    		button.click();	
	    		button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("descriptionNode")));
	    		button.clear();
	    		button.sendKeys("Description");
	    		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSettings")));
	    		button.click();
	    		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("saveAndApplyMultipleNode")));
	    		button.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		break;
	    	}
	    }
	    
	    //Apply the change to other nodes	    
		List <WebElement> checkboxNode = RegressionTestPCS.driver.findElements(By.id("checkboxNode"));
	    System.out.println("Number of elements:" +checkboxNode.size());
	    for (int i=0; i < checkboxNode.size();i++){
	    	WebElement checkboxNodeId = checkboxNode.get(i).findElement(By.id("checkboxNodeId"));
	    	String nodeName = checkboxNodeId.getText().toString();   	
	    	if(nodeName.equals(RegressionTestPCS.nodeName3)) {	
	    		checkboxNodeId.click();	    		 
	    	}
	    	if(nodeName.equals(RegressionTestPCS.nodeName4)) {	
	    		checkboxNodeId.click();	    		
	    	}
	    }     		    
	    wait = new WebDriverWait(RegressionTestPCS.driver, 80);	
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveAllNodes")));
	    button.click();
	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
		RegressionTestPCS.driver.switchTo().alert().accept(); 
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnClose")));
	    button.click();
	    
	    //Check if the change was successful
	    WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 90);
	    WebElement btnHome2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link2 = btnHome2.getAttribute("href");
		RegressionTestPCS.driver.get(link2);	
	    
	    List <WebElement> listOfElements6 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements6.size());
	    for (int i=0; i < listOfElements6.size();i++){
	    	System.out.println(i);
	    	for (int j=0; j<90000; j++) {
	    		if(RegressionTestPCS.driver.findElement(By.id("tableNodeID")).isDisplayed()) {
	    			System.out.println(i);
	    			break;	    			
	    		}	    		
	    	}				
	    	WebElement elements = listOfElements6.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements6.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals(RegressionTestPCS.nodeName3))  {
	    		System.out.println(nodeName);	
	    		wait = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		button = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		button.click();
	    		button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("descriptionNode")));
	    		String description = button.getText().toString();
	    		if (!description.equals("Description")) {
	    			System.out.println("Description");	
	    		}else {
	    			fail();	    			
	    		}
	    		WebDriverWait wait3 = new WebDriverWait(RegressionTestPCS.driver, 90);
			    WebElement btnHome3 = wait3.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
				String link3 = btnHome3.getAttribute("href");
				RegressionTestPCS.driver.get(link3);
				break;
	    	}	    	
	    }	    
	    
	    WebDriverWait wait4 = new WebDriverWait(RegressionTestPCS.driver, 90);
	    WebElement btnHome4 = wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
		String link4 = btnHome4.getAttribute("href");
		RegressionTestPCS.driver.get(link4);	
	    List <WebElement> listOfElements7 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements7.size());
	    for (int i=0; i < listOfElements7.size();i++){
	    	System.out.println(i);
	    	for (int j=0; j<90000; j++) {
	    		if(RegressionTestPCS.driver.findElement(By.id("tableNodeID")).isDisplayed()) {
	    			System.out.println(i);
	    			break;	    			
	    		}	  	    		
	    	}
	    	WebElement elements = listOfElements7.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements7.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();      
	    	if(nodeName.equals(RegressionTestPCS.nodeName4))  {
	    		System.out.println(nodeName);	
	    		wait = new WebDriverWait(RegressionTestPCS.driver, 80);	
	    		button = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		button.click();
	    		button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("descriptionNode")));
	    		String description = button.getText().toString();
	    		if (!description.equals("Description")) {
	    			System.out.println("Description");	
	    		}else {
	    			fail();	    			
	    		}
	    	    WebDriverWait wait5 = new WebDriverWait(RegressionTestPCS.driver, 90);
	    	    WebElement btnHome5 = wait5.until(ExpectedConditions.elementToBeClickable(By.id("btnHome")));
	    		String link5 = btnHome5.getAttribute("href");
	    		RegressionTestPCS.driver.get(link5);	
	    		break;
	    	}	 
	    }
		System.out.println("saveAndApplyMultipleNode");	
	}
	
	//POP Tests
	
	public void loginValidatePOP() throws Exception {
		RegressionTestPCS.driver.get(RegressionTestPCS.baseUrlPOP);
		RegressionTestPCS.driver.findElement(By.id("pcsusername")).clear();
		RegressionTestPCS.driver.findElement(By.id("pcsusername")).sendKeys("Superuser");
		RegressionTestPCS.driver.findElement(By.id("pcspass")).clear();
		RegressionTestPCS.driver.findElement(By.id("pcspass")).sendKeys("test2");
		//Submit
		RegressionTestPCS.driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(2000);
		assertEquals(RegressionTestPCS.driver.findElement(By.className("error")).getText(), "LOGIN FAILED! Please verify the Username and Password. ");
		RegressionTestPCS.driver.findElement(By.id("pcspass")).clear();
		RegressionTestPCS.driver.findElement(By.id("pcspass")).sendKeys("test");
	    //Submit
		RegressionTestPCS.driver.findElement(By.id("btnSubmit")).click();
	}	
	
	public void checkCameras() throws Exception {
		WebDriverWait waitbtnSidebarCam = new WebDriverWait(RegressionTestPCS.driver, 40);
		WebElement element = waitbtnSidebarCam.until(ExpectedConditions.elementToBeClickable(By.id("btnSidebarCam")));
	    element.click();
		
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNameCamera"));
	    if(listOfElements.isEmpty()) {
	    	System.out.println("Number of elements:" +listOfElements.size());
	    	fail();
	    }
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement element1 = listOfElements.get(i).findElement(By.id("nameCamera"));
	    	String nodeName = element1.getText().toString();    
	    	Thread.sleep(1000); 
	    	WebElement element2 = listOfElements.get(i).findElement(By.id("statusCamera"));
	    	Thread.sleep(1000); 
	    	String status = element2.getAttribute("ng-reflect-ng-class").toString();
	    	System.out.println(nodeName);  	
    		if(status.equals("running") || status.equals("unavailable")) {
    			System.out.println("Node "+nodeName+" is running.");
    		}else {
    			System.out.println("Node "+nodeName+" is not running.");
    			fail();
    		}	    	    	    	
	    }	
	}
	public void createNewCamera() throws Exception {
		WebDriverWait waitBtnSidebarCam = new WebDriverWait(RegressionTestPCS.driver, 10);
		WebElement btnSidebarCam = waitBtnSidebarCam.until(ExpectedConditions.elementToBeClickable(By.id("btnSidebarCam")));
		btnSidebarCam.click();
	
		RegressionTestPCS.driver.findElement(By.id("btnNewCamera")).click();
		WebDriverWait waitBtnSaveCam = new WebDriverWait(RegressionTestPCS.driver, 10);
		WebElement btnSaveCam = waitBtnSaveCam.until(ExpectedConditions.elementToBeClickable(By.id("bntSaveCamera")));
		btnSaveCam.click();	
		WebElement text = RegressionTestPCS.driver.findElement(By.id("msgCameraUnsaved"));
	    Boolean m = new WebDriverWait(RegressionTestPCS.driver, 10).until(ExpectedConditions.textToBePresentInElement(text,"Cameras Edited - Unsaved"));
	    if(m.equals(true)) {
	    	System.out.println("Cameras Edited - Unsaved");
	    }			
		
	    RegressionTestPCS.driver.findElement(By.id("cameraId")).clear();
	    RegressionTestPCS.driver.findElement(By.id("cameraId")).sendKeys("Camera1");
	    RegressionTestPCS.driver.findElement(By.id("cameraUsername")).clear();
	    RegressionTestPCS.driver.findElement(By.id("cameraUsername")).sendKeys("admin");
	    RegressionTestPCS.driver.findElement(By.id("cameraPassword")).clear();
	    RegressionTestPCS.driver.findElement(By.id("cameraPassword")).sendKeys("123456");
	    RegressionTestPCS.driver.findElement(By.id("cameraIpAddress")).clear();
	    RegressionTestPCS.driver.findElement(By.id("cameraIpAddress")).sendKeys("10.10.80.102");	
		
		waitBtnSaveCam = new WebDriverWait(RegressionTestPCS.driver, 10);
		btnSaveCam = waitBtnSaveCam.until(ExpectedConditions.elementToBeClickable(By.id("bntSaveCamera")));
		btnSaveCam.click();	
	}
	
}