CREATE DATABASE almacen;

use almacen;


-- Tabla Clientes
-- -----------------------------------------------------------
CREATE TABLE `client` (
  `id_Client` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `nit`  varchar(13) DEFAULT NULL,
  `name` varchar(244) DEFAULT NULL,
  `address` varchar(244) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `client` ( `nit`, `name`, `address`, `state`) VALUES
( '4859623-1A', 'Juan Guerrero Solis', '12 calle 21-24 zona 12', '1'),
( '4589685-9A', 'Maria Rosas Villanueva', 'Recidenciales Petapa 12av 12-56', '1'),
( '5689826-9', 'Andres de Santa Cruz', '24 calle 18-25 Zona 1 La flores', '1'),
( '6541568-3B', 'Andres Mendoza', '15 calle 46-38 Zona 2 de Mixco', '1');

select * from  `client`;


-- Table producto
-- ----------------------------------------------------------
CREATE TABLE `product` (
  `id_Product` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` varchar(244) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int(11) UNSIGNED DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `product` (`name`, `price`, `stock`, `state`) VALUES
('Teclado Logitech 345 Editado', 150.5, 99, '1'),
('Mouse Logitech 567', 20.5, 98, '1'),
('Laptop Lenovo Ideapad 520', 800, 100, '1'),
('HeadPhones Sony M333', 500.5, 98, '1'),
('Producto Nuevo w', 22, 35, '1');

select * from product;

-- Table empleado
-- --------------------------------------------------------
CREATE TABLE `employee` (
  `id_Employee` int(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `dpi`  BIGINT(13) DEFAULT NULL,
  `password`  varchar(40) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(9) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  `user` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `employee` (`dpi`,`password`, `name`, `phone`, `state`, `User`) VALUES
(4859856874859, 'HolaMundo','Pedro Hernandez', '988252459', '1', 'emp01'),
(4856895968598, 'HolaTodos','Roman Riquelme', '988252459', '1', 'Jo46'),
(4858968958485, 'HolaCasa' ,'Palermo Suarez', '453536458', '1', 'Em22');

select * from employee;


-- Tabla Ventas 
-- --------------------------------------------------------
CREATE TABLE `sales` (
  `id_Sales` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `id_Client` int(11) NOT NULL,
  `id_Employee` int(10) NOT NULL,
  `serial_Number` varchar(244) DEFAULT NULL,
  `sale_Date` date DEFAULT NULL,
  `total_Price` double DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
   FOREIGN KEY(`id_Client`) REFERENCES `client`(`id_Client`),
   FOREIGN KEY(`id_Employee`) REFERENCES `employee`(`id_Employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from sales;

-- Detalle Venta 
-- ---------------------------------------------------------
CREATE TABLE `sale_detail` (
  `id_Sale_detail` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `id_Sales` int(11) NOT NULL,
  `id_Product` int(11) NOT NULL,
  `quantity` int(11) UNSIGNED DEFAULT NULL,
  `SubTotal` double DEFAULT NULL,
   FOREIGN KEY(id_Sales) REFERENCES  `sales`(`id_Sales`),
   FOREIGN KEY(id_Product) REFERENCES `product`(`id_Product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from sale_detail;


-- Procedimiento Almacenado Clientes

-- Buscar Clientes 
-- --------------------------------------------------------
delimiter $
CREATE PROCEDURE `listClient` ( in condicion varchar(244))
begin
 select * from  `client` where `name` like concat(condicion,'%') or `nit` like concat(condicion,'%');
end $

-- call listClient('');


-- Buscar Productos
-- --------------------------------------------------------

delimiter $
CREATE PROCEDURE `listProduct` ( in condicion varchar(244))
begin
 select * from  `product` where `name` like concat(condicion,'%') or `id_Product` like concat(condicion,'%');
end $



