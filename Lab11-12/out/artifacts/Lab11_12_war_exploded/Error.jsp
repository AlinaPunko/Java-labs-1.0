<%--
  Created by IntelliJ IDEA.
  User: Alina
  Date: 03.06.2019
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%@include file="Header.jsp"%>

<h1>Oops...</h1>
<p>Sorry, an error occurred.</p>
<p>Here is the exception stack trace: </p>
<pre><% exception.printStackTrace(response.getWriter()); %></pre>

<%@include file="Footer.jsp"%>
</body>
</html>

