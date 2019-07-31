/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcode.sistemaventas_web_app.controller;

import com.jcode.sistemaventas_web_app.model.dao.EmployeeDao;
import com.jcode.sistemaventas_web_app.model.dto.Employee;
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
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController"})
public class EmployeeController extends HttpServlet {

    Employee employee = new Employee();
    EmployeeDao employeeDao = new EmployeeDao();
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

        if (menu.equalsIgnoreCase("employee")) {

            switch (action) {

                case "list":

                    List<Employee> list = employeeDao.listAll();
                    request.setAttribute("listEmployee", list);
                    break;

                case "agregar":

                    employee.setDpi(Long.valueOf(request.getParameter("dpi")));
                    employee.setName(request.getParameter("name"));
                    employee.setPhone(request.getParameter("phone"));
                    employee.setState(request.getParameter("state"));
                    employee.setUser(request.getParameter("user"));
                    employee.setPassword(request.getParameter("password"));
                    employeeDao.add(employee);

                    request.getRequestDispatcher("EmployeeController?menu=employee&accion=list").forward(request, response);
                    break;

                case "editar":
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    Employee _employee = employeeDao.listById(id);
                    request.setAttribute("employee", _employee);
                    request.getRequestDispatcher("EmployeeController?menu=employee&accion=list").forward(request, response);
                    break;

                case "actualizar":

                    employee.setDpi(Long.valueOf(request.getParameter("dpi")));
                    employee.setName(request.getParameter("name"));
                    employee.setPhone(request.getParameter("phone"));
                    employee.setState(request.getParameter("state"));
                    employee.setUser(request.getParameter("user"));
                    employee.setPassword(request.getParameter("password"));
                    employee.setId_employee(id);
                    employeeDao.update(employee);
                    
                    request.getRequestDispatcher("EmployeeController?menu=employee&accion=list").forward(request, response);
                    break;
                    
                case "eliminar":
                    
                    employeeDao.delete(Integer.parseInt(request.getParameter("id")));
                    request.getRequestDispatcher("EmployeeController?menu=employee&accion=list").forward(request, response);
                    break;

            }

            request.getRequestDispatcher("employee.jsp").forward(request, response);

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
