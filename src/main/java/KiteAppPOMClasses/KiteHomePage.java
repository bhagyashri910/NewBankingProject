package KiteAppPOMClasses;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {

	@FindBy(xpath = "//span[@class='user-id']")private WebElement UserID;
	@FindBy(xpath = "//a[@target='_self']")private WebElement logOut;
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String getActualUserID()
	{
		String actualuserID = UserID.getText();
		return actualuserID;
		
	}
	public void clickOnLogOutButton() throws InterruptedException
	{
		UserID.click();
	//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Thread.sleep(1000);
		logOut.click();
	}
}
