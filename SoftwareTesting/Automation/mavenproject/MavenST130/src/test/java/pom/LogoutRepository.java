package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutRepository {
WebDriver wd;

public LogoutRepository(WebDriver wd){
	this.wd=wd;
}

By menu=By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button");
By logout=By.linkText("Logout");

public void Menu() {
	wd.findElement(menu).click();
}
public void Logout() {
	wd.findElement(logout).click();
}
}
