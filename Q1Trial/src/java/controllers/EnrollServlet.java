/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author Anh
 */
public class EnrollServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtStName = req.getParameter("txtStName");
        String txtFSource = req.getParameter("txtFSource");
        String txtLevel = req.getParameter("txtLevel");
        Date txtDOE = Date.valueOf(req.getParameter("txtDOE"));
        resp.setContentType("text/html: charset=utf-8");
        resp.getWriter().print("Student Name: " + txtStName
                + "\n" + "Financial Source: " + txtFSource
                + "\n" + "Level: " + txtLevel
                + "\n" + "DOE: " + txtDOE);
    }
    
}
