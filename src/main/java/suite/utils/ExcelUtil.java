package suite.utils;

	

	import java.io.File;
	import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtil {
		

			static String systemPath;
			static XSSFWorkbook workbook;
			static XSSFSheet sheet;
			public FileInputStream fis = null;
			public String path;
			public FileOutputStream fileOut = null;
			private XSSFRow row = null;
			private XSSFCell cell = null;
			


			/**
		     * Input the excel path
		     *
		     * @param excelPath path of the excel file
		     */
		    public XSSFWorkbook ExcelDataConfig(String excelPath) {
		        try {
		            File filePath = new File(excelPath);
		            FileInputStream Inputfile = new FileInputStream(filePath);
		            workbook = new XSSFWorkbook(Inputfile);
		            return workbook;
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		        }
		        return workbook;
		    }

			public static int getRowCount()
			{
				int rowCount = sheet.getPhysicalNumberOfRows();
				System.out.println("no. of rows: "+rowCount);
				return rowCount;
			}
			
			public static int getColCount()
			{
				int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
				System.out.println("no. of columns:" +colCount);
				return colCount;
			}

			public static String  getCellCountString(int rowNum, int colNum)
			{
				String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
				//System.out.println(cellData);
				return cellData;
			}



			public static double getCellCountNumber(int rowNum, int colNum)
			{
				double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				//System.out.println(cellData);
				return cellData;
			}
			
			
			// returns true if data is set successfully else false
			public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
				try {
					fis = new FileInputStream(path);
					workbook = new XSSFWorkbook(fis);

					if (rowNum <= 0)
						return false;

					int index = workbook.getSheetIndex(sheetName);
					int colNum = -1;
					if (index == -1)
						return false;

					sheet = workbook.getSheetAt(index);

					row = sheet.getRow(0);
					for (int i = 0; i < row.getLastCellNum(); i++) {
						// System.out.println(row.getCell(i).getStringCellValue().trim());
						if (row.getCell(i).getStringCellValue().trim().equals(colName))
							colNum = i;
					}
					if (colNum == -1)
						return false;

					sheet.autoSizeColumn(colNum);
					row = sheet.getRow(rowNum - 1);
					if (row == null)
						row = sheet.createRow(rowNum - 1);

					cell = row.getCell(colNum);
					if (cell == null)
						cell = row.createCell(colNum);

					// cell style
					// CellStyle cs = workbook.createCellStyle();
					// cs.setWrapText(true);
					// cell.setCellStyle(cs);
					cell.setCellValue(data);

					fileOut = new FileOutputStream(path);

					workbook.write(fileOut);

					fileOut.close();

				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			
			// returns true if column is created successfully
			public boolean addColumn(String sheetName, String colName) {
				// System.out.println("**************addColumn*********************");

				try {
					fis = new FileInputStream(path);
					workbook = new XSSFWorkbook(fis);
					int index = workbook.getSheetIndex(sheetName);
					if (index == -1)
						return false;

					XSSFCellStyle style = workbook.createCellStyle();
					// style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
					// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

					sheet = workbook.getSheetAt(index);

					row = sheet.getRow(0);
					if (row == null)
						row = sheet.createRow(0);

					// cell = row.getCell();
					// if (cell == null)
					// System.out.println(row.getLastCellNum());
					if (row.getLastCellNum() == -1)
						cell = row.createCell(0);
					else
						cell = row.createCell(row.getLastCellNum());

					cell.setCellValue(colName);
					cell.setCellStyle(style);

					fileOut = new FileOutputStream(path);
					workbook.write(fileOut);
					fileOut.close();

				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}

				return true;

			}

			
		}





