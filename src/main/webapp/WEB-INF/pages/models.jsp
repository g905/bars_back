<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="<c:url value = "/assets/style.css"/>" rel = "stylesheet" type="text/css">

    </head>
    <body>
        <h1>Hello Models World!</h1>
        <a href="test">go to test</a>
        <br>
        <br>

        <table>
            <caption>List of models</caption>
            <tr>
                <th>ID</th>
                <th>Number</th>
                <th>Name</th>
                <th>Cool?</th>
                <th>Created at</th>
                <th>Updated at</th>
                <th></th>
            </tr>
            <c:forEach var="model" items="${modelsList}">
                <tr>
                    <td>${model.getId()}</td>
                    <td><a href="/spring/edit/${model.getId()}">${model.getNumber()}</a></td>
                    <td><a href="/spring/edit/${model.getId()}">${model.getName()}</a></td>
                    <td>${model.getCool()}</td>
                    
                    <jsp:useBean id="createdValue" class="java.util.Date"/>
                    <jsp:setProperty name="createdValue" property="time" value="${model.getCreated_at()}"/>
                    
                    <td><fmt:formatDate value="${createdValue}" pattern="dd/MM/yyyy HH:mm"/></td>
                    <jsp:useBean id="updatedValue" class="java.util.Date"/>
                    <jsp:setProperty name="updatedValue" property="time" value="${model.getUpdated_at()}"/>
                    
                    <td><fmt:formatDate value="${updatedValue}" pattern="dd/MM/yyyy HH:mm"/></td>
                    <td class="delTD"><a class="btn delBtn" href="/spring/delete/${model.getId()}">&times;</a></td>
                </tr>
            </c:forEach>
            <tr class="bottomTR">
                <td colspan = "7"><a class="btn addBtn" href = "/spring/add/">Add model</a></td>
            </tr>
        </table>
        <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
            <c:url value="/" var="url">
                <c:param name="page" value="${i.index}"/>
            </c:url>
            <c:if test="${i.index ne page}">
                <a class="pageLink" href="${url}">${i.index}</a>
            </c:if>
            <c:if test="${i.index eq page}">
                ${i.index}
            </c:if>
        </c:forEach>

    </body>
</html>
