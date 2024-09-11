package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	FileInputStream fis;
	FileOutputStream fos;
	Workbook book;
	DataFormatter df;
	Cell cell;
	Row row;
	Sheet sheet;
	String path;

	public ReadDataFromExcel(String path) {
		this.path = path;
	}

	public String readData(String Sheet, int row, int column) {

		try {
			fis = new FileInputStream("./src/test/resources/Data/UserData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(Sheet);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		

	}

	public int getRowCount(String sheetName) throws Throwable {
		fis = new FileInputStream(path);
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		book.close();
		fis.close();
		return rowCount;

	}

	public int getCellCount(String sheetName, int rownum) throws Throwable {
		fis = new FileInputStream(path);
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		book.close();
		fis.close();
		return cellCount;
	}

	public String getCellData(String sheetName, int rownum, int columnnum) throws Throwable {
		fis = new FileInputStream(path);
		book = WorkbookFactory.create(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(columnnum);
		String data;

		try {
			data = df.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}

		book.close();
		fis.close();
		return data;

	}

	public void setCellData(String sheetName, int rownum, int columnnum, String data) throws Throwable {
		File xlFile = new File(path);
		if (!xlFile.exists()) {
			book = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			book.write(fos);
		}
		fis = new FileInputStream(path);
		book = new XSSFWorkbook(fis);

		if (book.getSheetIndex(sheetName) == -1)
			book.createSheet(sheetName);
		sheet = book.getSheet(sheetName);

		if (sheet.getRow(rownum) == null)
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);

		cell = row.createCell(columnnum);
		cell.setCellValue(data);
		fos = new FileOutputStream(path);
		book.write(fos);
		fis.close();
		fos.close();
	}

}
