package selenium5.dropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoQASelectMenuExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();

        // --- 1. Standard single-select dropdown ---
        Select oldStyle = new Select(driver.findElement(By.id("oldSelectMenu")));
        oldStyle.selectByVisibleText("White");
        System.out.println("Single-select selected: " + oldStyle.getFirstSelectedOption().getText());

        Thread.sleep(1000);

        // --- 2. Multi-select dropdown ---
        Select multiSelect = new Select(driver.findElement(By.id("cars")));
        if (multiSelect.isMultiple()) {
            multiSelect.selectByVisibleText("Volvo");
            multiSelect.selectByVisibleText("Saab");
            System.out.println("Multi-select chosen: ");
            multiSelect.getAllSelectedOptions()
                       .forEach(opt -> System.out.println(" - " + opt.getText()));
        }
        
        Thread.sleep(1000);

        // --- 3. Custom dropdown (React select) ---
        WebElement reactDropdown = driver.findElement(By.cssSelector("#react-select-2-input"));
        reactDropdown.sendKeys("Green");
        reactDropdown.sendKeys(Keys.ENTER);
        System.out.println("React dropdown selected: Green");

        Thread.sleep(1000);

        driver.quit();
        
//        Dropdown Types on DemoQA Select Menu:-
        
//        1.Standard HTML <select> dropdowns:
//        Single-select: Select options like “Old Style Select Menu” 
//        (identified by <select id="oldSelectMenu">) — handled using Selenium’s Select class.

//        2.Multi-select: Dropdowns like “Multi-select drop down” (using <select multiple>). 
//        Also handled via Select.

//        3.Custom dropdowns:
//        Built using div, span, and li elements (not <select>), like the "Select value" and "Old style React menu". 
//        These require manual clicking, sendKeys, or JS/Actions strategy.
        
//        | Type of Dropdown                         | How to Handle                                                |
//        | ---------------------------------------- | ------------------------------------------------------------ |
//        | `<select>` HTML tag                      | Use `Select` class                                           |
//        | Custom UI dropdown (div, span, li, etc.) | Use `click()` + locator                                      |
//        | Multi-select dropdown                    | `Select` class methods like `selectByIndex()` multiple times |
        
//        What This Covers:
//        	1)Standard dropdown with Select.selectByVisibleText()
//        	2)Multi-select dropdown with isMultiple() and multiple selections with Select
//        	Custom React-style dropdown where Select cannot be used—handled with sendKeys() and Enter key

	}

}
