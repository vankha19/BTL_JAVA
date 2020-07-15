/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DatabaseUtils;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class UserDao {
    public User checkLogin(String username, String password) throws Exception{
        String sql = "select * from Users where username = ? and password = ?";
        try (
           Connection con = DatabaseUtils.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)
        ){
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
               User users = new User();
               users.setUsername(rs.getString("username"));
               users.setPassword(rs.getString("password"));
               users.setRole(rs.getString("role"));
               return users;
            }
           
        } 
         return null;
    } 
}
