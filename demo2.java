package sample;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class demo2 extends parent{

	@Test
	public void appiumbas() {
		//setup();
		
		Activity act = new Activity("com.google.android.apps.photos","com.google.android.apps.photos.home.HomeActivity");
	
		 //((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.google.android.apps.photos/com.google.android.apps.photos.home.HomeActivity"));
	 //  ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.google.android.apps.photos/com.google.android.apps.photos.home.HomeActivity"));
 
	   WebElement dragd = driver.findElement(AppiumBy.accessibilityId("Photos"));
	  
	  
	  // Java
	   ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
	       "elementId", ((RemoteWebElement) dragd).getId(),
	       "endX", 608,
	       "endY", 1092
	   ));
	   
	   
	}
}
