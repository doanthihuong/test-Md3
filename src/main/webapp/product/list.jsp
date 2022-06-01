<%--
  Created by IntelliJ IDEA.
  User: chopp
  Date: 6/1/2022
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1> danh sách sản phẩm</h1>--%>
<%--<c:forEach var="pr" items="${prod}">--%>
<%--    <h2>${pr.id}, ${pr.name},${pr.price},${pr.quantity},${pr.color},${pr.category.name}</h2>--%>
<%--</c:forEach>--%>
<%--</body>--%>

<%--</html>--%>


<%----%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
          crossorigin="anonymous">
</head>
<body>
<%--<form action="/lops" method="get">--%>
<div class="container">
    <div class="row">
        <div class="col-12"><nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">HOME</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a href="#"></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Students?action=create">Add Student</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled">Disabled</a>
                    </li>
                </ul>
                <form method="post">
                    <input type="text" name="name" placeholder="ten can tim">
                    <button>Tìm</button>
                </form>

            </div>
        </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <h3 style="text-align: center"> Danh Sách sản phẩm</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Color</th>
                    <th scope="col">Category</th>
                    <th scope="col">Action</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach var="pr" items="${prod}">
                    <tr>
                        <td>${pr.id}</td>
                        <td>${pr.name}</td>
                        <td>${pr.price}</td>
                        <td>${pr.quantity}</td>
                        <td>${pr.color}</td>
                        <td>${pr.category.name}</td>
                        <td>
                            <a class="btn btn-primary" href="/ProductS?action=view&id=${pr.id}">View</a>
                            <a class="btn btn-secondary">Sửa</a>
                            <a class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>


<%--                            <form action="/Students" method="get" id="delete${pr.id}" style="display: inline">--%>
<%--                                <input type="hidden" name="action" value="delete">--%>
<%--                                <input type="hidden" name="id" value="${pr.id}">--%>
<%--                                <a class="btn btn-danger" onclick="xacNhanDelete(${pr.id})">Xoá</a>--%>

<%--                            </form>--%>


                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    function xacNhanDelete(id) {
        if (confirm("Bạn có chắc muốn xoá?")) {
            document.getElementById("delete"+id).submit();
        }
    }
</script>

</body>
</html>

