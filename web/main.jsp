<%--
  Created by IntelliJ IDEA.
  User: lvjun
  Date: 2018-03-22
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
    <title>主页</title>
</head>
<body>
<form name="form1" action="main" method="post">
    <table border="1" align="center">
        <tr>
            <td> 欢迎：${uname }</td>
            <td>最新：${total}篇 </td>
            <td colspan="6"><a href="/insert">发布新闻</a></td>
            <td><a href="/index.jsp">安全退出</a></td>
        </tr>

        <tr>
            <th>编号</th>
            <th>标题</th>
            <th>作者</th>
            <th>时间</th>
            <th>类型</th>
            <th>状态</th>
            <th colspan="3">操作</th>
        </tr>
        <c:forEach items="${list }" var="list" varStatus="st">
            <tr>
                <td>${list.id }</td>
                <td>${list.title }</td>
                <td>${list.author }</td>
                <td>${list.ctime }</td>
                <td>
                    <c:if test="${list.type =='0' }">未分类</c:if>
                    <c:if test="${list.type =='1' }">原创</c:if>
                    <c:if test="${list.type =='2' }">转载</c:if>
                </td>
                <td>
                    <c:if test="${list.stat == '0' }">正常</c:if>
                    <c:if test="${list.stat == '1' }">已注销</c:if>
                </td>
                <td><a href="detail?id=${list.id }">详情</a></td>
                <td><a href="update?id=${list.id }">修改</a></td>
                <td><a href="delete?id=${list.id }">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="9" align="center">
                <a href="/page?start=0">[首  页]</a>  |
                <a href="/page?start=${pre}">[上一页]</a>   |
                <a href="/page?start=${next}">[下一页]</a>   |
                <a href="/page?start=${last}">[末  页]</a>
            </td>nmn
        </tr>

    </table>
</form>
</body>
</html>