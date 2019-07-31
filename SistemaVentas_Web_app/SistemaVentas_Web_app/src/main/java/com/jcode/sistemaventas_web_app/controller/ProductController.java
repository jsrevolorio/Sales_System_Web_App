/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.controller;

import com.jcode.sistemaventas_web_app.model.dao.ProductDao;
import com.jcode.sistemaventas_web_app.model.dto.Product;
import java.io.IOException;
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
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {

    Product product = new Product();
    ProductDao productDao = new ProductDao();
    int id;

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

        if (menu.equalsIgnoreCase("product")) {

            switch (action) {

                case "list":

                    String text = request.getParameter("text");

                    if (text == null) {
                        text = "";
                    }

                    List<Product> list = productDao.listAll(text);
                    request.setAttribute("listproduct", list);
                    break;

                case "agregar":

                    product.setName(request.getParameter("name"));
                    product.setPrice(Float.valueOf(request.getParameter("price")));
                    product.setStock(Integer.parseInt(request.getParameter("stock")));
                    product.setState(request.getParameter("state"));
                    productDao.add(product);

                    request.getRequestDispatcher("ProductController?menu=product&accion=list").forward(request, response);
                    break;

                case "editar":

                    id = Integer.parseInt(request.getParameter("id"));
                    Product _product = productDao.listById(id);
                    request.setAttribute("product", _product);
                    request.getRequestDispatcher("ProductController?menu=product&accion=list").forward(request, response);

                    break;

                case "actualizar":
                    product.setName(request.getParameter("name"));
                    product.setPrice(Float.valueOf(request.getParameter("price")));
                    product.setStock(Integer.parseInt(request.getParameter("stock")));
                    product.setState(request.getParameter("state"));
                    product.setId_Product(id);
                    productDao.update(product);

                    request.getRequestDispatcher("ProductController?menu=product&accion=list").forward(request, response);
                    break;

                case "eliminar":

                    productDao.delete(Integer.parseInt(request.getParameter("id")));
                    request.getRequestDispatcher("ProductController?menu=product&accion=list").forward(request, response);
                    break;

            }

            request.getRequestDispatcher("product.jsp").forward(request, response);
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
