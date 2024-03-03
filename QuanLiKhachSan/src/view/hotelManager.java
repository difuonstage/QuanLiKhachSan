package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.IconView;

import com.mysql.cj.callback.UsernameCallback;

import controller.mainCentral;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class hotelManager extends JFrame {
	

	public hotelManager() {
		getContentPane().setBackground(new Color(241, 250, 238));
		this.mainapp();
	}
	
	public void mainapp() {
		this.setTitle("Hotel Manager");		
		this.setSize(1300,590);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// controller
		mainCentral control = new mainCentral(this);
		//
		GridLayout grid_main = new GridLayout(5,1,2,2);
		getContentPane().setLayout(grid_main);
		JPanel  header = new JPanel(new BorderLayout());
		header.setBackground(new Color(241, 250, 238));
		JLabel lb_header = new JLabel("HotelManager");
		lb_header.setForeground(new Color(230, 57, 70));
		lb_header.setBackground(new Color(241, 250, 238));
		lb_header.setFont(new Font("Cascadia Mono", Font.BOLD, 45));
		lb_header.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lb_header,BorderLayout.CENTER);
		getContentPane().add(header);
		
		JPanel panel_nut = new JPanel();
		panel_nut.setBorder(new EmptyBorder(15, 20, 15, 20));
		panel_nut.setBackground(new Color(241, 250, 238));
		GridLayout grid_nut = new GridLayout(1,5,100,1);
		
		JButton btnManagerroom = new JButton("ManagerRoom");
		btnManagerroom.setForeground(new Color(29, 53, 87));
		btnManagerroom.setBackground(new Color(168,218,220));
		btnManagerroom.setFont(new Font("Candara Light", Font.BOLD, 13));
		btnManagerroom.addActionListener(control);
		
		JButton btnCheckIn = new JButton("Customer Check In");
		btnCheckIn.setForeground(new Color(29, 53, 87));
		btnCheckIn.setBackground(new Color(168, 218, 220));
		btnCheckIn.setFont(new Font("Candara Light", Font.BOLD, 13));
		btnCheckIn.addActionListener(control);
		
		JButton btnCheckOut = new JButton("Customer Check Out");
		btnCheckOut.setForeground(new Color(29, 53, 87));
		btnCheckOut.setBackground(new Color(168, 218, 220));
		btnCheckOut.setFont(new Font("Candara Light", Font.BOLD, 13));
		btnCheckOut.addActionListener(control);
		
		JButton button_logOut = new JButton("Logout");
		button_logOut.addActionListener(control);
		button_logOut.setForeground(new Color(29, 53, 87));
		button_logOut.setBackground(new Color(168,218,220));
		button_logOut.setFont(new Font("Candara Light", Font.BOLD, 13));
		
		JPanel pn_welcome = new JPanel();
		pn_welcome.setBorder(new EmptyBorder(2, 2, 2, 2));
		pn_welcome.setBackground(new Color(241, 250, 238));
		pn_welcome.setLayout(new BorderLayout());
		JLabel welcome = new JLabel("Welcome back ^^ !!");
		welcome.setForeground(new Color(29, 53, 87));
		welcome.setBackground(new Color(241, 250, 238));
		welcome.setFont(new Font("Cascadia Mono", Font.ITALIC, 18));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		pn_welcome.add(welcome,BorderLayout.CENTER);
		
		panel_nut.setLayout(grid_nut);
		panel_nut.add(btnManagerroom);
		panel_nut.add(btnCheckIn);
		panel_nut.add(btnCheckOut);
		panel_nut.add(button_logOut);
		getContentPane().add(panel_nut);
		getContentPane().add(pn_welcome);
	}
	
	public void logOUT() {
		try {
			this.setVisible(false);
			new signIn_View().setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cusCheckIn() {	
			new cusCheckIn().setVisible(true);
	}
	public void manager() {
			new manageRoom().setVisible(true);
	}
	public void cusCheckOut() {
			new cusCheckOut().setVisible(true);
	}

}
