package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups={"DataDriven"})
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();

		/*Data is valid - login success - test pass - logout
		  					login failed - test fail

		Data is invalid - login success - test fail - logout
		  				  login failed - test pass
		 */

		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();

		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage == true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}			
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage == true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	}
}
