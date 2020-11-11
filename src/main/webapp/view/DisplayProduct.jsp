<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PShynn
  Date: 11/11/2020
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-2">
            <button type="button" class="btn btn-secondary"><a href="/product?action=createProduct">Add New Product</a></button>
        </div>
        <div class="col-6">
            <div class="col-2">
                <button type="button" class="btn btn-secondary"><a href="/product">Home</a></button>
            </div>
        </div>
        <div class="col-4">
            <form class="form-inline" action="/product?action=searchProduct" method="post">
                <label class="sr-only" for="productName">Product Name</label>
                <input type="text" class="form-control mb-2 mr-sm-2" id="productName" name="productName" placeholder="Enter product name...">
                <button type="submit" class="btn btn-primary mb-2">Search</button>
            </form>
        </div>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">ProductName</th>
            <th scope="col">Price</th>
            <th scope="col">Amount</th>
            <th scope="col">Color</th>
            <th scope="col">Description</th>
            <th scope="col">Category</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="product">
            <tr>
                <th scope="row"><c:out value="${product.getProductID()}"/></th>
                <td><c:out value="${product.getProductName()}"/></td>
                <td><c:out value="${product.getPrice()}"/></td>
                <td><c:out value="${product.getAmount()}"/></td>
                <td><c:out value="${product.getColor()}"/></td>
                <td><c:out value="${product.getDescription()}"/></td>
                <td><c:out value="${product.getCategory().getCategoryName()}"/></td>
                <td>
                    <a href="/product?action=editProduct&&productID=${product.getProductID()}">Edit</a>
                    <a href="/product?action=deleteProduct&&productID=${product.getProductID()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
