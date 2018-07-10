package com.OneAssist.API_Automation.fileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.OneAssist.API_Automation.helperClasses.HelperFunctions;

public class ExcelUtil {
	
	public String filePath;
	public String fileName;
	public FileInputStream inputStream = null;
	private Workbook workBook = null;
	private Sheet sheet = null;
	private Row row = null;
	private Cell cell = null;
	List<String> sheetNames;


	// Xls_Reader Constructor
	public ExcelUtil(String filePath, String fileName) throws IOException {

		this.filePath = filePath;
		this.fileName = fileName;
		//Create an object of File class to open xlsx file
		File file = new File(filePath + "//" + fileName);
		//Create an object of FileInputStream class to read excel file
		inputStream = new FileInputStream(file);
		//Find the file extension by splitting  file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {
			workBook = new XSSFWorkbook(inputStream);
		}
		//Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			workBook = new HSSFWorkbook(inputStream);
		}
		sheetNames = readAllSheetsName(workBook);
	}
	
	public ExcelUtil() {
		super();
	}
	
	//Return Excel data in Hash Map, containing Column names as Keys and Column values as List of values. 
		public static Map<String,List<String>> getAllExcelDataInHashMap(String filePath, String fileName, String sheetName){
			Map<String,List<String>> exlMapData = new LinkedHashMap<String,List<String>>();
			try {
				List<String> headerData = getHeaders(filePath,fileName,sheetName);
				for(String str: headerData) {
					int colNo=1; int startRowNo=1;
					long totalRowsNo=getNoOfRows(filePath,fileName,sheetName);
					List<String> ColumnData = getOneColumnDataFromMultipleRows(filePath,fileName,sheetName,colNo,startRowNo,totalRowsNo);
					exlMapData.put(str, ColumnData);
					colNo++;
				}
			} catch (Exception e) {
				System.out.println("Exception while getting All Excel Data from File {"+fileName+"} and Sheet {"+sheetName+"}. {}"+e.getStackTrace());
			}
		return exlMapData;
	}
	
	//Return Excel data in Hash Map, containing Column names as Keys and Column values as values [Row 1 as Headers and Row 2{rowNo} as values]. 
		public static Map<String,String> getExcelRowColDataInHashMap(String filePath, String fileName, String sheetName, int rowNo){
			Map<String,String> exlMapData = new LinkedHashMap<String,String>();
			int colNo=0;
			try {
				List<String> headerData = getHeaders(filePath,fileName,sheetName);
				List<String> apiData = getExcelDataOfOneRow(filePath, fileName, sheetName, rowNo);				
				
				/*for(String str: apiData) {
					System.out.println("api data : " + str);
				}*/
				
				for(String str: headerData) {
					if("SKIP".equalsIgnoreCase(apiData.get(colNo))) {
						colNo++;
						continue;
					}						
					/*else if("NULL".equalsIgnoreCase(apiData.get(colNo))) {
						exlMapData.put(str, null);
					}*/
					else if("BLANK".equalsIgnoreCase(apiData.get(colNo))) {
						exlMapData.put(str, "");
					}
					else if("SYSDATE".equalsIgnoreCase(apiData.get(colNo))) {
						Date date = new Date();  
					    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  
					    String strDate = formatter.format(date);
					    exlMapData.put(str, strDate);
					}						
					else if("EMAIL".equalsIgnoreCase(apiData.get(colNo))) {
						String email = "email" + LocalDateTime.now()+"@mailinator.com";
						exlMapData.put(str, email);
					}						
					else if("MOBILE".equalsIgnoreCase(apiData.get(colNo))) {
						String mob = "54321"+HelperFunctions.getRandomNumberInRange(11111, 99999);
						exlMapData.put(str, mob);
					}
					else {
						exlMapData.put(str, apiData.get(colNo));
					}
					
					colNo++;
				}
			} catch (Exception e) {
				
				System.out.println("Exception while getting All Excel Data from File {"+fileName+"} and Sheet {"+sheetName+"}. {"+colNo+"}"+e.getStackTrace());
			}
		return exlMapData;
	}
	
	//Returns the data of Any One Row. Row No is
		public static List<String> getExcelDataOfOneRow(String filePath, String fileName, String sheetName, int rowNo) {
			List<String> oneRowData = new ArrayList<String>();
			try {
				FileInputStream file = new FileInputStream(new File(filePath + "//" + fileName));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheet(sheetName);
				if (sheet == null) {
					System.out.println("Couldn't locate Sheet {"+sheetName+"} in File {"+fileName+"}");
					return oneRowData;
				}
				if (sheet.getPhysicalNumberOfRows() < rowNo) {
					System.out.println("Row No. {"+rowNo+"} doesn't exist.");
					return oneRowData;
				}
				if (rowNo < 1) {
					System.out.println("Row No. can't be less than 1.");
					return oneRowData;
				}
				Iterator<Row> rowIterator = sheet.iterator();
				Row row = null;
				for (int i = 0; i < rowNo; i++)
					row = rowIterator.next();

				int noOfColumns = row.getPhysicalNumberOfCells();
				for (int j = 0; j < noOfColumns; j++) {
					Cell cell = row.getCell(j);
					if (cell == null) {
						oneRowData.add(null);
						continue;
					}
					
					if (cell.getCellTypeEnum() == CellType.NUMERIC)
						oneRowData.add(Double.toString(cell.getNumericCellValue()));
					else if (cell.getCellTypeEnum() == CellType.STRING)
						oneRowData.add(cell.getStringCellValue());
					else if (cell.getCellTypeEnum() == CellType.BOOLEAN)
						oneRowData.add(Boolean.toString(cell.getBooleanCellValue()));
					else if (cell.getCellTypeEnum() == CellType.BLANK)
						oneRowData.add("");
				}
				file.close();
			} catch (Exception e) {
				System.out.println("exception caught.." + e.getStackTrace() + e.getMessage());
			}
			return oneRowData;
		}

		public static List<String> getHeaders(String filePath, String fileName, String sheetName) {
			return getExcelDataOfOneRow(filePath, fileName, sheetName, 1);
		}

		public static synchronized List<String> getOneColumnDataFromMultipleRows(String excelFilePath, String excelFileName, String sheetName, int columnNo, int startingRowNo,
		                                                                         Long noOfRows) {
			List<String> columnData = new ArrayList<String>();
			try {
				FileInputStream file = new FileInputStream(new File(excelFilePath + "/" + excelFileName));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheet(sheetName);
				if (sheet == null) {
					System.out.println("Couldn't locate Sheet {"+sheetName+"} in File {"+excelFileName+"}.");
					return columnData;
				}

				Iterator<Row> rowIterator = sheet.iterator();
				int rowNo = 0;
				while (rowNo < startingRowNo && rowIterator.hasNext()) {
					rowIterator.next();
					rowNo++;
				}

				int i = 0;
				Row row;
				while (i < noOfRows && rowIterator.hasNext()) {
					row = rowIterator.next();
					columnData.add(row.getCell(columnNo).toString());
					i++;
				}

				file.close();
			} catch (Exception e) {
				System.out.println("Exception while Getting Data for Column No {"+columnNo+"} in Sheet {"+sheetName+"} at File location [{"+excelFilePath+"}]. {"+excelFileName+"}"
						+ e.getStackTrace());
			}
			return columnData;
		}
		
		public static List<List<String>> getAllExcelData(String filePath, String fileName, String sheetName) {
			List<List<String>> allData = new ArrayList<List<String>>();
			List<String> oneRowData;
			try {
				FileInputStream file = new FileInputStream(new File(filePath + "//" + fileName));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheet(sheetName);
				if (sheet == null) {
					System.out.println("Couldn't locate Sheet {"+sheetName+"} in File {"+fileName+"}.");
					return allData;
				}

				Iterator<Row> rowIterator = sheet.iterator();
				Row row = rowIterator.next();
				int noOfColumns = row.getPhysicalNumberOfCells();

				while (rowIterator.hasNext()) {
					oneRowData = new ArrayList<String>();
					row = rowIterator.next();

					for (int i = 0; i < noOfColumns; i++) {
						Cell cell = row.getCell(i);
						if (cell == null) {
							oneRowData.add(null);
							continue;
						}

						if (cell.getCellTypeEnum() == CellType.NUMERIC)
							oneRowData.add(Double.toString(cell.getNumericCellValue()));
						else if (cell.getCellTypeEnum() == CellType.STRING)
							oneRowData.add(cell.getStringCellValue());
						else if (cell.getCellTypeEnum() == CellType.BOOLEAN)
							oneRowData.add(Boolean.toString(cell.getBooleanCellValue()));
						else if (cell.getCellTypeEnum() == CellType.BLANK)
							oneRowData.add("");
					}
					allData.add(oneRowData);
				}
				file.close();
			} catch (Exception e) {
				System.out.println("Exception while getting All Excel Data from File {"+fileName+"} and Sheet {"+sheetName+"}. {}"+e.getStackTrace());
			}
			return allData;
		}
		
		public static List<List<String>> getExcelDataOfMultipleRows(String filePath, String fileName, String sheetName, int startingRowNo, int noOfRows) {
			List<List<String>> allData = new ArrayList<List<String>>();
			List<String> oneRowData;
			try {
				FileInputStream file = new FileInputStream(new File(filePath + "//" + fileName));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheet(sheetName);
				if (sheet == null) {
					System.out.println("Couldn't locate Sheet {"+sheetName+"} in File {"+fileName+"}.");
					return allData;
				}

				Iterator<Row> rowIterator = sheet.iterator();
				Row row = rowIterator.next();
				int noOfColumns = row.getPhysicalNumberOfCells();

				int rowNo = 0;
				while (rowNo < startingRowNo - 1) {
					if (rowIterator.hasNext()) {
						rowIterator.next();
						rowNo++;
					} else {
						System.out.println("The Excel Sheet {"+sheetName+"} has lesser no of rows than Starting Row No. {"+startingRowNo+"}. Hence couldn't get Excel Data");
						return allData;
					}
				}

				rowNo = 0;
				while (rowIterator.hasNext() && rowNo < noOfRows) {
					rowNo++;
					oneRowData = new ArrayList<String>();
					row = rowIterator.next();

					for (int i = 0; i < noOfColumns; i++) {
						Cell cell = row.getCell(i);
						if (cell == null) {
							oneRowData.add(null);
							continue;
						}

						if (cell.getCellTypeEnum() == CellType.NUMERIC)
							oneRowData.add(Double.toString(cell.getNumericCellValue()));
						else if (cell.getCellTypeEnum() == CellType.STRING)
							oneRowData.add(cell.getStringCellValue());
						else if (cell.getCellTypeEnum() == CellType.BOOLEAN)
							oneRowData.add(Boolean.toString(cell.getBooleanCellValue()));
						else if (cell.getCellTypeEnum() == CellType.BLANK)
							oneRowData.add("");
					}
					allData.add(oneRowData);
				}
				file.close();
			} catch (Exception e) {
				System.out.println("Exception while getting Excel Data of Multiple Rows (starting Row: {"+startingRowNo+"} and No of Rows: {"+noOfRows+"}) from File {"+fileName+"} and Sheet {"+sheetName+"}. {}"
				+e.getStackTrace());
			}
			return allData;
		}

		public static int getNoOfRows(String excelFilePath, String excelFileName, String sheetName) {
			int noOfRows = 0;
			try {
				FileInputStream file = new FileInputStream(new File(excelFilePath + "/" + excelFileName));
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheet(sheetName);

				noOfRows = (sheet.getPhysicalNumberOfRows());
			} catch (Exception e) {
				System.out.println("Exception while getting Total No of Rows in Excel Sheet {"+sheetName+"}" + e.getStackTrace());
			}
			return noOfRows;
		}

		public List<String> getSheetNames() {
			return sheetNames;
		}
		
		// it will return all the sheetsName in WorkBook
		public List<String> readAllSheetsName(Workbook workbook) {

			List<String> sheetNames = new ArrayList<String>();
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
				sheetNames.add(workBook.getSheetName(i));
			}
			return sheetNames;
		}

		// Xls_Reader - Returns Sheet Existence
		public boolean isSheetExist(String sheetName) {
			int index = workBook.getSheetIndex(sheetName);
			if (index == -1) {
				index = workBook.getSheetIndex(sheetName.toUpperCase());
				if (index == -1)
					return false;
				else
					return true;
			} else
				return true;
		}


}


