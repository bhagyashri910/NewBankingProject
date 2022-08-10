package utilityPackgae;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import org.testng.Reporter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
public static String readPropertyFile(String key) throws IOException
{
	Properties pro=new Properties();
	FileInputStream myFile=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Bankingproject\\PropertyFile");
	pro.load(myFile);
	String value = pro.getProperty(key);
	return value;
	
}
public static void takeScreenShot(WebDriver driver,int TCID) throws IOException
{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest= new File("D:\\Myscreenshot\\TC "+TCID+"Myscreenshot.png");
	FileHandler.copy(src, dest);
	Reporter.log("take screen shot successfully",true);
	
	
}
}
