<%--
  Created by IntelliJ IDEA.
  User: gzx
  Date: 16-11-20
  Time: 下午9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <c:forEach items="${userList}" var = "user">
            <tr>
                <td>
                    <a href="<c:url value="/user/showUser/${user.userName}.html"/>">
                        ${user.userName}
                    </a>
                </td>
                <td>
                    ${user.realName}
                </td>
                <td>
                    ${user.password}
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
