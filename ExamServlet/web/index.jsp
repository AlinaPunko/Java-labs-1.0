<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alina
  Date: 23.06.2019
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="TheServlet" method="post">
      phone
      <input type="text" name="phone">
      email
      <input type="text" name="email">
      <button type="submit">Submit</button>
  </form>

  <c:if test="${errorMessage ne null}">
      <h2>${errorMessage}</h2>
  </c:if>
  </body>
</html>
