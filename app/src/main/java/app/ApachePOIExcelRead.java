package app;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ApachePOIExcelRead {

    private static final String FILE_NAME = "/Users/tonisutomo/Documents/Benar.xlsx";
	private static Workbook workbook;

    public static void main(String[] args) {

        try {
        		
        		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            while (iterator.hasNext()) {
            	
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
                        System.out.print(currentCell.getNumericCellValue() + "formula num--");
                        System.out.print(currentCell.getCellFormula() + "formula str--");
                    }

                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
        		e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
//	public static void main(String[] args) {
//		System.out.println("Done");
//	}

    
    
}
