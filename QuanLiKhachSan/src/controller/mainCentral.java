package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import view.hotelManager;

public class mainCentral implements ActionListener{
	
	private hotelManager quanlikhachsan;
	
	public mainCentral(hotelManager quanlikhachsan) {
		super();
		this.quanlikhachsan = quanlikhachsan;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String src = e.getActionCommand();
		
		if(src.equals("Logout")) {
			
			quanlikhachsan.logOUT();
			
		} else if(src.equals("Customer Check In")){
			
			quanlikhachsan.cusCheckIn();
		
		} else if(src.equals("ManagerRoom")) {
			
			quanlikhachsan.manager();
		
		} else if(src.equals("Customer Check Out")) {
			
			quanlikhachsan.cusCheckOut();
		
		}
	}

}
