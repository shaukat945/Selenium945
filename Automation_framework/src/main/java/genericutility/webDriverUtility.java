package genericutility;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class webDriverUtility {
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void clickAndHold(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void getPhoto(WebDriver driver,String screenShotName) throws IOException {
		JavaUtility jvu=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+jvu.getSystemTime()+".png");
		org.openqa.selenium.io.FileHandler.copy(temp, dest);
		
	}	
	public void handlePopAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	public String handlePopAndCaptureTheText(WebDriver driver) {
		Alert popup = driver.switchTo().alert();
		String message = popup.getText();
		popup.accept();
		return message;
	}
	public void handlePopupAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void selectDropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	public void selectDropdown(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void selectDropdownByText(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	
	

}
