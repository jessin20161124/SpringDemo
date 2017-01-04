package com.baobaotao.web;

import com.baobaotao.domain.User;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by gzx on 16-11-21.
 */
public class UserListPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline;filename=" + new String("用户列表.pdf".getBytes(), "iso8859-1"));
        List<User> userList = (List<User>)model.get("userList");
        //创建一个3列的表格，且表格最后被添加到pdf视图document中
        Table table = new Table(3);
        //设置table自己的属性
        table.setWidth(80);
        table.setBorder(1);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        // 创建用于中文字符的字体格式，注意中文字符必须用中文字段构造
        BaseFont cnBaseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
        Font cnFont = new Font(cnBaseFont, 10, Font.NORMAL, Color.BLUE);
        table.addCell(buildFontCell("账号", cnFont));
        table.addCell(buildFontCell("姓名", cnFont));
        table.addCell(buildFontCell("密码", cnFont));
        // 一行三列
        for(User user : userList){
            table.addCell(user.getUserName());
            table.addCell(buildFontCell(user.getRealName(), cnFont));
            table.addCell(user.getPassword());
        }
        //将table对象添加到pdf视图中
        document.add(table);
    }

    //中文字符构造自己的cell
    private Cell buildFontCell(String content, Font font){
        Phrase phrase = new Phrase(content, font);
        try {
            return new Cell(phrase);
        } catch (BadElementException e) {
            e.printStackTrace();
        }
        return null;
    }
}
