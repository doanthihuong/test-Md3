<%--
  Created by IntelliJ IDEA.
  User: chopp
  Date: 6/1/2022
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    <h5>id</h5>
    <input class="form-control" type="text" name="id" placeholder="id">
    <h5> Product of name: </h5>
    <input class="form-control" type="text" name="name" placeholder="name">
    <h5> Price: </h5>
    <input class="form-control" type="text" name="price" placeholder="price">
    <h5> Quantity: </h5>
    <input class="form-control" type="text" name="quantity" placeholder="quantity">
    <h5> Color: </h5>
    <input class="form-control" type="text" name="color" placeholder="color">
    <h5> Description: </h5>
    <input class="form-control" type="text" name="description" placeholder="description">
    <h5> CategoryId: </h5>
    <select class="form-control" name="categoryId">
        <c:forEach var="ct" items="${cate}">
            <option value="${ct.id}">${ct.name}</option>
        </c:forEach>
    </select>
    <button> Add</button>


</form>
</body>
</html>
