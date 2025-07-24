package seleniumprc;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsEx {

	public static void main(String[] args) {
		WebDriver wd = new FirefoxDriver();
		wd.get("https://demo.phpmyadmin.net/master-config/public");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions ac = new Actions(wd);
		
		List<WebElement> menu = wd.findElements(By.className("hover_show_full"));
		for (int i=1; i<=menu.size();i++) {
			
			ac.moveToElement(menu.get(i)).build().perform();
			System.out.println(menu.get(i).getText());
			
		}
		
		
	}

}
