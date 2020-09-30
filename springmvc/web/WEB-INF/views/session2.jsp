<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/7/29
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>session数据: ${sessionScope.abc}</h1>
    <h1>session第二个数据数据: ${sessionScope.def}</h1>
    <h1>第三个session数据测试：${sessionScope.user.name}</h1>
    <%--用来验证，springmvc把request中的数据放到session中后，本身数据是否清除----还是有数据 --%>
    <h1>request数据: ${requestScope.abc}</h1>
    <h1>request数据: ${requestScope.def}</h1>
</body>
</html>
