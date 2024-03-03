package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.cusCheckOut;

public class cusCheckOut_Contr implements ActionListener {
	private cusCheckOut checkOut;
	public cusCheckOut_Contr(cusCheckOut checkOut) {
		super();
		this.checkOut = checkOut;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("Check Out")) {
			checkOut.out();
		} else if(src.equals("Clear")) {
			checkOut.clearBTN();
		} else if(src.equals("Search")) {
			checkOut.searchFunction();
		}
	}

}
