package pom;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CallingPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd=new ChromeDriver();
		wd.get("https://www.saucedemo.com/v1/");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		LoginRepository lgr=new LoginRepository(wd);
		lgr.User("standard_user");
		lgr.Pass("secret_sauce");
		lgr.Login();
		
		LogoutRepository lgout = new LogoutRepository(wd);
		lgout.Menu();
		Thread.sleep(4000);
		lgout.Logout();
		Thread.sleep(2000);
		wd.quit();

	}

}
