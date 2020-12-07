package suite.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import suite.init.SessionInit;
import suite.listener.WebDriverListener;
import suite.utils.ExcelUtil;
import suite.utils.Xls_Reader;



/**
 * This is Test Base class for automation framework contains all the common test
 * prerequisites for automation
 * 
 * @author Kuldeep
 *
 */
public class TestBase extends EnvBase {

	private WebDriver driver;
	private WebDriverWait wait;
	private EventFiringWebDriver eventHandler;
	private WebDriverListener ecapture;

	@Parameters({ "env" })
	@BeforeClass
	public void setUpEnv(@Optional("qa") String env) {
		setEnv(env);
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void setDriver(@Optional("chrome") String browser) {
		
		SessionInit.getDriverSession().initiateBrowserSession(browser);
		this.driver = SessionInit.getDriverSession().getBrowserSession();

		this.eventHandler = new EventFiringWebDriver(driver);
		this.ecapture = new WebDriverListener();
		this.eventHandler.register(ecapture);
	}

	@AfterMethod
	public void tearDown() {
		this.eventHandler.unregister(ecapture);
		SessionInit.getDriverSession().terminateBrowserSession(driver);
	}

	public EventFiringWebDriver getDriver() {
		return this.eventHandler;
	}

	@Override
	public String getEnv() {
		return super.getEnv();
	}

	public WebDriverWait getWait() {
		return wait;
	}
	

	
	public Object[][] getData() throws Exception
	{


		int rowCount = ExcelUtil.getRowCount();
		int colCount = ExcelUtil.getColCount();


		Object data[][] = new Object[rowCount-1][colCount];

		for(int i =1;i<rowCount;i++)
		{
			for(int j = 0; j<colCount;j++)
			{

				Object cellData = ExcelUtil.getCellCountString(i,j);
				System.out.print(cellData +" | ");
				data[i-1][j] = cellData;
			}
			System.out.println();
		}
		return data;

	}	
	
	/**
     * for getting the data from excel sheet
     *    
     * @return path of the sheet
     */
	
	  public XSSFWorkbook getTestData() { return new
	  ExcelUtil().ExcelDataConfig("src/main/resources/TestDataSheet.xlsx"); }
	 

    public  Xls_Reader getTestData2() {

    	return new Xls_Reader("src/main/resources/TestDataSheet.xlsx");
		

		
	}
    
    
    
    
}