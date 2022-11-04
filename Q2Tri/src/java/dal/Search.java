package dal;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.StudentDAO;


public class Search extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("txtSearch");
        
        ArrayList<Student> st = new StudentDAO().getStudentByName(name);
        req.getSession().setAttribute("st", st);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }
    
    
    
}
