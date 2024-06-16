/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author micha
 */
public class IssueBook extends javax.swing.JFrame {

    
    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    public void getBookDetails(){
    int bookId = Integer.parseInt(txt_bookId.getText());
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
        java.sql.PreparedStatement pst = con.prepareStatement("select * from book_details where bookid = ?");
        pst.setInt(1, bookId);
        java.sql.ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            lbl_bookId.setText(rs.getString("bookid"));
            lbl_bookName.setText(rs.getString("bookname"));
            lbl_author.setText(rs.getString("author"));
            lbl_quantity.setText(rs.getString("quantity"));
        }else{
            lbl_bookError.setText("invalid book Id");
        }
    }catch (Exception e){
        e.printStackTrace();
        
    }   
}
    
       public void getstudentDetails(){
    int bookId = Integer.parseInt(txt_studentId.getText());
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
        java.sql.PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
        pst.setInt(1, bookId);
        java.sql.ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            lbl_studentId.setText(rs.getString("student_id"));
            lbl_studentName.setText(rs.getString("name"));
            lbl_course.setText(rs.getString("course"));
            lbl_branch.setText(rs.getString("branch"));
        }else{
            lbl_studentError.setText("invalid student Id");
        }
    }catch (Exception e){
        e.printStackTrace();
        
    }   
}
       
       public boolean issueBook(){
           boolean isIssued = false;
           int bookId = Integer.parseInt(txt_bookId.getText());
           int studentId = Integer.parseInt(txt_studentId.getText());
           String bookName = lbl_bookName.getText();
           String studentName = lbl_studentName.getText();
           
           Date uIssueDate = date_issueDate.getDate();
           Date uDueDate = date_dueDate.getDate();
           
         long issueTime = uIssueDate.getTime();
         long dueTime = uDueDate.getTime();
           
           java.sql.Date sIssueDate = new java.sql.Date(issueTime);
           java.sql.Date sDueDate = new java.sql.Date(dueTime);
           
           try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
               String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,"+ "issue_date,due_date,status) values(?,?,?,?,?,?,?)";
               java.sql.PreparedStatement pst = con.prepareStatement(sql);
               
                 pst.setInt(1, bookId);
                 pst.setString(2, bookName);
                 pst.setInt(3, studentId);
                 pst.setString(4, studentName);
                 pst.setDate(5, sIssueDate);
                 pst.setDate(6, sDueDate);
                 pst.setString(7, "pending");

        int rowCount = pst.executeUpdate();
        if(rowCount > 0) {
               isIssued = true;
           } else{
                   isIssued = false;
                   }
        
           }catch (Exception e){ 
               e.printStackTrace();
           }
           return isIssued;
       }
       
       public void updateBookCount(){
           int bookId = Integer.parseInt(txt_bookId.getText());
           try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
             
             String sql = "update book_details set quantity =  quantity - 1 where bookid = ?";
             java.sql.PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, bookId);
             
             int rowCount = pst.executeUpdate();
             
             if(rowCount > 0){
               JOptionPane.showMessageDialog(this, "book count updated"); 
               int initialCount = Integer.parseInt(lbl_quantity.getText());
               lbl_quantity.setText(Integer.toString(initialCount - 1));
             }else{
                 JOptionPane.showMessageDialog(this, "can't updated book count");
             }
           }catch(Exception e){
               e.printStackTrace();
           }
       }
       
       public boolean isAlreadyIssued(){
           boolean isAlreadyIssued = false;
           int bookId = Integer.parseInt(txt_bookId.getText());
           int studentId = Integer.parseInt(txt_studentId.getText());
           
           try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
               String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
               java.sql.PreparedStatement pst = con.prepareStatement(sql);
                 pst.setInt(1, bookId);
                 pst.setInt(2, studentId);
                 pst.setString(3, "pending");
                 
                java.sql.ResultSet rs = pst.executeQuery();
                
                if(rs.next()) {
                     isAlreadyIssued = true;
                } else{
                     isAlreadyIssued = false;
                   }
               
           }catch(Exception e){
               e.printStackTrace();
               
           }
           return isAlreadyIssued;
       }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSDateChooserBeanInfo1 = new rojeru_san.componentes.RSDateChooserBeanInfo();
        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        date_issueDate = new com.toedter.calendar.JDateChooser();
        date_dueDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jButton5.setText("Back");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("  Book Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 270, 100));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 270, -1));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 140, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Author :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Id :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        lbl_bookId.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 140, 30));

        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 140, 30));

        lbl_author.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 140, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Quantity :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 260, 30));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 650));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel10.setText("  Book Details");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 270, 100));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 270, 5));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Branch :");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        lbl_branch.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 140, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Student Name :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Course :");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Id :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        lbl_studentId.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 140, 30));

        lbl_studentName.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 140, 30));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 140, 30));

        lbl_studentError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(102, 0, 0));
        jPanel4.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 260, 30));

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 350, 650));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/AddNewBookIcons/d.png"))); // NOI18N
        jLabel3.setText("  Issue Book");
        panel_main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 210, -1));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 270, 5));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_main.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 50, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Book ID :");
        panel_main.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, -1, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book ID...");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 210, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Issue Date :");
        panel_main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, -1, -1));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student ID...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 210, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Student ID :");
        panel_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Due Date :");
        panel_main.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ISSUE BOOK");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_main.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 230, 40));

        date_issueDate.setBorder(new javax.swing.border.MatteBorder(null));
        date_issueDate.setDateFormatString("dd-MM-yyyy");
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 362, 200, 30));

        date_dueDate.setBorder(new javax.swing.border.MatteBorder(null));
        date_dueDate.setDateFormatString("dd-MM-yyyy");
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 442, 200, 30));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        setSize(new java.awt.Dimension(1100, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
        if(!txt_bookId.getText().equals("")){
          getBookDetails();  
        }
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
           if(!txt_studentId.getText().equals("")){
          getstudentDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(lbl_quantity.getText().equals("0")){
           JOptionPane.showMessageDialog(this, "book is not available"); 
        }else{
                    if(isAlreadyIssued() == false){
                 if(issueBook() == true){
                    JOptionPane.showMessageDialog(this, "book issued successfully");
                    updateBookCount();
                 }else{
                    JOptionPane.showMessageDialog(this, "can't issue the book");
             }   
        }else{
            JOptionPane.showMessageDialog(this, "this student already has this book");
        }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date_dueDate;
    private com.toedter.calendar.JDateChooser date_issueDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
