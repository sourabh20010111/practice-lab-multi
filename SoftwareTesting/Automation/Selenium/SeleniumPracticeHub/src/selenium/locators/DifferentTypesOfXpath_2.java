package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DifferentTypesOfXpath_2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        // 1. Relative XPath - Login username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(1500); // wait to see action

        // 2. contains() - Login password
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("secret_sauce");
        Thread.sleep(1500);

        // 3. text() - Click Login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(1500);

        // 4. starts-with() - First product title
        WebElement firstItem = driver.findElement(By.xpath("//div[starts-with(@class,'inventory_item_name')]"));
        System.out.println("First product: " + firstItem.getText());
        Thread.sleep(1500);

        // 5. Index - Add to cart (first button)
        driver.findElement(By.xpath("(//button[contains(text(),'ADD TO CART')])[1]")).click();
        Thread.sleep(1500);

        // 6. Parent - Go from product name to its parent div
        WebElement parentDiv = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/../.."));
        System.out.println("Parent element class: " + parentDiv.getAttribute("class"));
        Thread.sleep(1500);

        driver.quit();

//		1. Absolute XPath
//		Starts from the root (`html`)** of the document and follows the full path to the element.

//		Example:
//		driver.findElement(By.xpath("/html/body/div[2]/form/input[1]")).sendKeys("text");
//		* ❌ **Downside**: Breaks easily if page structure changes.


//		2. Relative XPath
//		Starts from **any element** in the HTML (not the root).
		
//		Example:
//		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("Admin");
//		* ✅ **Advantage**: Shorter, less fragile, preferred in practice.

//		3. XPath with `and` / `or`
//		Matches when **multiple conditions** are true (and) or at least one is true (or).
		
//		Example:
//		driver.findElement(By.xpath("//input[@id='user-name' and @type='text']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@id='user' or @name='username']")).sendKeys("Admin");

//		4. XPath with `contains()`
//		Used when attribute value is **partial** or **dynamic**.
		
//		Example:
//		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("Admin");


//		5. XPath with `starts-with()`**
//		Matches attribute values starting with specific text.
		
//		Example:
//		driver.findElement(By.xpath("//input[starts-with(@id,'user-')]")).sendKeys("Admin");

//		6. XPath with `text()`**
//		Finds element by **visible text**.
		
//		Example:
//		driver.findElement(By.xpath("//button[text()='Login']")).click();

//		7. XPath with `normalize-space()`**
//		Ignores leading/trailing spaces in text.
		
//		Example:
//		driver.findElement(By.xpath("//a[normalize-space()='Register Now']")).click();

//		8. XPath with Index
//		When multiple elements match — pick by position.
		
//		Example:
//		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Admin");

//		9. XPath with Parent/Child
//		Child**: `//div[@class='form']/input`
//		Parent**: `//input[@id='user-name']/..` (goes to parent node)

//
//		10. XPath Axes
//		These help navigate through the DOM relative to a known element:

//		* **following**: `//input[@id='user-name']/following::input[1]`
//		* **preceding**: `//input[@id='password']/preceding::input[1]`
//		* **following-sibling**: `//h2/following-sibling::p`
//		* **ancestor**: `//input[@id='user-name']/ancestor::form`
//		* **descendant**: `//div[@class='form']/descendant::input`


//		| XPath Type          | Example                                 |
//		| ------------------- | --------------------------------------- |
//		| Absolute            | `/html/body/div/form/input`             |
//		| Relative            | `//input[@id='user-name']`              |
//		| Multiple Conditions | `//input[@id='user' and @type='text']`  |
//		| contains()          | `//input[contains(@id,'user')]`         |
//		| starts-with()       | `//input[starts-with(@id,'user-')]`     |
//		| text()              | `//button[text()='Login']`              |
//		| normalize-space()   | `//a[normalize-space()='Register Now']` |
//		| Index               | `(//input[@type='text'])[2]`            |
//		| Parent              | `//input[@id='user-name']/..`           |
//		| Child               | `//div[@class='form']/input`            |
//		| Axes                | `//h2/following-sibling::p`             |

	}

}
