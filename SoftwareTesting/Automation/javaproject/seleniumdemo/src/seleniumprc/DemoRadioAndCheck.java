package seleniumprc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoRadioAndCheck {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new FirefoxDriver();
		wd.get("https://demo.phpmyadmin.net/master-config/public/");
		wd.manage().window().maximize();
		
		Thread.sleep(4000);
		
		wd.findElement(By.linkText("mysql")).click();
		WebElement check=wd.findElement(By.id("checkbox_tbl_1"));
		check.click();
		System.out.println(check.isSelected());
		
		Thread.sleep(2000);
		
		wd.findElement(By.linkText("Search")).click();
		WebElement rdo=wd.findElement(By.id("criteriaSearchTypeRadio5"));
		rdo.click();
		System.out.println(rdo.isSelected());
		
		Thread.sleep(2000);
		wd.quit();

	}

}
