package selenium9.miscellaneous.scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollingExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down vertically by 500 pixels
        js.executeScript("window.scrollBy(0,500);");
        Thread.sleep(2000);

        // Scroll up vertically by 300 pixels
        js.executeScript("window.scrollBy(0,-300);");
        Thread.sleep(2000);

        // Scroll element into view
        WebElement element = driver.findElement(By.id("cars"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

        driver.quit();
        
//        Other scroll methods you can use with JSExecutor:
//        1.Scroll to specific position on page:
//        js.executeScript("window.scrollTo(0, 1000);");  // Scroll to 1000 pixels from top

//        2.Scroll to bottom of page:
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
//        3.Scroll an element into view (align to top or bottom):
//        js.executeScript("arguments[0].scrollIntoView(true);", element);  // Align top of element to view
//        js.executeScript("arguments[0].scrollIntoView(false);", element); // Align bottom of element to view

//        4.Smooth scrolling (if supported):
//        js.executeScript("window.scrollBy({ top: 500, behavior: 'smooth' });");
        
//      Summary:
//    	scrollBy(x, y) and scrollTo(x, y) work with pixel values.
//    	scrollIntoView() scrolls the element fully into view (no pixel count needed).
//    	You can combine smooth behavior with scrolling if browser supports it.
	}

}
