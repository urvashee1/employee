<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add Employee</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>

<body>
    <div class="container my-5">
        <h3> Add Employee</h3>
        <div class="card">
            <div class="card-body">
                <div class="col-md-10">
                    <form action="saveemployee" th:action="@{/createEmployee}" th:object="${employee}" method="post">
                        <div class="row">
                            <div class="form-group col-md-8">
                                <label for="firstname" class="col-form-label">First Name</label> 
                                <input type="text" th:field="*{firstName}" class="form-control" 
                                            id="firstName" placeholder="First Name" />
                            </div>
                             <div class="form-group col-md-8">
                                <label for="lastname" class="col-form-label">Last Name</label> 
                                <input type="text" th:field="*{lastName}" class="form-control" 
                                            id="lastName" placeholder="Last Name" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="title" class="col-form-label">Job Title</label> 
                                <input type="text" th:field="*{jobTitle}" class="form-control" 
                                            id="jobTitle" placeholder="Job Title" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="email" class="col-form-label">Email</label> 
                                <input type="text" th:field="*{email}" class="form-control" 
                                            id="email" placeholder="Email Id" />
                            </div>
                           <div class="form-group col-md-8">
                                <label for="number" class="col-form-label">Contact No</label> 
                                <input type="text" th:field="*{contactNo}" class="form-control" 
                                            id="contactNo" placeholder="Contact No" />
                            </div>
                            
                            <div class="form-group col-md-8">
                                <label for="email" class="col-form-label">Address</label> 
                                <input type="text" th:field="*{address}" class="form-control" 
                                            id="address" placeholder="Address" />
                            </div>
                            
                            <div class="form-group col-md-8">
                                <label for="experience" class="col-form-label">Experience</label> 
                                <input type="text" th:field="*{experience}" class="form-control" 
                                            id="experience" placeholder="Experience" />
                            </div>
                            
                            <div class="form-group col-md-8">
                                <label for="typeOfEmployee" class="col-form-label">TypeOfEmployee</label> 
                                <input type="text" th:field="*{typeOfEmployee}" class="form-control" 
                                            id="typeOfEmployee" placeholder="TypeOfEmployee" />
                            </div>
                            <div class="col-md-6">
                                <input type="submit" class="btn btn-primary" value=" Submit ">
                            </div>

                            <input type="hidden" id="id" th:field="*{id}">
    
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>