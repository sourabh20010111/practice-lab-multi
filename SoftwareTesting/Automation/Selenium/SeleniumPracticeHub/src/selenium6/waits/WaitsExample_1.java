package selenium6.waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsExample_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        1️.Implicit Wait
//        Sets a default wait time for all elements.
//        Applied once and used throughout the script.
//        Selenium will try to find the element until timeout before throwing NoSuchElementException.
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

//        2️.Fluent Wait for Username field
//        Similar to Explicit Wait, but allows:
//        Polling frequency (check every X seconds)
//        Ignore exceptions
//        Useful for dynamic elements.
        
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement username = fluentWait.until(d -> d.findElement(By.id("user-name")));
        username.sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//        3️.Explicit Wait for Login Button
//        Used for specific elements or conditions.
//        Waits until the condition is met or timeout occurs.
//        Requires WebDriverWait and ExpectedConditions.
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginBtn.click();
        
        driver.quit();
        
//        When to use:
//        	Implicit Wait → Set once for all elements (good for small scripts).
//        	Explicit Wait → Use for specific elements that take time to load or become clickable.
//        	Fluent Wait → Use when element appears/disappears at unpredictable times, with polling.
        
//        What is Polling?
//        	In Selenium waits, polling means how often Selenium will check if the element 
//        	has appeared before the total wait time expires.

//        example:
//        .withTimeout(Duration.ofSeconds(15))
//        .pollingEvery(Duration.ofSeconds(2))
        
//        withTimeout(15 sec) → Maximum wait time is 15 seconds.
//        pollingEvery(2 sec) → Selenium will re-check every 2 seconds.
//        If the element is found earlier, the wait ends immediately (it doesn’t wait for the full 15 seconds).

//        | Time (seconds) | Action Selenium Takes                 |
//        | -------------- | ------------------------------------- |
//        | 0s             | Check element – Not found             |
//        | 2s             | Check again – Not found               |
//        | 4s             | Check again – Found!                  |
//        | 7s+            | (Wait stops here, does not go to 15s) |
        
//        Why Polling is useful?
//        	Saves time: Script continues as soon as the element appears.
//        	Avoids unnecessary long waits.
//        	Reduces chances of NoSuchElementException by repeatedly checking.
        
//       When to use Thread.sleep Method:

//        | **Purpose**                                                                                             | **Better Option**                 | **Why**                                                                                                               |
//        | ------------------------------------------------------------------------------------------------------- | --------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
//        | **Wait until an element is present/visible/clickable**                                                  | **WebDriverWait** (Explicit wait) | Checks every few milliseconds (polling) and moves ahead immediately when condition is met. More efficient & reliable. |
//        | **Pause just for timing/visual effect** (e.g., show typing slowly, or simulate delay for demo purposes) | **`Thread.sleep()`**              | Always waits fixed time, useful only when you want a *forced* delay regardless of page readiness.                     |

//        #Rule of thumb
//        1.Testing real web element loading → Use WebDriverWait.
//        2.Just to hold execution for UI effect or debugging → Use Thread.sleep().
        
//        Conclusion:
//        For element readiness → Use Explicit Wait / Fluent Wait.
//        For global default wait → Use Implicit Wait.
//        For debugging or visual pauses → Use Thread.sleep().
//        For very custom situations → Use JavaScript delay.

	}

}
