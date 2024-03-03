package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDTB {
		
		// ket noi mySQL
		public static  Connection getCon() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlkhachsan", "root", "root");		
				return con;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		
		}
			
		
}
