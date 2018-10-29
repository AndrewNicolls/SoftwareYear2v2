/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Andrew
 */
public class returningStudentForm2 extends javax.swing.JFrame {

    /**
     * Creates new form returningStudentForm2
     */
    Connection con;
    Statement stmt;
    ResultSet rs;
    String userID;

    public returningStudentForm2() throws SQLException {
        initComponents();
        
    }
    public returningStudentForm2(String u) throws SQLException{
        initComponents();
        userID=u;
        populate();
    }
            // user input validation method
    public boolean Validate() {
        String[] testArr = {sponsorTitleTxf.getText(), firstnameTxf.getText(), surnameTxf.getText(),
            initialsTxf.getText(), hNumTxf.getText(), cNumTxf.getText(), emailAddTxf.getText(), idNumTxf.getText(),
             (String) mariStatCbx.getSelectedItem(), 
             resAddTxf1.getText() + "" + resAddTxf2.getText(), resZipTxf.getText(),postAddTxf1.getText() + "" + postAddTxf2.getText(),
              postZipTxf.getText()  };

        // verify user has entered data into required fields
        String inputTest = "";

        for (int i = 0; i < testArr.length; i++) {
            if (testArr[i].equals(inputTest)) {

                JOptionPane.showMessageDialog(rootPane, "please fill in all required fields", "ERROR", ERROR_MESSAGE);
                
                return false;
                

            }
           
                
        }
        //verify Home number
        if(hNumTxf.getText().length()!=10){
            
        JOptionPane.showMessageDialog(rootPane, "Invaild Home number", "ERROR", ERROR_MESSAGE);
        errHNum.setText("!");
        
        return false;
        }
        else{
        errHNum.setText("");
        }
        //verify CellNo
         if(cNumTxf.getText().length()!=10){
            
        JOptionPane.showMessageDialog(rootPane, "Invaild Cellphone number", "ERROR", ERROR_MESSAGE);
        errCNum.setText("!");
        
        return false;
        
        }
         else{
        errCNum.setText("");
        }
        //verify email
        String email =emailAddTxf.getText(); 
        if(!email.contains("@")|| !email.contains(".")){
         
        JOptionPane.showMessageDialog(rootPane, "Invaild email address", "ERROR", ERROR_MESSAGE);
        errEmail.setText("!");
        return false;
         }
         else{
             errEmail.setText("");
         }
        
        //verify ID No. (Local)
        String ID = idNumTxf.getText();
        if(ID.length()!=13){
        
        JOptionPane.showMessageDialog(rootPane, "Invaild ID number", "ERROR", ERROR_MESSAGE);
        errID.setText("!");
        return false;
        }
        else{
            errID.setText("");
        }
     
        if(resZipTxf.getText().length()!=4){
        JOptionPane.showMessageDialog(rootPane, "Invaild Zip Code", "ERROR", ERROR_MESSAGE);
        errZipRes.setText("!");
        return false;
        
        }
        else{
        
            errZipRes.setText("");
        }
         if(postZipTxf.getText().length()!=4){
        JOptionPane.showMessageDialog(rootPane, "Invaild Zip Code", "ERROR", ERROR_MESSAGE);
        errZipPost.setText("!");
        return false;
        
        }
        else{
        
            errZipPost.setText("");
        }
        
               
        return true;

    }
    
    public void populate() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/ease", "root", "");
        
        stmt = con.createStatement();
        String sql = "SELECT * FROM sponsor WHERE idStudent ='"+userID+"'";
        rs = stmt.executeQuery(sql);
        rs.next();
        
        String idSponsor = rs.getString("idSponsor");
        String title = rs.getString("Title");
        String firstName = rs.getString("Name");
        String lastName = rs.getString("Surname");
        String initials = rs.getString("Initials");
        String IDnum = rs.getString("ID Number");
        String maritalStatus = rs.getString("Marital Status");
        String email = rs.getString("email");
        String cellNum = rs.getString("cellNum");
        String homeNum = rs.getString("homeNum");
        String resAddress = rs.getString("resAddress");
        String resZip = rs.getString("resZip");
        String postAddress = rs.getString("postAddress");
        String postZip = rs.getString("postZip");
        
