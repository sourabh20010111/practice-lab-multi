package selenium7.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample_1 {

	public static void main(String[] args) throws InterruptedException {
//		Steps in Selenium:
//			1️ Start → In Main Page (driver by default here)
//			2️ Switch to frame → driver.switchTo().frame("frame1")
//			3️ Work inside frame → Click button / Get text
//			4️ Go back → driver.switchTo().defaultContent()

		WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        // Switch to frame by ID
        driver.switchTo().frame("frame1");

        // Get text inside frame
        String frameText = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Text inside frame: " + frameText);

        // Back to main page
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.quit();
        
//        What is a Frame?
//        A frame is like a separate webpage embedded inside another webpage.
//        If your element is inside a frame, Selenium cannot directly access it unless you first switch to that frame.
        
//        Switching to a Frame:-
//        Selenium provides three ways to switch:
//        1.By Index (0-based)
//        driver.switchTo().frame(0); // First frame
        
//        2.By Name or ID
//        driver.switchTo().frame("frameName");
        
//        3.By WebElement
//        WebElement frameElement = driver.findElement(By.id("frame1"));
//        driver.switchTo().frame(frameElement);

//        Switching Back:-
//        1.To main page
//        driver.switchTo().defaultContent();
        
//        2.To parent frame (one level up)
//        driver.switchTo().parentFrame();

//        In Web terms:
//        	A webpage can contain multiple HTML documents inside it using <iframe> tags.
//        	Selenium, by default, works on the main page only.
//        	If the element you want is inside a frame, Selenium will not find it until you switch to that frame.


//        In frames/iframes handling, Selenium doesn’t directly “jump” to elements inside them.
//        The first target is always the <iframe> (or <frame>) tag itself.

//        Steps:
//        1.Locate the frame element — using By.id, By.name, By.xpath, etc.
//        2.Switch Selenium’s focus to that frame.
//        3.Now interact with elements inside the frame as if it’s a new page.
//        4.Switch back to the main content when done.
        
//        #Why we need it:
//        Without switching back, Selenium will still be “inside” the frame.
//        If you try to interact with elements outside that frame (on the main page), it will throw NoSuchElementException.

	}

}
