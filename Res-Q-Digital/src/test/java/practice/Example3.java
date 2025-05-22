package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example3 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("file:///C:/Users/Shaukat%20Ali/Desktop/Car1M.html");
		
		WebElement car = driver.findElement(By.id("cars"));
		Select carSel=new Select(car);
		carSel.selectByValue("a");
		carSel.selectByIndex(3);
		carSel.selectByIndex(1);
		carSel.selectByIndex(2);
		//boolean firstSel = carSel.isMultiple();
		//System.out.println(firstSel.getText());
		//for(WebElement ele:firstSel) {
		//	System.out.println(ele.getText());
		System.out.println(carSel.isMultiple());
		
		}
		
	}

