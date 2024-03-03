package model;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class databaseManager {
	//thay doi du lieu tren mySQL sever
	public static void setData(String Query, String msg) {
		Connection con = null;
		Statement st = null;
		try {
			con = connectDTB.getCon();
			st=con.createStatement();
			st.executeUpdate(Query);
			if(!msg.equals("")) {
				JOptionPane.showMessageDialog(null, msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
	}
}
