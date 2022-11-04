/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dal.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.DAO;

/**
 *
 * @author Anh
 */
public class login extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        DAO d = new DAO();
//        if(username.equals("") && password.equals("")) {
//            req.setAttribute("msg", "access denied");
//            req.getRequestDispatcher("Login.jsp").forward(req, resp);
//        }
        if (username != null && password != null) {
            Account acc = d.getAccounts(username, password);
            if (acc == null) {
                req.setAttribute("msg", "Login Failed");
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            } else {
                req.setAttribute("msg", "Login Successful");
                req.getSession().setAttribute("acc", acc);
                req.getSession().setAttribute("username", username);
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }
        } 
        
    }
    
    
    
}
