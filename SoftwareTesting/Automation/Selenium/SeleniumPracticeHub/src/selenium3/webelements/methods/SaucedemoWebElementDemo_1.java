package selenium3.webelements.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaucedemoWebElementDemo_1 {

	public static void main(String[] args) throws InterruptedException {
		
		// Launch browser
        WebDriver driver = new FirefoxDriver();

        // 1. Open URL
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // 2. Enter username (sendKeys)
        WebElement username = driver.findElement(By.id("user-name"));
        username.clear(); // clear old text
        username.sendKeys("standard_user");

        // 3. Enter password (sendKeys)
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // 4. Click Login button (click)
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        
        // 5. Get Text of a product title (getText)
        String productName = driver.findElement(By.className("inventory_item_name")).getText();
        System.out.println("First product name: " + productName);

        // 6. Get attribute of price div (getAttribute)
        String priceAttr = driver.findElement(By.className("inventory_item_price")).getAttribute("class");
        System.out.println("Price element class attribute: " + priceAttr);

        // 7. Check if Add to Cart button is displayed (isDisplayed)
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        System.out.println("Add to Cart displayed: " + addToCartBtn.isDisplayed());

        // 8. Check if Add to Cart button is enabled (isEnabled)
        System.out.println("Add to Cart enabled: " + addToCartBtn.isEnabled());

        // 9. Click Add to Cart
        addToCartBtn.click();
        Thread.sleep(2000);

        // 10. Example of isSelected (using a checkbox simulation)
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        checkbox1.click();
        Thread.sleep(2000);
        System.out.println("Checkbox selected: " + checkbox1.isSelected());

        // Close browser
        driver.quit();
        
//        What this covers:
//        	click() → Login button, Add to Cart, Checkbox
//          sendKeys() → Username & Password
//        	clear() → Username field before typing
//        	getText() → Product name
//        	getAttribute() → Price element’s class attribute
//        	isDisplayed() → Add to Cart visibility
//        	isEnabled() → Add to Cart availability
//        	isSelected() → Checkbox selection check
        
//        | WebElement Method                   | Purpose                                              |
//        | ----------------------------------- | ---------------------------------------------------- |
//        | `click()`                           | Selects gender radio button and hobbies checkbox     |
//        | `sendKeys()`                        | Inputs text into fields (name, email, phone)         |
//        | `clear()`                           | Clears default field values before entering new ones |
//        | `getText()`                         | Retrieves text from the page heading                 |
//        | `isSelected()`                      | Checks if a radio button or checkbox is selected     |
//        | `isEnabled()`                       | Verifies if the submit button is enabled or disabled |
//        | `Select` (`.selectByVisibleText()`) | Chooses options in Skills and Country dropdowns      |

	}

}
