package Baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import utilityPackgae.Utility;

public class BaseUsingPropertyFile
{
	protected WebDriver driver;
public void launchBrowser() throws IOException
{
	System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM folder of SW\\chromedriver.exe");
 driver=new ChromeDriver();
	driver.get(Utility.readPropertyFile("URL"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	Reporter.log("Launching browser...",true);
}
public void closeBrowser()
{
	driver.close();
	Reporter.log("closing browser...",true);
}

}
