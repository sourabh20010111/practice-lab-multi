package selenium7.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertsDemo_1 {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

	        // 1️ Simple Alert
	        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	        Alert alert1 = driver.switchTo().alert();
	        System.out.println("Simple Alert Text: " + alert1.getText());
	        Thread.sleep(1000); // just to see
	        alert1.accept(); // Click OK

	        // 2️ Confirmation Alert
	        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	        Alert alert2 = driver.switchTo().alert();
	        System.out.println("Confirmation Alert Text: " + alert2.getText());
	        Thread.sleep(1000);
	        alert2.dismiss(); // Click Cancel

	        // 3️ Prompt Alert
	        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	        Alert alert3 = driver.switchTo().alert();
	        System.out.println("Prompt Alert Text: " + alert3.getText());
	        Thread.sleep(1000);
	        alert3.sendKeys("Sourabh Testing");
	        alert3.accept(); // Click OK

	        Thread.sleep(2000);
	        driver.quit();
	        
//	        How it works:
//	        	switchTo().alert() → moves focus to the alert box.
//	        	.getText() → reads the message.
//	        	.accept() → clicks OK.
//	        	.dismiss() → clicks Cancel.
//	        	.sendKeys() → types into prompt alert.

//	        Why // and not /?
//	     	// → search anywhere in the DOM.
//	     	/ → search from the root (more fragile).
	}

}
