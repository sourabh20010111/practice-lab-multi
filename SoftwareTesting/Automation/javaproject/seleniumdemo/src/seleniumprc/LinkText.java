package seleniumprc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("https://demo.phpmyadmin.net/master-config/public/");
		wd.manage().window().maximize();
		Thread.sleep(2000);
		
		
		wd.findElement(By.linkText("New")).click();
		wd.findElement(By.partialLinkText("information")).click();
		

	}

}
