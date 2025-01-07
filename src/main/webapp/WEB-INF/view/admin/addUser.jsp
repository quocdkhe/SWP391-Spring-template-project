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
                <form:input cssErrorClass="form-control is-invalid" path="name" id="name" cssClass="form-control" placeholder="Enter your name" />
                <form:errors path="name" cssClass="invalid-feedback" /> 
            </div>


            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <form:input cssErrorClass="form-control is-invalid" path="username" id="username" cssClass="form-control" placeholder="Enter a username" />
                <form:errors path="username" cssClass="invalid-feedback" />
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <form:input type="password" cssErrorClass="form-control is-invalid" path="password" id="password" class="form-control" placeholder="Enter a password" />
                <form:errors path="password" cssClass="invalid-feedback" />
            </div>

            <div class="mb-3">
                <label for="dob" class="form-label">Date of Birth</label>
                <form:input cssErrorClass="form-control is-invalid" path="dob" id="dob" type="date" class="form-control" />
                <form:errors path="dob" cssClass="invalid-feedback" />
            </div>

            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <form:input cssErrorClass="form-control is-invalid" path="address" id="address" class="form-control" placeholder="Enter your address" />
                <form:errors path="address" cssClass="invalid-feedback" />
            </div>

            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <form:input cssErrorClass="form-control is-invalid" path="phoneNumber" id="phoneNumber" class="form-control" placeholder="Enter your phone number" />
                <form:errors path="phoneNumber" cssClass="invalid-feedback" />
            </div>

            <div class="mb-3">
                <label for="job" class="form-label">Job</label>
                <form:input cssErrorClass="form-control is-invalid" path="job" id="job" class="form-control" placeholder="Enter your job" />
                <form:errors path="job" cssClass="invalid-feedback" />
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

