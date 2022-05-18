package lex.JavaUploadDiscontSpringBoot.excel;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<ExcelBean> excelToShopIdList(InputStream inputStream) {
        List<ExcelBean> list = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create (inputStream); // Создаем объект книги
            inputStream.close();
            Sheet sheet = workbook.getSheetAt (0); // Объект рабочего листа
            int rowLength = sheet.getLastRowNum (); // Общее количество строк
            //System.out.println("Сколько строк в общем количестве строк "+ rowLength);
            Row row = sheet.getRow (0); // Первая строка рабочего листа
            int colLength = row.getLastCellNum (); // Общее количество столбцов
            //System.out.println(" Сколько столбцов в общем количестве столбцов "+ colLength);
            Cell cell = row.getCell (0); // Первая ячейка первой строки
            for (int i = 1; i <= rowLength; i++) {
                ExcelBean bean = new ExcelBean();
                row = sheet.getRow(i);
           //     for (int j = 0; j < 5; j++) {
                    // Столбец: 0 имя 1 количество сотрудников 2 надбавка к питанию 3 отдел
                    //cell = row.getCell(j);
                    //if (cell != null) {
                        cell.setCellType (CellType.STRING); // Устанавливаем строковый тип ячейки
                        //String data = cell.getStringCellValue();
                        String data = getExcelCell(row.getCell(0)).trim();
                        String name = getExcelCell(row.getCell(1)).trim();
                        String phone = getExcelCell(row.getCell(2)).trim();
                        String card = getExcelCell(row.getCell(3)).trim();
                        String birthday = getExcelCell(row.getCell(4)).trim();
                        //data = data.trim();
                     /*   if (j == 0) {
                            bean.setDate(data);
                        } else if (j == 1) {
                            bean.setSub_name(data);
                        } else if (j == 2) {
                            bean.setPhone(data);
                        } else if (j == 3) {
                            bean.setCard(data);
                        } else if (j == 4) {
                            bean.setBirthday(data);
                        }*/
                    //}
                //}
                name = name.replace("null","");
                if (name.length()>0){
                    bean.setDate(data);
                    bean.setSub_name(name);
                    bean.setCard(card);
                    bean.setPhone(phone);
                    bean.setBirthday(birthday);
                    list.add (bean);

                }

                 // сохраняем каждую отдельную строку данных
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static String getExcelCell(Cell cell) {

        switch (cell.getCellType()) {
            case STRING:
                return  cell.getStringCellValue();
            case BOOLEAN:
                if(cell.getBooleanCellValue()){
                return "true";
                }else {
                    return "false";
                }

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)){
                    return cell.getDateCellValue().toString();
                }
                else {
                    return  Long.toString((long)cell.getNumericCellValue());
                }
            default:
        //        System.out.println("неизвестный тип ячейки" + cell.getCellType());
                return  "null";
        }

    }
}