/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author scorpion
 */
public class DBConexion {

    public final String url = "jdbc:mysql://localhost:3306/";
    public final String db = "almacen?autoReconnect=true&useSSL=false";
    public final String user = "root";
    public final String password = "";

    public Connection conexion() {
        Connection connection = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url + db, user, password);

            if (connection != null) {
                System.out.println("Connection was established");

            }

        } catch (SQLException e) {
            System.out.println("Erro de SQl");

        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Tipos de Erroes");
        } finally {
            return connection;
        }

    }
}
