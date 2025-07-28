package seleniumprc;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo2 {
	static WebDriver wd;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("enter the choice");
		 int ch  = sc.nextInt();
		 
		 switch(ch) {
		 case 1:
			 wd = new ChromeDriver();
			 break;
		 case 2:
			 wd = new EdgeDriver();
		default :
			System.out.println("enter valid choice");
		 }
		 if(wd != null) {
			 wd.get("https://www.selenium.dev/downloads/");
		 }
		 sc.close();
	}

}
