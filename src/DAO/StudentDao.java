/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DatabaseUtils;
import Model.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author banhg
 */
public class StudentDao {

    public boolean addStudent(Student e) throws Exception {
        String sql = "insert into Students(id,fullname,gender,birthdate,address,phoneNumber,email)"
                + " values(?,?,?,?,?,?,?)";

        try (
                Connection con = DatabaseUtils.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, e.getId());
            pstmt.setString(2, e.getFullName());
            pstmt.setString(3, e.getGender());
            pstmt.setString(4, e.getBirthdate());
            pstmt.setString(5, e.getAddress());
            pstmt.setString(6, e.getPhoneNum());
            pstmt.setString(7, e.getEmail());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean updateStudent(Student e) throws Exception {
        String sql = "update Students set fullname = ?, gender = ?,birthdate=?, address = ?, phoneNumber = ?, email = ? where id = ?";

        try (
                Connection con = DatabaseUtils.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(7, e.getId());
            pstmt.setString(1, e.getFullName());
            pstmt.setString(2, e.getGender());
            pstmt.setString(3, e.getBirthdate());
            pstmt.setString(4, e.getAddress());
            pstmt.setString(5, e.getPhoneNum());
            pstmt.setString(6, e.getEmail());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean deleteStudent(String id) throws Exception {
        String sql = "delete from students where id = ?";

        try (
                Connection con = DatabaseUtils.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, id);

            return pstmt.executeUpdate() > 0;
        }
    }

    public Student findStudentByID(String id) throws Exception {
        String sql = "select * from Students where id = ?";

        try (
                Connection con = DatabaseUtils.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("ID"));
                student.setFullName(rs.getString("FullName"));
                student.setGender(rs.getString("Gender"));
                student.setBirthdate(rs.getString("Birthdate"));
                student.setAddress(rs.getString("Address"));
                student.setPhoneNum(rs.getString("PhoneNumber"));
                student.setEmail(rs.getString("Email"));

                return student;
            }
            return null;
        }
    }

    public List<Student> findStudent() throws Exception {
        String sql = "select * from Students";

        try(Connection con = DatabaseUtils.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            ResultSet rs = pstmt.executeQuery();
            List<Student> list = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("ID"));
                student.setFullName(rs.getString("FullName"));
                student.setGender(rs.getString("Gender"));
                student.setBirthdate(rs.getString("Birthdate"));
                student.setAddress(rs.getString("Address"));
                student.setPhoneNum(rs.getString("PhoneNumber"));
                student.setEmail(rs.getString("Email"));

                list.add(student);
            }
            return list;
        }
    }

    
}