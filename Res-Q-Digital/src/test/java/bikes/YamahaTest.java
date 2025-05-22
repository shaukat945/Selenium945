package bikes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class YamahaTest {
	@Test
	public void lunch() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.yamaha-motor-india.com/");
		Reporter.log("Yamaha launched", true);
	}

}
