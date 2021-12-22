package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	//p.enterorg().enterphone().enterEmp().enterWebsite()
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name="website")
	private WebElement websiteTextField;
	
	@FindBy(name="phone")
	private WebElement phoneTextField;
	
	@FindBy(name="employees")
	private WebElement employeesTextField;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getEmployeesTextField() {
		return employeesTextField;
	}
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public CreateOrganizationPage enterOrganizationName(String orgName) {
		organizationNameTextField.sendKeys(orgName);
		return this;
	}
	
	public CreateOrganizationPage enterWebsite(String website) {
		websiteTextField.sendKeys(website);
		return this;
	}
	
	public CreateOrganizationPage enterPhoneNumber(String phoneNumber) {
		phoneTextField.sendKeys(phoneNumber);
		return this;
	}
	
	public CreateOrganizationPage enterEmployees(String employees) {
		employeesTextField.sendKeys(employees);
		return this;
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

}
