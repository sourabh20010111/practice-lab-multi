package seleniumprc;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PrcMagneto {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd= new ChromeDriver();
		wd.get("https://magento.softwaretestingboard.com/");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions ac = new Actions(wd);
		
		ac.moveToElement(wd.findElement(By.id("ui-id-6"))).perform();
		List<WebElement> op=wd.findElements(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/nav/ul/li[4]/ul/li/a/span"));
		for(int i=1; i<=op.size();i++) {
			ac.moveToElement(wd.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/nav/ul/li[4]/ul/li["+i+"]/a/span"))).perform();
			Thread.sleep(2000);
		}
		wd.quit();
	
	}

}
