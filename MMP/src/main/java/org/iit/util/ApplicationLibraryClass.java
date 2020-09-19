package org.iit.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationLibraryClass {
	
	// Method - Reading Excel with xls extension
	public String[][] readingXlsFile(String xlsFilePath) throws IOException {
		File file = new File(xlsFilePath);
		FileInputStream excelFile = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(excelFile);
		HSSFSheet sheet = wb.getSheetAt(0);
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		String Data[][] = new String[totalRows - 1][totalColumns];
		int k = 0;
		for (int i = 1; i < totalRows; i++) {
			HSSFRow row = sheet.getRow(i);
			for (int j = 0; j < totalColumns; j++) {
				String cellData = row.getCell(j).getStringCellValue();
				Data[k][j] = cellData;
				// System.out.println(Data[k][j]);
			}
			k++;

		}
		return Data;

	}

	// Method- Reading Excel with xlsx extension
	public String[][] readingXlsxFile(String xlsxFilePath) throws IOException {
		File file = new File(xlsxFilePath);
		FileInputStream excelFile = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(excelFile);
		XSSFSheet sheet = wb.getSheetAt(0);
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		String Data[][] = new String[totalRows - 1][totalColumns];
		int k = 0;
		for (int i = 1; i < totalRows; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < totalColumns; j++) {
				String cellData = row.getCell(j).getStringCellValue();
				Data[k][j] = cellData;
				System.out.println(Data[k][j]);
			}
			k++;

		}
		return Data;

	}
	
	//Method- Reading Text File
	public String readingTextFile(String filePath) {

		FileReader fr = null;

		BufferedReader br = null;
		String str = "";
		String txt = "";

		try {

			File file = new File(filePath);
			// FileReader fr = newFileReader(file);
			fr = new FileReader(file.getAbsolutePath());
			// BufferReader br = new BufferReader(fr);
			br = new BufferedReader(fr);

			while ((str = br.readLine()) != null) {
				txt = txt + str;

			}
			System.out.println(txt);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				fr.close();
				br.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		return txt;

	}
	
	
}
	
	


