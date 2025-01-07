<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container mt-3">
        <h3>User manager</h3>
        <a href="/admin/user/add" class="btn btn-primary">Thêm mới</a>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Address</th>
                    <th>Date of birth</th>
                    <th>Job</th>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Role</th>   
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items = "${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.address}</td>
                    <td>${user.dob}</td>
                    <td>${user.job}</td>
                    <td>${user.name}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.role.name}</td>
                    <td>
                        <a href="/admin/user/edit/${user.id}" class="btn btn-warning">Sửa</a>
                        <a href="/admin/user/delete/${user.id}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>