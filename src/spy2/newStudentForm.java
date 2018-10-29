/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy2;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Andrew
 */
public class newStudentForm extends javax.swing.JFrame {

    public String stuID = "";

    public String getStuID() {

        return stuID;
    }

    /**
     * Creates new form newStudentForm
     */
    public newStudentForm() {
        initComponents();

        //populating combobox with data froma  database
        Connection connection = null;
        ResultSet rs = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost/ease", "root", "");

            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM module;");
            while (rs.next()) {
                courseCbx.addItem(rs.getString("course"));
            }

        } catch (SQLException ex) {
        }
       
    }

    // user input validation method
    public boolean Validate() {
        String[] testArr = {(String) courseCbx.getSelectedItem(), fNameTxf.getText(), sNameTxf.getText(),
            dateRegistration.getDateFormatString(), hNumTxf.getText(), cNumTxf.getText(), emailTxf.getText(), IDTxf.getText(), dateBirth.getDateFormatString(),
             (String) genderCbx.getSelectedItem(), (String) languageCbx.getSelectedItem(), (String) raceCbx.getSelectedItem(),
             addressTxf1.getText() + "" + addressTxf2.getText(), zipTxf.getText()};

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
        String ID = IDTxf.getText();
        if(LresRbutton.isSelected()&&ID.length()!=13){
        
        JOptionPane.showMessageDialog(rootPane, "Invaild ID number", "ERROR", ERROR_MESSAGE);
        errID.setText("!");
        return false;
        }
        else{
            errID.setText("");
        }
        //verify Passport No. (International)
        if(intResRbutton.isSelected() && ID.length()!=9){
        JOptionPane.showMessageDialog(rootPane, "Invaild passport number", "ERROR", ERROR_MESSAGE);
        errID.setText("!");
        return false;
        
        }
        else{
        errID.setText("");
        }
        if(zipTxf.getText().length()!=4){
        JOptionPane.showMessageDialog(rootPane, "Invaild Zip Code", "ERROR", ERROR_MESSAGE);
        errZip.setText("!");
        return false;
        
        }
        else{
        
            errZip.setText("");
        }
        
               
        return true;

    }

    //code to generate new studentID
    public String generateID() {

        Random letterR = new Random();
        String letters = "BCDFGHJKLMNPQRSTVWXYZ";

        String randomLetter = "" + letters.charAt(letterR.nextInt(21)) + letters.charAt(letterR.nextInt(21)) + letters.charAt(letterR.nextInt(21));

        // (int) casts the double from the Math.random into an integer
        // (900)+100 sets the range of the random numbers (max-min+1)+min ie. (999-100+1)+100
        int number;

        number = (int) Math.floor(Math.random() * (9000) + 1000);

        String studentNum = randomLetter + "" + number;
        return studentNum;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nationality = new javax.swing.ButtonGroup();
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ease?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        administratorQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Administrator a");
        administratorList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : administratorQuery.getResultList();
        moduleQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT m FROM Module m");
        moduleList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : moduleQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        fNameLbl = new javax.swing.JLabel();
        sNameLbl = new javax.swing.JLabel();
        dorLbl = new javax.swing.JLabel();
        cNumLbl = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        intResRbutton = new javax.swing.JRadioButton();
        LresRbutton = new javax.swing.JRadioButton();
        fNameTxf = new javax.swing.JTextField();
        sNameTxf = new javax.swing.JTextField();
        cNumTxf = new javax.swing.JTextField();
        emailTxf = new javax.swing.JTextField();
        IDTxf = new javax.swing.JTextField();
        reminderLbl = new javax.swing.JLabel();
        studentInfoLbl = new javax.swing.JLabel();
        courseCbx = new javax.swing.JComboBox<>();
        courseLbl = new javax.swing.JLabel();
        starLbl2 = new javax.swing.JLabel();
        dobLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        langLbl = new javax.swing.JLabel();
        raceLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        zipLbl = new javax.swing.JLabel();
        starLbl9 = new javax.swing.JLabel();
        starLbl3 = new javax.swing.JLabel();
        starLbl1 = new javax.swing.JLabel();
        starLbl8 = new javax.swing.JLabel();
        genderCbx = new javax.swing.JComboBox<>();
        languageCbx = new javax.swing.JComboBox<>();
        raceCbx = new javax.swing.JComboBox<>();
        starLbl10 = new javax.swing.JLabel();
        starLbl11 = new javax.swing.JLabel();
        starLbl12 = new javax.swing.JLabel();
        starLbl13 = new javax.swing.JLabel();
        starLbl7 = new javax.swing.JLabel();
        starLbl6 = new javax.swing.JLabel();
        starLbl4 = new javax.swing.JLabel();
        addressTxf1 = new javax.swing.JTextField();
        addressTxf2 = new javax.swing.JTextField();
        hNumLbl = new javax.swing.JLabel();
        starLbl5 = new javax.swing.JLabel();
        hNumTxf = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        zipTxf = new javax.swing.JTextField();
        starLbl14 = new javax.swing.JLabel();
        errHNum = new javax.swing.JLabel();
        errCNum = new javax.swing.JLabel();
        errEmail = new javax.swing.JLabel();
        errID = new javax.swing.JLabel();
        errZip = new javax.swing.JLabel();
        dateRegistration = new com.toedter.calendar.JDateChooser();
        dateBirth = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fNameLbl.setText("Firstname");

        sNameLbl.setText("Surname");

        dorLbl.setText("Date of Registration ");

        cNumLbl.setText("Cellphone Number");

        emailLbl.setText("Email address");

        idLbl.setText("Identification/Passport Number");

        Nationality.add(intResRbutton);
        intResRbutton.setText("International");

        Nationality.add(LresRbutton);
        LresRbutton.setText("Local Resident");

        reminderLbl.setForeground(new java.awt.Color(255, 0, 0));
        reminderLbl.setText("Please fill in all required information (*)");

        studentInfoLbl.setText("Student Information");

        courseCbx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseCbxMouseClicked(evt);
            }
        });
        courseCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCbxActionPerformed(evt);
            }
        });

        courseLbl.setText("Course");

        starLbl2.setForeground(new java.awt.Color(255, 51, 0));
        starLbl2.setText("*");

        dobLbl.setText("Date of Birth");

        genderLbl.setText("Gender");

        langLbl.setText("Home language");

        raceLbl.setText("Race");

        addressLbl.setText("Residential address");

        zipLbl.setText("Area code");

        starLbl9.setForeground(new java.awt.Color(255, 51, 0));
        starLbl9.setText("*");

        starLbl3.setForeground(new java.awt.Color(255, 51, 0));
        starLbl3.setText("*");

        starLbl1.setForeground(new java.awt.Color(255, 51, 0));
        starLbl1.setText("*");

        starLbl8.setForeground(new java.awt.Color(255, 51, 0));
        starLbl8.setText("*");

        genderCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        languageCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "isiXhosa", "Afrikaans", "Portugese", "Spanish", "French", "Sotho", "Zulu", "Venda" }));

        raceCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Black", "Coloured", "White", "Asian", "Indian", "other" }));

        starLbl10.setForeground(new java.awt.Color(255, 51, 0));
        starLbl10.setText("*");

        starLbl11.setForeground(new java.awt.Color(255, 51, 0));
        starLbl11.setText("*");

        starLbl12.setForeground(new java.awt.Color(255, 51, 0));
        starLbl12.setText("*");

        starLbl13.setForeground(new java.awt.Color(255, 51, 0));
        starLbl13.setText("*");

        starLbl7.setForeground(new java.awt.Color(255, 51, 0));
        starLbl7.setText("*");

        starLbl6.setForeground(new java.awt.Color(255, 51, 0));
        starLbl6.setText("*");

        starLbl4.setForeground(new java.awt.Color(255, 51, 0));
        starLbl4.setText("*");

        hNumLbl.setText("Home number");

        starLbl5.setForeground(new java.awt.Color(255, 51, 0));
        starLbl5.setText("*");

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

        starLbl14.setForeground(new java.awt.Color(255, 51, 0));
        starLbl14.setText("*");

        errHNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errHNum.setForeground(new java.awt.Color(255, 0, 0));

        errCNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errCNum.setForeground(new java.awt.Color(204, 0, 0));

        errEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errEmail.setForeground(new java.awt.Color(255, 0, 0));

        errID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errID.setForeground(new java.awt.Color(204, 0, 0));

        errZip.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errZip.setForeground(new java.awt.Color(255, 0, 0));

        dateRegistration.setDateFormatString("yyyy-MM-dd");
        dateRegistration.setMaxSelectableDate(new Date());

        dateBirth.setDateFormatString("yyyy-MM-dd");
        dateBirth.setMaxSelectableDate(new java.util.Date(1009666890000L));
        dateBirth.setMinSelectableDate(new java.util.Date(-2208992310000L));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentInfoLbl)
                    .addComponent(reminderLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(genderLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(langLbl)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(raceLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dobLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(zipLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(sNameLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(idLbl)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(courseLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(starLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(fNameLbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(starLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(LresRbutton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(emailLbl)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(starLbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(hNumLbl)
                                                        .addGap(4, 4, 4)
                                                        .addComponent(starLbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(cNumLbl)))
                                            .addComponent(dorLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(starLbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(starLbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(starLbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backBtn)
                                    .addComponent(starLbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addressTxf2)
                                .addComponent(addressTxf1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(zipTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(errZip))
                                        .addComponent(nextBtn))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(hNumTxf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(intResRbutton, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fNameTxf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sNameTxf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cNumTxf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTxf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDTxf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(courseCbx, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(raceCbx, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(languageCbx, javax.swing.GroupLayout.Alignment.LEADING, 0, 167, Short.MAX_VALUE)
                                    .addComponent(genderCbx, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateRegistration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(dateBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errHNum, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(errCNum)
                                    .addComponent(errEmail)
                                    .addComponent(errID))))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(reminderLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentInfoLbl)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(intResRbutton)
                                    .addComponent(LresRbutton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(courseCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseLbl)
                                    .addComponent(starLbl1))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fNameLbl)
                                    .addComponent(fNameTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(starLbl2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sNameLbl)
                                    .addComponent(sNameTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(starLbl3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dorLbl)
                                    .addComponent(starLbl4)))
                            .addComponent(dateRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hNumLbl)
                            .addComponent(starLbl5)
                            .addComponent(hNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errHNum))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cNumLbl)
                            .addComponent(cNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(starLbl6)
                            .addComponent(errCNum))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLbl)
                            .addComponent(emailTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(starLbl7)
                            .addComponent(errEmail))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLbl)
                            .addComponent(IDTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(starLbl8)
                            .addComponent(errID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dobLbl)
                            .addComponent(starLbl9)))
                    .addComponent(dateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLbl)
                    .addComponent(genderCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(langLbl)
                    .addComponent(languageCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raceLbl)
                    .addComponent(raceCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLbl)
                    .addComponent(starLbl13)
                    .addComponent(addressTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addressTxf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipLbl)
                    .addComponent(zipTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl14)
                    .addComponent(errZip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn)
                    .addComponent(backBtn)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        
         //variable used to check whether user can progress to next screen
            boolean updateSuccess = false;

            //input validation
            updateSuccess = Validate();
            
        if (updateSuccess==true) {
            String nationality;
            if (LresRbutton.isSelected()) {
                nationality = "South African";
            } else {
                nationality = "Foreign";
            }

            // capturing student input
            stuID = generateID();
            String course = (String) courseCbx.getSelectedItem();
            String firstName = fNameTxf.getText();
            String surname = sNameTxf.getText();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateOfReg = dateFormat.format(dateRegistration.getDate());
            String dateOfBirth = dateFormat.format(dateBirth.getDate());
            
            
            //String dateOfReg = dateRegistration.getDateFormatString();
            String homeNum = hNumTxf.getText();
            String cellNum = cNumTxf.getText();
            String email = emailTxf.getText();
            String idNum = IDTxf.getText();
           // String dateOfBirth = dateBirth.getDateFormatString();
            String gender = (String) genderCbx.getSelectedItem();
            String language = (String) languageCbx.getSelectedItem();
            String race = (String) raceCbx.getSelectedItem();
            String resAddress = addressTxf1.getText() + "" + addressTxf2.getText();
            String zip = zipTxf.getText();

           
            

            String spID = generateID();

            Connection connection;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/ease", "root", "");
                Statement st = connection.createStatement();
                //The database needs to be updated NOT final

                //code to update table "student" in easeDB
                st.executeUpdate("INSERT INTO `student`(`idStudent`,`firstName`,`lastName`"
                        + ",`DOB`,`phoneNumber`,`zip`,`email`,`gender`,`nationality`,`IDnum`,"
                        + "`race`,`cellNum`,`resAddress`,`course`,`homeLang`,`idSponsor`)"
                        + "values('" + getStuID() + "','" + firstName + "','" + surname + "','" + dateOfBirth + "','" + cellNum + "','" + zip + "'"
                        + ",'" + email + "','" + gender + "','" + nationality + "','" + idNum + "','" + race + "','" + homeNum + "','" + resAddress + "'"
                        + ",'" + course + "','" + language + "','" + spID + "')");

                st.executeUpdate("INSERT INTO `sponsor`(`idSponsor`,`idStudent`) values('" + spID + "','" + getStuID() + "') ");

                //check to see if Query was successfull
                //System.out.println("db update successful");
                updateSuccess = true;
            } catch (SQLException ex) {
                Logger.getLogger(adminLoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (updateSuccess = true) {

                String host = "easeProject";
                String user = "softwareprojectyear2capetown@gmail.com";
                String to = emailTxf.getText();
                String sub = "Textbook List";
                String text = "Congratalations "+ firstName+" your enrollment has been completed " + "\n Please go look through the attached documents"+"\n Student Number: "+getStuID();

                boolean sessionDebug = false;
                Properties pros = new Properties();
                pros.put("mail.smtp.host", "smtp.gmail.com");
                pros.put("mail.smtp.port", "587");
                pros.put("mail.smtp.auth", "true");
                pros.put("mail.smtp.starttls.enable", "true");

                Session session = Session.getDefaultInstance(pros, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, host);
                    }
                });

                try {
                    Message msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress(user));
                    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    msg.setSubject(sub);

                    BodyPart messageBodyPart1 = new MimeBodyPart();
                    messageBodyPart1.setText(text);

                    BodyPart messageBodyPart2 = new MimeBodyPart();
                    String attachmentName = "C://Users/Rowan/Desktop/AndrewUpdate/SpRowan30-09-18/RowanSp2/src/files/textbookList.pdf";
                    DataSource source = new FileDataSource(attachmentName);
                    messageBodyPart2.setDataHandler(new DataHandler(source));
                    messageBodyPart2.setFileName(attachmentName);

                    Multipart multipartObject = new MimeMultipart();
                    multipartObject.addBodyPart(messageBodyPart1);
                    multipartObject.addBodyPart(messageBodyPart2);

                    msg.setContent(multipartObject);

                    Transport.send(msg);
                    System.out.println("Mail sent");

                } catch (AddressException ex) {
                    Logger.getLogger(newStudentForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
               
                this.setVisible(false);
                new newStudentForm2(getStuID()).setVisible(true);
             
            }
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new greetFrame().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_backBtnActionPerformed

    private void courseCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCbxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_courseCbxActionPerformed

    private void courseCbxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseCbxMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_courseCbxMouseClicked

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
            java.util.logging.Logger.getLogger(newStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newStudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDTxf;
    private javax.swing.JRadioButton LresRbutton;
    private javax.swing.ButtonGroup Nationality;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextField addressTxf1;
    private javax.swing.JTextField addressTxf2;
    private java.util.List<spy2.Administrator> administratorList;
    private javax.persistence.Query administratorQuery;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cNumLbl;
    private javax.swing.JTextField cNumTxf;
    private javax.swing.JComboBox<String> courseCbx;
    private javax.swing.JLabel courseLbl;
    private com.toedter.calendar.JDateChooser dateBirth;
    private com.toedter.calendar.JDateChooser dateRegistration;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JLabel dorLbl;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTxf;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel errCNum;
    private javax.swing.JLabel errEmail;
    private javax.swing.JLabel errHNum;
    private javax.swing.JLabel errID;
    private javax.swing.JLabel errZip;
    private javax.swing.JLabel fNameLbl;
    private javax.swing.JTextField fNameTxf;
    private javax.swing.JComboBox<String> genderCbx;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JLabel hNumLbl;
    private javax.swing.JTextField hNumTxf;
    private javax.swing.JLabel idLbl;
    private javax.swing.JRadioButton intResRbutton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel langLbl;
    private javax.swing.JComboBox<String> languageCbx;
    private java.util.List<spy2.Module> moduleList;
    private javax.persistence.Query moduleQuery;
    private javax.swing.JButton nextBtn;
    private javax.swing.JComboBox<String> raceCbx;
    private javax.swing.JLabel raceLbl;
    private javax.swing.JLabel reminderLbl;
    private javax.swing.JLabel sNameLbl;
    private javax.swing.JTextField sNameTxf;
    private javax.swing.JLabel starLbl1;
    private javax.swing.JLabel starLbl10;
    private javax.swing.JLabel starLbl11;
    private javax.swing.JLabel starLbl12;
    private javax.swing.JLabel starLbl13;
    private javax.swing.JLabel starLbl14;
    private javax.swing.JLabel starLbl2;
    private javax.swing.JLabel starLbl3;
    private javax.swing.JLabel starLbl4;
    private javax.swing.JLabel starLbl5;
    private javax.swing.JLabel starLbl6;
    private javax.swing.JLabel starLbl7;
    private javax.swing.JLabel starLbl8;
    private javax.swing.JLabel starLbl9;
    private javax.swing.JLabel studentInfoLbl;
    private javax.swing.JLabel zipLbl;
    private javax.swing.JTextField zipTxf;
    // End of variables declaration//GEN-END:variables
}
