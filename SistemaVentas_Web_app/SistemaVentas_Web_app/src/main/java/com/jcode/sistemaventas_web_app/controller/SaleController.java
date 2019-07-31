/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.controller;

import com.jcode.sistemaventas_web_app.configuration.GenerateSerialNumeber;
import com.jcode.sistemaventas_web_app.model.dao.ClientDao;
import com.jcode.sistemaventas_web_app.model.dao.ProductDao;
import com.jcode.sistemaventas_web_app.model.dao.SaleDao;
import com.jcode.sistemaventas_web_app.model.dto.Client;
import com.jcode.sistemaventas_web_app.model.dto.Employee;
import com.jcode.sistemaventas_web_app.model.dto.Product;
import com.jcode.sistemaventas_web_app.model.dto.Sale;
import com.jcode.sistemaventas_web_app.model.dto.Sale_Detail;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author scorpion
 */
@WebServlet(name = "SaleController", urlPatterns = {"/SaleController"})
public class SaleController extends HttpServlet {

    Client client = new Client();
    ClientDao clientDao = new ClientDao();

    Product product = new Product();
    ProductDao productDao = new ProductDao();

    Employee employee = new Employee();

    Sale sale = new Sale();
    Sale_Detail saleDetail = new Sale_Detail();
    SaleDao saleDao = new SaleDao();

    List<Sale_Detail> listSaleDetail = new ArrayList<>();
    int item = 1;
    float total;
    String numberSerial;

    //DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd " + "HH:mm:ss");
    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd ");
    Date date = new Date();
    String fecha = dateFormat.format(date);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("accion");
        String menu = request.getParameter("menu");

        if (menu.equalsIgnoreCase("sale")) {

            switch (action) {

                case "searchClient":
                    item = 1;
                    listSaleDetail.clear();

                    client = clientDao.nitClient(request.getParameter("clientNit"));
                    request.setAttribute("client", client);
                    request.setAttribute("NoSerie", numberSerial);
                    break;

                case "searchProduct":
                    product = productDao.listById(Integer.valueOf(request.getParameter("productCode")));
                    request.setAttribute("product", product);
                    request.setAttribute("client", client);
                    request.setAttribute("listSale", listSaleDetail);
                    request.setAttribute("NoSerie", numberSerial);
                    break;

                case "agregar":
                    int Quantity = Integer.valueOf(request.getParameter("Quantity"));
                    total = 0;

                    saleDetail = new Sale_Detail();
                    saleDetail.setItem(item);
                    saleDetail.setId_Sale(saleDao.SaleById() + 1);
                    saleDetail.setProduct(product);
                    saleDetail.setQuantity(Quantity);
                    saleDetail.setSubTotal(Quantity * product.getPrice());
                    listSaleDetail.add(saleDetail);
                    sale.setDetalis(listSaleDetail);
                    item++;

                    for (int i = 0; i < listSaleDetail.size(); i++) {
                        total = total + listSaleDetail.get(i).getSubTotal();
                    }

                    request.setAttribute("total", total);
                    request.setAttribute("listSale", listSaleDetail);
                    request.setAttribute("client", client);
                    request.setAttribute("NoSerie", numberSerial);

                    System.out.println(saleDao.SaleById() + 1);
                    break;

                case "addSale":

                    //Agregar Venta 
                    employee.setId_employee(1);
                    sale.setClient(client);
                    sale.setEmployee(employee);
                    sale.setSerial_Number(numberSerial);
                    sale.setSale_Date(fecha);
                    sale.setTotal_Price(total);
                    sale.setState("1");
                    boolean inte = saleDao.addSale(sale);

                    //Agregar Detalles Venta 
                    for (Sale_Detail sale_Detail : listSaleDetail) {
                        saleDao.addSaleDetail(sale_Detail);
                    }

                    System.out.println(inte);
                    for (Sale_Detail sale_Detail : listSaleDetail) {
                        int num1 = sale_Detail.getProduct().getStock()-sale_Detail.getQuantity();
                        sale_Detail.getProduct().setStock(num1);
                        System.out.println(sale_Detail.getProduct().getName() +" "+ sale_Detail.getProduct().getStock());
                    }
                    
                    for (Sale_Detail sale_Detail : listSaleDetail) {
                        productDao.update(sale_Detail.getProduct());
                    }
                    break;

                default:
                    numberSerial = saleDao.generateSerial();

                    if (numberSerial == null) {
                        numberSerial = "00000001";
                        request.setAttribute("NoSerie", numberSerial);
                    } else {
                        int incrementar = Integer.parseInt(numberSerial);

                        GenerateSerialNumeber generate = new GenerateSerialNumeber();
                        numberSerial = generate.numberSerial(incrementar);

                        sale.setSerial_Number(numberSerial);
                        request.setAttribute("NoSerie", numberSerial);
                    }

                    request.getRequestDispatcher("sale.jsp").forward(request, response);

            }

            request.getRequestDispatcher("sale.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
