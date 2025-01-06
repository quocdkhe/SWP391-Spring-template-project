<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Create New User</h2>
        <!-- Spring form tag with modelAttribute="user" -->
        <form:form action="/admin/user/add" method="post" modelAttribute="user">
            
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <form:input path="name" id="name" class="form-control" placeholder="Enter your name"  />
            </div>

            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <form:input path="username" id="username" class="form-control" placeholder="Enter a username"  />
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <form:password path="password" id="password" class="form-control" placeholder="Enter a password"  />
            </div>

            <div class="mb-3">
                <label for="dob" class="form-label">Date of Birth</label>
                <form:input path="dob" id="dob" type="date" class="form-control"  />
            </div>

            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <form:input path="address" id="address" class="form-control" placeholder="Enter your address"  />
            </div>

            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <form:input path="phoneNumber" id="phoneNumber" class="form-control" placeholder="Enter your phone number"  />
            </div>

            <div class="mb-3">
                <label for="job" class="form-label">Job</label>
                <form:input path="job" id="job" class="form-control" placeholder="Enter your job"  />
            </div>
            
            <div class="mb-3">
                <label for="role" class="form-label">Role</label>
                <form:select path="role.name" class="form-control">
                    <form:option value="Admin">Admin</form:option>
                    <form:option value="User">User</form:option>
                </form:select>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</body>
</html>

