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
            <td>编号<input type="hidden" name="id" value="${detail.id}"></td>
        </tr>
        <tr>
            <td>标题<input type="text" name="title" value="${detail.title}"></td>
        </tr>
        <tr>
            <td>作者<input type="text" name="author" value="${detail.author}"></td>
        </tr>
        <tr>
            <td>内容<input type="text" name="content" value="${detail.content}"></td>
        </tr>
        <tr>
            <td>时间<input type="text" name="ctime" value="${detail.ctime}"></td>
        </tr>
        <tr>
            <td>类型<input type="text" name="type" value="${detail.type}"></td>
        </tr>
        <tr>
            <td>状态<input type="text" name="stas" value="${detail.stat}"></td>
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
