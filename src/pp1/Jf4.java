package pp1;

import java.awt.EventQueue;
import loginDatabase.LoginDB;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Jf4 extends JFrame {

	private JPanel regi;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jf4 frame = new Jf4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jf4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		regi = new JPanel();
		regi.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(regi);
		regi.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Name:");
		lblNewLabel.setBounds(10, 37, 85, 14);
		regi.add(lblNewLabel);
		
		JLabel lblEnterYourId = new JLabel("Enter Id:");
		lblEnterYourId.setBounds(10, 81, 85, 14);
		regi.add(lblEnterYourId);
		
		JLabel lblChooseOne = new JLabel("Choose one:");
		lblChooseOne.setBounds(10, 169, 85, 14);
		regi.add(lblChooseOne);
		
		textField = new JTextField();
		textField.setBounds(85, 34, 133, 20);
		regi.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 78, 133, 20);
		regi.add(textField_1);
		
		Button button = new Button("User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jf6 j= new Jf6();
			      j.setVisible(true);
			      String name = textField.getText();
			      String uname = textField_1.getText();
			      String pass = passwordField.getText();
			      try {
					LoginDB.registerLogin(uname, pass, name, "U");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Duplicate");
				}
//			      System.out.println(name);
//			      System.out.println(pass);
			      
				
			}
		});
		button.setActionCommand("Viewer");
		button.setBounds(100, 169, 70, 22);
		regi.add(button);
		
		Button button_1 = new Button("Editor");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jf5 j= new Jf5();
			    j.setVisible(true);
			    String name = textField.getText();
			      String uname = textField_1.getText();
			      String pass = passwordField.getText();
			      try {
					LoginDB.registerLogin(uname, pass, name, "E");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Duplicate");
				}
			}
		});
		button_1.setBounds(208, 169, 70, 22);
		regi.add(button_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 120, 85, 14);
		regi.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 120, 133, 20);
		regi.add(passwordField);
	}
}
