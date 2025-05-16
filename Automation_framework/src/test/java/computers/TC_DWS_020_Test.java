package computers;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import objectrepository.HomePage;

public class TC_DWS_020_Test extends BaseClass {
	@Test
	public void clickOnComputers() {
		test=ereport.createTest("clickOnBooks");//test case name
		HomePage hp=new HomePage(driver);
		hp.getComputersLink().click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Computers","Computers page is not displayed");
		test.log(Status.PASS,"Computers page is displayed");
	}

}
