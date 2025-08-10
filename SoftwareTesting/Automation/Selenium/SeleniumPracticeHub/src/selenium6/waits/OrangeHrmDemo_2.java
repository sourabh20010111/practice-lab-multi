package selenium6.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmDemo_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		1.ImplicitlyWait
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		2.Explicitly wait
		
//		WebDriverWait wt = new WebDriverWait(wd, Duration.ofSeconds(20));
//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		wd.manage().window().maximize();
		
		wd.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(2000);
		wd.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(2000);
		wd.findElement(By.className("oxd-button")).click();

		Thread.sleep(4000);
		wd.quit();

	}

}
