package utilManager;

import org.openqa.selenium.WebDriver;

import pageobjects.CreateOrganizationPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.OrganizationInformationPage;
import pageobjects.OrganizationPage;

public class PagefactoryManager {
	private LoginPage loginPage;
	private HomePage homePage;
	private OrganizationPage organizationPage;
	private CreateOrganizationPage createOrgPage;
	private OrganizationInformationPage orgInfoPage;
	
	
	public LoginPage initLoginPage(WebDriver driver) {
		return (loginPage==null)?new LoginPage(driver):loginPage;
	}
	
	public HomePage initHomePage(WebDriver driver) {
		return (homePage==null)?new HomePage(driver):homePage;
	}
	
	public OrganizationPage initOrganizationPage(WebDriver driver) {
		return (organizationPage==null)?new OrganizationPage(driver):organizationPage;
	}
	
	public CreateOrganizationPage initCreateOrganizationPage(WebDriver driver) {
		return (createOrgPage==null)?new CreateOrganizationPage(driver):createOrgPage;
	}
	
	
	public OrganizationInformationPage initOrganizationInfoPage(WebDriver driver) {
		return (orgInfoPage==null)?new OrganizationInformationPage(driver):orgInfoPage;
	}
	

}
