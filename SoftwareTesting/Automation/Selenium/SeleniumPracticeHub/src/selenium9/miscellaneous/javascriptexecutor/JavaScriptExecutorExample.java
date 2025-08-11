package selenium9.miscellaneous.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutorExample {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");

        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Example 1: Show alert popup using JS
        js.executeScript("alert('Hello from JavaScriptExecutor!');");

        // Wait a bit to see alert (optional)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Accept alert
        driver.switchTo().alert().accept();

        // Example 2: Get page title via JS and print it
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page title is: " + title);

        driver.quit();
        
//        What it does:
//        	Runs JavaScript code inside the browser.
//        	Shows an alert popup.
//        	Retrieves page title using JS.
//        	Handles alert popup.
	}

}
