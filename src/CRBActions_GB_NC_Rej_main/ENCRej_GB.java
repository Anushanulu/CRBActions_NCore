package CRBActions_GB_NC_Rej_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CRBActions_GB_NC_Rej.Step02_ENCRej_GB;

import org.apache.log4j.Logger;

import lib.Excel;



public class ENCRej_GB
{
	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;

	WebDriver driver;


	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Softwares\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();

		url = Excel.getCellValue(xlsFilePath, sheet, 8, 2);

		driver.get(url);
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC

	@Test(priority=0)
	public void ENC_Wlcmpage() throws InterruptedException 
	{

		Step02_ENCRej_GB login = new Step02_ENCRej_GB(driver);
		login.loginENC();
		login.ENC_open_Request();
	}
	@Test(priority=1)
	public void ENC_auth() 
	{

		Step02_ENCRej_GB encauth = new Step02_ENCRej_GB(driver);
		encauth.submit_req();
	}
}


