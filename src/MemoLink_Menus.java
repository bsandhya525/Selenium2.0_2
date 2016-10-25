import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class MemoLink_Menus {
	
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://memolink.com");
		
		WebElement main = driver.findElement(By.xpath("//*[@id='navBar3']/div/ul/li[5]/a"));
		
		WebElement sub = driver.findElement(By.xpath("//*[@id='navBar3']/div/ul/li[5]/ul/li[7]/a/span"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(main).build().perform(); //works only with UL and LI tags
		
		Thread.sleep(3000);
		
		sub.click();
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
