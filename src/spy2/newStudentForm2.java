/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy2;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class newStudentForm2 extends javax.swing.JFrame {

    /**
     * Creates new form newStudentForm2
     */
    String studID="";
    public newStudentForm2() {
        initComponents();
        
    }
    public newStudentForm2(String i){
     initComponents();
      studID = i;
    }
        // user input validation method
    public boolean Validate() {
        String[] testArr = {titleTxf.getText(), fNameTxf.getText(), sNameTxf.getText(),
            initialTxf.getText(), hNumTxf.getText(), cNumTxf.getText(), emailTxf.getText(), idNumTxf.getText(),
             (String) maritalCbx.getSelectedItem(), 
             resTxf1.getText() + "" + resTxf2.getText(), zipResTxf.getText(),postTxf1.getText() + "" + postTxf2.getText(),
              zipPostTxf.getText()  };

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
        String email =emailTxf.getText(); 
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
     
        if(zipResTxf.getText().length()!=4){
        JOptionPane.showMessageDialog(rootPane, "Invaild Zip Code", "ERROR", ERROR_MESSAGE);
        errZipRes.setText("!");
        return false;
        
        }
        else{
        
            errZipRes.setText("");
        }
         if(zipPostTxf.getText().length()!=4){
        JOptionPane.showMessageDialog(rootPane, "Invaild Zip Code", "ERROR", ERROR_MESSAGE);
        errZipPost.setText("!");
        return false;
        
        }
        else{
        
            errZipPost.setText("");
        }
        
               
        return true;

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
        headingLbl = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        starLbl1 = new javax.swing.JLabel();
        starLbl2 = new javax.swing.JLabel();
        starLbl3 = new javax.swing.JLabel();
        starLbl4 = new javax.swing.JLabel();
        starLbl5 = new javax.swing.JLabel();
        starLbl6 = new javax.swing.JLabel();
        starLbl7 = new javax.swing.JLabel();
        starLbl8 = new javax.swing.JLabel();
        starLbl9 = new javax.swing.JLabel();
        starLbl10 = new javax.swing.JLabel();
        starLbl11 = new javax.swing.JLabel();
        starLbl13 = new javax.swing.JLabel();
        fNamelbl = new javax.swing.JLabel();
        sNameLbl = new javax.swing.JLabel();
        initialsLbl = new javax.swing.JLabel();
        idNumLbl = new javax.swing.JLabel();
        maritLbl = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        cellNumLbl = new javax.swing.JLabel();
        hNumLbl = new javax.swing.JLabel();
        resLbl = new javax.swing.JLabel();
        titleTxf = new javax.swing.JTextField();
        fNameTxf = new javax.swing.JTextField();
        sNameTxf = new javax.swing.JTextField();
        initialTxf = new javax.swing.JTextField();
        idNumTxf = new javax.swing.JTextField();
        emailTxf = new javax.swing.JTextField();
        cNumTxf = new javax.swing.JTextField();
        hNumTxf = new javax.swing.JTextField();
        resTxf1 = new javax.swing.JTextField();
        resTxf2 = new javax.swing.JTextField();
        zipResLbl1 = new javax.swing.JLabel();
        zipResTxf = new javax.swing.JTextField();
        postLbl = new javax.swing.JLabel();
        postTxf1 = new javax.swing.JTextField();
        postTxf2 = new javax.swing.JTextField();
        zipPostLbl = new javax.swing.JLabel();
        starLbl12 = new javax.swing.JLabel();
        zipPostTxf = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        maritalCbx = new javax.swing.JComboBox<String>();
        errHNum = new javax.swing.JLabel();
        errCNum = new javax.swing.JLabel();
        errEmail = new javax.swing.JLabel();
        errID = new javax.swing.JLabel();
        errZipRes = new javax.swing.JLabel();
        errZipPost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reminderLbl.setForeground(new java.awt.Color(255, 0, 0));
        reminderLbl.setText("Please fill in all required information (*)");

        headingLbl.setText("Sponsor details");

        titleLbl.setText("Title");

        starLbl1.setForeground(new java.awt.Color(255, 51, 0));
        starLbl1.setText("*");

        starLbl2.setForeground(new java.awt.Color(255, 51, 0));
        starLbl2.setText("*");

        starLbl3.setForeground(new java.awt.Color(255, 51, 0));
        starLbl3.setText("*");

        starLbl4.setForeground(new java.awt.Color(255, 51, 0));
        starLbl4.setText("*");

        starLbl5.setForeground(new java.awt.Color(255, 51, 0));
        starLbl5.setText("*");

        starLbl6.setForeground(new java.awt.Color(255, 51, 0));
        starLbl6.setText("*");

        starLbl7.setForeground(new java.awt.Color(255, 51, 0));
        starLbl7.setText("*");

        starLbl8.setForeground(new java.awt.Color(255, 51, 0));
        starLbl8.setText("*");

        starLbl9.setForeground(new java.awt.Color(255, 51, 0));
        starLbl9.setText("*");

        starLbl10.setForeground(new java.awt.Color(255, 51, 0));
        starLbl10.setText("*");

        starLbl11.setForeground(new java.awt.Color(255, 51, 0));
        starLbl11.setText("*");

        starLbl13.setForeground(new java.awt.Color(255, 51, 0));
        starLbl13.setText("*");

        fNamelbl.setText("First name");

        sNameLbl.setText("Surname");

        initialsLbl.setText("Initials");

        idNumLbl.setText("ID Number");

        maritLbl.setText("Marital status");

        emailLbl.setText("Email address");

        cellNumLbl.setText("Cellphone number");

        hNumLbl.setText("Home number");

        resLbl.setText("Residential address");

        zipResLbl1.setText("Area code");

        postLbl.setText("Postal address");

        zipPostLbl.setText("Area code");

        starLbl12.setForeground(new java.awt.Color(255, 51, 0));
        starLbl12.setText("*");

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

        maritalCbx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Married", "Single", "Divorced", "Widowed" }));

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
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reminderLbl)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(hNumLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cellNumLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cNumTxf, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(hNumTxf))
                        .addGap(10, 10, 10)
                        .addComponent(errCNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errHNum))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(zipResLbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(postLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backBtn)
                                    .addComponent(starLbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(zipPostLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(starLbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resTxf2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postTxf2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(zipResTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errZipRes))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(zipPostTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errZipPost))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(nextBtn))))
                    .addComponent(headingLbl)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(idNumLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(idNumTxf))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(initialsLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(initialTxf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sNameLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(sNameTxf))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(fNamelbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(fNameTxf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(titleLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addComponent(titleTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(emailLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(maritLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maritalCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(emailTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(errEmail)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errID)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(reminderLbl)
                .addGap(18, 18, 18)
                .addComponent(headingLbl)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLbl)
                    .addComponent(starLbl1)
                    .addComponent(titleTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNamelbl)
                    .addComponent(starLbl2)
                    .addComponent(fNameTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sNameLbl)
                    .addComponent(starLbl3)
                    .addComponent(sNameTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialsLbl)
                    .addComponent(initialTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idNumLbl)
                    .addComponent(idNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl5)
                    .addComponent(errID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maritLbl)
                    .addComponent(starLbl6)
                    .addComponent(maritalCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLbl)
                    .addComponent(starLbl7)
                    .addComponent(emailTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cellNumLbl)
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
                    .addComponent(resLbl)
                    .addComponent(starLbl10)
                    .addComponent(resTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(resTxf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipResLbl1)
                    .addComponent(starLbl11)
                    .addComponent(zipResTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errZipRes))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postLbl)
                    .addComponent(postTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl12))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(starLbl13)
                            .addComponent(zipPostLbl))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(postTxf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(errZipPost)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(zipPostTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backBtn)
                            .addComponent(nextBtn))
                        .addGap(5, 5, 5))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new newStudentForm().setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_backBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        
          //variable used to check whether user can progress to next screen
            boolean updateSuccess2 = false;

            //input validation
            updateSuccess2 = Validate();
            
        if (updateSuccess2==true) {
        
        String title = titleTxf.getText();
        String fName = fNameTxf.getText();
        String surname = sNameTxf.getText();
        String initials = initialTxf.getText();
        String spID = idNumTxf.getText();
        String marital = ""+maritalCbx.getSelectedItem();
        String email = emailTxf.getText();
        String cellNo = cNumTxf.getText();
        String homeNo = hNumTxf.getText();
        String resAddress = resTxf1.getText()+""+resTxf2.getText();
        String resZip = zipResTxf.getText();
        String postAddress = postTxf1.getText() +""+postTxf2.getText();
        String postZip = zipPostTxf.getText();
        
       
        
         Connection connection;
           try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost/ease", "root", "");
             Statement st = connection.createStatement();
             //The database needs to be updated NOT final
             
             st.execute("UPDATE `ease`.`sponsor` SET `Title` = '"+title+"',`Name` = '"+fName+"',"
                     + "`Surname` = '"+surname+"',`initials` = '"+initials+"',`ID Number` = '"+spID+"',"
                     + "`Marital status` = '"+marital+"',`email` = '"+email+"',`cellNum` = '"+cellNo+"'"
                     + ",`HomeNum` = '"+homeNo+"',`resAddress` = '"+resAddress+"',`resZip` = '"+resZip+"'"
                     + ",`postAddress` = '"+postAddress+"',`postZip` = '"+postZip+"' WHERE `idStudent` = '"+studID+"'");
             

            
            
           }catch(SQLException ex){
               Logger.getLogger(adminLoginFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        this.setVisible(false);
        new finishScreen().setVisible(true);
        }
    }//GEN-LAST:event_nextBtnActionPerformed

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
            java.util.logging.Logger.getLogger(newStudentForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newStudentForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newStudentForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newStudentForm2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newStudentForm2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField cNumTxf;
    private javax.swing.JLabel cellNumLbl;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTxf;
    private javax.swing.JLabel errCNum;
    private javax.swing.JLabel errEmail;
    private javax.swing.JLabel errHNum;
    private javax.swing.JLabel errID;
    private javax.swing.JLabel errZipPost;
    private javax.swing.JLabel errZipRes;
    private javax.swing.JTextField fNameTxf;
    private javax.swing.JLabel fNamelbl;
    private javax.swing.JLabel hNumLbl;
    private javax.swing.JTextField hNumTxf;
    private javax.swing.JLabel headingLbl;
    private javax.swing.JLabel idNumLbl;
    private javax.swing.JTextField idNumTxf;
    private javax.swing.JTextField initialTxf;
    private javax.swing.JLabel initialsLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel maritLbl;
    private javax.swing.JComboBox<String> maritalCbx;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel postLbl;
    private javax.swing.JTextField postTxf1;
    private javax.swing.JTextField postTxf2;
    private javax.swing.JLabel reminderLbl;
    private javax.swing.JLabel resLbl;
    private javax.swing.JTextField resTxf1;
    private javax.swing.JTextField resTxf2;
    private javax.swing.JLabel sNameLbl;
    private javax.swing.JTextField sNameTxf;
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
    private javax.swing.JLabel titleLbl;
    private javax.swing.JTextField titleTxf;
    private javax.swing.JLabel zipPostLbl;
    private javax.swing.JTextField zipPostTxf;
    private javax.swing.JLabel zipResLbl1;
    private javax.swing.JTextField zipResTxf;
    // End of variables declaration//GEN-END:variables
}
