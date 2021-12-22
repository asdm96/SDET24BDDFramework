package hook;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilManager.PagefactoryManager;
import utility.Base;
import utility.FileUtility;
import utility.WebdriverUtility;

public class Hook {
	//priority
//	@Before(order=0)
//	public void connectToDB() {
//		System.out.println("database connection");
//	}
//	
//	@Before(order=2)
//	public void login() {
//		System.out.println("perform login");
//	}
	Base base;
	public Hook(Base base) {
		this.base=base;
	}

	@Before//(order=1)
	public void initBrowser() throws Throwable {
		System.out.println("launch browser");
		String browserName=FileUtility.getPropertyValue("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		else {
			System.out.print("Invalid browser name: "+browserName);
		}
		base.webdriverUtility=new WebdriverUtility();
		base.pageManager=new PagefactoryManager();
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
//	@After(order=2)
//	public void logout() {
//		System.out.println("logout from app");
//	}

	@After//(order=1)
	public void closeBrowser(Scenario scenario) throws Throwable {
		if(scenario.isFailed()) {
			//take screenshot
			base.webdriverUtility.takeScreenshot(base.driver, scenario.getName());
		}
		System.out.println("close browser");
		base.driver.close();
	}
	
//	@After(order=0)
//	public void closeDB() {
//		System.out.println("close database connection");
//	}
	
	//perform login
	//launch browser
	//database connection
	
	/*
	 * close database connection
close browser
logout from app
	 */
}
