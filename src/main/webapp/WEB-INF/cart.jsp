<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<html xmlns="http://www.w3.org/1999/xhtml">
    <ul class="nav justify-content-end">
      <li class="nav-item">
        <a class="nav-link active" href="/">Admin</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="user">User</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cart">Cart</a>
      </li>
    </ul>

<table class="table table-hover" style="margin: 2em; max-width:700px">
    <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Quantity</th>
          <th scope="col">Price</th>
          <th scope="col">Action</th>
        </tr>
     </thead>
    <tbody>
        <c:forEach items="${cart.getProducts()}" var="product">
        <tr>
        <td>${product.getProductName()}</td>
        <td>${product.getProductQuantity()}</td>
        <td>${product.getProductPrice()}</td>
        <td>
        <a href="deleteFromCart?id=${product.id}"}><button class="btn btn-primary" value="delete" name="delete">Delete</button></a>
        </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<div style="min-width:50%;max-width:60%;margin-left:2em">
<div class="alert alert-dark" role="alert">
  Cart total: <b>$${cartTotal}</b>
</div>
</div>
</html>