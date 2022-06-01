<%--
  Created by IntelliJ IDEA.
  User: chopp
  Date: 6/1/2022
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> danh sách category</h1>
<c:forEach var="ct" items="${cate}">
    <h2> ${ct.name}</h2>
</c:forEach>
</body>
</html>
