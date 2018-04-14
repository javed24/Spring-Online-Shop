<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<h3>Edit Product Form</h3>
<form:form modelAttribute="product">
            <table border="0">

                <tr>
                    <td>Product Name:</td>
                    <td><form:input path="productName" /></td>
                </tr>
                <tr>
                    <td>Product Quantity:</td>
                    <td><form:input path="productQuantity" /></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><form:input path="productPrice" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Update" /></td>
                </tr>
            </table>
        </form:form>
</html>