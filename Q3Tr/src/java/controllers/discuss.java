/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dal.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.DAO;

/**
 *
 * @author Anh
 */
public class discuss extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("acc") == null) {
            req.setAttribute("msg", "access denied");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {
            ArrayList<Threads> ths = new DAO().getThreads();
            ArrayList<Account> ac2 = new DAO().getAllAccountList();

            ArrayList<Comment> cmt = new DAO().getComment();
            req.getSession().setAttribute("ths", ths);
            req.getSession().setAttribute("cmt", cmt);
            req.getSession().setAttribute("ac2", ac2);
            req.getSession().getAttribute("username");
            req.getRequestDispatcher("Chat.jsp").forward(req, resp);
            
//            Threads ths2 = new DAO().getThreads2();
//            Account ac = new DAO().getAllAccount();
//            Comment cmt2 = new DAO().getComment2();            
//            req.getSession().setAttribute("ths2", ths2);            
//            req.getSession().setAttribute("ac", ac);           
//            req.setAttribute("cmt2", cmt2);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idx = req.getParameter("id");
        String name = req.getParameter("txtName");
        String userid = req.getParameter("userid");
        int id = 0;
        try {
            id = Integer.parseInt(idx);
        } catch (Exception e) {
        }

        try {
            Comment c = new Comment();
            c.setCtitle(name);
            c.setTid(id);
            c.setUserid(userid);

            DAO d = new DAO();
            d.getAddComment(c);
            doGet(req, resp);
        } catch (Exception e) {
        }
    }

}
