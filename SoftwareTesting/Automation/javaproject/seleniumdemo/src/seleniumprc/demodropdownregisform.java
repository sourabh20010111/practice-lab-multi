package seleniumprc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class demodropdownregisform {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("https://demo.automationtesting.in/Register.html");
		wd.manage().window().maximize();
		Select sc= new Select(wd.findElement(By.id("Skills")));
//		sc.selectByIndex(3);
//		sc.selectByValue("Android");
		sc.selectByVisibleText("Adobe Photoshop");
		Thread.sleep(2000);
		wd.quit();
//		sc.deselectByVisibleText("Adobe Photoshop"); // deselects from multiple values
		

	}

}
