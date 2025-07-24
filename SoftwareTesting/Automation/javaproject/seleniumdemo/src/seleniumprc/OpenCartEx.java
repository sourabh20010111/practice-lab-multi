package seleniumprc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenCartEx {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd =new FirefoxDriver();
		wd.get("https://www.opencart.com/");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		for (int i=1;i<=8;i++) {
			wd.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li["+i+"]/a")).click();
			Thread.sleep(2000);
		}
		
		

	}

}
