package CRBActions_US_NC_Auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

public class Step02_ENC_US_dnd {
	
private WebDriver driver;
public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
public String sheet="Login";

//Login to the ENC user 
@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
@FindBy ( id="btn_signin") private WebElement Signin_Button ;
@FindBy ( xpath=".//*[@id='desktop']") private WebElement Username_Box ;
@FindBy ( xpath=".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement Password_Box ;

//Serach the particular request
@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting executive noncore approver action')]") private WebElement Awaiting_executive_noncore ;
@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Candidates')]") private WebElement Candidates ;
@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
@FindBy (name="btnGo") private WebElement GO_reqnum ;
@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement skill_link ;

//Submit the request to further authorization
@FindBy (id ="FLD_CMTS_TO_REQSTR" ) private WebElement comment_box ;
@FindBy (name ="btnSaveAndAuth" ) private WebElement Authorize_btn ;

	public Step02_ENC_US_dnd(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	// Function to login to the application
	public void loginENC()
	{
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOf(loginToContractor_Link));

		loginToContractor_Link.click();
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Signin_Button));

		Username_Box.clear();
		Username_Box.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 17, 0));
		Password_Box.clear();
		Password_Box.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 17, 1));

		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Practice Automation\\Review\\NCore\\US");

		Signin_Button.click();

	}

	public void ENC_open_Request ()
	{

		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Awaiting_executive_noncore));

		Awaiting_executive_noncore.click();

		WebDriverWait wait02 = new WebDriverWait(driver, 300);
		wait02.until(ExpectedConditions.visibilityOf(Req_Num_Search));

		Req_Num_Search.clear();
		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		GO_reqnum.click();

		WebDriverWait wait03 = new WebDriverWait(driver, 160);
		wait03.until(ExpectedConditions.visibilityOf(skill_link)); 
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Practice Automation\\Review\\NCore\\US");

		skill_link.click();

	}
	public void submit_req() 
	{
		WebDriverWait wait04 = new WebDriverWait(driver, 180);
		wait04.until(ExpectedConditions.visibilityOf(comment_box));
		comment_box.sendKeys("comments entered");
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Practice Automation\\Review\\NCore\\US");
		
		WebDriverWait wait05 = new WebDriverWait(driver, 180);
		wait05.until(ExpectedConditions.visibilityOf(Authorize_btn));
		Authorize_btn.click();
	}
}
