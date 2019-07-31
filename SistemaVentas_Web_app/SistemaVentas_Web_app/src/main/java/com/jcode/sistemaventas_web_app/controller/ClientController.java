/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.controller;

import com.jcode.sistemaventas_web_app.model.dao.ClientDao;
import com.jcode.sistemaventas_web_app.model.dto.Client;
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
@WebServlet(name = "ClientController", urlPatterns = {"/ClientController"})
public class ClientController extends HttpServlet {

    Client client = new Client();
    ClientDao clientDao = new ClientDao();
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

        if (menu.equalsIgnoreCase("client")) {

            switch (action) {

                case "list":

                    String text = request.getParameter("text");

                    if (text == null) {
                        text = "";
                    }

                    List<Client> list = clientDao.listAll(text);
                    request.setAttribute("listClient", list);
                    break;

                case "agregar":

                    client.setNit(request.getParameter("nit"));
                    client.setName(request.getParameter("name"));
                    client.setAddress(request.getParameter("address"));
                    client.setState(request.getParameter("state"));
                    clientDao.add(client);

                    request.getRequestDispatcher("ClientController?menu=client&accion=list").forward(request, response);
                    break;

                case "editar":

                    id = Integer.parseInt(request.getParameter("id"));
                    Client _client = clientDao.listById(id);
                    request.setAttribute("client", _client);
                    request.getRequestDispatcher("ClientController?menu=client&accion=list").forward(request, response);

                    break;

                case "actualizar":
                    client.setNit(request.getParameter("nit"));
                    client.setName(request.getParameter("name"));
                    client.setAddress(request.getParameter("address"));
                    client.setState(request.getParameter("state"));
                    client.setId_Client(id);
                    clientDao.update(client);

                    request.getRequestDispatcher("ClientController?menu=client&accion=list").forward(request, response);
                    break;

                case "eliminar":
                    
                    clientDao.delete(Integer.parseInt(request.getParameter("id")));
                    request.getRequestDispatcher("ClientController?menu=client&accion=list").forward(request, response);
                    break;

            }

            request.getRequestDispatcher("client.jsp").forward(request, response);
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
