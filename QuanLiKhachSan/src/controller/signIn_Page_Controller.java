package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.signIn_View;
import view.signUp_view;

public class signIn_Page_Controller implements ActionListener{
	private signIn_View signIn;
	
	public signIn_Page_Controller(signIn_View signIn) {
		
		this.signIn = signIn;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Sign In")) {
			signIn.signInButton();
		} else if (src.equals("Sign Up")) {
				signIn.setVisible(false);
				signIn.nutDangKi_SignIn();
		}
		
	}

	

}
