package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginRepository {

	WebDriver wd;
	public LoginRepository(WebDriver wd) {
		this.wd=wd;
	}
//	repository of webelement
	By user=By.id("user-name");
	By pass=By.id("password");
	By lgn=By.id("login-button");
	
//	repository of methods
	public void User(String un) {
		wd.findElement(user).clear();
		wd.findElement(user).sendKeys(un);;
	}
	public void Pass(String pw) {
		wd.findElement(pass).clear();
		wd.findElement(pass).sendKeys(pw);;
	}
	public void Login() {
		wd.findElement(lgn).click();
	}
}
