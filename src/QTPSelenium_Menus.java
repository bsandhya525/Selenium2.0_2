import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;


public class QTPSelenium_Menus {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		FirefoxProfile profile = new FirefoxProfile();
		
		profile.setEnableNativeEvents(true);
		
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://walmart.com");             
		
		WebElement main = driver.findElement(By.xpath("//*[@id='top']/div[3]/div/nav/div/div[4]/div/nav/ul/li[2]/div/a"));
				
		Actions act = new Actions(driver);
		
		act.moveToElement(main).build().perform();
		
		 Thread.sleep(5000);
		 
		 WebElement sub = driver.findElement(By.xpath("//*[starts-with(@id,'flyout')]/ul/li[1]/a[text()='Baby Registry']"));
		
		 sub.click();
	}

}