        sponsorTitleTxf.setText(title);
        firstnameTxf.setText(firstName);
        surnameTxf.setText(lastName);
        initialsTxf.setText(initials);
        idNumTxf.setText(IDnum);
        mariStatCbx.setSelectedItem(maritalStatus);
        emailAddTxf.setText(email);
        cNumTxf.setText(cellNum);
        hNumTxf.setText(homeNum);
        resAddTxf1.setText(resAddress);
        resZipTxf.setText(resZip);
        postAddTxf1.setText(postAddress);
        postZipTxf.setText(postZip);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        reminderLbl = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        sponsorTitleLbl = new javax.swing.JLabel();
        firstnameLbl = new javax.swing.JLabel();
        surnameLbl = new javax.swing.JLabel();
        initialsLbl = new javax.swing.JLabel();
        idNumLbl = new javax.swing.JLabel();
        mariStatLbl = new javax.swing.JLabel();
        emailAddLbl = new javax.swing.JLabel();
        cNumLbl = new javax.swing.JLabel();
        hNumLbl = new javax.swing.JLabel();
        resAddLbl = new javax.swing.JLabel();
        resZipLbl = new javax.swing.JLabel();
        postAddLbl = new javax.swing.JLabel();
        postZipLbl = new javax.swing.JLabel();
        sponsorTitleTxf = new javax.swing.JTextField();
        firstnameTxf = new javax.swing.JTextField();
        surnameTxf = new javax.swing.JTextField();
        starLbl1 = new javax.swing.JLabel();
        starLbl2 = new javax.swing.JLabel();
        starLbl3 = new javax.swing.JLabel();
        starLbl4 = new javax.swing.JLabel();
        starLbl5 = new javax.swing.JLabel();
        starLbl7 = new javax.swing.JLabel();
        starLbl6 = new javax.swing.JLabel();
        starLbl9 = new javax.swing.JLabel();
        starLbl8 = new javax.swing.JLabel();
        starLbl10 = new javax.swing.JLabel();
        starLbl11 = new javax.swing.JLabel();
        starLbl12 = new javax.swing.JLabel();
        starLbl13 = new javax.swing.JLabel();
        initialsTxf = new javax.swing.JTextField();
        emailAddTxf = new javax.swing.JTextField();
        cNumTxf = new javax.swing.JTextField();
        mariStatCbx = new javax.swing.JComboBox<String>();
        idNumTxf = new javax.swing.JTextField();
        hNumTxf = new javax.swing.JTextField();
        resAddTxf1 = new javax.swing.JTextField();
        resAddTxf2 = new javax.swing.JTextField();
        resZipTxf = new javax.swing.JTextField();
        postAddTxf1 = new javax.swing.JTextField();
        postAddTxf2 = new javax.swing.JTextField();
        postZipTxf = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        errHNum = new javax.swing.JLabel();
        errCNum = new javax.swing.JLabel();
        errEmail = new javax.swing.JLabel();
        errID = new javax.swing.JLabel();
        errZipRes = new javax.swing.JLabel();
        errZipPost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reminderLbl.setForeground(new java.awt.Color(255, 0, 0));
        reminderLbl.setText("Please confirm that all the information below is correct");

        titleLbl.setText("Sponsor details");

        sponsorTitleLbl.setText("Title");

        firstnameLbl.setText("Firstname");

        surnameLbl.setText("Surname");

        initialsLbl.setText("Initials");

        idNumLbl.setText("ID Number");

        mariStatLbl.setText("Marital Status");

        emailAddLbl.setText("Email addresss");

        cNumLbl.setText("Cell number");

        hNumLbl.setText("Home number");

        resAddLbl.setText("Residential address");

        resZipLbl.setText("Area code");

        postAddLbl.setText("Postal address");

        postZipLbl.setText("Area code");

        starLbl1.setForeground(new java.awt.Color(255, 0, 0));
        starLbl1.setText(" *");

        starLbl2.setForeground(new java.awt.Color(255, 0, 0));
        starLbl2.setText(" *");

        starLbl3.setForeground(new java.awt.Color(255, 0, 0));
        starLbl3.setText(" *");

        starLbl4.setForeground(new java.awt.Color(255, 0, 0));
        starLbl4.setText(" *");

        starLbl5.setForeground(new java.awt.Color(255, 0, 0));
        starLbl5.setText(" *");

