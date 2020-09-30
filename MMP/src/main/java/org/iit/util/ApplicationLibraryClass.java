package org.iit.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApplicationLibraryClass {

	// Method - Reading Excel with xls extension
	public static String[][] readingXlsFile(String xlsFilePath) throws IOException {
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
	public static String[][] readingXlsxFile(String xlsxFilePath) throws IOException {
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

	// Method- Reading Text File
	public static String readingTextFile(String filePath) {

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

	// Method- to get past Date

	public static String pastDate() {
		Random random = new Random();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -(random.nextInt(100)));
		cal.add(Calendar.MONTH, -2);
		cal.add(Calendar.YEAR, -1);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String pastDate = sdf.format(d);
		return pastDate;

	}
//method to get future date
	public static String futureDate() {
		Random random = new Random();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, random.nextInt(100));
		cal.add(Calendar.MONTH, 2);
		cal.add(Calendar.YEAR, 1);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String pastDate = sdf.format(d);
		return pastDate;

	}
	 public static boolean uploadingFile(String filePath) throws AWTException{
		    //"C:\\Users\\ektaj\\RepTest.txt" -File Path syntax
		    // copying file path on the clip board
		    StringSelection clipBoardContent = new StringSelection(filePath);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardContent, null);
			
		    //Thread.sleep(10000)
		    //pasting file path on the window and press Enter
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		    return true;
		  }

}
