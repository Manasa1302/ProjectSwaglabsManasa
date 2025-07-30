package genericlibrary;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import pagerepository.CheckoutCompletePage;
import pagerepository.LoginPage;

public class BaseConfig {
	public static WebDriver staticdriver; // for listeners implementation

	public WebDriver driver;
	public String url;
	public String username;
	public String password;
	public String FirstName;
	public String LastName;
	public String ZipCode;

	@Parameters("Browser")

	@BeforeClass
	public void browserSetup(String browsername) {

//		String browsername = "edge";

		// Open the Browser
		driver = WebDriverLibrary.openBrowser(browsername);
		staticdriver = driver;

		
		
		// Maximize the Browser
		WebDriverLibrary.maximizeBrowser();

		// Wait Statement
		WebDriverLibrary.WaitStatement();

		// Navigate to the application via URL
		WebDriverLibrary.navToApp(PropertiesLibrary.readData("url"));

		// Verify the page using Title
		Assert.assertEquals("Swag Labs", driver.getTitle());

		/*
		 * url = PropertiesLibrary.readData("url");
		 * 
		 * if (browsername.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); }
		 * else if (browsername.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
		 * else if (browsername.equalsIgnoreCase("firefox")) { driver = new
		 * FirefoxDriver(); } else { System.out.println("Invalid browser name"); }
		 * 
		 * // Maximize the Browser driver.manage().window().maximize();
		 * 
		 * // Wait Statement
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * 
		 * // Navigate to the application via URL driver.get(url);
		 */
		Reporter.log("Browser setup is done", true);

	}

	@BeforeMethod
	public void LogIn() {

		// Wait Statement
		WebDriverLibrary.WaitStatement();

		// Create an object for Login page
		LoginPage loginobj = new LoginPage(driver);

		// Validate the Username Text field
		Assert.assertTrue(loginobj.getusernametextfield().isDisplayed());

		// Perform Action
		// Enter Username in the Username Text field
		WebDriverLibrary.enterTheData(loginobj.getusernametextfield(), PropertiesLibrary.readData("username"));

		// Enter Password in the Password Text field
		WebDriverLibrary.enterTheData(loginobj.getpasswordtextfield(), PropertiesLibrary.readData("password"));

		// Validate the Login button
		Assert.assertTrue(loginobj.getloginbutton().isDisplayed());

		// Click on the Login button
		WebDriverLibrary.elementClick(loginobj.getloginbutton());

		/*
		 * username = PropertiesLibrary.readData("username"); password =
		 * PropertiesLibrary.readData("password");
		 * 
		 * firstname = ExcelLibrary.readsingledata("CheckoutInfo", 1, 0); lastname =
		 * ExcelLibrary.readsingledata("CheckoutInfo", 1, 1); zipcode =
		 * ExcelLibrary.readsingledata("CheckoutInfo", 1, 2);
		 * 
		 * // Verify Login page System.out.println("title is:" + driver.getTitle());
		 * 
		 * // Create an object for LoginPage LoginPage lpobj = new LoginPage(driver);
		 * 
		 * // Use the webElement from POM class
		 * 
		 * // Perform Login // Enter UserName in UserName Textfield
		 * lpobj.getusernametextfield().sendKeys(username);
		 * 
		 * // Enter UserName in UserName Textfield
		 * lpobj.getpasswordtextfield().sendKeys(password);
		 * 
		 * // Enter UserName in UserName Textfield lpobj.getloginbutton().click();
		 */
		Reporter.log("Login successfully", true);

	}

	@AfterMethod
	public void Logout() {

		// Wait Statement
		WebDriverLibrary.WaitStatement();

		// Create an object for logout page
		CheckoutCompletePage logutobj = new CheckoutCompletePage(driver);

		// Validate the logout menu
		Assert.assertTrue(logutobj.getmenubar().isDisplayed());

		// Click on the logout Menu
		WebDriverLibrary.elementClick(logutobj.getmenubar());

		// Validate the logout link
		// Assert.assertTrue(logutobj.getlogout().isDisplayed());

		// Click on the logout button
		WebDriverLibrary.elementClick(logutobj.getlogout());

		/*
		 * // Create an object for CheckoutCompletePage CheckoutCompletePage logoutobj =
		 * new CheckoutCompletePage(driver);
		 * 
		 * // Perform Action logoutobj.getmenubar().click();
		 * 
		 * logoutobj.getlogout().click();
		 */
		Reporter.log("Logout is done", true);

	}

	@AfterClass
	public void broserTerminate() {

		// Close the Browser
		WebDriverLibrary.closeAllWindows();

	}

	@DataProvider
	public Object[][] CheckoutInfo() {
		Object[][] data = new Object[1][3];

		data[0][0] = ExcelLibrary.readsingledata("CheckoutInfo", 1, 0);

		data[0][1] = ExcelLibrary.readsingledata("CheckoutInfo", 1, 1);

		data[0][2] = ExcelLibrary.readsingledata("CheckoutInfo", 1, 2);
		
		return data;


	}

}
	
		
	


