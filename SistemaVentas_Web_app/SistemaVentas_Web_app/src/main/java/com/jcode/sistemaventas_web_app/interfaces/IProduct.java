/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.interfaces;

import com.jcode.sistemaventas_web_app.model.dto.Product;
import java.util.List;

/**
 *
 * @author scorpion
 */
public interface IProduct {

    public List listAll(String dato);

    public Product listById(int id);

    public boolean add(Product product);

    public boolean update(Product product);

    public boolean delete(int id);

}
