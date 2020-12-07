package suite.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;


import suite.base.TestBase;
import suite.page.LoginPage;
import suite.testdata.LoginTestData;
import suite.utils.ExcelUtil;
import suite.utils.Xls_Reader;

public class MultiUser extends TestBase {
	
	private LoginPage login;
	public ExcelUtil eu;
	
	
	//
	
	//String sheetName = "Test";
	
	
	
	  private XSSFSheet getSheet() {
	        return getTestData().getSheet("Test");
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

		Xls_Reader reader = new Xls_Reader("src/main/resources/TestDataSheet.xlsx");
		int rowCount = Xls_Reader.getRowCount("Test");
	//	int colCount = Xls_Reader.getColCount();
		
	//	System.out.println(colCount);
		//System.out.println(rowCount);
		
		/*for(int i=1;i<=rowCount;i++) {
		  login = new LoginPage(getDriver()); login.getLoginPage(getPageUrl())
		  .enterUname(getSheet().getRow(i).getCell(1).getStringCellValue())
		  .enterPass(getSheet().getRow(1).getCell(2).getStringCellValue())
		  .clkSubmitBtn();*/
		String myEmailAddress = "kuldeep+" + System.nanoTime() + "@Gmail.com"; 
		System.out.println(myEmailAddress);
		 	
		}
	}
