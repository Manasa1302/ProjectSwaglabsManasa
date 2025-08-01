package producttest;

import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;

import genericlibrary.BaseConfig;
import pagerepository.CartPage;
import pagerepository.CheckoutOverviewPage;
import pagerepository.CheckoutPage;
import pagerepository.HomePage;
@Listeners(listenerlibrary.ListenersImplementation.class)
public class Example1Test extends BaseConfig {

	@Test(groups="RT", priority = 1, enabled = true, invocationCount = 1, dataProvider = "CheckoutInfo")
	public void orderProducts(String FirstName, String LastName, String ZipCode) {
		
		//Create the Test Information
		
				 test = report.createTest("Regressiontest");
				
				//Steps Information
				
				test.log(Status.INFO, "Step1: Launching The Browser Successfully");
				
				test.log(Status.INFO, "Step2: Navigating to the application via URL Successful");
				
				test.log(Status.PASS, "Step3: VERIFIED the Webpage Successful");
				
				
				
		
		Reporter.log(FirstName);
		Reporter.log(LastName);
		Reporter.log(ZipCode);

		// Wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Verify Home Page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		// Create an object for Home page
		HomePage hpobj = new HomePage(driver);

		// Use the WebElement from POM class

		// Click on the fourth product
		hpobj.getfourthproduct().click();
		
		
		// Verify Add To Cart button is Displayed & is Enabled
		Assert.assertTrue(hpobj.getaddtocartbtn().isDisplayed() && hpobj.getaddtocartbtn().isEnabled());
		
		if(hpobj.getfourthproduct().isDisplayed())
		{
			test.log(Status.PASS, "Step4: Verified the WebElements Displayed");
		}
		else
		{
			test.log(Status.PASS, "Step4: Verified the WebElements  not Displayed");
		}
		// Click on Add To Cart button
		hpobj.getaddtocartbtn().click();
		// Verify Back To Products link is Displayed & is Enabled
		Assert.assertTrue(hpobj.getbacktoproducts().isDisplayed() && hpobj.getbacktoproducts().isEnabled());
		// Click on Back To Products
		hpobj.getbacktoproducts().click();

		// Click on the Third product
		hpobj.getthirdproduct().click();
		// Verify Add To Cart button is Displayed & is Enabled
		Assert.assertTrue(hpobj.getaddtocartbtn1().isDisplayed() && hpobj.getaddtocartbtn1().isEnabled());
		// Click on Add To Cart button
		hpobj.getaddtocartbtn1().click();
		// Verify Back To Products link is Displayed & is Enabled
		Assert.assertTrue(hpobj.getbacktoproducts1().isDisplayed() && hpobj.getbacktoproducts1().isEnabled());
		// Click on Back To Products
		hpobj.getbacktoproducts1().click();

		// Click on the Second product
		hpobj.getsecondproduct().click();
		// Verify Add To Cart button is Displayed & is Enabled
		Assert.assertTrue(hpobj.getaddtocartbtn2().isDisplayed() && hpobj.getaddtocartbtn2().isEnabled());
		// Click on Add To Cart button
		hpobj.getaddtocartbtn2().click();
		// Verify Back To Products link is Displayed & is Enabled
		Assert.assertTrue(hpobj.getbacktoproducts2().isDisplayed() && hpobj.getbacktoproducts2().isEnabled());
		// Click on Back To Products
		hpobj.getbacktoproducts2().click();

		// Verify Cart Icon is Displayed & is Enabled
		Assert.assertTrue(hpobj.getcarticon().isDisplayed() && hpobj.getcarticon().isEnabled());
		// Click on Cart Icon
		hpobj.getcarticon().click();

		// Verify Cart Page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		// Create an object for Cart page
		CartPage cpobj = new CartPage(driver);

		// Use the webElement from POM class

		// Verify Checkout button is Displayed & is Enabled
		Assert.assertTrue(cpobj.getcheckoutbtn().isDisplayed() && cpobj.getcheckoutbtn().isEnabled());
		// Click on the CheckOut button
		cpobj.getcheckoutbtn().click();

		// Verify Checkout Page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		// Create an object for CheckOut page
		CheckoutPage chkobj = new CheckoutPage(driver);

		// Verify First Name text field is Displayed & Is Enabled
		Assert.assertTrue(chkobj.getfirstname().isDisplayed() && chkobj.getfirstname().isEnabled());
		// Enter the First Name
		chkobj.getfirstname().sendKeys(FirstName);
		// Verify Last Name text field is Displayed & Is Enabled
		Assert.assertTrue(chkobj.getlastname().isDisplayed() && chkobj.getlastname().isEnabled());
		// Enter Last Name
		chkobj.getlastname().sendKeys(LastName);
		// Verify Zipcode text field is Displayed & Is Enabled
		Assert.assertTrue(chkobj.getzipcode().isDisplayed() && chkobj.getzipcode().isEnabled());
		// Enter Zipcode
		chkobj.getzipcode().sendKeys(ZipCode);
		// Verify Continue button is Displayed &is Enabled
		Assert.assertTrue(chkobj.getcontinuebtn().isDisplayed() && chkobj.getcontinuebtn().isEnabled());
		// Click on Continue button
		chkobj.getcontinuebtn().click();

		// Verify Checkout Complete Page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		// Create an object for CheckOut-Overview page
		CheckoutOverviewPage ckovobj = new CheckoutOverviewPage(driver);

		// Verify Finish button is Displayed &is Enabled
		Assert.assertTrue(ckovobj.getfinishbtn().isDisplayed() && ckovobj.getfinishbtn().isEnabled());

		// Click on Finish button
		ckovobj.getfinishbtn().click();
		
//		 Assert.fail();

	}
	@Test
	public void Addproduct2() {
		// create the test information

		test = report.createTest("RegressionTest");

		// steps information
		test.log(Status.INFO, "Step1:Launching The Browser Succesfully");

	}
	@Test
	public void Addproduct3() {
		// create the test information

		test = report.createTest("RegressionTest");

		// steps information
		test.log(Status.INFO, "Step1:Launching The Browser Succesfully");

	}

}