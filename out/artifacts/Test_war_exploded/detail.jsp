<%--
  Created by IntelliJ IDEA.
  User: lvjun
  Date: 2018-03-22
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
    <title>详情</title>
</head>
<body>
<table border="1">
    <tr>
        <td colspan="3" align="center">${detail.title}</td>
    </tr>
    <tr>
        <td>${detail.author}</td>
        <td>${detail.ctime}</td>
        <td>${detail.type}</td>
    </tr>
    <tr>
        <td colspan="3">${detail.content}</td>
    </tr>
    <tr>
        <td colspan="3" align="center"><a href="/return">返回首页</a></td>
    </tr>
</table>
</body>
</html>
