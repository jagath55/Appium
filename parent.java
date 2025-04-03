package sample;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class parent {
	AndroidDriver driver;
	UiAutomator2Options options;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void setup() {
	
		
	 service = AppiumDriverLocalService.buildDefaultService();
	 service.start();
	
	 options = new UiAutomator2Options();
	 options.setDeviceName("pixel 8 Pro API 34");
     options.setPlatformName("Android");
     options.setAppPackage(null);
     	
	 driver = new AndroidDriver(service.getUrl(),options);
	
	}
	
	public void longgesture(WebElement element) {
		
	/*RemoteWebElement remoteelement = (RemoteWebElement) element;
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
    		    "elementId", remoteelement.getId()
    		));
		*/
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
    		    "elementId", ((RemoteWebElement) element).getId()
    		));
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		service.stop();
	}
	
}
