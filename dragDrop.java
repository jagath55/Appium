package sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class dragDrop extends parent {
	
	@Test
	public void drag() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               setup();
               
               WebElement app=driver.findElement(AppiumBy.accessibilityId("Confirmtkt"));
               
               
               ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
            		    "elementId", ((RemoteWebElement) app).getId(),
            		    "endX", 387,
            		    "endY", 1300
            		));
               
               
               ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
            		    "left", 300, "top", 100, "width", 200, "height",1200,
            		    "direction", "left",
            		    "percent", 1
            		));
               driver.pressKey(new KeyEvent(AndroidKey.HOME));
               
              // Thread.sleep(10);
               
               boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
              		    "left", 100, "top", 100, "width", 200, "height", 1200,
              		    "direction", "down",
              		    "percent", 3.0
              		));
               
               
              
               System.out.println("photos opened");
              // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"YT Music\"));"));
               
               
              //driver.setClipboardText("youtube");
               
            //  driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)"))
            //  .sendKeys(driver.getClipboardText());
               /*
               DeviceRotation landscape = new DeviceRotation(0,0,90);
               driver.rotate(landscape);s
               */
               
               teardown();
	}
}
