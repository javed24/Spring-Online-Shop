<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<html xmlns="http://www.w3.org/1999/xhtml">
<form:form modelAttribute="product"  style="margin: 2em; max-width:700px">
            <h4>Edit Product Form</h4>
                              <div class="form-group">
                                <label  for="ProductName">Name</label>
                                <form:input path="productName" class="form-control"/>
                              </div>

                              <div class="form-group">
                                <label for="productQty">Quantity</label>
                                <form:input path="productQuantity" class="form-control" />
                              </div>
                               <div class="form-group">
                                  <label  for="productPrice">Price</label>
                                  <form:input path="productPrice" class="form-control" />
                               </div>
                            <button type="submit" class="btn btn-primary">Add</button>
        </form:form>
</html>