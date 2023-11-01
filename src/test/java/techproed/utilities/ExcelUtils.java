package techproed.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet workSheet;
    private String path;
    public ExcelUtils(String path, String sheetName){// Bu constructor excel dosyasını açmak ve erişmek içindir
        this.path = path;
        try {
            // Excel dosyasının açılması
            FileInputStream fileInputStream = new FileInputStream(path);
            // çalışma kitabına erişim
            workbook = WorkbookFactory.create(fileInputStream);
            // çalışma sayfasını almak
            workSheet = workbook.getSheet(sheetName);
            // sayfanın veri içerip içermediğini iddia etmek
            Assert.assertNotNull(workSheet,"Worksheet: \"" + sheetName + "\" was not found\n");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    // Excel deki verileri List olarak almamizi saglar
    // Excel deki verileri test sinifinda kullanmak icin bu method u kullaniriz
    public List<Map<String,String>> getDataList(){
        // tüm sütunları almak
        List<String> columns = getColumnsNames();
        // metodu bunu döndürecektir
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++){
            // get each row
            Row row = workSheet.getRow(i);
            // sütun ve değer kullanılarak satırın eşleştirilmesi
            // key=column, value=cell
            Map<String,String> rowMap = new HashMap<String, String>();
            for (Cell cell : row){
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }
    // Belirli bir tek satırdaki sütun sayısını alma
    public int columnCount(){
        // satır 1'de kaç sayı olduğunu alma
        return workSheet.getRow(0).getLastCellNum();
    }
    // son satır numarasını nasıl alırsınız? Dizin 0'dan başlar.
    public int rowCount(){
        return workSheet.getLastRowNum() + 1; // gerçek sayıyı elde etmek için 1 ekleyerek
    }
    // Satır ve sütun numarasını girdiğinizde, verileri alırsınız
    public String getCellData(int rowNum, int colNum){
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // tüm verileri iki boyutlu diziye almak ve verileri döndürmek
    public String[][] getDataArray(){
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i< rowCount(); i++){
            for (int j = 0; j < columnCount(); j++){
                String value = getCellData(i,j);
                data[i][j] = value;
            }
        }
        return data;
    }

    // ilk satıra gidip her bir sütunu tek tek okumak
    public List<String> getColumnsNames(){
        List<String> columns = new ArrayList<>();
        for (Cell cell: workSheet.getRow(0)){
            columns.add(cell.toString());
        }
        return columns;
    }

    // Satır ve sütun numarasını girdiğinizde, değeri döndürme
    public void setCellData(String value, int rowNum, int colNum){
        Cell cell;
        Row row;
        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if (cell == null){ // eğer değer yoksa, bir hücre oluştur
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            }else {
                cell.setCellValue(value);
            }
            FileOutputStream fileInputStream = new FileOutputStream(path);
            workbook.write(fileInputStream);
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setCellData(String value, String columnName, int row){
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value,row,column);
    }
    // bu yöntem veri tablosunu 2d dizisi olarak döndürecektir
    // bu yüzden veri sağlayıcı nedeniyle bu formata ihtiyacımız var
    public String[][] getDataArrayWithOutFirstRow(){
        String[][] data = new String[rowCount()-1][columnCount()];
        for (int i =1 ; i< rowCount(); i++){
            for (int j =0; j< columnCount(); j++){
                String value = getCellData(i,j);
                data[i-1][j] = value;
            }
        }
        return data;
    }
}
