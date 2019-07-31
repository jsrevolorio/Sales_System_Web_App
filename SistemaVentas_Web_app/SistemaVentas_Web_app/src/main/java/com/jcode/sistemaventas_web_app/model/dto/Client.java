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
public class Client implements Serializable{

    private int id_Client;
    private String nit;
    private String name;
    private String address;
    private String state;

    public Client() {
    }

    public Client(int id_Client, String nit, String name, String address, String state) {
        this.id_Client = id_Client;
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.state = state;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
       
}
