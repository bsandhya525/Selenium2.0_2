import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;


public class Draggable {

	public static void main(String[] args) {
		
		FirefoxProfile profile = new FirefoxProfile();
		
		profile.setEnableNativeEvents(true);
		
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.get("http://jqueryui.com/demos/draggable");
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		System.out.println("frames:"+frames.size());
		
		WebElement frame;
		for(int i=0;i<frames.size();i++)
		{
			driver.switchTo().frame(frames.get(i));
			
			try{
				if(driver.findElement(By.xpath("//*[@id='draggable']"))!= null)
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
		
		
		WebElement draggableElm = driver.findElement(By.xpath("//*[@id='draggable']"));
				
		//Point p = draggableElm.getLocation();
		Actions act = new Actions(driver);
		
		act.clickAndHold(draggableElm).moveByOffset(100, 100).release().build().perform();
		
        driver.switchTo().defaultContent();
	}

}
