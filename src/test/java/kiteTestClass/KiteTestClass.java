package kiteTestClass;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Baseclass.BaseUsingPropertyFile;
import KiteAppPOMClasses.KiteAppPinPage;
import KiteAppPOMClasses.KiteHomePage;
import KiteAppPOMClasses.KiteLoginPage;
import utilityPackgae.Utility;

public class KiteTestClass extends BaseUsingPropertyFile{
  
  KiteHomePage home;
  KiteAppPinPage pin;
  KiteLoginPage login;
  @BeforeClass
  public void launchingBrowser() throws IOException
  {
	 launchBrowser();
	  
	  pin=new KiteAppPinPage(driver);
	   login=new KiteLoginPage(driver);
	   home=new KiteHomePage(driver);
	 	Reporter.log("launchbrowser succssfully",true);	  
  }
  @BeforeMethod
  public void loginApp() throws IOException
  {
	  login.enterUserId(Utility.readPropertyFile("UID"));
	  login.enterPassword(Utility.readPropertyFile("PWD"));
	  login.clickOnLoginButton();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	  pin.enterPin(Utility.readPropertyFile("PIN"));
	  pin.clickOnContinueButton();
	  Reporter.log("login in.....",true);
  }
  @Test
  public void validateUserID() throws IOException
  {
	 String actualUserId = home.getActualUserID();
	 String expectedUserId = Utility.readPropertyFile("UID");
	 Assert.assertEquals(actualUserId, expectedUserId,"actual and expected are not matching");
	 Reporter.log("validate userId succsesfully",true);
  }
  @AfterMethod
  public void closeApp() throws InterruptedException 
  {
	home.clickOnLogOutButton();  
 Reporter.log("closeApp sucessfully",true);
  }
  public void closingBrowser()
  {
	  closeBrowser();
	  Reporter.log("Closing browser sucessfully",true);
  }
}
