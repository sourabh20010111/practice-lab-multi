package seleniumprc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IdNameLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new FirefoxDriver();
		wd.get("https://www.saucedemo.com/v1/");
		wd.manage().window().maximize();
		
		wd.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		wd.findElement(By.name("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		wd.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		wd.quit();
		
//		Xpath practice 
		
//		//*[@id=\"menu_button_container\"]/div/div[3]/div/button -> relative 
		
//		/html/body/div/div[1]/div/div[2]/div[1]/nav/a[3] -> absolute
		
//		wd.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
//		Thread.sleep(2000);
//		wd.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/nav/a[3]")).click();
//		Thread.sleep(2000);
	}

}
