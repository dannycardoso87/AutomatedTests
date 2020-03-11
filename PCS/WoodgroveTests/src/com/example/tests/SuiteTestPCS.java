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
		
		Boolean m = new WebDriverWait(RegressionTestPCS.driver, 10).until(ExpectedConditions.textToBePresentInElement(text, "Node id cannot be empty."));
		if (m.equals(true)) {
			System.out.println("Node id cannot be empty.");
		}		
		RegressionTestPCS.driver.findElement(By.id("newNodeForm")).clear();
		RegressionTestPCS.driver.findElement(By.id("newNodeForm")).sendKeys("nodetest5");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitNewNode")));
		element.click();
		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
		RegressionTestPCS.driver.switchTo().alert().accept();
		Thread.sleep(1000);
		WebDriverWait wait2 = new WebDriverWait(RegressionTestPCS.driver, 10);
		WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.id("btnCancelNewNode")));
		element2.click();

		List<WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
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
		
		List<WebElement> listOfElements2 = RegressionTestPCS.driver.findElements(By.id("tableGroupNode"));
		System.out.println("Number of elements:" + listOfElements2.size());
		for (int i = 0; i < listOfElements2.size(); i++) {
			WebElement elements3 = listOfElements2.get(i).findElement(By.id("tableGroupNodeID"));
			String nodeName2 = elements3.getText().toString();
			if (nodeName2.equals("nodetest5\nEdit\nStop")) {
				System.out.println(nodeName2);
				Thread.sleep(5000);
				WebElement button = elements3.findElement(By.id("btnDeleteNode"));
				button.click();
				Thread.sleep(1000);
				new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
				RegressionTestPCS.driver.switchTo().alert().accept();
				break;
			}
		}
	}	
	
	public void editNode() throws Exception {
		String link = RegressionTestPCS.driver.findElement(By.className("logo")).getAttribute("href");  
		WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 10);			
		WebElement imputNodeName;
		WebElement imputTypeNode;
		WebElement btnSaveNode;
		WebElement cameraSettings;
		WebElement imputCameraIP;
		WebElement imputCameraModel;
		WebElement btnImageTest;
		WebElement button;
		
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement elements = listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 = listOfElements.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals("nodetest1"))  {
	    		System.out.println(nodeName);	    		
	    		Thread.sleep(1000);
	    		button = elements2.findElement(By.id("btnEditNodeID")); 
	    		Thread.sleep(5000);
	    		button.click(); 
	    		imputNodeName = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys("nodePFC");
	    		imputTypeNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("PFC");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	    		
	    		cameraSettings = wait.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    		
	    		imputCameraIP = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	    		
	    		imputCameraModel = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		btnImageTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		Thread.sleep(5000);
	    		RegressionTestPCS.driver.findElement(By.className("full-img"));		
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
	    		Thread.sleep(1000);
	    		button = elements2.findElement(By.id("btnEditNodeID")); 
	    		Thread.sleep(5000);
	    		button.click(); 
	    		imputNodeName = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys("nodePRC");
	    		imputTypeNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("PRC");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	    		
	    		cameraSettings = wait.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    		
	    		imputCameraIP = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	    		
	    		imputCameraModel = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    		btnImageTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		Thread.sleep(5000);
	    		RegressionTestPCS.driver.findElement(By.className("full-img"));		
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
	    		Thread.sleep(1000);
	    		button = elements2.findElement(By.id("btnEditNodeID")); 
	    		Thread.sleep(5000);
	    		button.click(); 
	    		imputNodeName = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys("nodeTruck");
	    		imputTypeNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("Truck Dump Volume");	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	    		
	    		cameraSettings = wait.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    		
	    		imputCameraIP = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	    		
	    		imputCameraModel = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    	    Thread.sleep(1000);
	    		btnImageTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		Thread.sleep(8000);
	    		RegressionTestPCS.driver.findElement(By.className("full-img"));		
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
	    		Thread.sleep(1000);
	    		button = elements2.findElement(By.id("btnEditNodeID")); 
	    		Thread.sleep(5000);
	    		button.click(); 
	    		imputNodeName = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputNodeName")));
	    		imputNodeName.clear();
	    		imputNodeName.sendKeys("nodeIMC");
	    		imputTypeNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputTypeNode")));
	    		imputTypeNode.click();
	    		imputTypeNode.sendKeys("Image Collector");	    	
	    		imputTypeNode.click();	    
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 	    		
	    		cameraSettings = wait.until(ExpectedConditions.elementToBeClickable(By.id("cameraSettings")));
	    		cameraSettings.click();	    		
	    		imputCameraIP = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraIP")));
	    		imputCameraIP.clear();
	    		imputCameraIP.sendKeys(RegressionTestPCS.urlCamera);	    		
	    		imputCameraModel = wait.until(ExpectedConditions.elementToBeClickable(By.id("imputCameraModel")));
	    		imputCameraModel.click();
	    		imputCameraModel.sendKeys("Demo (Folder)");	    	
	    		imputCameraModel.click();	   
	    		btnSaveNode = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNode")));
	    		btnSaveNode.click();
	    	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    	    RegressionTestPCS.driver.switchTo().alert().accept();
	    	    Thread.sleep(1000);
	    		btnImageTest = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnImageTest")));
	    		btnImageTest.click();
	    		Thread.sleep(8000);
	    		RegressionTestPCS.driver.findElement(By.className("full-img"));		
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
	    	Thread.sleep(5000); //alterar
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
		
		btnStopScheduler = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnStopScheduler")));
		btnStopScheduler.click();	

	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();	    
	    Thread.sleep(10000);	    
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
	    Thread.sleep(5000);
	    RegressionTestPCS.driver.findElement(By.id("btnStartScheduler")).click();
	    new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    RegressionTestPCS.driver.switchTo().alert().accept();
	    Thread.sleep(14000);
		assertEquals(RegressionTestPCS.driver.findElement(By.id("statusEnabled")).getText(), "Scheduler - Enabled");	
	   	List <WebElement> listOfElements2 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements2.size());	    
	    for (int i=0; i < listOfElements2.size();i++){
	    	WebElement elements = listOfElements2.get(i).findElement(By.id("tableNodeID"));
	    	String nodeName = elements.getText().toString();
	    	WebElement elements2 = listOfElements2.get(i).findElement(By.id("cycleTime"));
	    	String cycleTime1 = elements2.getText().toString();   
	    	System.out.println(cycleTime1); 
	    	Thread.sleep(10000);
	    	String cycleTime2 = elements2.getText().toString();   
	    	System.out.println(cycleTime2); 
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
	
	public void autoStartNodePCS() throws Exception {	
		String link = RegressionTestPCS.driver.findElement(By.className("logo")).getAttribute("href"); 
		RegressionTestPCS.driver.get(link);	
		//WebDriverWait wait = new WebDriverWait(RegressionTestPCS.driver, 10);	
		
		List <WebElement> listOfElements = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i < listOfElements.size();i++){
	    	System.out.println(i);
	    	WebElement elements =  listOfElements.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals("nodePRC"))  {
	    		System.out.println(nodeName);
	    		Thread.sleep(5000); 
	    		WebElement button = elements2.findElement(By.id("btnEditNodeID")); 
	    		Thread.sleep(5000); 
	    		button.click(); 
	    		Thread.sleep(5000); 
	    		RegressionTestPCS.driver.findElement(By.id("Auto")).click();    		
	    		RegressionTestPCS.driver.findElement(By.id("btnSaveNode")).click();
	    		Thread.sleep(5000);
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
				Thread.sleep(5000);
				RegressionTestPCS.driver.findElement(By.className("logo")).click();
				break;
			} 
	    }  
	    Thread.sleep(10000);
		List <WebElement> listOfElements2 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements2.size());	    
	    for (int i=0; i < listOfElements2.size();i++){
	    	WebElement elements = listOfElements2.get(i).findElement(By.id("tableNodeID"));
	    	String nodeName = elements.getText().toString(); 
	    	WebElement elements2 = listOfElements2.get(i).findElement(By.id("cycleTime"));
	    	String cycleTime1 = elements2.getText().toString();   
	    	System.out.println(cycleTime1); 
	    	Thread.sleep(8000);
	    	String cycleTime2 = elements2.getText().toString();   
	    	System.out.println(cycleTime2); 
	    	if(nodeName.equals("nodePRC")) {
	    		System.out.println(nodeName);
	    		if (cycleTime1.equals(cycleTime2)) {
	    			System.out.println("Node "+nodeName+" is stoped"); 	    			
				}else {
					System.out.println("Node "+nodeName+" is working");
					fail();
				}    	
	    	}		    	
	    }		
		List <WebElement> listOfElements3 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements3.size());
	    for (int i=0; i < listOfElements3.size();i++){
	    	System.out.println(i);
	    	WebElement elements =  listOfElements3.get(i).findElement(By.id("tableNodeID"));
	    	WebElement elements2 =  listOfElements3.get(i).findElement(By.id("btnEditNode"));
	    	String nodeName = elements.getText().toString();       	
	    	if(nodeName.equals("nodePRC"))  {
	    		System.out.println(nodeName);
	    		Thread.sleep(5000); 
	    		WebElement button = elements2.findElement(By.id("btnEditNodeID")); 
	    		Thread.sleep(5000);
	    		button.click();  
	    		Thread.sleep(5000); 
	    		RegressionTestPCS.driver.findElement(By.id("Auto")).click();    		
	    		RegressionTestPCS.driver.findElement(By.id("btnSaveNode")).click();
	    		Thread.sleep(5000);
	    		new WebDriverWait(RegressionTestPCS.driver, 30).until(ExpectedConditions.alertIsPresent());
	    		RegressionTestPCS.driver.switchTo().alert().accept(); 
				Thread.sleep(5000);
				RegressionTestPCS.driver.findElement(By.className("logo")).click();
				break;
			} 
	    }  
	    Thread.sleep(10000);
		List <WebElement> listOfElements4 = RegressionTestPCS.driver.findElements(By.id("tableNode"));
	    System.out.println("Number of elements:" +listOfElements4.size());	    
	    for (int i=0; i < listOfElements4.size();i++){
	    	WebElement elements = listOfElements4.get(i).findElement(By.id("tableNodeID"));
	    	String nodeName = elements.getText().toString(); 
	    	WebElement elements2 = listOfElements4.get(i).findElement(By.id("cycleTime"));
	    	String cycleTime1 = elements2.getText().toString();   
	    	System.out.println(cycleTime1); 
	    	Thread.sleep(8000);
	    	String cycleTime2 = elements2.getText().toString();   
	    	System.out.println(cycleTime2); 
	    	if(nodeName.equals("nodePRC")) {
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
	
}