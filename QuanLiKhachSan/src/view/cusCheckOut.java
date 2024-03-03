package view;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import controller.cusCheckOut_Contr;
import controller.dataSelect;
import model.databaseManager;

import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class cusCheckOut extends JFrame{
	    //
	int id =0;
    String roomType;
    String bed;
    String roomNo;
	 	//
    	private String Query;
	    private javax.swing.JButton bt_Search;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JLabel lb_searchRoom;
	    private javax.swing.JLabel lb_cusName;
	    private javax.swing.JLabel lb_Price;
	    private javax.swing.JLabel lb_checkOut;
	    private javax.swing.JLabel lb_total;
	    private javax.swing.JLabel lb_CheckInDate;
	    private javax.swing.JLabel lb_NumberOfDay;
	    private javax.swing.JLabel lb_phoneNumber;
	    private javax.swing.JLabel lb_idProof;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JPanel jPanel3;
	    private javax.swing.JPanel jPanel4;
	    private javax.swing.JPanel jPanel5;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable jTable1;
	    private javax.swing.JTextField tf_Search;
	    private javax.swing.JTextField tf_cusName;
	    private javax.swing.JTextField tf_Price;
	    private javax.swing.JTextField tf_CheckOut;
	    private javax.swing.JTextField tf_totalAmount;
	    private javax.swing.JTextField tf_CheckInDate;
	    private javax.swing.JTextField tf_NumberOfDay;
	    private javax.swing.JTextField tf_phoneNumber;
	    private javax.swing.JTextField tf_idProof;
		private SimpleDateFormat myFor;
		private Calendar myCal;
		private long dayAmount;
	
	    
	public cusCheckOut() throws HeadlessException {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			ResultSet rs = dataSelect.getData("SELECT * FROM customer WHERE checkOut is NULL");
			DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
			try {
				
				while(rs.next()) {
				
					model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});;
				
				}
				rs.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e);
			}
			
			}
		});
		getContentPane().setBackground(new Color(241, 250, 238));
		this.init();
		
		tf_CheckInDate.setEditable(false);
		tf_totalAmount.setEditable(false);
		tf_CheckOut.setEditable(false);
		tf_idProof.setEditable(false);
		tf_NumberOfDay.setEditable(false);
		tf_phoneNumber.setEditable(false);
		tf_Price.setEditable(false);
		
	}
	
	public void init() {                         
		
		//
		cusCheckOut_Contr ctr = new cusCheckOut_Contr(this);
		//
		
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(241, 250, 238));
        lb_searchRoom = new javax.swing.JLabel();
        bt_Search = new javax.swing.JButton();
        tf_Search = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new Color(241, 250, 238));
        lb_cusName = new javax.swing.JLabel();
        tf_cusName = new javax.swing.JTextField();
        tf_cusName.setEditable(false);
        lb_Price = new javax.swing.JLabel();
        tf_Price = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(new Color(241, 250, 238));
        lb_checkOut = new javax.swing.JLabel();
        tf_CheckOut = new javax.swing.JTextField();
        lb_total = new javax.swing.JLabel();
        tf_totalAmount = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel4.setBackground(new Color(241, 250, 238));
        lb_CheckInDate = new javax.swing.JLabel();
        tf_CheckInDate = new javax.swing.JTextField();
        lb_NumberOfDay = new javax.swing.JLabel();
        tf_NumberOfDay = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel5.setBackground(new Color(241, 250, 238));
        lb_phoneNumber = new javax.swing.JLabel();
        tf_phoneNumber = new javax.swing.JTextField();
        lb_idProof = new javax.swing.JLabel();
        tf_idProof = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton2.setFont(new Font("Cascadia Mono", Font.PLAIN, 10));
        jButton2.addActionListener(ctr);
        jButton3 = new javax.swing.JButton();
        jButton3.setFont(new Font("Cascadia Mono", Font.PLAIN, 10));
        jButton3.addActionListener(ctr);

        setBackground(new java.awt.Color(241, 250, 238));

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lb_searchRoom.setFont(new Font("Cascadia Code", Font.PLAIN, 14)); // NOI18N
        lb_searchRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_searchRoom.setText("Room Number");
        
        bt_Search.setText("Search");
        bt_Search.addActionListener(ctr);
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(lb_searchRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tf_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(tf_Search)
            .addComponent(bt_Search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
            .addComponent(lb_searchRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(26, Short.MAX_VALUE))
        );

        lb_cusName.setFont(new Font("Cascadia Mono", Font.PLAIN, 14)); // NOI18N
        lb_cusName.setText("Customer Name");

        lb_Price.setFont(new Font("Cascadia Mono", Font.PLAIN, 14)); // NOI18N
        lb_Price.setText("Price");
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(lb_cusName, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(lb_Price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tf_cusName, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addComponent(tf_Price))
            .addContainerGap(27, Short.MAX_VALUE))
        );
       
        jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_cusName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_cusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_Price)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lb_checkOut.setFont(new Font("Cascadia Mono", Font.PLAIN, 14)); // NOI18N
        lb_checkOut.setText("Check Out Date");

        lb_total.setFont(new Font("Cascadia Mono", Font.PLAIN, 14)); // NOI18N
        lb_total.setText("Total Amount");
   
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_checkOut, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(lb_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_CheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(tf_totalAmount))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_checkOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_CheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lb_CheckInDate.setFont(new Font("Cascadia Mono", Font.PLAIN, 14)); // NOI18N
        lb_CheckInDate.setText("Check In Date");

        lb_NumberOfDay.setFont(new Font("Cascadia Mono", Font.PLAIN, 14)); // NOI18N
        lb_NumberOfDay.setText("Number of Day Stay");
 
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_CheckInDate, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(lb_NumberOfDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_CheckInDate, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(tf_NumberOfDay))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_CheckInDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_CheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_NumberOfDay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_NumberOfDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lb_phoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_phoneNumber.setText("Customer Mobile Phone");

        lb_idProof.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_idProof.setText("ID Proof");
        
        
        // layout keo tha 
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_phoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(lb_idProof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_phoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(tf_idProof))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_phoneNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_idProof)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_idProof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        
        jScrollPane1.setBackground(new java.awt.Color(241, 250, 238));
        jScrollPane1.setFont(new Font("Cascadia Mono", Font.PLAIN, 14)); // NOI18N

        jTable1.setBackground(new java.awt.Color(241, 250, 238));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {  
            },
            new String [] {
                "ID", "Name", "Phone Number", "ID Proof", "Check In Date", "Room Number", "Bed", "Room Type", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Check Out");
        
        jButton3.setText("Clear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(405)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(561)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        					.addGap(58)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(14, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1378, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(35)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        				.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
        			.addGap(83))
        );
        getContentPane().setLayout(layout);

        pack();
    }    
	
	public void searchFunction() {
		String roomNo = tf_Search.getText();
		
		try {
			ResultSet rs = dataSelect.getData("SELECT * FROM customer WHERE roomNum='"+roomNo+"' AND  checkOut is NULL");
			
			if(rs.next()) {
				
				tf_Search.setEditable(false);
				id=rs.getInt(1);
				tf_cusName.setText(rs.getString(2));
				tf_phoneNumber.setText(rs.getString(3));
				tf_idProof.setText(rs.getString(4));
				tf_CheckInDate.setText(rs.getString(5));
				tf_Price.setText(rs.getString(9));
				tf_phoneNumber.setText(rs.getString(3));
				
				myFor = new SimpleDateFormat("DD/MM/YYYY");
				myCal = Calendar.getInstance();
				tf_CheckOut.setText(myFor.format(myCal.getTime()));
				
				String dateCheckInString = rs.getString(5);
				java.util.Date dateCheckIn =myFor.parse(dateCheckInString);
				String dateCheckOutString = myFor.format(myCal.getTime());
				java.util.Date dateCheckOut = myFor.parse(dateCheckOutString);
				
				dayAmount = dateCheckOut.getTime()-dateCheckIn.getTime();
				int dayStay = (int) (dayAmount/1000*60*60*24);
					if(dayStay==0) {
						dayStay=1;
						tf_NumberOfDay.setText(String.valueOf(dayStay));
						float price =Float.parseFloat(tf_Price.getText());
						tf_totalAmount.setText(String.valueOf(dayStay*price));
						tf_idProof.setText(rs.getString(4));
						roomType=rs.getString(8);
						bed=rs.getString(7);
					} else {
						JOptionPane.showMessageDialog(null, "Room Not Booked");
					}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void out() {
		String search = tf_Search.getText();
		String name = tf_cusName.getText();
		String phoneNumber =tf_phoneNumber.getText();
		String id = tf_idProof.getText();
		String checkOut = tf_CheckOut.getText();
		String numDay = tf_NumberOfDay.getText();
		String total = tf_totalAmount.getText();
		roomNo = tf_Search.getText();
		if(search.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Vui long nhap so phong!!");
		
		} else {
		
			try {
			Query="UPDATE customer SET timeStay='"+numDay+"', total='"+total+"', checkOut='"+checkOut+"' WHERE id ='"+id+"' ";
			databaseManager.setData(Query, "Check out Thanh Cong");
			
			Query="UPDATE room SET status='Not Booked' WHERE roomNo ='"+roomNo+"' ";
			databaseManager.setData(Query, "");
			
			setVisible(false);
			new cusCheckOut().setVisible(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			}
		
		}
	}

	public void clearBTN() {
		setVisible(false);
		new cusCheckOut().setVisible(true);
	}
	                   
}
	

