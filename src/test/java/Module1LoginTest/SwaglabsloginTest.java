package Module1LoginTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Libraries.BaseClass;
import Libraries.UtilityClass;
import Module1LoginPagePOM.SwagLabsHomePage;
import Module1LoginPagePOM.SwagLabsLoginPage;
import Module1LoginPagePOM.SwagLabsMenu;

public class SwaglabsloginTest extends BaseClass{

	SwagLabsLoginPage login;
	SwagLabsHomePage home;
	SwagLabsMenu menu;
	int TCID;
	
	@BeforeClass
	public void OpenBrowser() throws IOException {
		
		initialiseBroswer();
		login=new SwagLabsLoginPage(driver);
		home=new SwagLabsHomePage(driver);
	    menu=new SwagLabsMenu(driver);
		
		
	}
	@BeforeMethod
	public void loginIntoApp() throws IOException, InterruptedException {
		
		login.inputUserID(UtilityClass.getPFdata("UN"));
		Thread.sleep(2000);
		login.inputPass(UtilityClass.getPFdata("PWD"));
		login.clickLoginBtn();
		Thread.sleep(2000);
		//login.validateErrorMsg(UtilityClass.getPFdata("ErrorMsg"));
	}
	@Test
	public void homePageLogo() throws EncryptedDocumentException, IOException, InterruptedException {
		TCID=101;
		String actText = home.checkLogoText();
		String expectedText="Swag Labs";
		
		if(actText.equals(expectedText)) {
			System.out.println("Landed on correctly on home page");
		}
		else {
			System.out.println("Incorrect home page");
		}
		Thread.sleep(2000);
//		String actLogoText = home.checkLogoText();
//		String expLoloText = UtilityClass.getTD(0, 2);
//		
//		Assert.assertEquals(actLogoText, expLoloText,"Failed-both results are diff");
//		Thread.sleep(2000);
	}

	@AfterMethod
	public void clickMenuButton1(ITestResult s1) throws IOException, InterruptedException {
		
		if(s1.getStatus()==(ITestResult.FAILURE)) {
			UtilityClass.captureSS(driver, TCID);
		}
		
		home.clickMenuButton();

		Thread.sleep(2000);
		menu.logoutApp();
		
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
