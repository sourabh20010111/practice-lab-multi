package seleniumprc;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertEx {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new FirefoxDriver();
		wd.get("https://demo.automationtesting.in/Alerts.html");
		wd.manage().window().maximize();
		
		// simple alert
		wd.findElement(By.linkText("Alert with OK")).click();
		wd.findElement(By.className("btn-danger")).click();
		
		Alert alt = wd.switchTo().alert();
		Thread.sleep(2000);
		alt.accept();
		
		// confirmation alert
		wd.findElement(By.linkText("Alert with OK & Cancel")).click();
		wd.findElement(By.className("btn-primary")).click();
		Thread.sleep(2000);
		alt.dismiss();
		
		// prompt alert
		wd.findElement(By.linkText("Alert with Textbox")).click();
		wd.findElement(By.className("btn-info")).click();
		Thread.sleep(2000);
		alt.sendKeys(" ");
		
		Thread.sleep(2000);
		alt.sendKeys("users");
		alt.accept();
		
		
		Thread.sleep(3000);
		wd.quit();
		

	}

}
