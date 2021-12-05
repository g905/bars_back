<%--
    Document   : test
    Created on : Jun 4, 2020, 2:53:35 PM
    Author     : zharnikov
--%>

<%@page import="ru.g905.model.TestModel"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Model World!</h1>
        <a href="/demo">go to test</a>
        <table style="border: 1px solid gray">
            <tr>
                <td>${testModel.getName()}</td>
            </tr>
        </table>

        <p>Today <%= new java.util.Date()%></p>
    </body>
</html>
