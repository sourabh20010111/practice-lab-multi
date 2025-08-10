package selenium8.screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class ElementScreenshotExampleWithSaucedemo_2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        // Wrong credentials array
        String[][] wrongData = {
                {"wrongUser1", "wrongPass1"},
                {"wrongUser2", "wrongPass2"},
                {"wrongUser3", "wrongPass3"}
        };

        for (int i = 0; i < wrongData.length; i++) {
            // Clear old data
            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.id("password")).clear();

            // Enter wrong username & password
            driver.findElement(By.id("user-name")).sendKeys(wrongData[i][0]);
            driver.findElement(By.id("password")).sendKeys(wrongData[i][1]);

            // Click login
            driver.findElement(By.id("login-button")).click();

            // Wait a bit for error message to show
            Thread.sleep(1000);

            // Check if error message element present
            WebElement errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']"));

            // Create folder if doesn't exist
            File folder = new File("./ElementScreenshots");
            if (!folder.exists()) {
                folder.mkdirs();
                System.out.println("Folder created at: " + folder.getAbsolutePath());
            }

            // Take full page screenshot
            File srcFileFull = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFileFull, new File(folder, "InvalidLogin_FullPage_" + (i + 1) + ".png"));

            // Take screenshot of error message element only
            File srcFileElem = errorMsg.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFileElem, new File(folder, "InvalidLogin_ErrorElement_" + (i + 1) + ".png"));

            System.out.println("Screenshots saved for attempt " + (i + 1));
        }

        driver.quit();

	}

}
