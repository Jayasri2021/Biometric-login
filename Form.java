package fpscan;

import MFS.MFS100Test;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Form extends MFS100Test 
{
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JTextField uname;// initialize text fields
   private JTextField udob;
   private JTextField uemail;
   private JTextField uage;
   private JTextField uaddr;
   private JTextField uphno;
   //private JComboBox<String> ugender;
   private JButton usubmit;
   private JButton ucapture;
  
   public static void main(String[] args)
   {
       EventQueue.invokeLater(new Runnable()
       {
           public void run() {
               try {
                   Form frame = new Form();
                   frame.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               } 
           }
       });
   }
 //Constructor
   public Form()
   {
       //setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(450, 190, 1014, 597);
       setResizable(false);
       contentPane = new JPanel();
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       setContentPane(contentPane);
       contentPane.setLayout(null);
      
       //HEADING: New User(L)
       JLabel lblNewUserRegister = new JLabel("New User");
       lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 30));
       lblNewUserRegister.setBounds(448, 11, 139, 50);
       contentPane.add(lblNewUserRegister);
      
       //1L: User Name(L)
       JLabel lblName = new JLabel("User Name");
       lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
       lblName.setBounds(46, 73, 99, 43);
       contentPane.add(lblName);
      
       //2L: DOB(L)
       JLabel lblNewLabel = new JLabel("D.O.B");
       lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
       lblNewLabel.setBounds(46, 166, 110, 29);
       contentPane.add(lblNewLabel);
      
       //3L: Email Address(L)
       JLabel lblEmailAddress = new JLabel("Email\r\n Address");
       lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
       lblEmailAddress.setBounds(46, 251, 124, 36);
       contentPane.add(lblEmailAddress);
      
       //4L: GENDER(L)
       JLabel lblGender = new JLabel("Gender");
       lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
       lblGender.setBounds(44, 345, 141, 29);
       contentPane.add(lblGender);
      
       //age labelname
       JLabel lbluname = new JLabel("Age");
       lbluname.setFont(new Font("Tahoma", Font.PLAIN, 20));
       lbluname.setBounds(542, 80, 99, 29);
       contentPane.add(lbluname);
      
       //addr lbl name
       JLabel lblPassword = new JLabel("Address");
       lblPassword.setBackground(new Color(240, 240, 240));
       lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
       lblPassword.setBounds(542, 168, 99, 24);
       contentPane.add(lblPassword);
      
       //phno lbl name
       JLabel lblMobileNumber = new JLabel("Phone number");
       lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
       lblMobileNumber.setBounds(46, 422, 139, 26);
       contentPane.add(lblMobileNumber);
       //1L: UNAME(TF)
       uname = new JTextField();
       uname.setFont(new Font("Tahoma", Font.PLAIN, 20));
       uname.setBounds(214, 70, 228, 50);
       contentPane.add(uname);
       uname.setColumns(10);
      
       //2L: UDOB(TF)
       udob = new JTextField();
       udob.setFont(new Font("Tahoma", Font.PLAIN, 20));
       udob.setBounds(214, 156, 228, 50);
       contentPane.add(udob);
       udob.setColumns(10);
      
       //3L:EMAIL(TF)
       uemail = new JTextField();
       uemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
       uemail.setBounds(214, 245, 228, 50);
       contentPane.add(uemail);
       uemail.setColumns(10);
      
       //4L:GENDER(TF)
       final JComboBox<String> ugender = new JComboBox<String>();
       ugender.setFont(new Font("Tahoma", Font.PLAIN, 20));
       ugender.addItem("Male");
       ugender.addItem("Female");
       ugender.addItem("Other");
       ugender.setEditable(true);
       ugender.setBounds(214, 342, 228, 43);
       contentPane.add(ugender);
      
       //uageTF
       uage = new JTextField();
       uage.setFont(new Font("Tahoma", Font.PLAIN, 20));
       uage.setBounds(707, 73, 228, 50);
       contentPane.add(uage);
       uage.setColumns(10);
      
       //phno TF
       uphno = new JTextField();
       uphno.setFont(new Font("Tahoma", Font.PLAIN, 20));
       uphno.setBounds(214, 422, 228, 50);
       contentPane.add(uphno);
       uphno.setColumns(10);
       //addr TF
       uaddr = new JTextField();
       uaddr.setColumns(10);
       uaddr.setFont(new Font("Tahoma", Font.PLAIN, 20));
       uaddr.setBounds(707, 151, 228, 50);
       contentPane.add(uaddr);
       //submit button
       usubmit = new JButton(new AbstractAction("Submit")
       {
			@Override
			public void actionPerformed(ActionEvent e)
			{
               String username = uname.getText();
               String dob = udob.getText();
               String email = uemail.getText();
               String age = uage.getText();
               String address = uaddr.getText();
               String phnum = uphno.getText();
               int len = phnum.length();
               String gender = (String) ugender.getSelectedItem();
              
               String msg = "" + username;
               msg += " \n";
               if (len != 10) {
                   JOptionPane.showMessageDialog(usubmit, "Enter a valid mobile number");
               }
               try {
                   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fingerprint", "root", "123456");
                   String query = "INSERT INTO user_data(user_name,user_dob,user_age,user_phnum,email_id,user_address,user_gender)VALUES ('" + username + "','" + dob + "','" + age + "','" +
                       phnum + "','" + email + "','" + address +"','" + gender + "')";
                   Statement sta = connection.createStatement();
                   int x = sta.executeUpdate(query);
                   if (x == 0)
                   {
                       JOptionPane.showMessageDialog(usubmit, "This data alredy exist");
                   } else
                   {
                       JOptionPane.showMessageDialog(usubmit,
                           "Welcome, " + msg + "Your data is securely saved created");
                   }
                   connection.close();
               }               
               catch (Exception exception)
               {
                   exception.printStackTrace();
               }
           }
       });
       usubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
       usubmit.setText("SUBMIT");
      
       usubmit.setBounds(527, 477, 155, 50);
       contentPane.add(usubmit);
   }
}
