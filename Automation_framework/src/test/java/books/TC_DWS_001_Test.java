package books;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import objectrepository.HomePage;

public class TC_DWS_001_Test extends BaseClass {
	@Test
	public void ClickOnBooks() {
		test=ereport.createTest("clickOnBooks");
		HomePage hp=new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Books","Book Page is not displayed");
		test.log(Status.PASS, "Book page is displayed");
		
	}

}
