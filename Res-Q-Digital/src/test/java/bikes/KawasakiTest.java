package bikes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class KawasakiTest {
	@Test
	public void launch() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kawasaki-india.com/");
		Reporter.log("Kawasaki bike launched", true);
	}

}
