package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.signUp_view;

public class signUp_Page_Controller  implements ActionListener{
	
	private signUp_view dangki;

	
	public signUp_Page_Controller(signUp_view dangki) {
		super();
		this.dangki = dangki;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nut = e.getActionCommand();
		if(nut.equals("Sign Up")) {	
			try {
				dangki.nutDangky();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(nut.equals("Sign In")) {
			dangki.dangNhap();
		}
		
	}

}
