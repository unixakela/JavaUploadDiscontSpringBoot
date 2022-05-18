package lex.JavaUploadDiscontSpringBoot.excel.mapper;


import lex.JavaUploadDiscontSpringBoot.excel.ExcelBean;

import java.util.List;

public interface EmployeeMapper {
    List<ExcelBean> getAllEmployee();
    int insertEmployee(ExcelBean excelBean);
}