package src.com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;
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
		WebDriverWait waitbtnCreateNode = new WebDriverWait(RegressionTestPCS.driver, 10);
		WebElement btnCreateNode = waitbtnCreateNode.until(ExpectedConditions.elementToBeClickable(By.id("btnCreateNode")));
		btnCreateNode.click();	
		WebElement text = RegressionTestPCS.driver.findElement(By.id("nodeMsgModal"));
	    Boolean m = new WebDriverWait(RegressionTestPCS.driver, 10).until(ExpectedConditions.textToBePresentInElement(text,"Node id cannot be empty."));
	    if(m.equals(true)) {
	    	System.out.println("Node id cannot be empty");
	    }
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys("nodetest1");
	    WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
	    element.click();
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys("nodetest2");
	    wait = new WebDriverWait(RegressionTestPCS.driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
	    element.click();
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();   
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys("nodetest3");
	    wait = new WebDriverWait(RegressionTestPCS.driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
	    element.click();
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();     
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys("nodetest4");
	    wait = new WebDriverWait(RegressionTestPCS.driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
	    element.click();
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();     
	    wait = new WebDriverWait(RegressionTestPCS.driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCancelNewNode")));
	    element.click();
		String link = RegressionTestPCS.driver.findElement(By.className("logo")).getAttribute("href");  
		RegressionTestPCS.driver.get(link);
	}	
	
	public void createExistingNode() throws Exception {
		RegressionTestPCS.driver.findElement(By.id("btnCreateNode")).click();	    
	    WebElement text = RegressionTestPCS.driver.findElement(By.id("nodeMsgModal"));
	    Boolean m = new WebDriverWait(RegressionTestPCS.driver, 10).until(ExpectedConditions.textToBePresentInElement(text,"Node id cannot be empty."));
	    if(m.equals(true)) {
	    	System.out.println("Node id cannot be empty.");
	    }	    
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();	
	    RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys("nodetest1");
	    WebElement text2 = RegressionTestPCS.driver.findElement(By.id("nodeMsgModal"));
	    Boolean m2 = new WebDriverWait(RegressionTestPCS.driver, 10).until(ExpectedConditions.textToBePresentInElement(text2,"Node id already in use."));
	    if(m2.equals(true)) {
	    	System.out.println("Node id already in use.");
	    }
	    WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCancelNewNode")));
	    element.click();
	    
	  }
	
	public void deleteNode() throws Exception {
		RegressionTestPCS.driver.findElement(By.id("btnCreateNode")).click();
		WebElement text = RegressionTestPCS.driver.findElement(By.id("nodeMsgModal"));
		WebElement btnEditNodeID;
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 40);
		
		Boolean m = new WebDriverWait(RegressionTestPCS.driver, 10).until(ExpectedConditions.textToBePresentInElement(text, "Node id cannot be empty."));
		if (m.equals(true)) {
			System.out.println("Node id cannot be empty.");
		}		
		RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
		RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys("nodetest5");
		Thread.sleep(1000);
		
		WebElement btnSubmitNewNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
		btnSubmitNewNode.click();
		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
		RegressionTestPCS.driver.switchTo().alert().accept();
		WebElement btnCancelNewNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCancelNewNode")));
		btnCancelNewNode.click();

		List<WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
		System.out.println("Number of elements:" + listOfElements.size());
		for (int i = 0; i < listOfElements.size(); i++) {
			WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
			WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
			String nodeName = elements.getText().toString();
			if (nodeName.equals("nodetest5")) {
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
			if (nodeName2.equals("nodetest5\nEdit\nStop")) {
				System.out.println(nodeName2);
				WebElement button = elements3.findElement(By.id("btnDeleteNode"));
				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
				btnDeleteNode.click();
				new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
				RegressionTestPCS.driver.switchTo().alert().accept();
				break;
			}
		}
	}	
	
	public void editNode() throws Exception {
		String link = RegressionTestPCS.driver.findElement(By.className("logo")).getAttribute("href");  
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 70);			

		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals("nodetest1"))  {
	    		System.out.println(nodeName);	    	
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		Thread.sleep(1000);
	    		WebElement imputNodeName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys("nodePFC");
	    		WebElement imputTypeNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("PFC");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		WebElement btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	    		
	    		WebElement cameraSettings = wait.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    		
	    		WebElement imputCameraIP = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	    		
	    		WebElement imputCameraModel = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    	    WebElement btnImageTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		RegressionTestPCS.driver.get(link);		
				break;
			}     	
	    }  
		List <WebElement> listOfElements2 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements2.size());
	    for (int i=0; i < listOfElements2.size();i++){
	    	System.out.println(i);
	    	WebElement elements =  listOfElements2.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements2.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();  
	    	if(nodeName.equals("nodetest2"))  {
	    		System.out.println(nodeName);	    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();	    			   
	    		Thread.sleep(1000);
	    		WebElement imputNodeName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys("nodePRC");
	    		WebElement imputTypeNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("PRC");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		WebElement btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	    		
	    		WebElement cameraSettings = wait.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    		
	    		WebElement imputCameraIP = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	    		
	    		WebElement imputCameraModel = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    	    WebElement btnImageTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		RegressionTestPCS.driver.get(link);		
				break;
			} 
	    }	      
		List <WebElement> listOfElements3 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements3.size());
	    for (int i=0; i < listOfElements3.size();i++){
	    	System.out.println(i);
	    	WebElement elements =  listOfElements3.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements3.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();  
	    	if(nodeName.equals("nodetest3"))  {
	    		System.out.println(nodeName);	    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		Thread.sleep(1000);
	    		WebElement imputNodeName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys("nodeTruck");
	    		WebElement imputTypeNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("Truck Dump Volume");	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		WebElement btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	    		
	    		WebElement cameraSettings = wait.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    		
	    		WebElement imputCameraIP = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	    		
	    		WebElement imputCameraModel = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    	    Thread.sleep(1000);
	    	    WebElement btnImageTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		RegressionTestPCS.driver.get(link);		
				break;
			} 
	    }	     
		List <WebElement> listOfElements4 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements4.size());
	    for (int i=0; i < listOfElements4.size();i++){
	    	System.out.println(i);
	    	WebElement elements =  listOfElements4.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements4.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();  
	    	if(nodeName.equals("nodetest4"))  {
	    		System.out.println(nodeName);	    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(elements2));
	    		btnEditNodeID.click();
	    		Thread.sleep(1000);
	    		WebElement imputNodeName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys("nodeIMC");
	    		WebElement imputTypeNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("Image Collector");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		WebElement btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	    		
	    		WebElement cameraSettings = wait.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    		
	    		WebElement imputCameraIP = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	    		
	    		WebElement imputCameraModel = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    	    Thread.sleep(1000);
	    	    WebElement btnImageTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();	
	    		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("full-img")));
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();	    			    		
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		RegressionTestPCS.driver.get(link);		
				break;
			} 	
	    }   	
	}	
	public void statusCheck() throws Exception {
		String link = RegressionTestPCS.driver.findElement(By.className("logo")).getAttribute("href"); 
		RegressionTestPCS.driver.get(link);	
		
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
		System.out.println("Number of elements:" +listOfElements.size());	
	    for (int i=0; i < listOfElements.size();i++){
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	String nodeName = elements.getText().toString(); 
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("cycleTime"));
	    	String cycleTime1 = elements2.getText().toString(); 
	    	System.out.println(cycleTime1);
	    	String cycleTime2 = null;	    	
	    	for (int j=0; j < 100;j++) {
	    		elements2 = listOfElements.get(i).findElement(By.id("cycleTime"));
	    		cycleTime2 = elements2.getText().toString(); 
	    		if (!cycleTime1.equals(cycleTime2)) { 
	    			System.out.println(cycleTime2);
	    			break;
	    		}
	    	}   		    		    	
	    	if(nodeName.equals("nodePFC")) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    			fail();
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
	    	}
	    	if(nodeName.equals("nodePRC")) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    			fail();
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
	    	}if(nodeName.equals("nodeTruck")) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    			fail();
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
	    	}if(nodeName.equals("nodeIMC")) {
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
		String link = RegressionTestPCS.driver.findElement(By.className("logo")).getAttribute("href"); 
		RegressionTestPCS.driver.get(link);	
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 10);	
		WebElement btnStopScheduler;
		WebElement btnStartScheduler;
		
		btnStopScheduler = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnStopScheduler")));
		btnStopScheduler.click();	

	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	    
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("statusDisabled")));
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
	    	for (int j=0; j < 100;j++) {
	    		elements2 = listOfElements.get(i).findElement(By.id("cycleTime"));
	    		cycleTime2 = elements2.getText().toString(); 
	    		if (cycleTime1.equals(cycleTime2)) { 
	    			System.out.println(cycleTime2);
	    			break;
	    		}
	    	}  
	    	if(nodeName.equals("nodePFC")) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped");    			
				}else {
					System.out.println("Node "+nodeName+" is working"); 	  
					fail();
				}
	    	}
	    	if(nodeName.equals("nodePRC")) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		    			
				}else {
					System.out.println("Node "+nodeName+" is working"); 	
					fail();
				}
	    	}if(nodeName.equals("nodeTruck")) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped");
				}else {
					System.out.println("Node "+nodeName+" is working");
					fail();
				}
	    	}if(nodeName.equals("nodeIMC")) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 		  
	    		}else {
					System.out.println("Node "+nodeName+" is working"); 	
					fail();
				}
	    	}		    	
	    }

	    btnStartScheduler = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnStartScheduler")));
	    btnStartScheduler.click();	
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
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
	    	for (int j=0; j < 100;j++) {
	    		elements2 = listOfElements2.get(i).findElement(By.id("cycleTime"));
	    		cycleTime2 = elements2.getText().toString(); 
	    		if (!cycleTime1.equals(cycleTime2)) { 
	    			System.out.println(cycleTime2);
	    			break;
	    		}
	    	}  
	    	if(nodeName.equals("nodePFC")) {
				System.out.println(nodeName);
				if (cycleTime1.equals(cycleTime2)) {
					System.out.println("Node "+nodeName+" is stoped"); 		  
					fail("Node "+nodeName+" fail");
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
			}
			if(nodeName.equals("nodePRC")) {
				System.out.println(nodeName);
				if (cycleTime1.equals(cycleTime2)) {
					System.out.println("Node "+nodeName+" is stoped"); 		  
					fail("Node "+nodeName+" fail");
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
			}if(nodeName.equals("nodeTruck")) {
				System.out.println(nodeName);
				if (cycleTime1.equals(cycleTime2)) {
					System.out.println("Node "+nodeName+" is stoped"); 		  
					fail("Node "+nodeName+" fail");
				}else {
					System.out.println("Node "+nodeName+" is working"); 	    					
				}
			}if(nodeName.equals("nodeIMC")) {
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
	
	public void deleteNodeAllNodes() throws Exception {
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 30);	
		String link = RegressionTestPCS.driver.findElement(By.id("btnHome")).getAttribute("href");  
		
		List <WebElement> tableNode = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +tableNode.size());
	    for (int i=0; i < tableNode.size();i++){
	    	WebElement tableNodeID =  tableNode.get(i).findElement(By.id("tableNodeID"));
	    	WebElement btnEditNode =  tableNode.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = tableNodeID.getText().toString();   	
	    	if(nodeName.equals("nodePRC")) {
	    		System.out.println(nodeName);    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
	    		btnEditNodeID.click();    		
	            List <WebElement> tableGroupNode = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
	            System.out.println("Number of elements:" +tableGroupNode.size());
	            for (int j=0; j < tableGroupNode.size();j++){
	            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
	            	String nodeName2 = tableGroupNodeID.getText().toString();  
	            	if(nodeName2.contains("nodePRC")) {
	            		System.out.println(nodeName2);
	    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
	    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
	    				btnDeleteNode.click();
	            	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	            	    RegressionTestPCS.driver.switchTo().alert().accept(); 
	            		break;
	            	}    	    	
	            }break;
	    	} 
	    } 	
	    RegressionTestPCS.driver.get(link);	
	    
	    tableNode = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +tableNode.size());
	    for (int i=0; i < tableNode.size();i++){
	    	WebElement tableNodeID =  tableNode.get(i).findElement(By.id("tableNodeID"));
	    	WebElement btnEditNode =  tableNode.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = tableNodeID.getText().toString();   	
	    	if(nodeName.equals("nodePFC")) {
	    		System.out.println(nodeName);    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
	    		btnEditNodeID.click();    		
	            List <WebElement> tableGroupNode = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
	            System.out.println("Number of elements:" +tableGroupNode.size());
	            for (int j=0; j < tableGroupNode.size();j++){
	            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
	            	String nodeName2 = tableGroupNodeID.getText().toString();  
	            	if(nodeName2.contains("nodePFC")) {
	            		System.out.println(nodeName2);
	    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
	    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
	    				btnDeleteNode.click();
	            	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	            	    RegressionTestPCS.driver.switchTo().alert().accept(); 
	            		break;
	            	}    	    	
	            }break;
	    	} 
	    } 	
	    RegressionTestPCS.driver.get(link);	
	    
	    tableNode = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +tableNode.size());
	    for (int i=0; i < tableNode.size();i++){
	    	WebElement tableNodeID =  tableNode.get(i).findElement(By.id("tableNodeID"));
	    	WebElement btnEditNode =  tableNode.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = tableNodeID.getText().toString();   	
	    	if(nodeName.equals("nodeIMC")) {
	    		System.out.println(nodeName);    		
	    		WebElement btnEditNodeID = wait.until(ExpectedConditions.elementToBeClickable(btnEditNode));
	    		btnEditNodeID.click();    		
	            List <WebElement> tableGroupNode = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
	            System.out.println("Number of elements:" +tableGroupNode.size());
	            for (int j=0; j < tableGroupNode.size();j++){
	            	WebElement tableGroupNodeID =  tableGroupNode.get(j).findElement(By.id("tableGroupNodeID"));
	            	String nodeName2 = tableGroupNodeID.getText().toString();  
	            	if(nodeName2.contains("nodeIMC")) {
	            		System.out.println(nodeName2);
	    				WebElement button = tableGroupNodeID.findElement(By.id("btnDeleteNode"));
	    				WebElement btnDeleteNode = wait.until(ExpectedConditions.elementToBeClickable(button));
	    				btnDeleteNode.click();
	            	    new WebDriverWait(RegressionTestPCS.driver, 40).until(ExpectedConditions.alertIsPresent());
	            	    RegressionTestPCS.driver.switchTo().alert().accept(); 
	            		break;
	            	}    	    	
	            }break;
	    	} 
	    } 	
	    RegressionTestPCS.driver.get(link);	
	}		
	
	public void setGlobalUnitMeasure() throws Exception {
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 10);	
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
		
	}
	
	public void getSnapshot() throws Exception {
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 10);	
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSettings")));
		button.click();
		
		//select some nodes
		button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSnapShot")));
		button.click();	
		button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputRawImages")));
		button.clear();
		button.sendKeys("2");
		button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imputProcessedImages")));
		button.clear();
		button.sendKeys("3");
		
		List <WebElement> checkboxNode = RegressionTestPCS.driver.findElements(By.id("checkboxNode"));
	    System.out.println("Number of elements:" +checkboxNode.size());
	    for (int i=0; i < checkboxNode.size();i++){
	    	WebElement checkboxNodeId =  checkboxNode.get(i).findElement(By.id("checkboxNodeId"));
	    	String nodeName = checkboxNodeId.getText().toString();   	
	    	if(nodeName.equals("nodePRC")) {	
	    		checkboxNodeId.click();	    		
	    	}
	    	if(nodeName.equals("nodeTruck")) {	
	    		checkboxNodeId.click();	    		
	    	}
	    }
	    button = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnTakeSnapshot")));
	    button.click();
	    button = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("snapshotMessage")));
		
		
		/*select alguns nodes
		 * take snapshot
		 * ver se esta carregando
		 * ver se o arquivo foi gerado
		 * close		
		 */
		
		/*select all
		 *  take snapshot
		 * ver alerta
		 * ver se esta carregando
		 * ver se o arquivo foi gerado
		 * close
		*/	
		
		
		/*
		 * select none
		 *  take snapshot
		 * ver alerta
		 * ver se esta carregando (nao deve)
		 * ver se o arquivo foi gerado (nao deve)
		 * close
		*/
	}
}