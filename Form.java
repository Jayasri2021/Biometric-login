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
public class Form extends MFS100Test {
    private static final long serialVersionUID = 1L;
    // initialize text fields
    private JPanel contentPane;
    private JTextField uname;
    private JTextField udob;
    private JTextField uemail;
    private JTextField uage;
    private JTextField uaddr;
    private JTextField uphno;
    private JButton usubmit;
    private JButton ucapture;
    // private JButton uaddr1;

