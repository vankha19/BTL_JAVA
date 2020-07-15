/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameForm;

import DAO.ScoreDao;
import Model.Score;
import Model.Student;
import DAO.StudentDao;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.lang.Float;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyEvent;
import DB.DatabaseUtils;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Hau
 */
public class Main_Menu extends javax.swing.JFrame {

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    DefaultTableModel dtmStudent, dtmScore;

    /**
     * Creates new form Main_Menu
     */
    public Main_Menu() {

        initComponents();
        setIcon();
        pnStudent.setVisible(true);
        pnScore.setVisible(false);
        p3.setVisible(false);

        initTableStudentModel();
        loadTableStudentData();
        initTableScoreModel();
        loadTableScoretData();
    }

// begin funtion 
    public void initTableStudentModel() {
        String[] columnHeaders = new String[]{"id", "FullName", "Gender", "Birthdate", "Address", "PhoneNumber", "Email"};
        dtmStudent = new DefaultTableModel();
        dtmStudent.setColumnIdentifiers(columnHeaders);
        tblStudents.setModel(dtmStudent);
    }

    public void loadTableStudentData() {
        try {
            while (dtmStudent.getRowCount() > 0) {
                dtmStudent.removeRow(0);
            }
            StudentDao dao = new StudentDao();
            List<Student> list = dao.findStudent();
            for (Student student : list) {
                Vector row = new Vector();
                row.add(student.getId());
                row.add(student.getFullName());
                row.add(student.getGender());
//                row.add(student.isGender());
                row.add(student.getBirthdate());
                row.add(student.getAddress());
                row.add(student.getPhoneNum());
                row.add(student.getEmail());
                dtmStudent.addRow(row);
            }
            dtmStudent.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public void initTableScoreModel() {
        String[] columnHeaders = new String[]{
            "ID", "Name","Hạnh Kiểm", "Toán", "Văn", "Anh", "Lý", "Hóa", "ĐSinh", "Địa", "Sử", "QP", "Tin", "GDCD", "GDTC","DTB"
        };
        dtmScore = new DefaultTableModel();
        dtmScore.setColumnIdentifiers(columnHeaders);
        tblScore.setModel(dtmScore);
    }

    public void loadTableScoretData() {
        try {
            while (dtmScore.getRowCount() > 0) {
                dtmScore.removeRow(0);
            }

            ScoreDao dao = new ScoreDao();
            List<Score> list = dao.getScore();
            for (Score score : list) {
                Vector row = new Vector();
                row.add(score.getId());
                row.add(score.getFullname());
                row.add(score.getHanhKiem());
                row.add(score.getToan());
                row.add(score.getVan());
                row.add(score.getAnh());
                row.add(score.getLy());
                row.add(score.getHoa());
                row.add(score.getSinh());
                row.add(score.getDia());
                row.add(score.getSu());
                row.add(score.getQuocphong());
                row.add(score.getTin());
                row.add(score.getGdcd());
                row.add(score.getThechat());
                row.add(score.getDtb());

                dtmScore.addRow(row);
            }
            dtmScore.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // end funtion
    //begin verifile Text Students
    public boolean verifTextStudent() {
        if (txtID.getText().equals("") || txtfullname.getText().equals("") || txaAddress.getText().equals("")
                || txtPhone.getText().equals("") || txtEmail.getText().equals("") || jDateChooserBirthdate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "One Or More Empty Field");
            return false;
        } else if (jDateChooserBirthdate.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(null, "No larger than the current date is allowed");
            return false;
        } else {
            return true;
        }
    }

    //end verifile Text Students
//begin verifile Text Score
    public boolean verifiTextScore() {
        if (txtIDScore.getText().equals("") || txtfullnameScore.getText().equals("") || txtToan.getText().equals("")
                || txtVan.getText().equals("") || txtAnh.getText().equals("") || txtLy.getText().equals("")
                || txtHoa.getText().equals("") || txtSinh.getText().equals("") || txtDia.getText().equals("")
                || txtSu.getText().equals("") || txtQP.getText().equals("") || txtTin.getText().equals("") || txtGDCD.getText().equals("") || txtTheChat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "One Or More Empty Field");
            return false;
        } else {
            return true;
        }
    }
//end verifile Text Score
    // begin funtion reset 

    public void resetFormStudent() {
        txtID.setText("");
        txtfullname.setText("");
        txaAddress.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        jDateChooserBirthdate.setDate(null);
    }

    public void resetFormScore() {
        txtIDScore.setText("");
        txtfullnameScore.setText("");
        txtHanhKiem.setText("");
        txtToan.setText("");
        txtVan.setText("");
        txtAnh.setText("");
        txtLy.setText("");
        txtHoa.setText("");
        txtSinh.setText("");
        txtDia.setText("");
        txtSu.setText("");
        txtQP.setText("");
        txtTin.setText("");
        txtGDCD.setText("");
        txtTheChat.setText("");
        txtDTB.setText("");
    }
    //end funtion resetForm

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnMain = new javax.swing.JPanel();
        pnltop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlmenu = new javax.swing.JPanel();
        btnScore = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        pnlprinciple = new javax.swing.JPanel();
        pnStudent = new javax.swing.JPanel();
        pnInfor = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtfullname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaAddress = new javax.swing.JTextArea();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserBirthdate = new com.toedter.calendar.JDateChooser();
        scrTableStudent = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        pnButtonStudent = new javax.swing.JPanel();
        btnAddStudent = new javax.swing.JButton();
        btnResetStudent = new javax.swing.JButton();
        btnUpdateStudent = new javax.swing.JButton();
        btnDeleteStudent = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        pnScore = new javax.swing.JPanel();
        pnScoreforSub = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIDScore = new javax.swing.JTextField();
        txtfullnameScore = new javax.swing.JTextField();
        txtToan = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtVan = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtAnh = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtLy = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtHoa = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtSinh = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTheChat = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtGDCD = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTin = new javax.swing.JTextField();
        txtQP = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtSu = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtHanhKiem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtDTB = new javax.swing.JTextField();
        scrTableScore = new javax.swing.JScrollPane();
        tblScore = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnAddScore = new javax.swing.JButton();
        btnResetScore = new javax.swing.JButton();
        btnUpdateScore = new javax.swing.JButton();
        btnDeleteScore = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        p3 = new javax.swing.JPanel();
        pnBieuDo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(51, 255, 255));
        setMinimumSize(new java.awt.Dimension(1370, 700));

        pnMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnMain.setPreferredSize(new java.awt.Dimension(1280, 700));
        pnMain.setLayout(new java.awt.BorderLayout());

        pnltop.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("UTC2 University Student Management System");

        javax.swing.GroupLayout pnltopLayout = new javax.swing.GroupLayout(pnltop);
        pnltop.setLayout(pnltopLayout);
        pnltopLayout.setHorizontalGroup(
            pnltopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltopLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        pnltopLayout.setVerticalGroup(
            pnltopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnltopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        pnMain.add(pnltop, java.awt.BorderLayout.PAGE_START);

        pnlmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnScore.setBackground(new java.awt.Color(102, 102, 102));
        btnScore.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnScore.setForeground(new java.awt.Color(51, 51, 51));
        btnScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nhapdiem.png"))); // NOI18N
        btnScore.setText("SCORE");
        btnScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreActionPerformed(evt);
            }
        });
        pnlmenu.add(btnScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 190, 80));

        btnlogout.setBackground(new java.awt.Color(102, 102, 102));
        btnlogout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(51, 51, 51));
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User-Interface-Logout-icon.png"))); // NOI18N
        btnlogout.setText("LOGOUT");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });
        pnlmenu.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 190, 80));

        btnStudent.setBackground(new java.awt.Color(102, 102, 102));
        btnStudent.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnStudent.setForeground(new java.awt.Color(51, 51, 51));
        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Users-Student-icon.png"))); // NOI18N
        btnStudent.setText("STUDENT ");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        pnlmenu.add(btnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 80));

        btnsearch.setBackground(new java.awt.Color(102, 102, 102));
        btnsearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(51, 51, 51));
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-icon.png"))); // NOI18N
        btnsearch.setText("THỐNG KÊ");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        pnlmenu.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 190, 80));

        pnMain.add(pnlmenu, java.awt.BorderLayout.LINE_START);

        pnlprinciple.setLayout(new java.awt.CardLayout());

        pnStudent.setPreferredSize(new java.awt.Dimension(1170, 524));

        pnInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information Students ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel7.setText("ID:");

        jLabel8.setText("Full Name:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel9.setText("Gender:");

        jLabel11.setText("Address:");

        jScrollPane1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jScrollPane1.setMinimumSize(new java.awt.Dimension(15, 15));

        txaAddress.setColumns(20);
        txaAddress.setRows(5);
        jScrollPane1.setViewportView(txaAddress);

        buttonGroup1.add(rdbMale);
        rdbMale.setSelected(true);
        rdbMale.setText("Male");
        rdbMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMaleActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbFemale);
        rdbFemale.setText("Female");

        jLabel15.setText("Email:");

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        jLabel16.setText("Phone:");

        jLabel3.setText("Birthdate:");

        jDateChooserBirthdate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout pnInforLayout = new javax.swing.GroupLayout(pnInfor);
        pnInfor.setLayout(pnInforLayout);
        pnInforLayout.setHorizontalGroup(
            pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInforLayout.createSequentialGroup()
                        .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(35, 35, 35)
                        .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone)
                            .addComponent(txtEmail)))
                    .addGroup(pnInforLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnInforLayout.createSequentialGroup()
                        .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnInforLayout.createSequentialGroup()
                                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfullname, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                    .addComponent(txtID)))
                            .addGroup(pnInforLayout.createSequentialGroup()
                                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3))
                                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnInforLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(rdbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(rdbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnInforLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jDateChooserBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnInforLayout.setVerticalGroup(
            pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInforLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rdbMale)
                    .addComponent(rdbFemale))
                .addGap(18, 18, 18)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooserBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        tblStudents.setAutoCreateRowSorter(true);
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FullName", "Gender", "Birthdate", "address", "phone", "email"
            }
        ));
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblStudentsMousePressed(evt);
            }
        });
        scrTableStudent.setViewportView(tblStudents);

        btnAddStudent.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnAddStudent.setText("ADD");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });

        btnResetStudent.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnResetStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clear-icon.png"))); // NOI18N
        btnResetStudent.setText("RESET");
        btnResetStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetStudentActionPerformed(evt);
            }
        });

        btnUpdateStudent.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdateStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Text-Edit-icon.png"))); // NOI18N
        btnUpdateStudent.setText("UPDATE");
        btnUpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentActionPerformed(evt);
            }
        });

        btnDeleteStudent.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDeleteStudent.setText("DELETE");
        btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnButtonStudentLayout = new javax.swing.GroupLayout(pnButtonStudent);
        pnButtonStudent.setLayout(pnButtonStudentLayout);
        pnButtonStudentLayout.setHorizontalGroup(
            pnButtonStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonStudentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnResetStudent)
                .addGap(73, 73, 73)
                .addComponent(btnUpdateStudent)
                .addGap(91, 91, 91)
                .addComponent(btnDeleteStudent)
                .addGap(189, 189, 189))
        );
        pnButtonStudentLayout.setVerticalGroup(
            pnButtonStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonStudentLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnButtonStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateStudent)
                    .addComponent(btnDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Find");

        javax.swing.GroupLayout pnStudentLayout = new javax.swing.GroupLayout(pnStudent);
        pnStudent.setLayout(pnStudentLayout);
        pnStudentLayout.setHorizontalGroup(
            pnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnStudentLayout.createSequentialGroup()
                        .addComponent(pnButtonStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnStudentLayout.createSequentialGroup()
                        .addComponent(pnInfor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnStudentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrTableStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnStudentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(53, 53, 53))))))
        );
        pnStudentLayout.setVerticalGroup(
            pnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStudentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnStudentLayout.createSequentialGroup()
                        .addGroup(pnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrTableStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(pnButtonStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlprinciple.add(pnStudent, "card3");

        pnScore.setPreferredSize(new java.awt.Dimension(1170, 524));

        pnScoreforSub.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Score for Subjects", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel10.setText("ID:");

        jLabel12.setText("Full Name:");

        txtIDScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDScoreActionPerformed(evt);
            }
        });
        txtIDScore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDScoreKeyPressed(evt);
            }
        });

        txtToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToanActionPerformed(evt);
            }
        });

        jLabel19.setText("TOÁN");

        jLabel20.setText("NGỮ VĂN");

        jLabel21.setText("English");

        jLabel22.setText("VẬT LÝ");

        txtHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoaActionPerformed(evt);
            }
        });

        jLabel23.setText("HÓA HỌC");

        jLabel24.setText("SINH HỌC");

        jLabel25.setText("THỂ CHẤT");

        jLabel26.setText("GDCD");

        jLabel27.setText("TIN HỌC");

        jLabel28.setText("QP");

        jLabel29.setText("LỊCH SỬ");

        txtDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaActionPerformed(evt);
            }
        });

        jLabel30.setText("ĐỊA LÝ");

        txtHanhKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHanhKiemActionPerformed(evt);
            }
        });

        jLabel13.setText("Hạnh Kiểm");

        jLabel31.setText("DTB");

        javax.swing.GroupLayout pnScoreforSubLayout = new javax.swing.GroupLayout(pnScoreforSub);
        pnScoreforSub.setLayout(pnScoreforSubLayout);
        pnScoreforSubLayout.setHorizontalGroup(
            pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnScoreforSubLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnScoreforSubLayout.createSequentialGroup()
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfullnameScore)
                            .addGroup(pnScoreforSubLayout.createSequentialGroup()
                                .addComponent(txtIDScore, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnScoreforSubLayout.createSequentialGroup()
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnScoreforSubLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHanhKiem))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnScoreforSubLayout.createSequentialGroup()
                                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVan)
                                    .addComponent(txtAnh)
                                    .addComponent(txtLy, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(txtHoa)
                                    .addComponent(txtSinh)
                                    .addComponent(txtToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(46, 46, 46)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnScoreforSubLayout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTheChat, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnScoreforSubLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnScoreforSubLayout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(36, 36, 36)
                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnScoreforSubLayout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGDCD, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnScoreforSubLayout.createSequentialGroup()
                                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnScoreforSubLayout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDTB, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnScoreforSubLayout.setVerticalGroup(
            pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnScoreforSubLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtIDScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtfullnameScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtHanhKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnScoreforSubLayout.createSequentialGroup()
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnScoreforSubLayout.createSequentialGroup()
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtQP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtGDCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnScoreforSubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtTheChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(308, 308, 308))
        );

        tblScore.setAutoCreateRowSorter(true);
        tblScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FullName", "Toán", "Văn", "Anh", "Lý", "Hóa", "Sinh", "Địa", "Sử", "Tin", "QP", "GDCD", "Thể chất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblScoreMousePressed(evt);
            }
        });
        scrTableScore.setViewportView(tblScore);

        btnAddScore.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnAddScore.setText("ADD");
        btnAddScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddScoreActionPerformed(evt);
            }
        });

        btnResetScore.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnResetScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clear-icon.png"))); // NOI18N
        btnResetScore.setText("RESET");
        btnResetScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetScoreActionPerformed(evt);
            }
        });

        btnUpdateScore.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdateScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Text-Edit-icon.png"))); // NOI18N
        btnUpdateScore.setText("UPDATE");
        btnUpdateScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateScoreActionPerformed(evt);
            }
        });

        btnDeleteScore.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDeleteScore.setText("DELETE");
        btnDeleteScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteScoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(btnAddScore, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnResetScore)
                .addGap(73, 73, 73)
                .addComponent(btnUpdateScore)
                .addGap(91, 91, 91)
                .addComponent(btnDeleteScore)
                .addGap(189, 189, 189))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetScore, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddScore, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateScore)
                    .addComponent(btnDeleteScore, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Find");

        javax.swing.GroupLayout pnScoreLayout = new javax.swing.GroupLayout(pnScore);
        pnScore.setLayout(pnScoreLayout);
        pnScoreLayout.setHorizontalGroup(
            pnScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnScoreLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(96, 96, 96))
                    .addGroup(pnScoreLayout.createSequentialGroup()
                        .addComponent(pnScoreforSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnScoreLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(scrTableScore, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                                .addGap(14, 14, 14))
                            .addGroup(pnScoreLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(104, 104, 104))))))
        );
        pnScoreLayout.setVerticalGroup(
            pnScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnScoreLayout.createSequentialGroup()
                .addGroup(pnScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnScoreLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(scrTableScore, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnScoreLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(pnScoreforSub, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pnlprinciple.add(pnScore, "card2");

        p3.setPreferredSize(new java.awt.Dimension(1170, 524));

        javax.swing.GroupLayout pnBieuDoLayout = new javax.swing.GroupLayout(pnBieuDo);
        pnBieuDo.setLayout(pnBieuDoLayout);
        pnBieuDoLayout.setHorizontalGroup(
            pnBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        pnBieuDoLayout.setVerticalGroup(
            pnBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pnlprinciple.add(p3, "card4");

        pnMain.add(pnlprinciple, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreActionPerformed

        pnScore.setVisible(true);
        pnStudent.setVisible(false);
        p3.setVisible(false);
    }//GEN-LAST:event_btnScoreActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Do You Want To Logout", "Logout", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            LoginForm gl = new LoginForm();
            gl.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed

        pnScore.setVisible(false);
        pnStudent.setVisible(true);
        p3.setVisible(false);

    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed

        try {
            pnScore.setVisible(false);
            pnStudent.setVisible(false);
            p3.setVisible(true);
            JFreeChart pieChart = createChart(createDataset());
            ChartPanel chartPanel = new ChartPanel(pieChart);
            JFrame frame = new JFrame();
            frame.add(chartPanel);
            frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
            pnBieuDo.add(frame);
        } catch (Exception ex) {
            Logger.getLogger(Main_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        


    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed

    }//GEN-LAST:event_txtIDActionPerformed

    private void rdbMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMaleActionPerformed

    }//GEN-LAST:event_rdbMaleActionPerformed

    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentActionPerformed
        try {
            if (verifTextStudent()) {
                StudentDao dao = new StudentDao();
                Student student = new Student();
                SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
                student.setId(txtID.getText());
                student.setFullName(txtfullname.getText());
                if (rdbMale.isSelected()) {
                    student.setGender("Nam");
                } else {
                    student.setGender("Nữ");
                }
                student.setBirthdate(da.format(jDateChooserBirthdate.getDate()));
                student.setAddress(txaAddress.getText());
                student.setPhoneNum(txtPhone.getText());
                student.setEmail(txtEmail.getText());
                if (dao.addStudent(student)) {
                    JOptionPane.showMessageDialog(this, "Add thanh cong");
                } else {
                    JOptionPane.showMessageDialog(this, "Add khong thanh cong");
                }
                
                loadTableStudentData();
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAddStudentActionPerformed

    private void btnUpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStudentActionPerformed
        try {
            if (verifTextStudent()) {
                StudentDao dao = new StudentDao();
                Student student = new Student();
                SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
                student.setId(txtID.getText());
                student.setFullName(txtfullname.getText());
                if (rdbMale.isSelected()) {
                    student.setGender("Nam");
                } else {
                    student.setGender("Nữ");
                }
                student.setBirthdate(da.format(jDateChooserBirthdate.getDate()));
                student.setAddress(txaAddress.getText());
                student.setPhoneNum(txtPhone.getText());
                student.setEmail(txtEmail.getText());
                if (dao.updateStudent(student)) {
                    JOptionPane.showMessageDialog(this, "Update thanh cong");
                } else {
                    JOptionPane.showMessageDialog(this, "Update khong thanh cong");
                }
                
                loadTableStudentData();
            }

        } catch (Exception ex) {
            Logger.getLogger(Main_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateStudentActionPerformed


    private void tblStudentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMousePressed
        try {
            JTable table = (JTable) evt.getSource();
            if (evt.getClickCount() == 2 && table.getSelectedRow() >= 0) {
                Object idObject = tblStudents.getValueAt(table.getSelectedRow(), 0);
                StudentDao dao = new StudentDao();
                Student student = dao.findStudentByID(idObject.toString());
                if (student != null) {
                    txtID.setText(student.getId());
                    txtfullname.setText(student.getFullName());
                    if (student.getGender().equals("Nam")) {
                        rdbMale.setSelected(true);
                    } else {
                        rdbFemale.setSelected(true);
                    }
                    SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
                    jDateChooserBirthdate.setDate(da.parse(student.getBirthdate()));
                    txaAddress.setText(student.getAddress());
                    txtPhone.setText(student.getPhoneNum());
                    txtEmail.setText(student.getEmail());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }//GEN-LAST:event_tblStudentsMousePressed
    }

    private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed

        try {
            StringBuilder sb = new StringBuilder();
            if (txtID.getText().equals("")) {
                sb.append("Vui long nhap ID");
                txtfullname.setBackground(Color.red);
            } else {
                txtfullname.setBackground(Color.white);
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
            if (JOptionPane.showConfirmDialog(this, "Ban co muon xoa hoc sinh co ID: " + txtID.getText()) != JOptionPane.YES_OPTION) {
                return;
            }
            StudentDao dao = new StudentDao();
            String id = txtID.getText();
            if (dao.deleteStudent(id)) {
                JOptionPane.showMessageDialog(this, "Delete thanh cong");
            } else {
                JOptionPane.showMessageDialog(this, "Delete khong thanh cong");
            }
            resetFormStudent();
            loadTableStudentData();
        } catch (Exception ex) {
            Logger.getLogger(Main_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteStudentActionPerformed

    private void txtIDScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDScoreActionPerformed

    }//GEN-LAST:event_txtIDScoreActionPerformed

    private void tblScoreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScoreMousePressed
        try {
            JTable table = (JTable) evt.getSource();
            if (evt.getClickCount() == 2 && table.getSelectedRow() >= 0) {
                Object idObject = tblScore.getValueAt(table.getSelectedRow(), 0);
                ScoreDao dao = new ScoreDao();
                Score score = dao.findByID(idObject.toString());
                if (score != null) {
                    txtIDScore.setText(score.getId());
                    txtfullnameScore.setText(score.getFullname());
                    txtHanhKiem.setText(score.getHanhKiem());
                    txtToan.setText(Float.toString(score.getToan()));
                    txtVan.setText(Float.toString(score.getVan()));
                    txtAnh.setText(Float.toString(score.getAnh()));
                    txtLy.setText(Float.toString(score.getLy()));
                    txtHoa.setText(Float.toString(score.getHoa()));
                    txtSinh.setText(Float.toString(score.getSinh()));
                    txtDia.setText(Float.toString(score.getDia()));
                    txtSu.setText(Float.toString(score.getSu()));
                    txtQP.setText(Float.toString(score.getQuocphong()));
                    txtTin.setText(Float.toString(score.getTin()));
                    txtGDCD.setText(Float.toString(score.getGdcd()));
                    txtTheChat.setText(Float.toString(score.getThechat()));
                    txtDTB.setText(Float.toString(score.getDtb()));

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_tblScoreMousePressed

    private void btnAddScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddScoreActionPerformed
        try {
//            StringBuilder sb = new StringBuilder();
//            if (txtfullnameScore.getText().equals("")) {
//                sb.append("Vui long nhap ho ten");
//                txtfullnameScore.setBackground(Color.red);
//            } else {
//                txtfullnameScore.setBackground(Color.white);
//            }
//            if (sb.length() > 0) {
//                JOptionPane.showMessageDialog(this, sb.toString());
//                return;
//            }
            if (verifiTextScore()) {
                ScoreDao dao = new ScoreDao();
                Score score = new Score();
                score.setId(txtIDScore.getText());
                score.setFullname(txtfullnameScore.getText());
                score.setHanhKiem(txtHanhKiem.getText());
                score.setToan(Float.parseFloat(txtToan.getText()));
                score.setVan(Float.parseFloat(txtVan.getText()));
                score.setAnh(Float.parseFloat(txtAnh.getText()));
                score.setLy(Float.parseFloat(txtLy.getText()));
                score.setHoa(Float.parseFloat(txtHoa.getText()));
                score.setSinh(Float.parseFloat(txtSinh.getText()));
                score.setDia(Float.parseFloat(txtDia.getText()));
                score.setSu(Float.parseFloat(txtSu.getText()));
                score.setQuocphong(Float.parseFloat(txtQP.getText()));
                score.setTin(Float.parseFloat(txtTin.getText()));
                score.setGdcd(Float.parseFloat(txtGDCD.getText()));
                score.setThechat(Float.parseFloat(txtTheChat.getText()));
                score.setDtb(Float.parseFloat(txtDTB.getText()));

                if (dao.addScore(score)) {
                    JOptionPane.showMessageDialog(this, "Add thanh cong");
                } else {
                    JOptionPane.showMessageDialog(this, "Add khong thanh cong");
                }
                resetFormScore();
                loadTableScoretData();
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAddScoreActionPerformed

    private void btnUpdateScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateScoreActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            if (txtfullnameScore.getText().equals("")) {
                sb.append("Vui long nhap ho ten");
                txtfullnameScore.setBackground(Color.red);
            } else {
                txtfullnameScore.setBackground(Color.white);
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
            ScoreDao dao = new ScoreDao();
            Score score = new Score();
            score.setId(txtIDScore.getText());
            score.setFullname(txtfullnameScore.getText());
            score.setHanhKiem(txtHanhKiem.getText());
            score.setToan(Float.parseFloat(txtToan.getText()));
            score.setVan(Float.parseFloat(txtVan.getText()));
            score.setAnh(Float.parseFloat(txtAnh.getText()));
            score.setLy(Float.parseFloat(txtLy.getText()));
            score.setHoa(Float.parseFloat(txtHoa.getText()));
            score.setSinh(Float.parseFloat(txtSinh.getText()));
            score.setDia(Float.parseFloat(txtDia.getText()));
            score.setSu(Float.parseFloat(txtSu.getText()));
            score.setQuocphong(Float.parseFloat(txtQP.getText()));
            score.setTin(Float.parseFloat(txtTin.getText()));
            score.setGdcd(Float.parseFloat(txtGDCD.getText()));
            score.setThechat(Float.parseFloat(txtTheChat.getText()));
            score.setDtb(Float.parseFloat(txtDTB.getText()));
            if (dao.updateScore(score)) {
                JOptionPane.showMessageDialog(this, "Update thanh cong");
            } else {
                JOptionPane.showMessageDialog(this, "Update khong thanh cong");
            }
            resetFormScore();
            loadTableScoretData();
        } catch (Exception ex) {
            Logger.getLogger(Main_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateScoreActionPerformed

    private void btnDeleteScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteScoreActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            if (txtIDScore.getText().equals("")) {
                sb.append("Vui long nhap ID");
                txtIDScore.setBackground(Color.red);
            } else {
                txtIDScore.setBackground(Color.white);
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
            if (JOptionPane.showConfirmDialog(this, "Ban co muon xoa diem cua hoc sinh co ID: " + txtIDScore.getText()) != JOptionPane.YES_OPTION) {
                return;
            }
            ScoreDao dao = new ScoreDao();
            String id = txtIDScore.getText();
            if (dao.deleteScore(id)) {
                JOptionPane.showMessageDialog(this, "Delete thanh cong");
            } else {
                JOptionPane.showMessageDialog(this, "Delete khong thanh cong");
            }
            resetFormScore();
            loadTableScoretData();
        } catch (Exception ex) {
            Logger.getLogger(Main_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteScoreActionPerformed

    private void txtToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToanActionPerformed

    }//GEN-LAST:event_txtToanActionPerformed

    private void txtHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoaActionPerformed

    }//GEN-LAST:event_txtHoaActionPerformed
    //methol reset form score 
    private void btnResetScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetScoreActionPerformed
        resetFormScore();
    }//GEN-LAST:event_btnResetScoreActionPerformed
    //  methol reset form students
    private void btnResetStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetStudentActionPerformed
        resetFormStudent();
    }//GEN-LAST:event_btnResetStudentActionPerformed

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        // allow only number:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void txtHanhKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHanhKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHanhKiemActionPerformed

    private void txtDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaActionPerformed

    private void txtIDScoreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDScoreKeyPressed
       
      
        
    }//GEN-LAST:event_txtIDScoreKeyPressed

    /**
     * @param args the command line arguments
     */
    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "CƠ CẤU TỶ LỆ XẾP LOẠI HỌC SINH", dataset, true, true, true);
        return chart;
    }
    private static PieDataset createDataset() throws Exception {
        ScoreDao dao = new ScoreDao();
        List<Score> list = dao.getScore();
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Học sinh giỏi",new Float(dao.getHSGioi()*10));
        dataset.setValue("Học sinh khá", new Float(dao.getHSKha()*10));
        dataset.setValue("Học sinh trung bình", new Float(dao.getHSTB()*10));
        dataset.setValue("Học sinh yếu", new Float(dao.getHSYeu()*10));

        return dataset;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddScore;
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnDeleteScore;
    private javax.swing.JButton btnDeleteStudent;
    private javax.swing.JButton btnResetScore;
    private javax.swing.JButton btnResetStudent;
    private javax.swing.JButton btnScore;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnUpdateScore;
    private javax.swing.JButton btnUpdateStudent;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnsearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooserBirthdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel pnBieuDo;
    private javax.swing.JPanel pnButtonStudent;
    private javax.swing.JPanel pnInfor;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnScore;
    private javax.swing.JPanel pnScoreforSub;
    private javax.swing.JPanel pnStudent;
    private javax.swing.JPanel pnlmenu;
    private javax.swing.JPanel pnlprinciple;
    private javax.swing.JPanel pnltop;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JScrollPane scrTableScore;
    private javax.swing.JScrollPane scrTableStudent;
    private javax.swing.JTable tblScore;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextArea txaAddress;
    private javax.swing.JTextField txtAnh;
    private javax.swing.JTextField txtDTB;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGDCD;
    private javax.swing.JTextField txtHanhKiem;
    private javax.swing.JTextField txtHoa;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDScore;
    private javax.swing.JTextField txtLy;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtQP;
    private javax.swing.JTextField txtSinh;
    private javax.swing.JTextField txtSu;
    private javax.swing.JTextField txtTheChat;
    private javax.swing.JTextField txtTin;
    private javax.swing.JTextField txtToan;
    private javax.swing.JTextField txtVan;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtfullnameScore;
    // End of variables declaration//GEN-END:variables

}
