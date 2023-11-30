<%-- 
    Document   : score
    Created on : 21 лист. 2023 р., 21:04:43
    Author     : Oksana
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scores</title>
        <style>
            h1{
                text-align: center;
            }
            #page {
                width: 800px;
                margin: auto;
            }
            form {
                width: 400px;
                margin: 20px auto;
            }
            input[type=submit] {
                margin: auto;
            }
            .list, .list td, .list th {
                margin: auto;
                border: 1px solid black;
                border-collapse: collapse;
            }
            .list td, .list th {
                padding:10px;
            }
            body {
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: 100% 100%;
            }
            #content{
                background-color: lightblue;
                width: 600px;
                margin: 20px auto;
            }
        </style>
           </head>
    <body>
        <h1>Scores of <c:out value="${user.getId()}"/> <c:out value="${user.getName()}"/> <c:out value="${user.getSurname()}"/></h1>
        
        <div id="content">
            <table class="list">
                <tr>
                    <th>Discipline</th>
                    <th>Score</th>
                    <th>ECTS</th>
                </tr>
                <c:forEach var="disc" items="${scores}">
                    <tr>
                        <td><c:out value="${disc.getTitle()}"/></td>
                        <td><c:out value="${disc.getScore_num()}"/></td>
                        <td><c:out value="${disc.getScore_l()}"/></td>
                    </tr>
                </c:forEach>
            </table>
    </div>
    </body>
</html>