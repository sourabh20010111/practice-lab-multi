package seleniumprc;

//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoRegisFormWL {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		wd.get("https://demo.automationtesting.in/Register.html");
		wd.manage().window().maximize();
		
//		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		
		wd.findElement(By.id("msdd")).click();
		List<WebElement>options = wd.findElements(By.className("ui-corner-all"));
		System.out.println(options.size());
		
		for(WebElement op:options) {
			if(op.getText().equals("Arabic") || op.getText().equals("Croatian") ) {
				op.click();
			}
		}
		
		Thread.sleep(2000);
		wd.quit();

	}

}
