<%--
    Document   : test
    Created on : Jun 4, 2020, 2:53:35 PM
    Author     : zharnikov
--%>

<%@page import="ru.g905.spring.model.TestModel"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test = "${!empty testModel.getName()}">
            <title>Edit Page</title>
        </c:if>
        <c:if test = "${empty testModel.getName()}">
            <title>Add Page</title>
        </c:if>
    </head>
    <body>
        <h1>Hello Edit Model World!</h1>
        <c:if test = "${!empty testModel.getName()}">
            <c:url value = "/edit" var = "var"/>
        </c:if>
        <c:if test = "${empty testModel.getName()}">
            <c:url value = "/add" var = "var"/>
        </c:if>


        <form action = "${var}" method = "POST">
            <c:if test = "${!empty testModel.getName()}">
                <input type = "hidden" name = "id" value = "${testModel.getId()}">
            </c:if>
            <label for="name">Name</label>
            <input type="text" name="name" id="name" value = "${testModel.getName()}">
            <br>
            <label for="number">Number</label>
            <input type="text" name="number" id="number" value = "${testModel.getNumber()}">
            <br>
            <label for="cool">Cool?</label>
            <input type="checkbox" name="cool" id="cool" ${testModel.getCool() ? 'checked' : ''}>
            <br>
            <input type="submit" value="Perform action">
        </form>

        <p>Today <%= new java.util.Date()%></p>
    </body>
</html>
