/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.*;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anh
 */
public class DAO extends DBContext {

    public Account getAccounts(String username, String password) {
        try {
            String sql = "select * from Account where userid = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Account> getAllAccountList() {
        ArrayList<Account> accList = new ArrayList<>();

        // Create : PrepareStatement
        try {
            String sql = "Select * from Account";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo

                String userid = rs.getString("userid");
                String password = rs.getString("password");
                String displayname = rs.getString("displayname");

                // Intinilizial object 
                Account acc = new Account(userid, password, displayname);
                // Add p to arraylist
                accList.add(acc);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return accList;
    }

    public Account getAllAccount() {
//        ArrayList<Account> accList = new ArrayList<>();

        // Create : PrepareStatement
        try {
            String sql = "Select * from Account";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo

                String userid = rs.getString("userid");
                String password = rs.getString("password");
                String displayname = rs.getString("displayname");

                // Intinilizial object 
                Account acc = new Account(userid, password, displayname);
                // Add p to arraylist
                return acc;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public void getAddComment(Comment c) {
        int rs = 0;

        try {
            String sql = "INSERT INTO [dbo].[Comment]\n"
                    + "           ([ctitle]\n"
                    + "           ,[userid]\n"
                    + "           ,[tid])\n"
                    + "     VALUES "
                    + " (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getCtitle());
            ps.setString(2, c.getUserid());
            ps.setInt(3, c.getTid());
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public ArrayList<Threads> getThreads() {
        ArrayList<Threads> threads = new ArrayList<>();
        try {
            String sql = "select * from Thread";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int tid = rs.getInt("tid");
                String tcontent = rs.getString("tcontent");

                Threads t = new Threads(tid, tcontent);
                threads.add(t);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return threads;
    }

    public Threads getThreads2() {
//        ArrayList<Threads> threads = new ArrayList<>();
        try {
            String sql = "select * from Thread";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int tid = rs.getInt("tid");
                String tcontent = rs.getString("tcontent");

                Threads t = new Threads(tid, tcontent);

                return t;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Comment getComment2() {
//        ArrayList<Comment> comment = new ArrayList<>();
        try {
            String sql = "select * from Comment";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String ctitle = rs.getString("ctitle");
                int tid = rs.getInt("tid");
                String userid = rs.getString("userid");

                Comment c = new Comment(cid, ctitle, userid, tid);
                return c;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Comment> getComment() {
        ArrayList<Comment> comment = new ArrayList<>();
        try {
            String sql = "select * from Comment";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String ctitle = rs.getString("ctitle");
                int tid = rs.getInt("tid");
                String userid = rs.getString("userid");

                Comment c = new Comment(cid, ctitle, userid, tid);
                comment.add(c);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return comment;
    }

}
