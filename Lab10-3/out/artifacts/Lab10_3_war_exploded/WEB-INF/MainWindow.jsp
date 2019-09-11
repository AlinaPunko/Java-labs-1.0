<%--
  Created by IntelliJ IDEA.
  User: Alina
  Date: 02.06.2019
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello <%out.println(request.getAttribute("newusername").toString());%>  time on server <%out.println(request.getAttribute("date").toString());%>
</body>
</html>
