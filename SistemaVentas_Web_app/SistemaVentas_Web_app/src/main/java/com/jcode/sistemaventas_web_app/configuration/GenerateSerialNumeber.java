/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.configuration;

/**
 *
 * @author scorpion
 */
public class GenerateSerialNumeber {

    int data;
    String number;

    public String numberSerial(int data) {

        this.data = data + 1;

        if ((this.data >= 10000000) && (this.data <= 100000000)) {
            number = "" + this.data;
        }
        if ((this.data >= 1000000) && (this.data <= 10000000)) {
            number = "0" + this.data;
        }
        if ((this.data >= 100000) && (this.data <= 1000000)) {
            number = "00" + this.data;
        }
        if ((this.data >= 10000) && (this.data <= 100000)) {
            number = "000" + this.data;
        }
        if ((this.data >= 1000) && (this.data <= 10000)) {
            number = "0000" + this.data;
        }
        if ((this.data >= 100) && (this.data <= 1000)) {
            number = "00000" + this.data;
        }
        if ((this.data >= 10) && (this.data <= 100)) {
            number = "000000" + this.data;
        }
        if ((this.data < 10)) {
            number = "0000000" + this.data;
        }
        
        return number;
    }

}
