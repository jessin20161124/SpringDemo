package com.baobaotao.web;

import com.baobaotao.domain.User;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
/**
 * Created by gzx on 16-11-20.
 */
public class UserListExcelView extends AbstractExcelView{
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setHeader("Content-Disposition", "inline;filename=" + new String("用户列表.xls".getBytes(), "iso8859-1"));
        List<User> userList = (List<User>)model.get("userList");
        HSSFSheet sheet = workbook.createSheet("users");
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("账号");
        header.createCell(1).setCellValue("姓名");
        header.createCell(2).setCellValue("密码");
        int rowNum = 1;
        for(User user : userList){
            HSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getUserName());
            row.createCell(1).setCellValue(user.getRealName());
            row.createCell(2).setCellValue(user.getPassword());
        }
    }
}
