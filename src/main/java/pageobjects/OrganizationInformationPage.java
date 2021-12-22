package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[text()='Organization Name']/following-sibling::td/descendant::span[text()]")
	private WebElement organizationInfoText;
	
	@FindBy(xpath = "//td[text()='Website']/following-sibling::td/descendant::input[@id='txtbox_Website']")
	private WebElement websiteInfoText;
	
	@FindBy(xpath="//td[text()='Phone']/following-sibling::td/descendant::input[@id='txtbox_Phone']")
	private WebElement phoneInfoText;
	
	@FindBy(xpath="//td[text()='Employees']/following-sibling::td/descendant::input[@id='txtbox_Employees']")
	private WebElement employees;

	public WebElement getOrganizationInfoText() {
		return organizationInfoText;
	}

	public WebElement getWebsiteInfoText() {
		return websiteInfoText;
	}

	public WebElement getPhoneInfoText() {
		return phoneInfoText;
	}

	public WebElement getEmployees() {
		return employees;
	}
	
	
}
