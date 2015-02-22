package Client;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{
	
	
	private JPanel mainPanel, titlePanel, contentPanel, buttonPanel ;
	private JLabel header, username, password;
	private JTextField nameField, passwordField;
	JButton loginButton;
	private Sender sender;
	
	public GUI(Sender sender){
		setup();
		this.sender=sender;
	}

	private void initiatePanels() {
		//TitlePanel
		header = new JLabel();
		titlePanel.add(header);
		header.setText("Login");
		//ContentPanel
		username = new JLabel();
		password = new JLabel();
		username.setText("Username: ");
		password.setText("Password: ");
		nameField = new JTextField(10);
		passwordField = new JPasswordField(10);
		contentPanel.add(username);
		contentPanel.add(nameField);
		contentPanel.add(password);
		contentPanel.add(passwordField);
		//Buttons
		loginButton = new JButton("Login");
		buttonPanel.add(loginButton, BorderLayout.CENTER);
		loginButton.addActionListener(this);
		
	}

	private void addPanels() {
		mainPanel = new JPanel();
		titlePanel = new JPanel();
		contentPanel = new JPanel();
		buttonPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		add(mainPanel);
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(contentPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
	}

	private void setup() {
		setTitle("Hospital Patient System");
		setSize(500,300);
		setVisible(true);
		
		addPanels();
		initiatePanels();
		setSize(800,200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton){
			String userName = nameField.getText();
			String userPassword = passwordField.getText();
			sender.push("0\t"+userName+"\t"+userPassword);
			System.out.println(sender.msg());
		}
	}
	
	
}
