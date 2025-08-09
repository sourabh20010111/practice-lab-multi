package selenium4.actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {

	public static void main(String[] args) throws InterruptedException {
		
//		The Actions class in Selenium is used to perform advanced mouse and keyboard interactions.
		
//		1. Mouse Actions
//		| Action                      | Method            | Example                                                                    |
//		| --------------------------- | ----------------- | -------------------------------------------------------------------------- |
//		| **Hover (Move to Element)** | `moveToElement()` | `actions.moveToElement(element).perform();`                                |
//		| **Right Click**             | `contextClick()`  | `actions.contextClick(element).perform();`                                 |
//		| **Double Click**            | `doubleClick()`   | `actions.doubleClick(element).perform();`                                  |
//		| **Drag and Drop**           | `dragAndDrop()`   | `actions.dragAndDrop(source, target).perform();`                           |
//		| **Click and Hold**          | `clickAndHold()`  | `actions.clickAndHold(element).moveToElement(target).release().perform();` |

//		2. Keyboard Actions
//		| Action          | Method                | Example                                                                     |
//		| --------------- | --------------------- | --------------------------------------------------------------------------- |
//		| **Send Keys**   | `sendKeys()`          | `actions.sendKeys(element, "Text").perform();`                              |
//		| **Press Key**   | `keyDown(Keys.SHIFT)` | `actions.keyDown(Keys.SHIFT).sendKeys("test").keyUp(Keys.SHIFT).perform();` |
//		| **Release Key** | `keyUp()`             | `actions.keyUp(Keys.CONTROL).perform();`                                    |

		WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        // Mouse Hover Example
        WebElement hoverElement = driver.findElement(By.linkText("SwitchTo"));
        actions.moveToElement(hoverElement).perform();
        Thread.sleep(2000);

        // Right Click Example
        WebElement rightClickElement = driver.findElement(By.id("submitbtn"));
        actions.contextClick(rightClickElement).perform();
        Thread.sleep(2000);

        driver.quit();
        
//      Tip: 
//      Always use .perform() at the end to execute the built action.
//      You can chain multiple actions together in one go.


	}

}
