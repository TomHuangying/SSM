<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/7/24
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数测试</title>
</head>
<body>
<%--              参数传递   --%>
    <a href="testParam1?name=abc&age=23">第一种参数的接受方式</a><br/>
    <a href="testParam2?id=123">第二种参数的接受方式</a><br/>
    <a href="testParam3?id=123&name=asd">第三种参数的接受方式</a><br/>
    <a href="testParam4?name=zhangsan&age=22&phone=151&address=bj&a=123">第四种参数接收方式</a> <br/>
    <a href="testParam5?n=zzzz">第五种参数接收方式</a>  <br/>
<a href="/springmvc_test2_war_exploded/testParam6/1234">第六种参数接收方式</a>  <br/>
<a href="/springmvc_test2_war_exploded/testParam7/1234/abcd">第七种参数接收方式</a>  <br/>
</body>
</html>
