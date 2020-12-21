package stepdefinitions;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EmployeeDetails_Page;
import pages.LoginPage;
import utilities.ExcelRead;

import base.LaunchBrowser;
import base.Screenshot;


public class QualityPointTechTest extends ExcelRead{
	WebDriver driver;
	Screenshot sc;
	
	LoginPage login;
	EmployeeDetails_Page emp;
	
	
	
@Given("^Open chrome and start application$")
public void open_chrome_and_start_application() throws Throwable {
//	System.out.println("1"); 
    read();
	driver=LaunchBrowser.Launch_Browser("url");
	
	sc=new Screenshot(driver);
	
}

@When("Entering Username,Password and Click on Login button")
public void entering_Username_Password_and_Click_on_Login_button() throws Throwable {
	login=new LoginPage(driver);
	login.setUserName();
	login.setPassword();
	
    sc.getScreenshot(driver);
    login.clickOnLoginButton();

}


@Then("^user should be able to login$")
public void user_should_be_able_to_login() throws Throwable {
	login=new LoginPage(driver);
	
	Assert.assertEquals("http://qualitypointtech.net/timesheetdemo/report.php", driver.getCurrentUrl());
	
	System.out.println(driver.getCurrentUrl());
	System.out.println("login sucessfull"); 
	sc.getScreenshot(driver);

}

@When("^user clicks on Employee Details Button$")
public void user_clicks_on_Employee_Details_Button() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.clickOnEmployeeDetails();

	Assert.assertEquals("http://qualitypointtech.net/timesheetdemo/edit_employee.php", driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());
	System.out.println("edit emp details page is displayed"); 
	sc.getScreenshot(driver);
}
@And("^user clicks on edit option$")
public void user_clicks_on_edit_option() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.clickonEdit();
	
	System.out.println(" edit emp details page is displayed"); 
	sc.getScreenshot(driver);

}

@And("^user update mail id$")
public void user_update_mail_id() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.editEmailId(" ");
	emp.editEmailId("abc@gmail.com");

	sc.getScreenshot(driver);
	
}

@And("^user clicks on update employee details$")
public void user_clicks_on_update_employee_details() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.clickonUpdateEmp();
	System.out.println(" Employee Details updated Successfully"); 
	sc.getScreenshot(driver);

}

@And("^user clicks on logout$")
public void user_clicks_on_logout() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.clickonLogout();
	System.out.println(" logout successfully");
	sc.getScreenshot(driver);

}



@Then("^application should be closed$")
public void application_should_be_closed() throws Throwable {
	TimeUnit.SECONDS.sleep(5);
	driver.quit();
}


}
