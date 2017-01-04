<%--
  Created by IntelliJ IDEA.
  User: gzx
  Date: 16-11-21
  Time: 下午5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请上传个人头像</title>
</head>
<body>
    <h1>请上传个人头像</h1>
    <form method="post" action="upload.html" enctype="multipart/form-data">
        <input type="text" name="name"/>
        <input type="file" name="file"/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
