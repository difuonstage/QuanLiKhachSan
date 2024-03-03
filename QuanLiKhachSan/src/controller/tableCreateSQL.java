package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.swing.JOptionPane;

import model.connectDTB;
import view.signIn_View;
import view.hotelManager;
import view.signUp_view;

public class tableCreateSQL {
	// tao table trong dtb 
	public static void main(String[] args) throws IOException {
		Connection con = null;
		java.sql.Statement st = null;
		try {
			con=connectDTB.getCon();
			st = con.createStatement();
			//st.executeUpdate("CREATE TABLE user(name varchar(200), email varchar(200),password varchar(50))");
			//st.executeUpdate("CREATE TABLE room(roomno varchar(10),roomType varchar(200), bed varchar(200),price int, status varchar(20))"); 
			//st.executeUpdate("CREATE TABLE customer(id int, name varchar(200),phoneNumber varchar(10),idProfile varchar(200), checkIn varchar(500), roomNum varchar(10), bed varchar(200), roomType varchar(200), price int(10), timeStay int(10), total varchar(200), checkOut varchar(50))"); 
			JOptionPane.showMessageDialog(null, "Table create successfully");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				con.close();
				st.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
