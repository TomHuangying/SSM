<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/8/5
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>rest接口测试页面</title>
</head>
<body>
查许数据：<a href="book/123">查询</a>
<br/>
新增数据:
<form action="book" method="post">
    书名:<input name="name" type="text"/>
    作者: <input name="authdr" type="text"/>
    <input type="submit" value="提交">
</form>
<br/>
删除数据:
<form action="book/321" method="post">
    <%--  type=hidden是隐藏的输入框，可以传递隐藏参数
      过滤器会检测请求中是否含有_method参数，如果有，过滤器则会把该请求的请求方式
      转换成对应的value中指定的请求方式
                          参数名一样，用method = RequestMethod.DELETE 区分--%>
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除">
</form>

修改数据:
<form action="book/567" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="修改">
</form>
</body>
</html>
