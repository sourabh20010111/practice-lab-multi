package selenium0.browser.navigation.commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoOpenBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver wd=new FirefoxDriver();// We can open any browser in Selenium using its specific WebDriver implementation.
//		Each browser needs its own WebDriver.
//		Chrome → ChromeDriver
//		Firefox → FirefoxDriver
//		Edge → EdgeDriver
//		Safari → SafariDriver
//		These WebDriver classes act like “bridges” between Selenium and the actual browser.
//		You can’t use FirefoxDriver to open Chrome, or ChromeDriver to open Edge — each driver is specific to its browser.
		
		// Open URL
        wd.get("https://www.saucedemo.com/");
        Thread.sleep(2000); // Wait for page to load (just for demo)
        
		// Maximize Window
        wd.manage().window().maximize();
        Thread.sleep(1000);

        // Navigate to another URL
        wd.navigate().to("https://www.google.com/");
        Thread.sleep(2000);

        // Navigate Back
        wd.navigate().back();
        Thread.sleep(2000);

        // Navigate Forward
        wd.navigate().forward();
        Thread.sleep(2000);

        // Refresh Page
        wd.navigate().refresh();
        Thread.sleep(2000);

        // Close the current browser tab
        wd.close();

        // Quit the entire browser session
//        wd.quit();
        
//        In Selenium, you should call either close() or quit() at the end of your test, not both.
//        driver.close() → closes the current browser window where the driver is working.
//        driver.quit() → closes all browser windows and ends the WebDriver session.

//        If you call one, the session ends (in case of quit()) or that window closes (in case of close()), so calling the other afterward will throw:
//        NoSuchSessionException: Tried to run command without establishing a connection.

//        Tip:
//        Use close() if you opened multiple windows and just want to close one.
//        Use quit() at the end of the test to clean up everything.

	}

}
