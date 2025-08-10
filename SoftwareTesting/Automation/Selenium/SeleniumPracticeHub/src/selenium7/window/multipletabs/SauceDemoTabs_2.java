package selenium7.window.multipletabs;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoTabs_2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 1: Open SauceDemo
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Step 2: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Step 3: Store main window handle
        String mainWindow = driver.getWindowHandle();

        // Step 4: Click Twitter link (footer)
        driver.findElement(By.linkText("Twitter")).click();

        // Step 5: Get all windows and switch to new one
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);

                // Explicit wait for title to contain "Twitter"
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.titleContains("X"));

                System.out.println("New tab title: " + driver.getTitle());
                driver.close(); // Close new tab
            }
        }

        // Step 6: Switch back to main window
        driver.switchTo().window(mainWindow);
        System.out.println("Back to main window: " + driver.getTitle());
        
        Thread.sleep(2000);
        driver.quit();
    }
}
