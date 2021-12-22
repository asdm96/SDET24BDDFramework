package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * 
 * @author Adarsh M
 *
 */
public class WebdriverUtility {

	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void openNewTab(WebDriver driver, WindowType windowType) {
		driver.switchTo().newWindow(windowType);
	}
	
	public void takeScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(source, destination);
	}
	
	public void dropdown(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void dropdown(WebElement element, String visibleText) {
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void scrollIntoView(WebDriver driver, WebElement element) {
		int y=element.getLocation().getY();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	public void dragAndDrop(WebDriver driver,WebElement source, WebElement target) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