        starLbl7.setForeground(new java.awt.Color(255, 0, 0));
        starLbl7.setText(" *");

        starLbl6.setForeground(new java.awt.Color(255, 0, 0));
        starLbl6.setText(" *");

        starLbl9.setForeground(new java.awt.Color(255, 0, 0));
        starLbl9.setText(" *");

        starLbl8.setForeground(new java.awt.Color(255, 0, 0));
        starLbl8.setText(" *");

        starLbl10.setForeground(new java.awt.Color(255, 0, 0));
        starLbl10.setText(" *");

        starLbl11.setForeground(new java.awt.Color(255, 0, 0));
        starLbl11.setText(" *");

        starLbl12.setForeground(new java.awt.Color(255, 0, 0));
        starLbl12.setText(" *");

        starLbl13.setForeground(new java.awt.Color(255, 0, 0));
        starLbl13.setText(" *");

        mariStatCbx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Married", "Divorced", "Single", "Widowed" }));

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        errHNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errHNum.setForeground(new java.awt.Color(255, 0, 0));

        errCNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errCNum.setForeground(new java.awt.Color(255, 0, 0));

        errEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errEmail.setForeground(new java.awt.Color(255, 0, 0));

        errID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errID.setForeground(new java.awt.Color(255, 0, 0));

        errZipRes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errZipRes.setForeground(new java.awt.Color(255, 0, 0));

