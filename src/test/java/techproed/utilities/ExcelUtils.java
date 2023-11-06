package techproed.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class ExcelUtils {
    private Workbook workBook;
    private Sheet workSheet;
    private String path;

    public ExcelUtils(String path, String sheetName) {
        this.path = path;

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            this.workBook = WorkbookFactory.create(fileInputStream);
            this.workSheet = this.workBook.getSheet(sheetName);
            Assert.assertNotNull(this.workSheet, "Worksheet: \"" + sheetName + "\" was not found\n");
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public List<Map<String, String>> getDataList() {
        List<String> columns = this.getColumnsNames();
        List<Map<String, String>> data = new ArrayList();

        for(int i = 1; i < this.rowCount(); ++i) {
            Row row = this.workSheet.getRow(i);
            Map<String, String> rowMap = new HashMap();
            Iterator var6 = row.iterator();

            while(var6.hasNext()) {
                Cell cell = (Cell)var6.next();
                int columnIndex = cell.getColumnIndex();
                rowMap.put((String)columns.get(columnIndex), cell.toString());
            }

            data.add(rowMap);
        }

        return data;
    }

    public int columnCount() {
        return this.workSheet.getRow(0).getLastCellNum();
    }

    public int rowCount() {
        return this.workSheet.getLastRowNum() + 1;
    }

    public String getCellData(int rowNum, int colNum) {
        try {
            Cell cell = this.workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public String[][] getDataArray() {
        String[][] data = new String[this.rowCount()][this.columnCount()];

        for(int i = 0; i < this.rowCount(); ++i) {
            for(int j = 0; j < this.columnCount(); ++j) {
                String value = this.getCellData(i, j);
                data[i][j] = value;
            }
        }

        return data;
    }

    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList();
        Iterator var2 = this.workSheet.getRow(0).iterator();

        while(var2.hasNext()) {
            Cell cell = (Cell)var2.next();
            columns.add(cell.toString());
        }

        return columns;
    }

    public void setCellData(String value, int rowNum, int colNum) {
        try {
            Row row = this.workSheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }

            FileOutputStream fileOutputStream = new FileOutputStream(this.path);
            this.workBook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public void setCellData(String value, String columnName, int row) {
        int column = this.getColumnsNames().indexOf(columnName);
        this.setCellData(value, row, column);
    }

    public String[][] getDataArrayWithoutFirstRow() {
        String[][] data = new String[this.rowCount() - 1][this.columnCount()];

        for(int i = 1; i < this.rowCount(); ++i) {
            for(int j = 0; j < this.columnCount(); ++j) {
                String value = this.getCellData(i, j);
                data[i - 1][j] = value;
            }
        }

        return data;
    }
}
