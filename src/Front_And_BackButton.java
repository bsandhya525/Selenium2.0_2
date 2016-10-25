import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Front_And_BackButton {
	
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		driver = new FirefoxDriver();
		
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
