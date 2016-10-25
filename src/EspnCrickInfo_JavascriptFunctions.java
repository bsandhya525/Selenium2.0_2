import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class EspnCrickInfo_JavascriptFunctions {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.makemytrip.com/flights"); //Replace site url with actual url
		
		Thread.sleep(5000);
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		System.out.println("frames:"+frames.size());
		
		WebElement frame;
		for(int i=0;i<frames.size();i++)
		{
			driver.switchTo().frame(frames.get(i));
			
			try{
				if(driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']/span/i"))!= null)
				{
					System.out.println("Found");
					frame = frames.get(i);
					break;
				}
			}
			catch(Exception ex)
			{
				System.out.println("Not Found");
			}
			
			driver.switchTo().defaultContent();
		}
		
		if(driver.findElement(By.xpath("//*[@class='close']")).isDisplayed())
		
			driver.findElement(By.xpath("//*[@class='close']")).click();
		
		driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']/span/i")).click();
		
		driver.switchTo().defaultContent();
		
		
	//	((JavascriptExecutor)driver).executeScript("change_trip_type('one_way_button', 'trip_type', 'o')");//Replace here with actual javascript function
	
		             //or
		
		((JavascriptExecutor)driver).executeScript("document.getElementById('one_way_button1').click()");
		
		/*driver.get("http://ebay.com");
		
		WebElement main = driver.findElement(By.xpath("//*[@id='navigationFragment']/div/table/tbody/tr/td[4]/a"));
		
		WebElement sub = driver.findElement(By.xpath("//*[@id='navigationFragment']/div/table/tbody/tr/td[4]/div[2]/div[1]/ul[2]/li[4]/a"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(main).build().perform();
	
		Thread.sleep(3000);
		
		sub.click();*/
	}

}
