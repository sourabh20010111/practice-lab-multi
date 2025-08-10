package selenium7.window.multipletabs;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleTabsExample_1 {

	public static void main(String[] args) throws InterruptedException {
//		What It Means
//		When you click a link or perform some action, sometimes a new browser window or tab opens.
//		Selenium, by default, stays on the original window until you explicitly switch to the new one.

//		 Important Methods:
//		| Method                      | Purpose                                                |
//		| --------------------------- | ------------------------------------------------------ |
//		| `getWindowHandle()`         | Returns the **ID** of the current window.              |
//		| `getWindowHandles()`        | Returns a **Set** of all open window IDs.              |
//		| `switchTo().window(handle)` | Switches Selenium’s control to a different window/tab. |
//		| `close()`                   | Closes the current window.                             |
//		| `quit()`                    | Closes all windows.                                    |

		WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        
        driver.manage().window().maximize();

        // Implicit Wait → applied globally for all findElement calls
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Store current window ID
        String mainWindow = driver.getWindowHandle();

        // Click button to open new tab
        driver.findElement(By.id("tabButton")).click();
        
        // Wait for new tab to open (visual delay)
        Thread.sleep(2000);

        // Get all window IDs
        Set<String> allWindows = driver.getWindowHandles();

        // Loop through and switch to the new one
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("New Tab Text: " + driver.findElement(By.id("sampleHeading")).getText());
                
                Thread.sleep(3000); // Visual delay to see the new tab content
                driver.close(); // Close new tab
            }
        }

        // Switch back to main window
        driver.switchTo().window(mainWindow);
        
        Thread.sleep(2000); // Visual delay before quit
        driver.quit();

	        
//	        Diagram – Flow of Switching Tabs:
	        
//	        		[ Main Window ] → Click → [ New Tab ]
//	        	     	 ↑                         	↓
//	        	 Switch back ← Close new tab ← Switch control


	}

}
