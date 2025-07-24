package seleniumprc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("https://magento.softwaretestingboard.com/");
		wd.manage().window().maximize();
		
		wd.findElement(By.cssSelector("input#search")).sendKeys("A");
		Thread.sleep(2000);
		
		wd.findElement(By.cssSelector("button[type='submit']")).click();
		
		wd.navigate().back();
		
		wd.findElement(By.cssSelector("span.more")).click();
		
		wd.quit();		
	
	}

}
