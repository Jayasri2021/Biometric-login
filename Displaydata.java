package displaydata;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Blob;

@SuppressWarnings("serial")
public class displaying_of_data extends JFrame {
    // Declare components
    private JLabel nameL, ageL, addrLabel, genderLabel;
    private JTextField nameF, ageField, addrField, genderField;

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
        ageField = new JTextField(3);
        addrLabel = new JLabel("Address:");
        addrField = new JTextField(20);
        genderLabel = new JLabel("Gender:");
        genderField = new JTextField(20);
        // Add components to frame
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(nameL);
        panel.add(nameF);
        panel.add(ageL);
        panel.add(ageField);
        panel.add(addrLabel);
        panel.add(addrField);
        panel.add(genderLabel);
        panel.add(genderField);
        add(panel, BorderLayout.CENTER);
        // Retrieve data from database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fingerprint", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_data WHERE user_id=1" + ";");
            if (rs.next()) {
                nameF.setText(rs.getString("user_name"));
                ageField.setText(Integer.toString(rs.getInt("user_age")));
                addrField.setText(rs.getString("user_address"));
                genderField.setText(rs.getString("user_gender"));
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
