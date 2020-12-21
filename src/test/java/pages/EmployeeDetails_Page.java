package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeoutException;

import base.DriverWait;
import base.Logs;
import utilities.ExcelRead;


public class EmployeeDetails_Page {
		WebDriver driver;
		Logs log;
		DriverWait driverWait;

		By btnEmpdetails = By.linkText("Employee Details");
		By btnEdit = By.xpath("//tbody/tr[2]/td[4]/a[1]/img[1]");
		By txtEmail = By.xpath("//tbody/tr[3]/td[4]/input[1]");
		By btnUpdateEmpdetails = By.xpath("//tbody/tr[8]/td[1]/input[1]");
		By btnLogout = By.xpath("//a[contains(text(),'Logout')]");
		


		public  EmployeeDetails_Page(WebDriver driver) throws TimeoutException{
			this.driver=driver;
			driverWait=new DriverWait(driver);
			log=new Logs(driver);
		}
		
		//clicking on employee details
		public void clickOnEmployeeDetails()        
			{
				WebElement empdetails=driverWait.clickable(btnEmpdetails,40);     
				empdetails.click();
			
				System.out.println("Employee Details is clicked");
				log.update("******Employee Details is clicked******");
			}
		
		//clicking on edit employee details
		public void clickonEdit() {
		WebElement edit =driverWait.clickable(btnEdit,40);     
		edit.click();
	
		System.out.println("Edit button is clicked");
		log.update("******Edit button is clicked******");
		}
		
		// edit new email id 
		public void editEmailId(String mail) {
			WebElement email=driverWait.visibility(txtEmail,20);   
			email.clear();
			email.sendKeys("abc@gmail.com");
			
			System.out.println("Email Id is edited");
			log.update("******Email Id is edited******");
			
		}
		
		//clicking on update employee details button
		public void clickonUpdateEmp() {
			WebElement updateEmp=driverWait.clickable(btnUpdateEmpdetails,40);     
			updateEmp.click();
		
			System.out.println("Employee Details(Email) is updated");
			log.update("******Employee Details(Email) is updated******");
			}
		
		//clicking on logout button
		public void clickonLogout() {
			WebElement logout=driverWait.clickable(btnLogout,40);     
			logout.click();
		
			System.out.println("logout sucessful");
			log.update("******logout sucessful******");
			}

		
		}
		