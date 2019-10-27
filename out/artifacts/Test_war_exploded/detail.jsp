<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
<table border="1" align="center">
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
        <td colspan="3" align="center"><a href="return">返回首页</a></td>
    </tr>
</table>
</body>
</html>
