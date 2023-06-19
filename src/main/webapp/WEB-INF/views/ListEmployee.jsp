<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>All Employees</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>

<body>
    <div class="container my-2">
    <div class="card">
    <div class="card-body">
        <div th:switch="${employees}" class="container my-5">
            <p class="my-5">
                <a href="newemployee" class="btn btn-primary">
                <i class="fas fa-user-plus ml-2"> Add Employee </i></a>
            </p>
            <div class="col-md-10">
                <h2 th:case="null">No record found !!</h2>
                <div th:case="*">
                    <table class="table table-striped table-responsive-md">
                        <thead>
                            <tr>
                                <th>EmpId</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Job Title</th>
                                <th>Email</th>
                                <th>Contact NO</th>
                                <th>Address</th>
                                <th>Experience</th>
                                <th>TypeOfEmployee</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                                <tr th:each="employee : ${employees}">
                                <td th:text="${employee.empId}"></td>
                                <td th:text="${employee.firstName}"></td>
                                   <td th:text="${employee.lastName}"></td>
                                <td th:text="${employee.jobTitle}"></td>
                                <td th:text="${employee.email}"></td>
                                   <td th:text="${employee.ContactNo}"></td>
                                <td th:text="${employee.address}"></td>
                                <td th:text="${employee.experience}"></td>
                                <td th:text="${employee.typeOfEmployee}"></td>
                                <td>
                         <a th:href="@{/edit/{id}(id=${employee.empId})}" class="btn btn-primary"><i class="fas fa-user-edit ml-2"></i></a></td>
                         <td><a th:href="@{/delete/{id}(id=${employee.empId})}" class="btn btn-primary"><i class="fas fa-user-times ml-2"></i></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
    </div>
    </div>
</body>

</html>