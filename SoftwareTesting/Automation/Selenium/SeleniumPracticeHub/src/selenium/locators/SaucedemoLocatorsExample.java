package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaucedemoLocatorsExample {
	 public static void main(String[] args) throws InterruptedException {
//		 1.WebDriver
//		 What it is:
//		 An interface in Selenium that controls the browser.
//		 Think of it as the driver that takes your instructions and drives the browser to perform actions like opening a URL, clicking, typing, navigation, etc.
//		 Main uses:
//		 Launch browser
//		 Navigate to pages
//		 Manage browser window
//		 Close or quit browser
		 
	        // Launch Firefox
	        WebDriver wd = new FirefoxDriver(); // opens firefox
	        wd.get("https://www.saucedemo.com/v1/"); // open saucedemo site
	        wd.manage().window().maximize(); // maximize window
	        
	        // 1. ID Locator
	        wd.findElement(By.id("user-name")).sendKeys("standard_user");
	        Thread.sleep(2000); // Wait 2 seconds to observe typing action

	        // 2. Name Locator
	        wd.findElement(By.name("password")).sendKeys("secret_sauce");
	        Thread.sleep(2000);

	        // 3. ID Locator for button
	        wd.findElement(By.id("login-button")).click();
	        Thread.sleep(2000);

//	        2. WebElement
//	        What it is:
//	        An interface in Selenium that represents a specific element on a web page (button, input field, link, etc.).
//	        Once WebDriver finds the element, you can interact with it — type, click, get text, etc.
//	        Main uses:
//	        Click an element
//	        Type into input fields
//	        Get text/attributes
//	        Clear input fields
	        
	        
	        // 4. Class Name Locator (Get product name)
	        WebElement firstItem = wd.findElement(By.className("inventory_item_name"));
	        System.out.println("First product: " + firstItem.getText());
	        Thread.sleep(2000);

	        // 5. CSS Selector Locator (Add to cart button)
	        wd.findElement(By.cssSelector(".btn_inventory")).click();
	        Thread.sleep(2000);

	        // 6. Link Text Locator (Cart icon is a link)
	        wd.findElement(By.linkText("1")).click();  // Clicking the cart link
	        Thread.sleep(2000);

	        // 7. XPath Locator (Checkout button)
	        wd.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
	        Thread.sleep(2000);

	        // Quit browser or closes browser
	        wd.quit();
	        
//	        | Feature        | WebDriver                                                | WebElement                                   |
//	        | -------------- | -------------------------------------------------------- | -------------------------------------------- |
//	        | **Purpose**    | Controls the entire browser                              | Represents a single HTML element             |
//	        | **Scope**      | Global — whole browser                                   | Local — one specific element                 |
//	        | **Created by** | Using `new BrowserDriver()` (like `new FirefoxDriver()`) | Using `findElement()` from WebDriver         |
//	        | **Can Do**     | Open URL, navigate, manage window, quit browser          | Click, type, get text, clear, get attributes |
//	        | **Example**    | `driver.get("url")`                                      | `element.sendKeys("text")`                   |

	        
//	        Notes on Thread.sleep() in Selenium:
//	        Purpose in practice: Helps you visually see what’s happening step-by-step.
//	        In real projects: Use WebDriverWait instead of Thread.sleep() for better performance and stability.
	    }

}
