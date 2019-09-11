<%--
  Created by IntelliJ IDEA.
  User: Alina
  Date: 05.06.2019
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%--<%@ taglib uri="http://java.sun.com/jstl/xml" prefix="x" %>--%>
<html>
<body>
<c:out value="JSTL подключена"/>
<c:set var="user" value="guest" scope="page"/>
<c:if test="${ not empty user and user eq 'guest' }">
    User is Guest
</c:if>
<c:remove var="user"/>
<c:set var="number" value="50"/>
<c:choose>
    <c:when test="${ number > 10 }" >
        <c:out value="число ${ number } больше 10"/>
    </c:when>
    <c:when test="${ number > 40 }" >
        <c:out value="число ${ number } больше 40"/>
    </c:when>
    <c:when test="${ number > 60 }" >
        <c:out value="число ${ number } больше 60"/>
    </c:when>
    <c:otherwise>
        <c:out value="число ${ number } меньше 10"/>
    </c:otherwise>
</c:choose>
<c:set var="number" value="7.1" scope="session" />
<c:catch var="formatException">
    <c:if test="${number < 9}">
        <c:out value="Number ${ number }" /> меньше чем (9)
    </c:if>
</c:catch>
<br/>
<c:if test="${not empty formatException }">
    Неверный тип : <c:out value="${ number }" />
    <br /><hr />
    Сгенерировано исключение
    <hr />
    ${ formatException }
</c:if>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:setLocale value="en-EN"/>
Вывод даты в формате English<br/>
Сегодня: <fmt:formatDate value="${now}" /><br/>
<fmt:setLocale value="ru-RU"/>
Вывод даты в формате Russian<br/>
Сегодня: <fmt:formatDate value="${now}" /><br/>
Стиль времени:
(short): <fmt:formatDate value="${now}"
                         type="time" timeStyle="short" /><br/>
(medium):<fmt:formatDate value="${now}"
                         type="time" timeStyle="medium" /><br/>
(long): <fmt:formatDate value="${now}"
                        type="time" timeStyle="long" /><br/>
<br/>
<sql:setDataSource var = "snapshot" driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver" url = "jdbc:jtds:sqlserver://ALINA-ПК/Lab10J;instance=SQLEXPRESS"/>

<sql:query dataSource = "${snapshot}" var = "result">
    SELECT * from Users;
</sql:query>

<table border = "1" width = "100%">
    <tr>
        <th>login</th>
        <th>password</th>
    </tr>

    <c:forEach var = "row" items = "${result.rows}">
        <tr>
            <td> <c:out value = "${row.login}"/></td>
            <td> <c:out value = "${row.password}"/></td>
        </tr>
    </c:forEach>

</table>
<c:set var="user" value="alina" scope="page"/>
<c:out value="${fn:toUpperCase(user)}"/>
<%--Please enter an XML file:--%>
<%--<br />--%>

<%--<form method="post">--%>
<%--    <textarea rows="10" cols="50" name="xml">--%>
<%--      <students>--%>
<%--        <student id="1">--%>
<%--          <name>--%>
<%--            <first>John</first>--%>

<%--            <last>Smith</last>--%>

<%--            <middle>T</middle>--%>
<%--          </name>--%>

<%--          <grade>--%>
<%--            <points>88</points>--%>

<%--            <letter>B</letter>--%>
<%--          </grade>--%>
<%--        </student>--%>

<%--        <student id="2">--%>
<%--          <name>--%>
<%--            <first>James</first>--%>

<%--            <last>Smith</last>--%>

<%--            <middle>K</middle>--%>
<%--          </name>--%>

<%--          <grade>--%>
<%--            <points>92</points>--%>

<%--            <letter>A</letter>--%>
<%--          </grade>--%>
<%--        </student>--%>

<%--        <student id="3">--%>
<%--          <name>--%>
<%--            <first>Kelly</first>--%>

<%--            <last>Lane</last>--%>

<%--            <middle>A</middle>--%>
<%--          </name>--%>

<%--          <grade>--%>
<%--            <points>72</points>--%>

<%--            <letter>C</letter>--%>
<%--          </grade>--%>
<%--        </student>--%>
<%--      </students>--%>
<%--    </textarea>--%>

<%--    <br />--%>

<%--    <input type="submit" />--%>
<%--</form>--%>

<%--<c:if test="${pageContext.request.method=='POST'}">--%>

<%--    <x:parse var="doc" xml="${param.xml}"  />--%>

<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <td>$doc/students/student/name/first</td>--%>

<%--            <td>--%>
<%--                <x:out select="$doc/students/student/name/first" />--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>$doc/students/student[@id=2]/name/first</td>--%>

<%--            <td>--%>
<%--                <x:out select="$doc/students/student[@id=2]/name/first" />--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>$doc/students/student[@id=1]/name/first</td>--%>

<%--            <td>--%>
<%--                <x:out select="$doc/students/student[@id=12]/name/first" />--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</c:if>--%>
<%--<%@ taglib prefix="pnvtdl" uri="customtags" %>--%>

</body>
</html>
