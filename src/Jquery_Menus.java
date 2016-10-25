import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Jquery_Menus {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://apycom.com/menus/16-deep-sky-blue.html");
		
		String mainXpath="//*[@id='menu']/ul/li[1]/a/span";
		
		String subXpath="//*[@id='menu']/ul/li[1]/span/div/ul/li[2]/a/span";
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath(mainXpath))).build().perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(subXpath)).click();

	}

}
