/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.model.dao;

import com.jcode.sistemaventas_web_app.configuration.DBConexion;
import com.jcode.sistemaventas_web_app.model.dto.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jcode.sistemaventas_web_app.interfaces.IEmployee;

/**
 *
 * @author scorpion
 */
public class EmployeeDao implements IEmployee {

    public Employee validate(String user, String password) {

        Employee employee = new Employee();

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "select * from employee where User =? and password = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employee.setId_employee(resultSet.getInt("id_Employee"));
                employee.setDpi(resultSet.getLong("dpi"));
                employee.setPassword(resultSet.getString("password"));
                employee.setName(resultSet.getString("name"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setState(resultSet.getString("state"));
                employee.setUser(resultSet.getString("User"));
            }

            connection.close();

        } catch (SQLException e) {

        }

        return employee;
    }

    @Override
    public List listAll() {

        ArrayList<Employee> ListEmployee = new ArrayList<>();

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "SELECT * FROM employee";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id_Employee"),
                        resultSet.getLong("dpi"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("state"),
                        resultSet.getString("user"));
                ListEmployee.add(employee);
            }

            connection.close();

        } catch (SQLException e) {

        }

        return ListEmployee;
    }

    @Override
    public boolean add(Employee employee) {

        boolean resultado;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "INSERT INTO employee (dpi, password, name, phone, state, User) VALUES(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, employee.getDpi());
            preparedStatement.setString(2, employee.getPassword());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getState());
            preparedStatement.setString(6, employee.getUser());

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

            String query = "DELETE FROM employee WHERE id_Employee = "+ id;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;

    }

    @Override
    public Employee listById(int id) {
        
        Employee employee = new Employee();
        
        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "SELECT * FROM employee WHERE id_Employee = "+ id;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employee.setId_employee(resultSet.getInt("id_employee"));
                employee.setDpi(resultSet.getLong("dpi"));
                employee.setPassword(resultSet.getString("password"));
                employee.setName(resultSet.getString("name"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setState(resultSet.getString("state"));
                employee.setUser(resultSet.getString("User"));
            }

            connection.close();

        } catch (SQLException e) {

        }

        return employee;
    }

    @Override
    public boolean update(Employee employee) {

        boolean resultado;

        DBConexion connect = new DBConexion();

        try (Connection connection = connect.conexion()) {

            String query = "UPDATE employee SET dpi = ?, password = ?, name = ?, phone = ?, state = ?, User = ? WHERE id_Employee = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, employee.getDpi());
            preparedStatement.setString(2, employee.getPassword());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getState());
            preparedStatement.setString(6, employee.getUser());
            preparedStatement.setInt(7, employee.getId_employee());

            preparedStatement.executeUpdate();

            connection.close();

            resultado = true;

        } catch (SQLException e) {
            resultado = false;
        }

        return resultado;
    }
}
