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
public class Product  implements Serializable{
    
    private int id_Product;
    private String name;
    private float price;
    private int stock;
    private String state;

    
    public Product() {
    }
    
    public Product(int id_Product, String name, float price, int stock, String state) {
        this.id_Product = id_Product;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.state = state;
    }

    public int getId_Product() {
        return id_Product;
    }

    public void setId_Product(int id_Product) {
        this.id_Product = id_Product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
