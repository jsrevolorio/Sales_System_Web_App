<%-- 
    Document   : Client
    Created on : 15/07/2019, 08:45:03 AM
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
                <form action="ClientController?menu=client" method="POST">
                    <div class="form-group">
                        <label for="">No. Nit:</label>
                        <input type="text" value="${client.getNit()}"name="nit" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Nombre:</label>
                        <input type="text" value="${client.getName()}" name="name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Direccion:</label>
                        <input type="text" value="${client.getAddress()}" name="address" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Estado:</label>
                        <input type="text" value="${client.getState()}" name="state" class="form-control">
                    </div>
                    <!--<input type="hidden" name="id" value="client.getId_Client()">-->
                    <button type="submit" name="accion" value="agregar" class="btn btn-info"
                        style="color: black;"><Span><i class="fas fa-user-plus"></i></Span> Agregar</button>
                    <button type="submit" name="accion" value="actualizar" class="btn btn-success"
                        style="color: black;"><Span><i class="fas fa-user-edit"></i></Span> Actualizar</button>
                </form>
            </div>
        </div>
        <div class="col-sm-8">
            <form action="ClientController?menu=client" method="POST" style="display: flex; margin-bottom: 15px;"
                class="form-inline">
                <input type="search" name="text" class="form-control" style="width: 500px;">
                <button type="submit" name="accion" value="list" class="btn btn btn-outline-info"><Span><i
                            class="fas fa-search"></i></Span></button>
            </form>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>No. Nit</th>
                        <th>Nombre</th>
                        <th>Direccion</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="client" items="${listClient}">
                        <tr>
                            <td>${client.getId_Client()}</td>
                            <td>${client.getNit()}</td>
                            <td>${client.getName()}</td>
                            <td>${client.getAddress()}</td>
                            <td>${client.getState()}</td>
                            <td>
                                <form action="ClientController?menu=client" method="POST">
                                    <input type="hidden" name="id" value="${client.getId_Client()}">
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