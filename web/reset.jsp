<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/5
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<div align="center">
    <form action="reset" method="post">
        <table border="1">

            <tr>
                <td>账号</td>
                <td><input type="text" name="uname"></td>
            </tr>

            <tr>
                <td>旧密码</td>
                <td><input type="password" name="upwd"></td>
            </tr>
            <tr>
                <td>新密码</td>
                <td><input type="password" name="npwd"></td>
            </tr>

            <tr>
                <td align="center" colspan="2"><input type="submit" value="修改密码"></td>
            </tr>



        </table>
    </form>

</div>

</body>
</html>
