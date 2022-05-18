package lex.JavaUploadDiscontSpringBoot.excel.service;



import lex.JavaUploadDiscontSpringBoot.excel.ExcelBean;
import lex.JavaUploadDiscontSpringBoot.excel.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<ExcelBean> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public int insertEmployee(ExcelBean excelBean) {
        return employeeMapper.insertEmployee(excelBean);
    }
}