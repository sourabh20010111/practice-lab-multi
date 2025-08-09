package selenium2.locators;

public class DifferentTypesOfLocators_1 {
		
//		There are 8 main types of locators you can use in Selenium WebDriver: 
		
//		1. ID
//		Description: Finds element by the HTML id attribute.
//		When to use: When the element has a unique id.
		
//		2. Name
//		Description: Finds element by the HTML name attribute.
//		When to use: When id is not available but name is unique.
		
//		3. Class Name
//		Description: Finds element by the HTML class attribute.
//		When to use: When the class is unique or specific enough.
		
//		4. Tag Name
//		Description: Finds element by the HTML tag name.
//		When to use: Rarely used alone; useful for getting lists of elements.
		
//		5. Link Text
//		Description: Finds anchor (<a>) elements by exact link text.
	
//		6. Partial Link Text
//		Description: Finds link by partial match of the link text.
	
//	| Feature                 | `linkText`              | `partialLinkText`                    |
//	| ----------------------- | ----------------------- | ------------------------------------ |
//	| Match Type              | Exact match             | Contains match                       |
//	| Case Sensitivity        | Yes                     | Yes                                  |
//	| Works On `<a>` Tag Only | ✅                      | ✅                                    |
//	| Speed                   | Slightly faster (exact) | Slightly slower (searches substring) |

//	When to use:
//  Use linkText when you know the full link text exactly.
//	Use partialLinkText when the link text is too long or dynamic.

//		7. CSS Selector
//		Description: Finds element using CSS rules (id, class, attribute, etc.).
//		Power: Very fast and flexible.
	
//		8. XPath
//		Description: Finds element using XML path syntax.
//		Power: Can locate elements even without id/name, supports complex queries.
		
//		| Locator Type      | Syntax Example                        |
//		| ----------------- | ------------------------------------- |
//		| `id`              | `By.id("username")`                   |
//		| `name`            | `By.name("password")`                 |
//		| `className`       | `By.className("login-btn")`           |
//		| `tagName`         | `By.tagName("a")`                     |
//		| `linkText`        | `By.linkText("Register Now")`         |
//		| `partialLinkText` | `By.partialLinkText("Register")`      |
//		| `cssSelector`     | `By.cssSelector("#username")`         |
//		| `xpath`           | `By.xpath("//input[@id='username']")` |

}
