package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Base;

public class LoginTest {
	//Webbase.driver base.driver;
	//global variable
	Base base;
	public LoginTest(Base base) {
		this.base=base;
	}
	
	@Given("I will launch browser")
	public void i_will_launch_browser() {
	   WebDriverManager.chromedriver().setup();
	   base.driver=new ChromeDriver();
	   base.driver.manage().window().maximize();
	   base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("Enter the url")
	public void enter_the_url() {
	    base.driver.get("http://localhost:8888");
	}

	@When("Login page is displayed and I will enter username and password")
	public void login_page_is_displayed_and_i_will_enter_username_and_password() {
//	    base.driver.findElement(By.name("user_name")).sendKeys("admin");
//	    base.driver.findElement(By.name("user_password")).sendKeys("manager");
		base.pageManager.initLoginPage(base.driver).login("admin", "manager");
	    
	}

	@When("click on login button")
	public void click_on_login_button() {
	   base.pageManager.initLoginPage(base.driver).clickOnLoginButton();
	}

	@Then("I will verify it will navigating to home page or not")
	public void i_will_verify_it_will_navigating_to_home_page_or_not() {
	  String title=base.driver.getTitle();
	  System.out.println(title);
	}
	
	@Given("I will launch {string} browser")
	public void i_will_launch_browser(String browser) {
	   if(browser.equals("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   base.driver=new ChromeDriver();
	   }
	   else if(browser.equals("firefox")) {
		   WebDriverManager.firefoxdriver().setup();
		   base.driver=new FirefoxDriver();
	   }else {
		   System.out.println("Invalid browser input: "+browser);
	   }
	}
	@Given("Enter the url {string}")
	public void enter_the_url(String url) {
	    base.driver.get(url);
	}
	@When("Login page is displayed enter the username {string} and password {string}")
	public void login_page_is_displayed_enter_the_username_and_password(String username, String password) {
//		 base.driver.findElement(By.name("user_name")).sendKeys(username);
//		    base.driver.findElement(By.name("user_password")).sendKeys(password);
		base.pageManager.initLoginPage(base.driver).login("admin", "manager"); 
	}
	@When("click on login")
	public void click_on_login() {
		//base.driver.findElement(By.id("submitButton")).click();
		base.pageManager.initLoginPage(base.driver).clickOnLoginButton();
	}
	@Then("Verify the title {string}")
	public void verify_the_title(String expectedTitle) {
	    Assert.assertEquals(base.driver.getTitle(), expectedTitle);
	    
	}
	
	@When("login page is displayed enter username {string} and password {string}")
	public void login_page_is_displayed_enter_username_and_password(String username, String password) {
		 base.driver.findElement(By.name("user_name")).sendKeys(username);
		    base.driver.findElement(By.name("user_password")).sendKeys(password);
	}
	@Then("verify the error message {string}")
	public void verify_the_error_message(String errormessage) {
	    String errorMsg=base.driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	    Assert.assertEquals(errorMsg, errormessage,"Login page error message not matching");
	    base.driver.close();
	}
	
	@When("Home page is displayed click on organization link")
	public void home_page_is_displayed_click_on_organization_link() {
	   //base.driver.findElement(By.linkText("Organizations")).click();
		base.pageManager.initHomePage(base.driver).clickOnOrganizationLink();
		}
	@When("click on create new organization")
	public void click_on_create_new_organization() {
	   // base.driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		base.pageManager.initOrganizationPage(base.driver).clickOnCreateNewOrganizationImage();
	}
	@When("enter the organization name {string} and click on save button")
	public void enter_the_organization_name_and_click_on_save_button(String orgName) {
		int randomNum=new Random().nextInt(1000);
    //base.driver.findElement(By.name("accountname")).sendKeys(orgName+randomNum);
//	    base.driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		base.pageManager.initCreateOrganizationPage(base.driver).enterEmployees(orgName+randomNum);
		base.pageManager.initCreateOrganizationPage(base.driver).clickOnSaveButton();
	}
	@Then("verify organization {string} created or not")
	public void verify_organization_created_or_not(String orgName) throws Throwable {
		Thread.sleep(1000);
	 String actualOrgName=  base.pageManager.initOrganizationInfoPage(base.driver).getOrganizationInfoText().getText();
		//String actualOrgName=base.driver.findElement(By.xpath("//td[text()='Organization Name']/following-sibling::td/descendant::span[text()]")).getText();
	   Assert.assertTrue(actualOrgName.contains(orgName));
	  
	}

	String orgName;
	String phone;
	String website;
	String employee;
	@When("Enter organization name, phone, website and employees")
	public void enter_organization_name_phone_website_and_employees(io.cucumber.datatable.DataTable dataTable) {
	   List<Map<String, Object>> data = dataTable.asMaps(String.class, Object.class);
	   int randomNum=new Random().nextInt(1000);
	   orgName=(String) data.get(0).get("organization name")+randomNum;
	    phone=(String) data.get(0).get("phone");
	    website=(String)data.get(0).get("website");
	    employee=(String)data.get(0).get("employees");
//		base.driver.findElement(By.name("accountname")).sendKeys(orgName);
//		base.driver.findElement(By.name("website")).sendKeys(website);
//		base.driver.findElement(By.id("phone")).sendKeys(phone);
//		base.driver.findElement(By.id("employees")).sendKeys(employee);
	    base.pageManager.initCreateOrganizationPage(base.driver)
	    .enterOrganizationName(orgName)
	    .enterWebsite(website)
	    .enterPhoneNumber(phone)
	    .enterEmployees(employee);
	}
	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		 base.pageManager.initCreateOrganizationPage(base.driver).clickOnSaveButton(); 
		 Thread.sleep(3000);
	}
	@Then("verify the organization Name, phone, website and employees")
	public void verify_the_organization_name_phone_website_and_employees() {
		//String actualOrgName=base.driver.findElement(By.xpath("//td[text()='Organization Name']/following-sibling::td/descendant::span[text()]")).getText();
		 String actualOrgName=  base.pageManager.initOrganizationInfoPage(base.driver).getOrganizationInfoText().getText();
		Assert.assertTrue(actualOrgName.contains(orgName));
//		String website=base.driver.findElement(By.xpath("//td[text()='Website']/following-sibling::td/descendant::input[@id='txtbox_Website']")).getText();
//		String phone=base.driver.findElement(By.xpath("//td[text()='Phone']/following-sibling::td/descendant::input[@id='txtbox_Phone']")).getText();
//		String employees=base.driver.findElement(By.xpath("//td[text()='Employees']/following-sibling::td/descendant::input[@id='txtbox_Employees']")).getText();
		String website=base.pageManager.initOrganizationInfoPage(base.driver).getWebsiteInfoText().getText();
		String phone=base.pageManager.initOrganizationInfoPage(base.driver).getPhoneInfoText().getText();
		String employees=base.pageManager.initOrganizationInfoPage(base.driver).getEmployees().getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(this.website.contains(website));
		softAssert.assertTrue(this.phone.contains(phone));
		softAssert.assertTrue(this.employee.contains(employees));
		base.driver.close();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
