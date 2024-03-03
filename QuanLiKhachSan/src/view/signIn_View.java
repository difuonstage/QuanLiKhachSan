package view;

import java.awt.BorderLayout;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.border.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.dataSelect;
import controller.signIn_Page_Controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class signIn_View extends JFrame {
	
	private JTextField username_TextField;
	
	private JPasswordField passWord_Login;
    
	private signUp_view windowSignUp;
	
	
	
	public signIn_View() throws IOException {
		setBackground(new Color(241, 250, 238));
		this.init();
	}


	public void init() throws IOException {

		this.setTitle("Login");		
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// controller
		
		signIn_Page_Controller ctl_signin = new signIn_Page_Controller(this);
	
		
		// chung
		JPanel jpanel_chung = new JPanel();
		jpanel_chung.setBackground(new Color(241, 250, 238));
		GridLayout layout_chung = new GridLayout(1,2,5,5);
		jpanel_chung.setLayout(layout_chung);
		
		
		//Ben phaisssss
		JPanel benphai  = new JPanel();
		benphai.setBackground(new Color(241, 250, 238));
		benphai.setBorder(new EmptyBorder(30, 30, 30, 30));
		GridLayout layout_phai = new GridLayout(6,1);
		benphai.setLayout(layout_phai);
		JLabel label_Header = new JLabel("SIGN IN");
		label_Header.setForeground(new Color(29, 53, 87));
		label_Header.setFont(new Font("Cascadia Mono", Font.BOLD, 50));
		label_Header.setToolTipText("WelCome back ^^");
		label_Header.setHorizontalAlignment(SwingConstants.CENTER);
		label_Header.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel username_label = new JLabel("Username:");
		username_label.setForeground(new Color(29, 53, 87));
		username_label.setFont(new Font("Cascadia Code", Font.BOLD, 15));
		username_TextField = new JTextField();
		username_TextField.setFont(new Font("Candara Light", Font.BOLD, 15));
		username_TextField.setForeground(new Color(250, 57, 70));
		username_TextField.setColumns(10);
		
		JLabel password_label = new JLabel("Password");
		password_label.setForeground(new Color(29, 53, 87));
		password_label.setFont(new Font("Cascadia Code", Font.BOLD, 15));
		passWord_Login = new JPasswordField();
		passWord_Login.setFont(new Font("Candara Light", Font.BOLD, 15));
		passWord_Login.setForeground(new Color(250, 57, 70));
		
		username_TextField.setToolTipText("Ten dang nhap");	
		passWord_Login.setEchoChar('*');
		passWord_Login.setColumns(10);
		passWord_Login.setToolTipText("Mat Khau");
		benphai.add(label_Header);
		benphai.add(username_label);
		benphai.add(username_TextField);
		benphai.add(password_label);
		benphai.add(passWord_Login);
		
		JPanel nutbam= new JPanel(new GridLayout(1,2,50,50));
		nutbam.setBackground(new Color(241, 250, 238));
		JButton button_SignIn = new JButton("Sign In");
		button_SignIn.setIcon(null);
		
		button_SignIn.setForeground(new Color(29, 53, 87));
		button_SignIn.setBackground(new Color(168, 218, 220));
		button_SignIn.setFont(new Font("Cascadia Code", Font.BOLD, 15));
		button_SignIn.addActionListener(ctl_signin);
		JButton button_SignUp = new JButton("Sign Up");
		button_SignUp.setForeground(new Color(29, 53, 87));
		button_SignUp.setBackground(new Color(250, 57, 70));
		button_SignUp.setFont(new Font("Cascadia Code", Font.BOLD, 15));
		button_SignUp.addActionListener(ctl_signin);
		nutbam.add(button_SignIn);
		nutbam.add(button_SignUp);
		benphai.add(nutbam);
		jpanel_chung.add(benphai);		
		this.add(jpanel_chung, BorderLayout.CENTER);
		
	
	}
	 
	 // dang ki thanh cong 
		public void signInButton() {
			int check = 0;
			String password = passWord_Login.getText();
			String username = username_TextField.getText();
				if(password.equals("") || username.equals("")) {
					check=1;
					JOptionPane.showMessageDialog(null, "vui long dien day du thong tin!!");
				} else {
					ResultSet rs = dataSelect.getData("SELECT name,password FROM user WHERE  name ='"+username+"' AND password='"+password+"' ");
				
					try {
					if(rs.next()) {
						check=1;
						if (rs.getString(2) != null) {
							setVisible(false);
							new hotelManager().setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(null,"Wait Admin Approve");
					}
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e);
							}
						} 
				if (check==0) {
					JOptionPane.showMessageDialog(null, "Ban da sai mat khau hoac ten dang nhap");
		}
	}
		
		//
		public void nutDangKi_SignIn() {
			new signUp_view().setVisible(true);
		}
	
	
}
