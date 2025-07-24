package seleniumprc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoDropdown2 {

	public static void main(String[] args) {
		WebDriver wd=new FirefoxDriver();
		wd.get("https://www.saucedemo.com/v1/");
		wd.manage().window().maximize();
		
		wd.findElement(By.id("user-name")).sendKeys("standard_user");
		wd.findElement(By.id("password")).sendKeys("secret_sauce");
		
		wd.findElement(By.id("login-button")).click();
		
		Select sc = new Select(wd.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select")));
		sc.selectByVisibleText("Price (low to high)");

	}

}
