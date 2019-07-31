/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.model.dao;

import com.jcode.sistemaventas_web_app.configuration.DBConexion;
import com.jcode.sistemaventas_web_app.interfaces.IProduct;
import com.jcode.sistemaventas_web_app.model.dto.Product;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author scorpion
 */
public class ProductDao implements IProduct {

    @Override
    public List listAll(String dato) {

        ArrayList<Product> listProduct = new ArrayList<>();

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "call listProduct(?)";

            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, dato);

            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product(resultSet.getInt("id_Product"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("stock"),
                        resultSet.getString("state"));
                listProduct.add(product);
            }

            connection.close();

        } catch (SQLException e) {
        }

        return listProduct;
    }

    @Override
    public Product listById(int id) {

        Product product = new Product();

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "SELECT * FROM product WHERE id_Product = " + id;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                product.setId_Product(resultSet.getInt("id_Product"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                product.setStock(resultSet.getInt("stock"));
                product.setState(resultSet.getString("state"));
            }

            connection.close();

        } catch (SQLException e) {

        }

        return product;
    }

    @Override
    public boolean add(Product product) {

        boolean resultado;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "INSERT INTO product (name, price, stock, state) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getStock());
            preparedStatement.setString(4, product.getState());

            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean update(Product product) {

        boolean resultado;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "UPDATE product SET name = ?, price = ?, stock = ?, state =? WHERE id_Product = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getStock());
            preparedStatement.setString(4, product.getState());
            preparedStatement.setInt(5, product.getId_Product());

            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean delete(int id) {

        boolean resultado;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "DELETE FROM product WHERE id_Product = " + id;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

}
