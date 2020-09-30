<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/7/29
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- session 的用session域sessionScope --%>
    <h1>session数据：${sessionScope.username}</h1>
    <h1>request数据：${username}</h1>
</body>
</html>
