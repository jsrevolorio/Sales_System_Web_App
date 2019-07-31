/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.model.dto;

import java.io.Serializable;

/**
 *
 * @author scorpion
 */
public class Employee implements Serializable {

    private int id_employee;
    private long dpi;
    private String password;
    private String name;
    private String phone;
    private String state;
    private String user;

    
    public Employee() {
    }

    public Employee(int id_employee, long dpi, String password, String name, String phone, String state, String user) {
        this.id_employee = id_employee;
        this.dpi = dpi;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.state = state;
        this.user = user;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public long getDpi() {
        return dpi;
    }

    public void setDpi(long dpi) {
        this.dpi = dpi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
