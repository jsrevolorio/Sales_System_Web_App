/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.model.dao;

import com.jcode.sistemaventas_web_app.configuration.DBConexion;
import com.jcode.sistemaventas_web_app.interfaces.IClient;
import com.jcode.sistemaventas_web_app.model.dto.Client;
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
public class ClientDao implements IClient {

    @Override
    public List listAll(String datos) {

        ArrayList<Client> listClient = new ArrayList<>();

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "call listClient(?)";

            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, datos);

            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client(resultSet.getInt("id_Client"),
                        resultSet.getString("nit"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("state"));
                listClient.add(client);
            }

            connection.close();

        } catch (SQLException e) {
        }

        return listClient;
    }

    @Override
    public Client listById(int id) {

        Client client = new Client();

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "SELECT * FROM client WHERE id_Client = " + id;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                client.setId_Client(resultSet.getInt("id_Client"));
                client.setNit(resultSet.getString("nit"));
                client.setName(resultSet.getString("name"));
                client.setAddress(resultSet.getString("address"));
                client.setState(resultSet.getString("state"));
            }

            connection.close();

        } catch (SQLException e) {

        }

        return client;

    }

    @Override
    public boolean add(Client client) {

        boolean resultado;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "INSERT INTO client ( nit, name, address, state) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, client.getNit());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setString(4, client.getState());

            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

    @Override
    public boolean update(Client client) {

        boolean resultado;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "UPDATE client SET   nit = ?, name = ?, address = ?, state = ? WHERE id_Client = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, client.getNit());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setString(4, client.getState());
            preparedStatement.setInt(5, client.getId_Client());

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

            String query = "DELETE FROM client WHERE id_Client = " + id;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }

    public Client nitClient(String nit) {
        Client client = new Client();

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "SELECT * FROM client WHERE nit = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nit);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                client.setId_Client(resultSet.getInt("id_Client"));
                client.setNit(resultSet.getString("nit"));
                client.setName(resultSet.getString("name"));
                client.setAddress(resultSet.getString("address"));
                client.setState(resultSet.getString("state"));
            }

            connection.close();

        } catch (SQLException e) {

        }
        
        return client;
    }

}
