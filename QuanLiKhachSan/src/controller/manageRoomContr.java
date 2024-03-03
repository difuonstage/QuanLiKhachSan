package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.accessibility.AccessibleAction;

import view.manageRoom;

public class manageRoomContr implements ActionListener {
	private manageRoom magRoom;

	public manageRoomContr(manageRoom magRoom) {
		super();
		this.magRoom = magRoom;
	}
	
	
	// thuc hien nut bam
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("Add Room")) {
			magRoom.addRoom();
		}
	}

	
}
