package lex.JavaUploadDiscontSpringBoot.excel;


import lex.JavaUploadDiscontSpringBoot.excel.service.EmployeeServiceImpl;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


@Controller
public class ExcelController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response)throws IOException {
        String fileName = "Информация о сотруднике.xls";
        response.setContentType ("application / excel"); // Разрешить клиентскому браузеру различать разные типы данных
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));

        List <ExcelBean> list = employeeService.getAllEmployee (); // данные mysql

        HSSFWorkbook workbook = new HSSFWorkbook (); // Создать книгу
        HSSFSheet sheet = workbook.createSheet (); // Создаем рабочий лист

        int rowNum = 0;

        String [] headers = {"Дата", "ФИО", "телефон", "карта", "Дата рождения"};

        HSSFRow row = sheet.createRow (rowNum); // Создаем первую строку

        // Строка заголовка
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell (i); // Создать столбец (ячейку)
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue (text); // Устанавливаем значение столбца
            sheet.setColumnWidth (i, 256 * 13); // Устанавливаем ширину столбца
        }

        // Строка данных
        for (ExcelBean employee : list) {
            rowNum++;
            HSSFRow row1 = sheet.createRow(rowNum);

            row1.createCell(0).setCellValue(employee.getDate());
            row1.createCell(1).setCellValue(employee.getSub_name());
            row1.createCell(2).setCellValue(employee.getPhone());
            row1.createCell(3).setCellValue(employee.getCard());
            row1.createCell(4).setCellValue(employee.getBirthday());
        }
        workbook.write(response.getOutputStream());
        System.out.println ("[загрузка завершена] экспортировать данные mysql в Excel и загрузить ...");
    }
}