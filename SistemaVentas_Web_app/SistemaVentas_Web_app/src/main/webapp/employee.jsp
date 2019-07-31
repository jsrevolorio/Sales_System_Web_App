<%-- 
    Document   : Employee
    Created on : 15/07/2019, 08:46:07 AM
    Author     : scorpion
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/efcaf1f395.js"></script>
    <title>JSP Page</title>
</head>

<body>
    <div class="d-flex">
        <div class="card col-sm-4">
            <div class="card-body">
                <form action="EmployeeController?menu=employee" method="POST">
                    <div class="form-group">
                        <label for="">DPI:</label>
                        <input type="text" value="${employee.getDpi()}" name="dpi" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Nombre:</label>
                        <input type="text" value="${employee.getName()}" name="name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Telefono:</label>
                        <input type="text" value="${employee.getPhone()}" name="phone" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Estado:</label>
                        <input type="text" value="${employee.getState()}" name="state" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Usuario:</label>
                        <input type="text" value="${employee.getUser()}" name="user" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Password:</label>
                        <input type="password" name="password" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for=""> Repita el Password:</label>
                        <input type="password" name="pass" class="form-control">
                    </div>
                    <button type="submit" name="accion" value="agregar" class="btn btn-info"
                        style="color: black;"><Span><i class="fas fa-user-plus"></i></Span> Agregar</button>
                    <button type="submit" name="accion" value="actualizar" class="btn btn-success"
                        style="color: black;"><Span><i class="fas fa-user-edit"></i></Span> Actualizar</button>
                </form>
            </div>
        </div>
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DPI</th>
                        <th>Nombre</th>
                        <th>Telefono</th>
                        <th>Estado</th>
                        <th>Usuario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${listEmployee}">
                        <tr>
                            <td>${employee.getId_employee()}</td>
                            <td>${employee.getDpi()}</td>
                            <td>${employee.getName()}</td>
                            <td>${employee.getPhone()}</td>
                            <td>${employee.getState()}</td>
                            <td>${employee.getUser()}</td>
                            <td>
                                <form action="EmployeeController?menu=employee" method="POST">
                                    <input type="hidden" name="id" value="${employee.getId_employee()}">
                                    <button type="submit" name="accion" value="editar" class="btn btn-warning"
                                        style="color: black;"><Span><i class="fas fa-edit"></i></Span></button>
                                    <button type="submit" name="accion" value="eliminar" class="btn btn-danger"
                                        style="color: black;"><Span><i class="fas fa-trash-alt"></i></Span></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>