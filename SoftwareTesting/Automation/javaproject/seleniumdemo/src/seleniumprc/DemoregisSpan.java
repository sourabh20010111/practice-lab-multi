package seleniumprc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoregisSpan {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd= new ChromeDriver();
		wd.get("https://demo.automationtesting.in/Register.html");
		wd.manage().window().maximize();
		Thread.sleep(2000);
		
		wd.findElement(By.id("select2-country-container"));
		
		
		
		
		
		Thread.sleep(2000);
		wd.quit();
		

	}

}
