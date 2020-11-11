<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PShynn
  Date: 11/11/2020
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-3">
            <button type="button" class="btn btn-secondary"><a href="/product">Home</a></button>
        </div>
        <div class="col-10">
        </div>
    </div>
    <form action="/product?action=createNewProduct" method="post">
        <div class="form-group">
            <label for="inputProductName">Product Name</label>
            <input type="text" class="form-control" name="productName"
                   id="inputProductName"
                   placeholder="Enter product name...">
        </div>
        <div class="form-group">
            <label for="inputPrice">Price</label>
            <input type="number" class="form-control" name="price" id="inputPrice"
                   placeholder="Enter price...">
        </div>
        <div class="form-group">
            <label for="inputAmount">Amount</label>
            <input type="number" class="form-control" name="amount" id="inputAmount"
                   placeholder="Enter amount...">
        </div>
        <div class="form-group">
            <label for="inputColor">Color</label>
            <input type="text" class="form-control" name="color" id="inputColor"
                   placeholder="Enter color...">
        </div>
        <div class="form-group">
            <label for="inputDescription">Description</label>
            <textarea type="text" class="form-control" name="description"
                      id="inputDescription"
                      placeholder="Enter description..."></textarea>
        </div>
        <div class="form-group">
            <label for="inputCategory">Category</label>
            <select class="form-control" id="inputCategory"
                    name="categoryID">
                <c:forEach items="${list}" var="category">
                    <option value="${category.getCategoryID()}"><c:out value="${category.getCategoryName()}"/></option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>
