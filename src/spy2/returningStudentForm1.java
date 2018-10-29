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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
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

/**
 *
 * @author Andrew
 */
public class returningStudentForm1 extends javax.swing.JFrame {

    /**
     * Creates new form returningStudentForm1
     */
    String userID;
    String pass;
    Connection con;
    Statement stmt;
    ResultSet rs;

    public returningStudentForm1() throws SQLException {
        initComponents();
        
    }
        // user input validation method
    public boolean Validate() {
        String[] testArr = {(String) courseCbx.getSelectedItem(), firstnameTxf.getText(), surnameTxf.getText(),
             hNumTxf.getText(), cNumTxf.getText(), emailTxf.getText(), idNumTxf.getText(), dateBirth.getDateFormatString(),
             (String) genderCbx.getSelectedItem(), (String) languageCbx.getSelectedItem(), (String) raceCbx.getSelectedItem(),
             resAddrTxf1.getText() + "" + resAddrTxf2.getText(), zipTxf.getText()};

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
        if(lclBtn.isSelected()&&ID.length()!=13){
        
        JOptionPane.showMessageDialog(rootPane, "Invaild ID number", "ERROR", ERROR_MESSAGE);
        errID.setText("!");
        return false;
        }
        else{
            errID.setText("");
        }
        //verify Passport No. (International)
        if(intBtn.isSelected() && ID.length()!=9){
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


    public returningStudentForm1(String u, String p) throws SQLException {
        initComponents();
       
        userID = u;
        pass = p;
        populate();
    }

    public void populate() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/ease", "root", "");

        stmt = con.createStatement();
      //  String sql = "SELECT * FROM student";
        String sql = "SELECT * FROM student WHERE idStudent ='"+userID+"'";
        rs = stmt.executeQuery(sql);
        
        rs.next();
       // int idStudent_col = rs.getInt("idStudent");
        String idStudent = rs.getString("idStudent");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String DOB = rs.getString("DOB");
        int phoneNum_col = rs.getInt("phoneNumber");
        String phoneNum = Integer.toString(phoneNum_col);
        int zip_col = rs.getInt("zip");
        String zip = Integer.toString(zip_col);
        String email = rs.getString("email");
        String title = rs.getString("title");
        String gender = rs.getString("gender");
        String nationality = rs.getString("nationality");
        int IDnum_col = rs.getInt("IDnum");
        String IDnum = Integer.toString(IDnum_col);
        String race = rs.getString("race");
        int cellNum_col = rs.getInt("cellNum");
        String cellNum = Integer.toString(cellNum_col);
        String resAddress = rs.getString("resAddress");
        String course = rs.getString("course");
        String homeLang = rs.getString("homeLang");

        firstnameTxf.setText(firstName);
        surnameTxf.setText(lastName);
        idNumTxf.setText(IDnum);
        
        try {
            java.util.Date dob2 = new SimpleDateFormat("yyyy-MM-dd").parse(DOB);
            dateBirth.setDate(dob2);
        } catch (ParseException ex) {
            Logger.getLogger(returningStudentForm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        emailTxf.setText(email);
        cNumTxf.setText(cellNum);
        hNumTxf.setText(phoneNum);
        resAddrTxf1.setText(resAddress);
        zipTxf.setText(zip);
        courseCbx.setSelectedItem(course);
        genderCbx.setSelectedItem(gender);
        languageCbx.setSelectedItem(homeLang);
        raceCbx.setSelectedItem(race);
        
        if ("South African".equals(nationality)) {
            lclBtn.setSelected(true);
        } else {
            intBtn.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nationalityBtnGrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        starLbl3 = new javax.swing.JLabel();
        starLbl2 = new javax.swing.JLabel();
        idNumTxf = new javax.swing.JTextField();
        starLbl4 = new javax.swing.JLabel();
        starLbl6 = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        starLbl5 = new javax.swing.JLabel();
        lclBtn = new javax.swing.JRadioButton();
        starLbl7 = new javax.swing.JLabel();
        intBtn = new javax.swing.JRadioButton();
        starLbl8 = new javax.swing.JLabel();
        emailTxf = new javax.swing.JTextField();
        starLbl9 = new javax.swing.JLabel();
        cNumTxf = new javax.swing.JTextField();
        starLbl10 = new javax.swing.JLabel();
        courseLbl = new javax.swing.JLabel();
        starLbl11 = new javax.swing.JLabel();
        firstnameLbl = new javax.swing.JLabel();
        surnameLbl = new javax.swing.JLabel();
        resAddrTxf2 = new javax.swing.JTextField();
        idNumLbl = new javax.swing.JLabel();
        dobLbl = new javax.swing.JLabel();
        starLbl12 = new javax.swing.JLabel();
        starLbl13 = new javax.swing.JLabel();
        hNumTxf = new javax.swing.JTextField();
        starLbl1 = new javax.swing.JLabel();
        resAddrTxf1 = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        genderLbl = new javax.swing.JLabel();
        zipLbl = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        languageLbl = new javax.swing.JLabel();
        zipTxf = new javax.swing.JTextField();
        raceLbl = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        genderCbx = new javax.swing.JComboBox<>();
        cNumLbl = new javax.swing.JLabel();
        languageCbx = new javax.swing.JComboBox<>();
        hNumLbl = new javax.swing.JLabel();
        raceCbx = new javax.swing.JComboBox<>();
        resAddrLbl = new javax.swing.JLabel();
        courseCbx = new javax.swing.JComboBox<>();
        firstnameTxf = new javax.swing.JTextField();
        surnameTxf = new javax.swing.JTextField();
        reminderLbl = new javax.swing.JLabel();
        errHNum = new javax.swing.JLabel();
        errCNum = new javax.swing.JLabel();
        errEmail = new javax.swing.JLabel();
        errID = new javax.swing.JLabel();
        errZip = new javax.swing.JLabel();
        dateBirth = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        starLbl3.setForeground(new java.awt.Color(255, 0, 0));
        starLbl3.setText("*");

        starLbl2.setForeground(new java.awt.Color(255, 0, 0));
        starLbl2.setText(" *");

        starLbl4.setForeground(new java.awt.Color(255, 0, 0));
        starLbl4.setText(" *");

        starLbl6.setForeground(new java.awt.Color(255, 0, 0));
        starLbl6.setText(" *");

        titleLbl.setText("Student information");

        starLbl5.setForeground(new java.awt.Color(255, 0, 0));
        starLbl5.setText(" *");

        nationalityBtnGrp.add(lclBtn);
        lclBtn.setText("Local Resident");

        starLbl7.setForeground(new java.awt.Color(255, 0, 0));
        starLbl7.setText(" *");

        nationalityBtnGrp.add(intBtn);
        intBtn.setText("International");

        starLbl8.setForeground(new java.awt.Color(255, 0, 0));
        starLbl8.setText(" *");

        starLbl9.setForeground(new java.awt.Color(255, 0, 0));
        starLbl9.setText(" *");

        starLbl10.setForeground(new java.awt.Color(255, 0, 0));
        starLbl10.setText(" *");

        courseLbl.setText("Course");

        starLbl11.setForeground(new java.awt.Color(255, 0, 0));
        starLbl11.setText(" *");

        firstnameLbl.setText("Firstname");

        surnameLbl.setText("Surname");

        idNumLbl.setText("ID Number");

        dobLbl.setText("Date of Birth");

        starLbl12.setForeground(new java.awt.Color(255, 0, 0));
        starLbl12.setText(" *");

        starLbl13.setForeground(new java.awt.Color(255, 0, 0));
        starLbl13.setText(" *");

        starLbl1.setForeground(new java.awt.Color(255, 0, 0));
        starLbl1.setText(" *");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        genderLbl.setText("Gender");

        zipLbl.setText("Area code");

        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        languageLbl.setText("Home Language");

        raceLbl.setText("Race");

        emailLbl.setText("Email address");

        genderCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        cNumLbl.setText("Cell number");

        languageCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "isiXhosa", "Afrikaans", "Zulu", "French", "Portugese" }));

        hNumLbl.setText("Home number");

        raceCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Black", "White", "Coloured", "Indian", "Asian", "other" }));

        resAddrLbl.setText("Residential address");

        courseCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bsc IT", "Bcomm Law", "Ba Psych" }));

        reminderLbl.setForeground(new java.awt.Color(255, 0, 0));
        reminderLbl.setText("Please ensure all information below is correct");

        errHNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errHNum.setForeground(new java.awt.Color(255, 0, 0));

        errCNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errCNum.setForeground(new java.awt.Color(255, 0, 0));

        errEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errEmail.setForeground(new java.awt.Color(255, 0, 0));

        errID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errID.setForeground(new java.awt.Color(255, 0, 0));

        errZip.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errZip.setForeground(new java.awt.Color(255, 0, 0));

        dateBirth.setDateFormatString("yyyy MM dd");
        dateBirth.setMaxSelectableDate(new java.util.Date(978303709000L));
        dateBirth.setMinSelectableDate(new java.util.Date(-62135773091000L));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(genderLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(languageLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(raceLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(emailLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cNumLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(hNumLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(zipLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(courseLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lclBtn)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(dobLbl)
                                    .addGap(9, 9, 9)
                                    .addComponent(starLbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(surnameLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(idNumLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(resAddrLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starLbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(backBtn)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(firstnameLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resAddrTxf2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nextBtn)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(intBtn)
                                            .addComponent(genderCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(languageCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(raceCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(courseCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(firstnameTxf)
                                            .addComponent(surnameTxf)
                                            .addComponent(idNumTxf)
                                            .addComponent(emailTxf)
                                            .addComponent(cNumTxf)
                                            .addComponent(hNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(zipTxf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errZip)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(errCNum)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(errHNum)
                                                    .addComponent(errEmail)))
                                            .addComponent(errID)))
                                    .addComponent(resAddrTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reminderLbl)
                            .addComponent(titleLbl))))
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(reminderLbl)
                .addGap(18, 18, 18)
                .addComponent(titleLbl)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lclBtn)
                            .addComponent(intBtn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseLbl)
                            .addComponent(courseCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(starLbl1))
                        .addGap(19, 19, 19)
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
                            .addComponent(idNumLbl)
                            .addComponent(idNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(starLbl4)
                            .addComponent(errID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dobLbl)
                            .addComponent(starLbl5)))
                    .addComponent(dateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLbl)
                    .addComponent(genderCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageLbl)
                    .addComponent(languageCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raceLbl)
                    .addComponent(raceCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLbl)
                    .addComponent(emailTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl9)
                    .addComponent(errEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cNumLbl)
                    .addComponent(cNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl10)
                    .addComponent(errCNum))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hNumLbl)
                    .addComponent(hNumTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl11)
                    .addComponent(errHNum))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resAddrLbl)
                    .addComponent(resAddrTxf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl12))
                .addGap(18, 18, 18)
                .addComponent(resAddrTxf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipLbl)
                    .addComponent(zipTxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starLbl13)
                    .addComponent(errZip))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(nextBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new greetFrame().setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_backBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        //variable used to check whether user can progress to next screen
            boolean updateSuccess3 = false;

            //input validation
            updateSuccess3 = Validate();
        
        if (updateSuccess3==true) {

            String course = (String) courseCbx.getSelectedItem();
            String firstName = firstnameTxf.getText();
            String surname = surnameTxf.getText();
            String homeNum = hNumTxf.getText();
            String cellNum = cNumTxf.getText();
            String email = emailTxf.getText();
            String idNum = idNumTxf.getText();
            String gender = (String) genderCbx.getSelectedItem();
            String language = (String) languageCbx.getSelectedItem();
            String resAddress = resAddrTxf1.getText() + "" + resAddrTxf2.getText();
            String zip = zipTxf.getText();

            //variable used to check whether user can progress to next screen
            boolean updateSuccess = false;

            Connection connection;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/ease", "root", "");
                Statement st = connection.createStatement();

           
                st.execute("UPDATE `ease`.`student` SET `firstName` = '"+firstName+"',`lastName` = '"+surname+"',`phoneNumber` = '"+homeNum+"',"
                     + "`zip` = '"+zip+"',`email` = '"+email+"',`gender` = '"+gender+"',"
                     + "`cellNum` = '"+cellNum+"',`resAddress` = '"+resAddress+"',`course` = '"+course+"'"
                     + ",`homeLang` = '"+language+"' WHERE `idStudent` ='"+userID+"'");
                
                
                
                
                
                updateSuccess = true;

            } catch (SQLException ex) {
                Logger.getLogger(adminLoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (updateSuccess = true) {
                String host = "easeProject";
                String user = "softwareprojectyear2capetown@gmail.com";
                String to = emailTxf.getText();
                String sub = "Textbook List";
                String text = "Test to see if the email is sent with attachment" + "\n Reply on whatsapp or discord if received";

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
                try {
                    new returningStudentForm2(userID).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(returningStudentForm1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
            java.util.logging.Logger.getLogger(returningStudentForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returningStudentForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returningStudentForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returningStudentForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new returningStudentForm1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(returningStudentForm1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cNumLbl;
    private javax.swing.JTextField cNumTxf;
    private javax.swing.JComboBox<String> courseCbx;
    private javax.swing.JLabel courseLbl;
    private com.toedter.calendar.JDateChooser dateBirth;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTxf;
    private javax.swing.JLabel errCNum;
    private javax.swing.JLabel errEmail;
    private javax.swing.JLabel errHNum;
    private javax.swing.JLabel errID;
    private javax.swing.JLabel errZip;
    private javax.swing.JLabel firstnameLbl;
    private javax.swing.JTextField firstnameTxf;
    private javax.swing.JComboBox<String> genderCbx;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JLabel hNumLbl;
    private javax.swing.JTextField hNumTxf;
    private javax.swing.JLabel idNumLbl;
    private javax.swing.JTextField idNumTxf;
    private javax.swing.JRadioButton intBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> languageCbx;
    private javax.swing.JLabel languageLbl;
    private javax.swing.JRadioButton lclBtn;
    private javax.swing.ButtonGroup nationalityBtnGrp;
    private javax.swing.JButton nextBtn;
    private javax.swing.JComboBox<String> raceCbx;
    private javax.swing.JLabel raceLbl;
    private javax.swing.JLabel reminderLbl;
    private javax.swing.JLabel resAddrLbl;
    private javax.swing.JTextField resAddrTxf1;
    private javax.swing.JTextField resAddrTxf2;
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
    private javax.swing.JLabel zipLbl;
    private javax.swing.JTextField zipTxf;
    // End of variables declaration//GEN-END:variables
}
