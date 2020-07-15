/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DatabaseUtils;
import Model.Score;
import Model.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author banhg
 */
public class ScoreDao {

    public boolean addScore(Score s) throws Exception {
        String sql = "insert into Scores(id,fullname,hanhkiem,Toan,Van,Anh,Ly,Hoa,Sinh,Dia,Su,QP,Tin,GDCD,Thechat,DTB)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (
                 Connection con = DatabaseUtils.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, s.getId());
            pstmt.setString(2, s.getFullname());
            pstmt.setString(3, s.getHanhKiem());
            pstmt.setFloat(4, s.getToan());
            pstmt.setFloat(5, s.getVan());
            pstmt.setFloat(6, s.getAnh());
            pstmt.setFloat(7, s.getLy());
            pstmt.setFloat(8, s.getHoa());
            pstmt.setFloat(9, s.getSinh());
            pstmt.setFloat(10, s.getDia());
            pstmt.setFloat(11, s.getSu());
            pstmt.setFloat(12, s.getQuocphong());
            pstmt.setFloat(13, s.getTin());
            pstmt.setFloat(14, s.getGdcd());
            pstmt.setFloat(15, s.getThechat());
            pstmt.setFloat(16, s.getDtb());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean updateScore(Score s) throws Exception {
        String sql = "update Scores set fullname = ?, hanhkiem = ?,Toan = ?, Van = ?, Anh = ?, Ly = ?, Hoa = ?, Sinh = ?,Dia = ?, Su= ?, QP = ?, Tin = ?, GDCD = ?, Thechat = ?, DTB = ? where id = ?";

        try (
                 Connection con = DatabaseUtils.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(16, s.getId());
            pstmt.setString(1, s.getFullname());
            pstmt.setString(2, s.getHanhKiem());
            pstmt.setFloat(3, s.getToan());
            pstmt.setFloat(4, s.getVan());
            pstmt.setFloat(5, s.getAnh());
            pstmt.setFloat(6, s.getLy());
            pstmt.setFloat(7, s.getHoa());
            pstmt.setFloat(8, s.getSinh());
            pstmt.setFloat(9, s.getDia());
            pstmt.setFloat(10, s.getSu());
            pstmt.setFloat(11, s.getQuocphong());
            pstmt.setFloat(12, s.getTin());
            pstmt.setFloat(13, s.getGdcd());
            pstmt.setFloat(14, s.getThechat());
            pstmt.setFloat(15, s.getDtb());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean deleteScore(String id) throws Exception {
        String sql = "delete from Scores where id = ?";

        try (
                 Connection con = DatabaseUtils.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, id);

            return pstmt.executeUpdate() > 0;
        }
    }

    public Score findByID(String id) throws Exception {
        String sql = "select * from Scores where id = ?";

        try (
                 Connection con = DatabaseUtils.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Score score = new Score();
                score.setId(rs.getString("ID"));
                score.setFullname(rs.getString("FullName"));
                score.setHanhKiem(rs.getString("HanhKiem"));
                score.setToan(rs.getFloat("Toan"));
                score.setVan(rs.getFloat("Van"));
                score.setAnh(rs.getFloat("Anh"));
                score.setLy(rs.getFloat("Ly"));
                score.setHoa(rs.getFloat("Hoa"));
                score.setSinh(rs.getFloat("Sinh"));
                score.setDia(rs.getFloat("Dia"));
                score.setSu(rs.getFloat("Su"));
                score.setQuocphong(rs.getFloat("QP"));
                score.setTin(rs.getFloat("Tin"));
                score.setGdcd(rs.getFloat("GDCD"));
                score.setThechat(rs.getFloat("Thechat"));
                score.setDtb(rs.getFloat("DTB"));

                return score;
            }
            return null;
        }
    }

    public List<Score> getScore() throws Exception {
        String sql = "select * from Scores";

        try (
                 Connection con = DatabaseUtils.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            ResultSet rs = pstmt.executeQuery();
            List<Score> list = new ArrayList<>();
            while (rs.next()) {
                Score score = new Score();
                score.setId(rs.getString("ID"));
                score.setFullname(rs.getString("FullName"));
                score.setHanhKiem(rs.getString("HanhKiem"));
                score.setToan(rs.getFloat("Toan"));
                score.setVan(rs.getFloat("Van"));
                score.setAnh(rs.getFloat("Anh"));
                score.setLy(rs.getFloat("Ly"));
                score.setHoa(rs.getFloat("Hoa"));
                score.setSinh(rs.getFloat("Sinh"));
                score.setDia(rs.getFloat("Dia"));
                score.setSu(rs.getFloat("Su"));
                score.setQuocphong(rs.getFloat("QP"));
                score.setTin(rs.getFloat("Tin"));
                score.setGdcd(rs.getFloat("GDCD"));
                score.setThechat(rs.getFloat("Thechat"));
                score.setDtb(rs.getFloat("DTB"));

                list.add(score);
            }
            return list;
        }
    }

    public int getHSGioi() throws Exception {
        ScoreDao dao = new ScoreDao();
        List<Score> list = dao.getScore();

        int count = 0;
        for (Score score : list) {
            if (score.getHanhKiem().equalsIgnoreCase("Tốt") && score.getDtb() >= 8) {
                count++;
            }

        }
        return count;
    }

    public int getHSKha() throws Exception {
        ScoreDao dao = new ScoreDao();
        List<Score> list = dao.getScore();

        int count = 0;
        for (Score score : list) {
            if ((score.getHanhKiem().equalsIgnoreCase("Khá")) && score.getDtb() >= 6.5) {
                count++;
            } else if (score.getHanhKiem().equals("Tốt") && score.getDtb() < 8 && score.getDtb() >= 6.5) {
                count++;
            }
        }
        return count;
    }

    public int getHSTB() throws Exception {
        ScoreDao dao = new ScoreDao();
        List<Score> list = dao.getScore();

        int count = 0;
        for (Score score : list) {
            if ((score.getHanhKiem().equalsIgnoreCase("Trung bình")) && score.getDtb() >= 5) {
                count++;
            } else if ((score.getHanhKiem().equals("Tốt") || score.getHanhKiem().equalsIgnoreCase("Khá")) && score.getDtb() < 6.5 && score.getDtb() >= 5) {
                count++;
            }
        }
        return count;
    }

    public int getHSYeu() throws Exception {
        ScoreDao dao = new ScoreDao();
        List<Score> list = dao.getScore();

        int count = 0;
        for (Score score : list) {
            if ((score.getHanhKiem().equalsIgnoreCase("Yếu")) || score.getDtb() < 5) {
                count++;
            }

        }
        return count;
    }
}
