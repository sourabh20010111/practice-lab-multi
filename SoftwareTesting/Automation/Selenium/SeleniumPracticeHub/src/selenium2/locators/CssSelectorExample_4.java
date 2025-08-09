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
        
//        | Selenium Method  | Works When…                                                 | Example HTML              | Example in Selenium                             |
//        | ---------------- | ----------------------------------------------------------- | ------------------------- | ----------------------------------------------- |
//        | `By.id()`        | Element has a **unique `id`**                               | `<input id="username">`   | `driver.findElement(By.id("username"))`         |
//        | `By.className()` | Element has a **class** (single or first class if multiple) | `<div class="login-box">` | `driver.findElement(By.className("login-box"))` |
//        | `By.name()`      | Element has a **name** attribute                            | `<input name="email">`    | `driver.findElement(By.name("email"))`          |

//        Limitations:
//        	className won’t work directly if the element has multiple classes (needs exact match).
//        	These can only find elements based on that one specific attribute.
        
//        | Selector Type               | CSS Syntax       | Example HTML                | Example in Selenium                |
//        | --------------------------- | ---------------- | --------------------------- | ---------------------------------- |
//        | By **id**                   | `#idValue`       | `<input id="username">`     | `By.cssSelector("#username")`      |
//        | By **class**                | `.classValue`    | `<div class="login-box">`   | `By.cssSelector(".login-box")`     |
//        | By **attribute**            | `[name='email']` | `<input name="email">`      | `By.cssSelector("[name='email']")` |
//        | By **hierarchy**            | `div > input`    | `<div><input></div>`        | `By.cssSelector("div > input")`    |
//        | Multiple classes/attributes | `.class1.class2` | `<div class="btn primary">` | `By.cssSelector(".btn.primary")`   |

//        Key Difference:
//        id / className / name → Short, readable, but very limited.
//        cssSelector → Can replace all three above and do much more (like complex combinations, multiple attributes, or child/parent selection).
        
//        This will work as long as you have:
//        Selenium 4+, Firefox installed, Internet access

	}

}
