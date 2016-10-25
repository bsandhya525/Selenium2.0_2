import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;


public class MouseMovement {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver web_dr=new FirefoxDriver();
		
		EventFiringWebDriver driver = new EventFiringWebDriver(web_dr);
		
		MyListener listener = new MyListener();
		
		driver.register(listener);
		
		EventFiringMouse mouse = new EventFiringMouse(driver,listener);
		
		driver.get("http://timesofindia.com");
		
		Thread.sleep(2000);
		
		List<WebElement> frames = driver.findElements(By.id("indiatimes"));
		
		System.out.println("frames:"+frames.size());
		
		WebElement frame = null;
		
		
		//driver.switchTo().frame(getFrame(frames,driver));
				
		Locatable locator = (Locatable)driver.findElement(By.xpath("//div[@id='environmentwidget']/ul/li[1]/h3/a"));
	
		Coordinates coords = locator.getCoordinates();
		try{
			mouse.mouseMove(coords);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		Point p = (driver.findElement(By.xpath("//div[@id='environmentwidget']/ul/li[1]/h3/a"))).getLocation();
	
		System.out.println("x:"+p.x);
		
		System.out.println("y:"+p.y);
		
		//driver.switchTo().defaultContent();
		
	}
	
	public static WebElement getFrame(List<WebElement> frames,WebDriver driver)
	{
		
		for(int i=0;i<frames.size();i++)
		{
			System.out.println(frames.get(i).getAttribute("id")+"---"+frames.get(i).getTagName());
			driver.switchTo().frame(frames.get(i));
			try{
								
				 if(driver.findElement(By.cssSelector("ul[class='list2'] li:nth-child(1) h3 a")) != null)
				 {
					 

					 System.out.println("Found");
							
					 return frames.get(i);
				 }
			}
			catch(Exception ex)
			{
				System.out.println("Not Found");
			}
			
			driver.switchTo().defaultContent();
		}
		
		return null;
	}
}
