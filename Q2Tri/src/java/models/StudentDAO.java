/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.DBContext;
import dal.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anh
 */
public class StudentDAO extends DBContext{
    
    public ArrayList<Student> getStudentByName(String nameS) {
        ArrayList<Student> students = new ArrayList<>();

        // Create : PrepareStatement
        try {
            String sql = "select * from Student where name like ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            ps.setString(1, "%" + nameS + "%");
            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo
                int sid = rs.getInt("sid");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                Date dob = rs.getDate("dob");

                // Intinilizial object 
                Student st = new Student(sid, name, gender, dob);
                // Add p to arraylist
                students.add(st);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return students;
    }
}
