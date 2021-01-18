<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="<%= request.getContextPath() %>/display-discount" method="post">
    <label>Product Description</label>
    <input type="text" name="desc">
    <label>List Price</label>
    <input type="number" name="price" min="0" step=".01">
    <label>Discount Percent</label>
    <input type="number" name="discount" min="0" max="100" step=".01">
    <input type="submit" value="OK">
</form>
</body>
</html>