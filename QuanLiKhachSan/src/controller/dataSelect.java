package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.connectDTB;

public class dataSelect {
	// cau lenh trong mySQL 
	public static ResultSet getData(String Query) {
		Connection con=null;
		ResultSet rss = null;
		Statement st = null;
		try {
			con = connectDTB.getCon();
			st = con.createStatement();
			rss = st.executeQuery(Query);
			return rss;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}	
	}
}
