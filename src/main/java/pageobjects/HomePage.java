package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}
	
	public void clickOnOrganizationLink() {
		organizationsLink.click();
	}
	
	public void clickOnContactLink() {
		contactsLink.click();
	}
	
}
