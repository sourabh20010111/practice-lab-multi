package selenium3.webelements.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormAutomation {
	 public static void main(String[] args) throws InterruptedException {
		 
	        WebDriver driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        
	        // 1. Open the registration form
	        driver.get("https://demo.automationtesting.in/Register.html");
	        Thread.sleep(2000);

	        // 2. Fill in First Name and Last Name
	        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
	        firstName.clear();
	        firstName.sendKeys("John");

	        WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
	        lastName.clear();
	        lastName.sendKeys("Doe");

	        // 3. Fill Email
	        WebElement email = driver.findElement(By.cssSelector("input[type='email']"));
	        email.sendKeys("john.doe@example.com");

	        // 4. Phone Number
	        WebElement phone = driver.findElement(By.cssSelector("input[type='tel']"));
	        phone.sendKeys("1234567890");

	        // 5. Gender radio button (Male)
	        WebElement maleRadio = driver.findElement(By.cssSelector("input[value='Male']"));
	        System.out.println("Male selected before click: " + maleRadio.isSelected());
	        maleRadio.click();
	        System.out.println("Male selected after click: " + maleRadio.isSelected());

	        // 6. Hobbies checkbox (Cricket)
	        WebElement cricketCheckbox = driver.findElement(By.cssSelector("input[value='Cricket']"));
	        cricketCheckbox.click();
	        System.out.println("Cricket selected: " + cricketCheckbox.isSelected());

	        // 7. Skills dropdown
	        Select skills = new Select(driver.findElement(By.cssSelector("#Skills")));
	        skills.selectByVisibleText("Java");
	        Thread.sleep(1000);

	        // 8. Get the page heading using getText()
	        WebElement heading = driver.findElement(By.cssSelector(".navbar-inverse"));
	        System.out.println("Heading Text: " + heading.getText());

	        // 9. Check and print if submit button is enabled (it should be disabled initially)
	        WebElement submitButton = driver.findElement(By.id("submitbtn"));
	        System.out.println("Submit enabled: " + submitButton.isEnabled());

	        driver.quit();
	 }

}
