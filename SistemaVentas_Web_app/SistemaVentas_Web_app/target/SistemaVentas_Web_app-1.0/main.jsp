<%-- 
    Document   : index
    Created on : 14/07/2019, 06:38:37 PM
    Author     : scorpion
--%>

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
    <nav class="navbar navbar-expand-lg navbar-light bg-dark">
        <div class="collapse navbar-collapse" id="navbarNav" style="max-width: 97%; margin: 0 auto;">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a a style="margin-left: 10px; border:none;" class="btn btn-outline-light" href="HomeController?accion=home"  target="myframe" ><i class="fas fa-home"></i> Home</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border:none;" class="btn btn-outline-light"
                        href="ProductController?menu=product&accion=list" target="myframe"><i class="fas fa-briefcase"></i>
                        Producto</a>
                </li>
                <li class="nav-item">
                    <a a style="margin-left: 10px; border:none;" class="btn btn-outline-light"
                        href="EmployeeController?menu=employee&accion=list" target="myframe"><i
                            class="fas fa-user-friends"></i> Empleado</a>
                </li>
                <li class="nav-item">
                    <a a style="margin-left: 10px; border:none;" class="btn btn-outline-light"
                        href="ClientController?menu=client&accion=list" target="myframe"><i class="fas fa-users"></i>
                        Clientes</a>
                </li>
                <li class="nav-item">
                    <a a style="margin-left: 10px; border:none;" class="btn btn-outline-light"
                        href="SaleController?menu=sale&accion=default" target="myframe"><i class="fas fa-address-card"></i> Nueva
                        Venta</a>
                </li>
            </ul>
            <div class="dropdown">
                <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${user.getName()}
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#"> <img src="img/perfil.png" alt="60" width="60"> </a>
                    <a class="dropdown-item" href="#">${user.getUser()}</a>
                    <a class="dropdown-item" href="#">user@gmail.com</a>
                    <div class="dropdown-divider">
                    </div>
                    <form action="LoginController" method="POST">
                        <button name="accion" value="exit" class="dropdown-item" href="#">Salir</a>
                    </form>
                </div>
            </div>
        </div>
    </nav>
    <div class="m-4" style="height: 744px;">
        <iframe style="height: 100%; width: 100%;" name="myframe" frameborder="0"></iframe>
    </div>
    <footer id="sticky-footer" class="py-4 bg-dark text-white-50" style="color: white;">
        <div class="container text-center">
            <small>Copyright &copy; Your Website</small>
        </div>
    </footer>


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