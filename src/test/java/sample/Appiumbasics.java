package sample;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.options.locking.SupportsUnlockTypeOption;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Appiumbasics extends parent {
    
    @Test
    
    public void appiumtest () throws InterruptedException, IOException 
    {  
    	String result;
    	//setup();   	
    	
    		
    	//driver.findElement(AppiumBy.accessibilityId("YT Music")).click();
    	
    	//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"YT Music\"));"));
    	
    	
    //opening camera     //android.widget.TextView[@content-desc="Camera"]
       WebElement cam= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Camera']\n"
        		+ ""));
       cam.click();
       
       System.out.println("camera opened");

               
       List<WebElement> pop=driver.findElements(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
       //Assert.assertTrue(pop);
      System.out.println(pop);
       
        
        if (!pop.isEmpty() && pop.get(0).isDisplayed()) {
        	pop.get(0).click();
        
        	System.out.println("pop is displayed");
        	 result ="pass";
        	
        }
        else {
        	System.out.println("pop not displayed");
        	 result ="skip";
        }
        
      //swipe gesture to different mode
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
     		    "left", 100, "top", 100, "width", 200, "height",900,
     		    "direction", "left",
     		    "percent", 1
     		));
        System.out.println("swipe gesture works fine");
        
        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(finger,1);
        
        
       WebElement thub= driver.findElement(AppiumBy.accessibilityId("Photo gallery"));
       
       //longclick on thumnail
       longgesture(thub);
       /*((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
    		    "elementId", ((RemoteWebElement) thub).getId()
    		)); */
       System.out.println("longesture worked");
       
     // driver.findElement(AppiumBy.id("com.google.android.GoogleCamera:id/center_left_placeholder")).click();
       
      // longgesture(thub);
        
       driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.GoogleCamera:id/menu_item_layout\").instance(1)")).click();
       System.out.println("locked folder clicked");
       
       driver.findElement(AppiumBy.id("com.google.android.GoogleCamera:id/options_entry_button_icon")).click();
       driver.findElement(AppiumBy.accessibilityId("Open settings")).click();
      
       
       //scrolling  to the bottom of page and click 
       
       driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Help\"));"));
     
       /*
       boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
   		    "left", 100, "top", 100, "width", 200, "height", 600,
   		    "direction", "down",
   		    "percent", 3.0
   		));
   		*/
   		
       
       
       /*
           // Find a scrollable element using UiSelector
           

           // Perform the scrolling action
           scrollableElement.sendKeys("");
           */
       
        
       driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Help\")")).click();
       
       driver.navigate().back();
       
     
        driver.findElement(AppiumBy.androidUIAutomator(
               "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                       + "new UiSelector().text(\"Camera scan suggestions\"))"));
        
        driver.findElement(By.xpath("//*[contains(@text,'Camera scan suggestions')]")).click();
 
       //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollBackward().scrollIntoView(text(\"Guided Frame\"));"));
       
        
       // driver.findElement(AppiumBy.accessibilityId("Photo gallery")).click();   
//        ProcessBuilder pb = new ProcessBuilder("adb reboot");
//        Process process = pb.start();
//        int exitCode = process.waitFor();
//        System.out.println("ADB exited with code: " + exitCode);
//       
       // teardown() ;
    	}}
        
        //Thread.sleep(1000);
         
         
    
    
    


