package selenium9.miscellaneous.fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/upload");  // Example test page
        
        Thread.sleep(2000);
        // Send file path to input element
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\saura\\Desktop\\hello.txt");
        
        Thread.sleep(2000);
        // Click the upload button
        driver.findElement(By.id("file-submit")).click();

        // Add your validations or assertions here

        Thread.sleep(2000);
        driver.quit();
        
//       # Important Notes:
//        	1.Make sure the file path is absolute and correct.
//        	2.This works only if the upload control is an <input type="file">.
//        	3.If file upload uses a custom button or drag-and-drop, it may require advanced handling or third-party tools.
	}

}
