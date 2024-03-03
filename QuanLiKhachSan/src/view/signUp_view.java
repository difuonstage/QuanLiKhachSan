package view;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.dataSelect;
import controller.signUp_Page_Controller;
import model.databaseManager;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class signUp_view extends JFrame {
	
	public JPasswordField password_SignUp;
	public JTextField 	   username_SignUp;
	public JTextField 	   email_SignUp;
	
	public signUp_view()  {
		this.signUpP();	
	}

		public void signUpP() {	
			
			this.setTitle("Sign Up");		
			this.setSize(600,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			// controller
		
			signUp_Page_Controller signUp = new signUp_Page_Controller(this);
			
			// ben trai
			JPanel pn_chung = new JPanel();
			GridLayout grid_chung = new GridLayout(1,2,2,2);
			pn_chung.setLayout(grid_chung);
			
			
			// ben phai
			JPanel benphai  = new JPanel();
			benphai.setBackground(new Color(241, 250, 238));
			benphai.setBorder(new EmptyBorder(35, 35, 35, 35));
			GridLayout layout_phai = new GridLayout(8,1,10,10);
			benphai.setLayout(layout_phai);
			JLabel label_Header = new JLabel("SIGN UP");
			label_Header.setForeground(new Color(230, 57, 70));
			label_Header.setFont(new Font("Cascadia Mono", Font.BOLD, 50));
			label_Header.setToolTipText("WelCome back ^^");
			label_Header.setHorizontalAlignment(SwingConstants.CENTER);
			label_Header.setAlignmentX(Component.CENTER_ALIGNMENT);

			JLabel username_label = new JLabel("Username:");
			username_label.setForeground(new Color(29, 53, 87));
			username_label.setFont(new Font("Cascadia Code", Font.BOLD, 15));
			username_SignUp = new JTextField();
			username_SignUp.setFont(new Font("Cascadia Code", Font.PLAIN, 10));
			username_SignUp.setColumns(10);
			JLabel label_email = new JLabel("Email: ");
			label_email.setFont(new Font("Cascadia Code", Font.BOLD, 15));
			label_email.setForeground(new Color(29, 53, 87));
			email_SignUp = new JTextField();
			email_SignUp.setFont(new Font("Cascadia Code", Font.PLAIN, 10));
			
			JLabel password_label = new JLabel("Password");
			password_label.setForeground(new Color(29, 53, 87));
			password_label.setFont(new Font("Cascadia Code", Font.BOLD, 15));
			password_SignUp = new JPasswordField();
			password_SignUp.setForeground(new Color(230, 57, 70));
			username_SignUp.setToolTipText("Ten dang nhap");	
			password_SignUp.setEchoChar('*');
			password_SignUp.setColumns(10);
			password_SignUp.setToolTipText("Mat Khau");
			benphai.add(label_Header);
			benphai.add(username_label);
			benphai.add(username_SignUp);
			benphai.add(label_email);
			benphai.add(email_SignUp);
			benphai.add(password_label);
			benphai.add(password_SignUp);
			
			JPanel nutbam= new JPanel(new GridLayout(1,2,50,50));
			nutbam.setBackground(new Color(241, 250, 238));
			nutbam.setForeground(new Color(241, 250, 238));
			JButton button_SignIn = new JButton("Sign In");
			button_SignIn.setForeground(new Color(168, 218, 220));
			button_SignIn.setBackground(new Color(29, 53, 87));
			button_SignIn.setFont(new Font("Cascadia Code", Font.BOLD, 15));
			button_SignIn.setPreferredSize(new Dimension(10,5));
			button_SignIn.addActionListener(signUp);
			
			JButton button_SignUp = new JButton("Sign Up");
			button_SignUp.addActionListener(signUp);
			button_SignUp.setForeground(new Color(168, 218, 220));			
			button_SignUp.setBackground(new Color(29, 53, 87));
			button_SignUp.setFont(new Font("Cascadia Code", Font.BOLD, 15));
			nutbam.add(button_SignIn);
			nutbam.add(button_SignUp);
			benphai.add(nutbam);
			pn_chung.add(benphai);
			getContentPane().add(pn_chung);
			
		}
		
		
		public void nutDangky() throws Exception {	
			String email = email_SignUp.getText();
			String password = password_SignUp.getText();
			String username = username_SignUp.getText();
			
			String Query ="SELECT COUNT(*) FROM user WHERE name = '"+username+"' ";
			ResultSet rs = dataSelect.getData(Query);
			rs.next();
			int check = rs.getInt(1);
			int checkLongPass = password.length();
			
			if(email.isEmpty() || password.isEmpty() || username.isEmpty() ) {
				
				JOptionPane.showMessageDialog(null, "Vui long dien day du thong tin!!");
			}
			else if(checkLongPass<6) {
				
				JOptionPane.showMessageDialog(null, "Mat khau qua ngan!!!");
				
			} else if(check>0) {
				
				JOptionPane.showMessageDialog(null, "Ten dang nhap da su dung!!!");
			
			}else if(email.equals("") || password.equals("") || username.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Vui long dien day du thong tin");
			
			}else {
				
				Query="INSERT INTO user VALUES ('"+username+"','"+email+"','"+password+"') ";
				databaseManager.setData(Query, "Dang Ki Thanh Cong");
				setVisible(false);
				new signIn_View().setVisible(true);
			}
		}
		
		public void dangNhap() {
			setVisible(false);
			try {
				new signIn_View().setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

}
