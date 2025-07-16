package Appiumdemo;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class swipetouchactions {
       AndroidDriver driver;
       UiAutomator2Options options;
       AppiumDriverLocalService service;
       
       @BeforeClass
       public void setup() {
    	  service  =AppiumDriverLocalService.buildDefaultService();
    	  service.start();
    	  
    	options=new UiAutomator2Options();
    	options.setDeviceName("Pixel 8a API 35");
    	options.setPlatformName("android");
    	
    	driver = new AndroidDriver(service.getUrl(),options);
    	
    	      	   
       }
       
       
       @Test
       public void swipetest() {
    	   Dimension size=driver.manage().window().getSize();
    	   int startx=size.getWidth()/2;
    	   int starty=size.getHeight()/2;
    	   
    	   int endx=startx;
    	   int endy=(int) (size.getHeight()*0.25);
    	   
    	   //
    	   PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
    	   Sequence sq=new Sequence(finger,1);
    	   
    	   //list of actions to be performed
    	   sq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), startx,starty))
    	     .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
    	     .addAction(new Pause(finger,Duration.ofMillis(200)))
    	     .addAction(finger.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(),endx,endy))
    	     .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    	   
    	   //perofrm the collection sequence
    	   driver.perform(Collections.singletonList(sq));
    	   driver.quit();
       }
}
