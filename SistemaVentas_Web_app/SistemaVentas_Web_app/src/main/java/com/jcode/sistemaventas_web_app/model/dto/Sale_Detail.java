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
public class Sale_Detail implements Serializable {
    
    private int item;
    private String id_Sale_detail;
    private int id_Sale;
    private Product product;
    private int quantity;
    private float subTotal; 

    public Sale_Detail() {
    }

    public Sale_Detail(int item, String id_Sale_detail, int id_Sale, Product product, int quantity, float subTotal) {
        this.item = item;
        this.id_Sale_detail = id_Sale_detail;
        this.id_Sale = id_Sale;
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
    
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getId_Sale_detail() {
        return id_Sale_detail;
    }

    public void setId_Sale_detail(String id_Sale_detail) {
        this.id_Sale_detail = id_Sale_detail;
    }

    public int getId_Sale() {
        return id_Sale;
    }

    public void setId_Sale(int id_Sale) {
        this.id_Sale = id_Sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
   
    
    
}
