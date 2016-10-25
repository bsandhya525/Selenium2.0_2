import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;


public class Slider {

	public static void main(String[] args) {
		
		FirefoxProfile profile = new FirefoxProfile();
		
		profile.setEnableNativeEvents(true);
		
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.get("http://jqueryui.com/slider/");
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		System.out.println("frames:"+frames.size());
		
		
		for(int i=0;i<frames.size();i++)
		{
			driver.switchTo().frame(frames.get(i));
			
			try{
				if(driver.findElement(By.xpath("//*[@id='slider']/span"))!= null)
				{
					System.out.println("Found");
					
					break;
				}
			}
			catch(Exception ex)
			{
				System.out.println("Not Found");
			}
			
			driver.switchTo().defaultContent();
		}
		
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
		
		Point p = slider.getLocation();
		
		Actions act = new Actions(driver);
		
		act.clickAndHold(slider).moveByOffset(p.x+500, p.y).release(slider).build().perform();
		
		

	}

}
