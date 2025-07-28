package frameworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import pom.LoginRepository;
import pom.LogoutRepository;

public class DataDrivenFramework {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver wd=new FirefoxDriver();
		wd.get("https://www.saucedemo.com/v1/");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileInputStream fis=new FileInputStream("C:\\Users\\saura\\Desktop\\data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("data");
		
		for(int i=1;i<=sh.getLastRowNum();i++) {
			XSSFRow rw=sh.getRow(i);
			XSSFCell un=rw.getCell(0);
			XSSFCell pw=rw.getCell(1);
			XSSFCell res=rw.createCell(2);
			System.out.println(un+" "+pw);
			
			LoginRepository lgn=new LoginRepository(wd);
			lgn.User(un.toString());
			lgn.Pass(pw.toString());
			lgn.Login();
			res.setCellValue("Pass");
			
			
			try {
				LogoutRepository lout=new LogoutRepository(wd);
				lout.Menu();
				lout.Logout();
			}
			catch(Exception e){
				TakesScreenshot ts=(TakesScreenshot)wd;
				FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),new File("./"+un+"_"+pw+".png"));
				System.out.println("invalid data");
				res.setCellValue("Fail");
			}
			
			}
		
		
//		wb.close();
		fis.close();
		FileOutputStream fos=new FileOutputStream("C:\\Users\\saura\\Desktop\\data.xlsx");
		wb.write(fos);
		
		wd.quit();
	}

}
