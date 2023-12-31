package displaydata;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Blob;

@SuppressWarnings("serial")
public class displaying_of_data extends JFrame {
    // Declare components
    private JLabel nameL, ageL, addrL, genderL;
    private JTextField nameF, ageF, addrF, genderF;

    // private Blob temp;
    // Constructor
    public displaying_of_data() {
        super("Display Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        // Initialize components
        nameL = new JLabel("Name:");
        nameF = new JTextField(20);
        ageL = new JLabel("Age:");
        ageF = new JTextField(3);
        addrL = new JLabel("Address:");
        addrF = new JTextField(20);
        genderL = new JLabel("Gender:");
        genderF = new JTextField(20);
        // Add components to frame
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(nameL);
        panel.add(nameF);
        panel.add(ageL);
        panel.add(ageF);
        panel.add(addrL);
        panel.add(addrF);
        panel.add(genderL);
        panel.add(genderF);
        add(panel, BorderLayout.CENTER);
        // Retrieve data from database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fingerprint", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_data WHERE user_id=1" + ";");
            if (rs.next()) {
                nameF.setText(rs.getString("user_name"));
                ageF.setText(Integer.toString(rs.getInt("user_age")));
                addrF.setText(rs.getString("user_address"));
                genderF.setText(rs.getString("user_gender"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Main method
    public static void main(String[] args) {
        displaying_of_data form = new displaying_of_data();
        form.setVisible(true);
    }
}
