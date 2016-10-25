import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class ListenerTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver web_dr=new FirefoxDriver();
		
		EventFiringWebDriver driver = new EventFiringWebDriver(web_dr);
		
		MyListener listener = new MyListener();
		
		driver.register(listener);
		
		driver.navigate().to("https://www.yahoo.com/");
		
		driver.findElement(By.xpath("//span[text()='Finance']")).click();
		
		Thread.sleep(5000);
		
		driver.navigate().back();
		
		Thread.sleep(5000);
		
		driver.navigate().forward();
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
