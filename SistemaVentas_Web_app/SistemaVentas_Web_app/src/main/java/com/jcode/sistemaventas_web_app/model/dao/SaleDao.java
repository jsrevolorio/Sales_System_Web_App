/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.model.dao;

import com.jcode.sistemaventas_web_app.configuration.DBConexion;
import com.jcode.sistemaventas_web_app.model.dto.Sale;
import com.jcode.sistemaventas_web_app.model.dto.Sale_Detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author scorpion
 */
public class SaleDao {

    public String generateSerial() {

        String serialNumber = null;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "SELECT MAX(serial_Number) FROM sales";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                serialNumber = resultSet.getString("MAX(serial_Number)");
            }

            connection.close();

        } catch (SQLException e) {

        }

        return serialNumber;

    }

    public int SaleById() {

        int saleId = 0;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "SELECT MAX(id_Sales) FROM sales";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                saleId = resultSet.getInt("MAX(id_Sales)");
            }

            connection.close();

        } catch (SQLException e) {

        }

        return saleId;
    }

    public boolean addSale(Sale sale) {

        boolean resultado;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "INSERT INTO sales (id_Client, id_Employee, serial_Number, sale_Date, total_Price, state) VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sale.getClient().getId_Client());
            preparedStatement.setInt(2, sale.getEmployee().getId_employee());
            preparedStatement.setString(3, sale.getSerial_Number());
            preparedStatement.setString(4, sale.getSale_Date());
            preparedStatement.setFloat(5, sale.getTotal_Price());
            preparedStatement.setString(6, sale.getState());

            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            System.out.println(e);
            resultado = false;
        }

        System.out.println(sale.getClient().getId_Client() + " " + sale.getEmployee().getId_employee() + " "+ sale.getSerial_Number() + " "+ sale.getSale_Date()+ " "+ sale.getTotal_Price());
        return resultado;
    }

    public boolean addSaleDetail(Sale_Detail saleDetail) {
        boolean resultado = false;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "INSERT INTO sale_detail (id_Sales, id_Product, quantity, SubTotal) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, saleDetail.getId_Sale());
            preparedStatement.setInt(2, saleDetail.getProduct().getId_Product());
            preparedStatement.setInt(3, saleDetail.getQuantity());
            preparedStatement.setDouble(4, saleDetail.getSubTotal());
            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            System.out.println(e);
            resultado = false;
        }

        System.out.println(saleDetail.getId_Sale()+" "+ saleDetail.getProduct().getName() + " "+ saleDetail.getQuantity()+" " + saleDetail.getSubTotal());
        
        return resultado;
    }

}
