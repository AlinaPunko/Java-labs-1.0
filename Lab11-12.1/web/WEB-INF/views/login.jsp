<%--
  Created by IntelliJ IDEA.
  User: Alina
  Date: 06.06.2019
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><font color="red">${errorLogin}</font></p>
<form
        action="${pageContext.servletContext.contextPath}/controller?command=login" method="POST">
    <p> Вход пользователя </p>
    <p> Введите имя : <input name="loginName" type="text" />
    </p>
    <p> Введите пароль : <input name="password" type="password" />
    </p>
    <input class ="button-main-page" type="submit" value="Вход"/>
</form>
</body>
</html>
