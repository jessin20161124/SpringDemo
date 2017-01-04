<%--
  Created by IntelliJ IDEA.
  User: gzx
  Date: 16-11-19
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <title>新增用户</title>
</head>
<body>
    <form method="post" action="<c:url value="/user.html"/>">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="realName"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
