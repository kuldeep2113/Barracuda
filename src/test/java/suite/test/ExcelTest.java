package suite.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.LoginPage;
import suite.testdata.LoginTestData;
import suite.utils.ExcelUtil;
import suite.utils.Xls_Reader;

public class ExcelTest extends TestBase {
	
	private LoginPage login;
	public ExcelUtil eu;
	int count = 20;
	
	
	Xls_Reader reader = new Xls_Reader("src/main/resources/TestDataSheet.xlsx");
	
	//String sheetName = "Registered_user";
	
	
	  private XSSFSheet getSheet() {
	        return getTestData().getSheet("Registered_user");
	    }
	  
	 
	
	/**
	 * create page url
	 * 
	 * @return login pageurl
	 */
	private String getPageUrl() {
		return getEnv().concat(LoginTestData.LOGIN_PAGE);
	}
	
	@Test
	public void abc() {
	
		
		String myEmailAddress = "kuldeep+" + System.nanoTime() + "@Gmail.com"; 
		
	
		reader.setCellData("Registered_user", "UserID", 2, myEmailAddress);
		
		  login = new LoginPage(getDriver()); login.getLoginPage(getPageUrl())
	   //  .enterUname(reader.getCellData("Registered_user", "UserID", 2))
		 //.enterPass(reader.getCellData("Registered_user", "Password", 2)) .clkSubmitBtn();
		  
		  .enterUname(getSheet().getRow(1).getCell(1).getStringCellValue())
		  .enterPass(getSheet().getRow(1).getCell(2).getStringCellValue()) .clkSubmitBtn();
		 
		 
	//	reader.addColumn(sheetName, "Status");
		//reader.setCellData(sheetName, "order_id", 2, "Pass");
		  // reader.setCellData("Registered_user", "Order ID", 2, "124dfsf331");
		
		   reader.removeColumn("Test", 2);
		   reader.addColumn("Test", "Order ID");
		   reader.setCellData("Test", "Order ID", 2, "124dfsf331");
		
		 // eu.setCellData("Registered_user", "Order_ID", 1, "12312ff1"); 
		  


	}	
		
}
