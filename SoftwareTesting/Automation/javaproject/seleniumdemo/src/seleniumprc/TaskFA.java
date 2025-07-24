package seleniumprc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TaskFA {

	public static void main(String[] args) {
		WebDriver wd =  new ChromeDriver();
		wd.get("https://quastechproject.com/project/frontaccounting_automation/index.php");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		wd.findElement(By.name("user_name_entry_field")).sendKeys("fauser01");
		wd.findElement(By.name("password")).sendKeys("fauser01");
		Select sc= new Select(wd.findElement(By.name("company_login_name")));
		sc.selectByVisibleText("Automation_Thane");
		
		wd.findElement(By.name("SubmitUser")).click();

	}

}
