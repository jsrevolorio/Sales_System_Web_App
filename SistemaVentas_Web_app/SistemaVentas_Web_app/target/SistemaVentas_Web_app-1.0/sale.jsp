<%-- 
    Document   : Sale
    Created on : 15/07/2019, 08:47:29 AM
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
        <style type="text/css">
            @media print{
                .parte1, .btn, .accion{
                    display: none;    
                }
            }
        </style>
    </head>

    <body>
        <div class="d-flex">
            <div class="col-sm-5 parte1">
                <div class="card">
                    <form action="SaleController?menu=sale" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="clientNit" value="${client.getNit()}" class="form-control" placeholder="No. Nit">
                                    <button type="submit" name="accion" value="searchClient" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="clientName" value="${client.getName()}" class="form-control" placeholder="Dato Cliente">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="productCode" value="${product.getId_Product()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="searchProduct" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="productName" value="${product.getName()}" class="form-control" placeholder="Datos Producto">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="price" value="${product.getPrice()}" class="form-control" placeholder="$/.0.00">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="Quantity" value="1" class="form-control" placeholder="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${product.getStock()}" class="form-control" placeholder="Stock">
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" name="accion" value="agregar" class="btn btn-outline-primary">Agregar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label for="">No.Serie:</label>
                            <input type="text" name="noSerie " value="${NoSerie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Contidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="sale" items="${listSale}">
                                    <tr>
                                        <td>${sale.getItem()}</td>
                                        <td>${sale.getProduct().getId_Product()}</td>
                                        <td>${sale.getProduct().getName()}</td>
                                        <td>${sale.getProduct().getPrice()}</td>
                                        <td>${sale.getQuantity()}</td>
                                        <td>${sale.getSubTotal()}</td>
                                        <td>
                                            <button class="btn btn-warning" >Editar</button>
                                            <button class="btn btn-danger" >Eliminar</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <form action="SaleController?menu=sale" method="POST">
                                <button type="submit" name="accion" value="addSale" onclick="print()"  class="btn btn-success">Generar Venta</button>
                            <button type="submit" name="accion" value="cancelar"  class="btn btn-danger">Cancelar</button>
                            </form>
                        </div>
                        <div class="col-sm-4  ml-auto">
                            <input type="text" name="total" value="$/ ${total}" class="form-control" >
                        </div>
                    </div>
                </div>
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