        errZipPost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errZipPost.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cNumLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(hNumLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resAddLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(resAddTxf2)
                            .addComponent(resAddTxf1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hNumTxf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(cNumTxf))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errCNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errHNum)
                                .addGap(62, 62, 62))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resZipLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(postAddLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(postZipLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(postAddTxf1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resZipTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errZipRes))
                            .addComponent(postAddTxf2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(postZipTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errZipPost))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(backBtn)
                        .addGap(71, 71, 71)
                        .addComponent(nextBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titleLbl)
                            .addComponent(reminderLbl)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(mariStatCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(idNumLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(mariStatLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(87, 87, 87)
                                .addComponent(idNumTxf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(initialsLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(surnameLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(surnameTxf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(initialsTxf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(sponsorTitleLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(firstnameLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sponsorTitleTxf)
                                    .addComponent(firstnameTxf, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(emailAddLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(starLbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(emailAddTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errEmail)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(reminderLbl)
                .addGap(18, 18, 18)
                .addComponent(titleLbl)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sponsorTitleLbl)
                    .addComponent(sponsorTitleTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameLbl)
                    .addComponent(firstnameTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLbl)
                    .addComponent(surnameTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialsLbl)
                    .addComponent(starLbl4)
                    .addComponent(initialsTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idNumLbl)
                    .addComponent(starLbl5)
                    .addComponent(idNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mariStatLbl)
                    .addComponent(starLbl6)
                    .addComponent(mariStatCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAddLbl)
                    .addComponent(starLbl7)
                    .addComponent(emailAddTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cNumLbl)
                    .addComponent(starLbl8)
                    .addComponent(cNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errCNum))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hNumLbl)
                    .addComponent(starLbl9)
                    .addComponent(hNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errHNum))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resAddLbl)
                    .addComponent(starLbl10)
                    .addComponent(resAddTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resAddTxf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resZipLbl)
                    .addComponent(starLbl11)
                    .addComponent(resZipTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errZipRes))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postAddLbl)
                    .addComponent(starLbl12)
                    .addComponent(postAddTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(postAddTxf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postZipLbl)
                    .addComponent(postZipTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl13)
                    .addComponent(errZipPost))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(nextBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
      
        boolean updateSuccess4 = false;

            //input validation
            updateSuccess4 = Validate();
        
        if (updateSuccess4 == true) {
            String firstName = firstnameTxf.getText();
            String initials = initialsTxf.getText();
            String surname = surnameTxf.getText();
            String sponsorTitle = sponsorTitleTxf.getText();
            String homeNum = hNumTxf.getText();
            String email = emailAddTxf.getText();            
            String maritalStatus = (String) mariStatCbx.getSelectedItem();
            String cellNum = cNumTxf.getText();
            String resAddress = resAddTxf1.getText() + resAddTxf2.getText();
            String resZip = resZipTxf.getText();
            String postAddress = postAddTxf1.getText() + postAddTxf2.getText();
            String postZip = postZipTxf.getText();
            String idNum = idNumTxf.getText();
            
            Connection connection;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/ease", "root", "");
                Statement st = connection.createStatement();
                
                st.execute("UPDATE `ease`.`sponsor` SET `idSponsor` = '"+idNum+"',`Title` = '"+sponsorTitle+"',`Name` = '"+firstName+"',"
                     + "`Surname` = '"+surname+"',`initials` = '"+initials+"',`ID Number` = '"+idNum+"',"
                     + "`Marital status` = '"+maritalStatus+"',`email` = '"+email+"',`cellNum` = '"+cellNum+"'"
                     + ",`HomeNum` = '"+homeNum+"',`resAddress` = '"+resAddress+"',`resZip` = '"+resZip+"'"
                     + ",`postAddress` = '"+postAddress+"',`postZip` = '"+postZip+"'  WHERE `idStudent` ='"+userID+"'");
                
                
                
                
                
               /* st.execute("UPDATE `ease`.`sponsor` SET `Name`='" + firstName + "',`Surname`='" + surname + "'"
                        + ",`homeNum` ='" + homeNum + "'`,`email`='" + email + "',`maritalStatus`='" + maritalStatus + "',`Initials`='" + initials + "'"
                        + ",`cellNum`='" + cellNum + "',`resAddress`='" + resAddress + "',`resZip`='" + resZip + "',`postAddress`='" + postAddress + "',`postZip`='" + postZip + "',`Title`='" + sponsorTitle + "'"
                        + " WHERE `idStudent` ='"+userID+"'");                
                */
            } catch (SQLException ex) {
                Logger.getLogger(adminLoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            setVisible(false);
            finishScreen object = new finishScreen();
            object.setVisible(true);
        }        
    }//GEN-LAST:event_nextBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
       this.setVisible(false);
       
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(returningStudentForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returningStudentForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returningStudentForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returningStudentForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new returningStudentForm2().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(returningStudentForm2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cNumLbl;
    private javax.swing.JTextField cNumTxf;
    private javax.swing.JLabel emailAddLbl;
    private javax.swing.JTextField emailAddTxf;
    private javax.swing.JLabel errCNum;
    private javax.swing.JLabel errEmail;
    private javax.swing.JLabel errHNum;
    private javax.swing.JLabel errID;
    private javax.swing.JLabel errZipPost;
    private javax.swing.JLabel errZipRes;
    private javax.swing.JLabel firstnameLbl;
    private javax.swing.JTextField firstnameTxf;
    private javax.swing.JLabel hNumLbl;
    private javax.swing.JTextField hNumTxf;
    private javax.swing.JLabel idNumLbl;
    private javax.swing.JTextField idNumTxf;
    private javax.swing.JLabel initialsLbl;
    private javax.swing.JTextField initialsTxf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> mariStatCbx;
    private javax.swing.JLabel mariStatLbl;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel postAddLbl;
    private javax.swing.JTextField postAddTxf1;
    private javax.swing.JTextField postAddTxf2;
    private javax.swing.JLabel postZipLbl;
    private javax.swing.JTextField postZipTxf;
    private javax.swing.JLabel reminderLbl;
    private javax.swing.JLabel resAddLbl;
    private javax.swing.JTextField resAddTxf1;
    private javax.swing.JTextField resAddTxf2;
    private javax.swing.JLabel resZipLbl;
    private javax.swing.JTextField resZipTxf;
    private javax.swing.JLabel sponsorTitleLbl;
    private javax.swing.JTextField sponsorTitleTxf;
    private javax.swing.JLabel starLbl1;
    private javax.swing.JLabel starLbl10;
    private javax.swing.JLabel starLbl11;
    private javax.swing.JLabel starLbl12;
    private javax.swing.JLabel starLbl13;
    private javax.swing.JLabel starLbl2;
    private javax.swing.JLabel starLbl3;
    private javax.swing.JLabel starLbl4;
    private javax.swing.JLabel starLbl5;
    private javax.swing.JLabel starLbl6;
    private javax.swing.JLabel starLbl7;
    private javax.swing.JLabel starLbl8;
    private javax.swing.JLabel starLbl9;
    private javax.swing.JLabel surnameLbl;
    private javax.swing.JTextField surnameTxf;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
