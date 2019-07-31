/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.interfaces;

import com.jcode.sistemaventas_web_app.model.dto.Employee;
import java.util.List;

/**
 *
 * @author scorpion
 */
public interface IEmployee {

    public List listAll();

    public Employee listById(int id);

    public boolean add(Employee employee);

    public boolean update(Employee employee);

    public boolean delete(int id);
}
