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
