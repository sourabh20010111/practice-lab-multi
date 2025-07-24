package seleniumprc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(2000);
		
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		WebDriverWait wt = new WebDriverWait(wd, Duration.ofSeconds(20));
//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		wd.manage().window().maximize();
		
		wd.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(2000);
		wd.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(2000);
//		wd.findElement(By.className("orangehrm-login-button")).click();
		wd.findElement(By.className("oxd-button")).click();

		Thread.sleep(4000);
		wd.quit();
	}

}
