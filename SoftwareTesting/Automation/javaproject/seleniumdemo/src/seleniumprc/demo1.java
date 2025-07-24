package seleniumprc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo1 {
public static void main(String[] args) {
		
	WebDriver wd = new ChromeDriver();
	wd.get("https://www.selenium.dev/downloads/");
	wd.manage().window().maximize();
	wd.quit();		
		
	}
}
