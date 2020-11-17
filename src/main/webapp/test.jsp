<%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 13.11.2020
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<jsp:useBean id="test" class="Model.Test" scope="session"/>
    <p>
        ${test.name}
    </p>
    <p>
        ${test.employed}
    </p>
</body>
</html>
