<%@ page import="com.example.hien_thi_danh_sach_khach_hang.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    List<Person> personList = new ArrayList<>();
    personList.add(new Person("Mai Van Hoan", "1983-08-20", "Ha Noi"));
    personList.add(new Person("Nguyen Van Nam", "1983-08-21", "Bac Giang"));
    personList.add(new Person("Nguyen Thai Hoa", "1983-08-22", "Nam Dinh"));
    personList.add(new Person("Tran Dang Khoa", "1983-08-17", "Ha Tay"));
    personList.add(new Person("Nguyen Dinh Thi", "1983-08-19", "Ha Noi"));
%>

<h1>Danh sach khach hang</h1>
<table>
    <thead>
    <tr>
        <td>Ten</td>
        <td>Ngay sinh</td>
        <td>Dia chi</td>
        <td>Hinh anh</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="<%=personList%>" var="person">
        <tr>
            <td>${person.name}</td>
            <td>${person.dob}</td>
            <td>${person.address}</td>
            <td><img src="${person.img}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>