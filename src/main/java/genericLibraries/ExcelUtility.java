package genericLibraries;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Map;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	/**
	 * This class contains all reusable methods to read/write data from/to excel
	 * 
	 * @author jyoth
	 *
	 */
	public class ExcelUtility {
		private Workbook wb;
		Sheet sh;
		DataFormatter df;

		/**
		 * This method is used to initialize excel
		 * 
		 * @param excelPath
		 */
		public void excelInit(String excelPath) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(excelPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				wb = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException | IOException e) {
				e.printStackTrace();
			}
			
			df = new DataFormatter();
		}

		/**
		 * This method is used to read data from excel
		 * 
		 * @param expectedTestName
		 * @param sheetName
		 * @return
		 */
		public Map<String, String> readFromExcel(String expectedTestName, String sheetName) {
			sh=wb.getSheet(sheetName);
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i <= sh.getLastRowNum(); i++) {
				if (df.formatCellValue(sh.getRow(i).getCell(1)).equals(expectedTestName)) {
					for (int j = i; j <= sh.getLastRowNum(); j++) {
						map.put(df.formatCellValue(sh.getRow(j).getCell(2)), df.formatCellValue(sh.getRow(j).getCell(3)));
						if (df.formatCellValue(sh.getRow(j).getCell(2)).equals("####"))
							break;
					}
					break;
				}
			}
			System.out.println(map);
			return map;
		}

		/**
		 * This method is used to write to excel
		 * 
		 * @param expectedTestName
		 * @param status
		 * @param excelPath
		 * @param sheetName
		 */
		public void updateTestStatus(String expectedTestName, String status, String excelPath, String sheetName) {
			sh=wb.getSheet(sheetName);
			for (int i = 0; i <= sh.getLastRowNum(); i++) {
				if (df.formatCellValue(sh.getRow(i).getCell(1)).equals(expectedTestName)) {
					Cell c = sh.getRow(i).createCell(4);
					c.setCellValue(status);
					break;
				}
			}
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(excelPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				wb.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * This method is used to close excel
		 */
		public void closeExcel() {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

