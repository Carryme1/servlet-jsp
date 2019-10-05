<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/5
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户登陆</title>
  </head>
  <body>
  <div align="center">
    <form action="index" method="post">
      <table border="1">

        <tr>
          <td>账号</td>
          <td><input type="text" name="uname"></td>
        </tr>

        <tr>
          <td>密码</td>
          <td><input type="password" name="upwd"></td>
        </tr>

        <tr>
          <td align="center" colspan="2"><input type="submit" value="登陆"></td>
        </tr>
          <td align="center" colspan="2">
            <a href="register">用户注册</a>
            <a href="reset">密码修改</a>
          </td>
        <tr>

        </tr>



      </table>
    </form>

  </div>
  </body>
</html>
