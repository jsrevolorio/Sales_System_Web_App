/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author scorpion
 */
public class Sale implements Serializable{
    
    private int id_Sales;
    private Client client;
    private Employee employee;
    private String serial_Number;
    private String sale_Date;
    private float total_Price;
    private String state;
    private List<Sale_Detail> detalis;

    public Sale() {
    }

    public Sale(int id_Sales, Client client, Employee employee, String serial_Number, String sale_Date, float total_Price, String state, List<Sale_Detail> detalis) {
        this.id_Sales = id_Sales;
        this.client = client;
        this.employee = employee;
        this.serial_Number = serial_Number;
        this.sale_Date = sale_Date;
        this.total_Price = total_Price;
        this.state = state;
        this.detalis = detalis;
    }
    
    
    public int getId_Sales() {
        return id_Sales;
    }

    public void setId_Sales(int id_Sales) {
        this.id_Sales = id_Sales;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSerial_Number() {
        return serial_Number;
    }

    public void setSerial_Number(String serial_Number) {
        this.serial_Number = serial_Number;
    }

    public String getSale_Date() {
        return sale_Date;
    }

    public void setSale_Date(String sale_Date) {
        this.sale_Date = sale_Date;
    }

    public float getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(float total_Price) {
        this.total_Price = total_Price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Sale_Detail> getDetalis() {
        return detalis;
    }

    public void setDetalis(List<Sale_Detail> detalis) {
        this.detalis = detalis;
    }
    
    

    
}
