package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	private LowerButton lowerButton;
	private String id;
	private String passwd;
	
	void loginGUI(BackgroundPanel backgroundPanel) {
		ImagePanel loginPanel = backgroundPanel.background("ȯ���մϴ�");
		loginPanel.setVisible(true);
		
		JLabel loginLabel = new JLabel("   LOG IN");
		loginLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
		loginLabel.setBounds(155, 253, 201, 95);
		loginPanel.add(loginLabel);
		
		JTextField idTextField = new JTextField();
		idTextField.setBounds(126, 396, 357, 68);
		loginPanel.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel idIconLabel = new JLabel("");
		idIconLabel.setIcon(new ImageIcon(PatientApplication.PATH + "login_ID.png"));
		idIconLabel.setBounds(40, 395, 74, 68);
		loginPanel.add(idIconLabel);
		
		JLabel passwdIconLabel = new JLabel("");
		passwdIconLabel.setIcon(new ImageIcon(PatientApplication.PATH + "login_passwd.png"));
		passwdIconLabel.setBounds(40, 497, 74, 68);
		loginPanel.add(passwdIconLabel);
		
		JButton loginButton = new JButton("");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setIcon(new ImageIcon(PatientApplication.PATH + "loginButton2.png"));
		loginButton.setBounds(343, 589, 140, 60);
		loginButton.setPressedIcon(new ImageIcon(PatientApplication.PATH + "loginButton_click.png"));
		loginPanel.add(loginButton);
		
		JPasswordField passwdTextField = new JPasswordField();
		passwdTextField.setBounds(126, 497, 357, 68);
		loginPanel.add(passwdTextField);
		
		JLabel signupInLoginLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		signupInLoginLabel.setForeground(Color.BLUE);
		signupInLoginLabel.setFont(new Font("���� ����", Font.BOLD, 12));
		signupInLoginLabel.setBounds(283, 634, 48, 15);
		loginPanel.add(signupInLoginLabel);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id = "abc";
				passwd = "abc";
				if (id.equals(idTextField.getText()) && Arrays.equals(passwdTextField.getPassword(), passwd.toCharArray())) {
					JOptionPane.showMessageDialog(null, "You have logged in successfully");
					loginPanel.setVisible(false);
					HospitalList hospitalList = new HospitalList(backgroundPanel, id);
					hospitalList.hospitalListGUI();
				} else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}
		});
		
		signupInLoginLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				loginPanel.setVisible(false);
				SignUp signUp = new SignUp();
				signUp.signUpGUI(backgroundPanel);
		    }
		});
		lowerButton = new LowerButton(backgroundPanel);
		lowerButton.buttons(loginPanel, id);
	}
	
}
