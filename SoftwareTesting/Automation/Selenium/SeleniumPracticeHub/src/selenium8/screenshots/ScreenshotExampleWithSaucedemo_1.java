package selenium8.screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenshotExampleWithSaucedemo_1 {

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
            
            
         // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
//          FileHandler.copy(srcFile, new File("./screenshots/InvalidLogin" + (i + 1) + ".png")); // this will give error if folder doesn't exist
            
            File folder = new File("./screenshots");
            if (!folder.exists()) {
                folder.mkdirs();
                System.out.println("Folder created at: " + folder.getAbsolutePath());
            }
            
            FileHandler.copy(srcFile, new File(folder, "InvalidLogin" + (i + 1) + ".png"));
            System.out.println("Screenshot saved: InvalidLogin" + (i + 1) + ".png");
        }

        driver.quit();
	}

}
