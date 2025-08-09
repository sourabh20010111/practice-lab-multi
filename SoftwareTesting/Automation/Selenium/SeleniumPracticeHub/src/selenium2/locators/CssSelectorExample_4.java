package selenium2.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CssSelectorExample_4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // CSS by ID
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");

        // CSS by attribute
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("secret_sauce");

        // CSS by class
        driver.findElement(By.cssSelector(".submit-button")).click();

        Thread.sleep(1000);

        // CSS by tag + attribute
        WebElement productName = driver.findElement(By.cssSelector("div[data-test='inventory-item-name']"));
        System.out.println("Product Name: " + productName.getText());

        // CSS by class name
        WebElement price = driver.findElement(By.cssSelector(".inventory_item_price"));
        System.out.println("Price: " + price.getText());

        driver.quit();
        
//        This will work as long as you have:
//        Selenium 4+, Firefox installed, Internet access

	}

}
