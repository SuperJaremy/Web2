<%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 13.11.2020
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Таблица</title>
    <style>
        table,th,td{
            border: 1px solid black;
            margin: auto;
            text-align: center;
            table-layout: fixed;
        }
        td,th{
            width: 170px;
            text-wrap: normal;
            word-wrap: break-word;
        }
    </style>
</head>
<body>
    <jsp:useBean id="table" class="Model.Table" scope="session"/>
    ${table.table}
<form action="controller" method="post">
    <input type="submit" value="Вернуться">
</form>
</body>
</html>
