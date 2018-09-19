package DataDriven;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Provider {
	WebDriver driver;
	
  @Test(dataProvider="testdata")
  public void datapp(String username,String password) {
	  System.setProperty("webdriver.chrome.driver","D:\\All Testing\\Browser files\\ChromeDriver\\chromedriver.exe");
       driver=new ChromeDriver();
      driver.manage().window().maximize();
       driver.navigate().to("http://facebook.com");
       driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
       driver.findElement(By.id("email")).sendKeys(username);
       driver.findElement(By.id("pass")).sendKeys(password);
       driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
       System.out.println(driver.getTitle());
         
  }
  @AfterMethod()
	  public void close(){
	  driver.quit();
  }
  @DataProvider(name="testdata")
	  public Object[][] passdata()
	  {
		  Object[][] data=new Object[3][2];
		  data[0][0]="umasai20@gmail.com";
		  data[0][1]="saisrinivas";
		  data[1][0]="umasai20@gmail.om";
		  data[1][1]="saisriniva";
		  data[2][0]="umasai20@gmail.cm";
		  data[2][1]="saisrinias";
		  return data;
	  }
  }

