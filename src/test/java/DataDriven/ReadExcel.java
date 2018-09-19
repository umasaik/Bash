package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
	public static void main(String[] args) throws BiffException, IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\All Testing\\Browser files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://facebook.com");
		File src=new File("F:\\Saisrinivas\\LearnAutomationDataDriven\\src\\main\\java\\DataExcel\\login.xls");
		FileInputStream fis=new FileInputStream(src);
		Workbook w=Workbook.getWorkbook(fis);
		Sheet s=w.getSheet(0);
		int rows=s.getRows();
		System.out.println(rows);
		int columns=s.getColumns();
		System.out.println(columns);
		for(int i=0;i<rows;i++)
		{
			String username=s.getCell(0,i).getContents();
			driver.findElement(By.id("email")).sendKeys(username);
			String password=s.getCell(1,i).getContents();
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
		
		}
		
	}

}
