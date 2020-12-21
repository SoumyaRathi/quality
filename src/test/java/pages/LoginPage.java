package pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverWait;
import base.Logs;
import utilities.ExcelRead;


public class LoginPage {
	WebDriver driver;
	ExcelRead excel=new ExcelRead();
	DriverWait driverWait;
	Logs log;

	String[][] test1=new String[1][1];
	
	By txtUserName=By.id("username");
	By txtPassword=By.xpath("//td[text()='Log In']//following::input[2]");
	By btnLogin=By.xpath("//td[text()='Log In']//following::input[3]");
	
public LoginPage(WebDriver driver) throws TimeoutException
	{
		this.driver=driver;
		driverWait=new DriverWait(driver);
		log=new Logs(driver);
	}
	
//Entering username
public void setUserName()        
	{
			test1=excel.read();
			String userName1=test1[0][1];
			
			WebElement username=driverWait.visibility(txtUserName,20);         
			username.sendKeys(userName1);
			
			System.out.println("UserName is entered");
			log.update("******UserName is entered*****");
	}
//Entering password
public void setPassword()        
	{
			test1=excel.read();
			String password1=test1[0][1];
			
			WebElement pswrd=driverWait.visibility(txtPassword,20);         
			pswrd.sendKeys(password1);
			
			System.out.println("Password is entered");
			log.update("******Password is entered*****");
	}
//Clicking on login button
public void clickOnLoginButton()        
	{
			WebElement loginbtn=driverWait.visibility(btnLogin,20);         
			loginbtn.click();
			
			System.out.println("Login button is clicked");
			log.update("******Login button is clicked*****");
	}
}
