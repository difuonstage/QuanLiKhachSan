package view;

import java.awt.EventQueue;import java.awt.GridBagLayout;


import java.awt.GridLayout;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import controller.dataSelect;
import model.databaseManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.AclEntry;

public class cusCheckIn extends JFrame {

	private JTextField tf_price;
	private JTextField tf_id;
	private JTextField tf_name;
	private JTextField tf_phone;
	private JComboBox cb_type;
	private JTextField tf_Date;
	private JComboBox cb_bed;
	private JComboBox cb_roomNum;
	
	String bed;
	String roomType;
	String roomNo;
	String price;
	
	public cusCheckIn() {	
		    this.init();
		    tf_Date.setEditable(false);
			tf_price.setEditable(false);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			tf_Date.setText(dateFormat.format(cal.getTime()));
		
	}
	
	public void init() {
		this.setLocationRelativeTo(null);
		this.setSize(1095,498);
		
		JPanel pn_chung = new JPanel(new GridLayout(4,4,20,20));
		pn_chung.setBackground(new Color(241, 250, 238));
		pn_chung.setBorder(new EmptyBorder(15, 15, 15, 15));
		
		JPanel n1 = new JPanel(new GridLayout(2,1,5,5));
		n1.setBackground(new Color(241, 250, 238));
		JLabel lb_name = new JLabel("Name");
		lb_name.setForeground(new Color(29, 53, 87));
		lb_name.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		lb_name.setBackground(new Color(241, 250, 238));
		tf_name = new JTextField();
		n1.add(lb_name);
		n1.add(tf_name);
		
		JPanel n2 = new JPanel(new GridLayout(2,1,5,5));
		n2.setBackground(new Color(241, 250, 238));
		JLabel lb_phone = new JLabel("Phone Number");
		lb_phone.setForeground(new Color(29, 53, 87));
		lb_phone.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		lb_phone.setBackground(new Color(241, 250, 238));
		tf_phone = new JTextField();
		n2.add(lb_phone);
		n2.add(tf_phone);
		
		JPanel n3 = new JPanel(new GridLayout(2,1,5,5));
		n3.setBackground(new Color(241, 250, 238));
		JLabel lb_id = new JLabel("ID");
		lb_id.setForeground(new Color(29, 53, 87));
		lb_id.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		lb_id.setBackground(new Color(241, 250, 238));
		tf_id = new JTextField();
		n3.add(lb_id);
		n3.add(tf_id);
		
		JPanel n4 = new JPanel(new GridLayout(2,1,5,5));
		n4.setBackground(new Color(241, 250, 238));
		JLabel lb_date = new JLabel("Check In Date");
		lb_date.setForeground(new Color(29, 53, 87));
		lb_date.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		lb_date.setBackground(new Color(241, 250, 238));
		tf_Date = new JTextField();
		n4.add(lb_date);
		n4.add(tf_Date);
		
		JPanel n5 = new JPanel(new GridLayout(2,1,5,5));
		n5.setBackground(new Color(241, 250, 238));
		JLabel lb_bed = new JLabel("Bed");
		lb_bed.setForeground(new Color(29, 53, 87));
		lb_bed.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		lb_bed.setBackground(new Color(241, 250, 238));
		cb_bed = new JComboBox();
		cb_bed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				roomInfor();
			}
		});
		
		cb_bed.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Triple"}));
		n5.add(lb_bed);
		n5.add(cb_bed);
		
		JPanel n6 = new JPanel(new GridLayout(2,1,5,5));
		n6.setBackground(new Color(241, 250, 238));
		JLabel lb_type = new JLabel("Room Type");
		lb_type.setForeground(new Color(29, 53, 87));
		lb_type.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		lb_type.setBackground(new Color(241, 250, 238));
		cb_type = new JComboBox();
		cb_type.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				roomInfor();
			}
		});
		
		
		cb_type.setForeground(new Color(230, 57, 70));
		cb_type.setFont(new Font("Candara", Font.BOLD, 14));
		cb_type.setModel(new DefaultComboBoxModel(new String[] {"AC", "Non-AC"}));
		n6.add(lb_type);
		n6.add(cb_type);
		
		JPanel n7 = new JPanel(new GridLayout(2,1,5,5));
		n7.setBackground(new Color(241, 250, 238));
		JLabel lb_roomNum = new JLabel("Room Number");
		lb_roomNum.setForeground(new Color(29, 53, 87));
		lb_roomNum.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		lb_roomNum.setBackground(new Color(241, 250, 238));
		cb_roomNum = new JComboBox();
		cb_roomNum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				roomNum();
			}
		});
		
		cb_roomNum.setForeground(new Color(230, 57, 70));
		cb_roomNum.setFont(new Font("Candara", Font.BOLD, 14));
		cb_roomNum.setModel(new DefaultComboBoxModel(new String[] {""}));
		n7.add(lb_roomNum);
		n7.add(cb_roomNum);
		
		
		JPanel n8 = new JPanel(new GridLayout(2,1,5,5));
		n8.setBackground(new Color(241, 250, 238));
		JLabel lb_price = new JLabel("Price");
		lb_price.setForeground(new Color(29, 53, 87));
		lb_price.setFont(new Font("Cascadia Mono", Font.BOLD, 15));
		lb_price.setBackground(new Color(241, 250, 238));
		tf_price = new JTextField();
		n8.add(lb_price);
		n8.add(tf_price);
		
		JPanel n9 = new JPanel(new GridLayout(2,1,5,5));
		n9.setBackground(new Color(241, 250, 238));
		JButton bt_allocate = new JButton("Allocate Room");
		bt_allocate.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				int id = 1;
				String name = tf_name.getText();
				String phoneNumber = tf_phone.getText();
				String idProfile = tf_id.getText();
				String checkInDate = tf_Date.getText();
				String bed = (String) cb_bed.getSelectedItem();
				String type = (String) cb_type.getSelectedItem();
				String roomNumber = (String) cb_roomNum.getSelectedItem();
				String price = tf_price.getText();
				String Query= "SELECT MAX(id) FROM customer";// lệnh lấy vị trí id cao nhất trong sql			
				
				try {
					Integer.parseInt(phoneNumber);
					Integer.parseInt(idProfile);
					ResultSet rs = dataSelect.getData(Query); // láy id lớn nhất 
					//
					while(rs.next()) {               
						id= rs.getInt(1);         
						id = id + 1;             
						if(!price.equals("")) {  
							 
							/* nếu giá tiền không tồn tại thì phòng đã được cho thuê */
							Query="UPDATE room SET status ='Booked' WHERE roomNo='"+roomNumber+"'";
							databaseManager.setData(Query, "");
							Query ="INSERT INTO customer(id,name,phoneNumber,idProfile,checkIn,roomNum,bed,roomType,price) VALUES("+id+",'"+name+"','"+phoneNumber+"','"+idProfile+"','"+checkInDate+"','"+roomNumber+"','"+bed+"','"+type+"','"+price+"')";	
							databaseManager.setData(Query, "CheckInSuccessfully");
							
							setVisible(false);
							new cusCheckIn().setVisible(true);
						}
					}
					//
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"Loi");	
				} 			
			}
		});
		
		bt_allocate.setForeground(new Color(241, 250, 238));
		bt_allocate.setBackground(new Color(29, 53, 87));
		bt_allocate.setFont(new Font("Cascadia Code", Font.ITALIC, 14));
		
		JButton bt_clear = new JButton("Clear");
		bt_clear.setForeground(new Color(241, 250, 238));
		bt_clear.setBackground(new Color(29, 53, 87));
		bt_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearBT();
			}
		});
		n9.add(bt_allocate);
		n9.add(bt_clear);
		
		pn_chung.add(n1);
		pn_chung.add(n2);
		pn_chung.add(n3);
		pn_chung.add(n4);
		pn_chung.add(n5);
		pn_chung.add(n6);
		pn_chung.add(n7);
		pn_chung.add(n8);
		pn_chung.add(n9);
		getContentPane().add(pn_chung); 
	
	}
	
		//
		private void roomInfor() {
				cb_roomNum.removeAllItems();
				tf_price.setText("");
				bed =(String) cb_bed.getSelectedItem(); // (String) ép kiểu dữ liệu cho dữ liệu đầu vào 
				roomType= (String)cb_type.getSelectedItem();
		
		try {
				ResultSet rs = dataSelect.getData("SELECT * FROM room  WHERE bed = '"+bed+"' AND roomType = '"+roomType+"' AND status = 'Not Booked'"); 
				while(rs.next()) {
					cb_roomNum.addItem(rs.getString(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null	, e);
		}
	
	}
		//
		private void roomNum() {
			roomNo = (String) cb_roomNum.getSelectedItem();
			try {
				ResultSet rs = dataSelect.getData("SELECT * FROM room WHERE roomNo ='"+roomNo+"' ");
				while(rs.next()) {
					tf_price.setText(rs.getString(4));
				}
			} catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e1);
			}
		}
		
		//
		
		public void clearBT() {
				setVisible(false);
				new cusCheckIn().setVisible(true);
		}
		
}
