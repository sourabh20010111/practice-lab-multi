package seleniumprc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.amazon.in/");
		wd.manage().window().maximize();
		Thread.sleep(3000);
		
		Select sc = new Select(wd.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")));
//		sc.selectByIndex(2);
		sc.selectByValue("search-alias=fashion");
//		sc.selectByVisibleText("Amazon Fashion");
		Thread.sleep(2000);
		wd.quit();		

	}

}
