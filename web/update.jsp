<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/6
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="update" method="post">
    <table align="center">
        <tr>
            <td>标题</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>时间</td>
            <td><input type="text" name="ctime"></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" name="type"></td>
        </tr>
        <tr>
            <td>状态</td>
            <td><input type="text" name="stas"></td>
        </tr>

        <tr>
            <td align="center" colspan="2">
                <input type="submit" name="提交修改">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
