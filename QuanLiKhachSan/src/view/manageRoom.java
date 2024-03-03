package view;
import view.*;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import controller.dataSelect;
import controller.manageRoomContr;
import model.databaseManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.ResultSet;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class manageRoom extends JFrame {

	private JLabel lbnumber;
	private JTextField tfnumber;
	private JLabel lbtype;
	private JComboBox<String> cbtype;
	private JLabel lbbed;
	private JComboBox<String> cbbed;
	private JLabel lbprice;
	private JTextField tfprice;
	private JTextField tfstt;
	private DefaultTableModel model;
	private JTable table;
	
	public manageRoom() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs = dataSelect.getData("SELECT * FROM qlkhachsan.room");
				model = (DefaultTableModel) table.getModel();
				try {
				    while (rs.next()) {
				        model.addRow(new Object[] {
				            rs.getObject("roomno"),
				            rs.getObject("roomType"),
				            rs.getObject("bed"),
				            rs.getObject("price"),
				            rs.getObject("status")
				        });
				    }
				    rs.close();
				} catch (SQLException e2) {
				    JOptionPane.showMessageDialog(null, e2);
				}
			}
			
		});
		
		this.init();
	}
	
	public void init() {
		
		this.setSize(400,400);
		this.setBounds(100, 100, 1266, 600);
		this.setLocationRelativeTo(null);
		// actioner
		manageRoomContr action1 = new manageRoomContr(this);
		// phai
		JPanel  panel_chung = new JPanel();
		panel_chung.setLayout(new GridLayout(1,2,2,2));
		
		JPanel panel_trai = new JPanel();
		JPanel panel_phai = new JPanel();
		panel_phai.setLayout(new GridLayout(9,1,10,10));
		
		lbnumber = new JLabel("Room Number");
		lbnumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbnumber.setHorizontalAlignment(SwingConstants.LEFT);
		lbnumber.setBounds(772, 106, 118, 24);
		panel_phai.add(lbnumber);

		tfnumber = new JTextField();
		tfnumber.setBounds(772, 127, 400, 29);
		panel_phai.add(tfnumber);
		tfnumber.setColumns(10);

		lbtype = new JLabel("Room Type");
		lbtype.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbtype.setHorizontalAlignment(SwingConstants.LEFT);
		lbtype.setBounds(772, 166, 118, 24);
		panel_phai.add(lbtype);
		cbtype=new JComboBox();
		cbtype.setModel(new DefaultComboBoxModel(new String[] {"AC","non-AC"}));
		panel_phai.add(cbtype);
		
		lbbed = new JLabel("Bed");
		lbbed.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbbed.setBounds(772, 227, 118, 24);
		panel_phai.add(lbbed);
		cbbed = new JComboBox();
		cbbed.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cbbed.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "Triple"}));
		cbbed.setBounds(772, 250, 400, 29);
		panel_phai.add(cbbed);

		lbprice = new JLabel("Price");
		lbprice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbprice.setBounds(772, 300, 45, 13);
		panel_phai.add(lbprice);

		tfprice = new JTextField();
		tfprice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfprice.setBounds(772, 315, 400, 29);
		panel_phai.add(tfprice);
		tfprice.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Room");
		
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		
		btnNewButton.setBounds(772, 364, 106, 35);
		
		btnNewButton.addActionListener(action1);
		panel_phai.add(btnNewButton);
		//trai
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(87, 106, 537, 355);
		panel_trai.add(scrollPane);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Room Number", "Room Type", "Bed", "Price", "Status"}){
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		panel_chung.add(panel_trai);
		panel_chung.add(panel_phai);
		getContentPane().add(panel_chung);
		
	}
	
		public void addRoom() {
		String roomNo = tfnumber.getText();
		String roomType = (String)cbtype.getSelectedItem();
		String bed = (String)cbbed.getSelectedItem();
		String price = tfprice.getText();
		try {
			Float.parseFloat(price);
			String Query = "INSERT INTO room VALUES('"+roomNo+"','"+roomType+"','"+bed+"','"+price+"','Not Booked' )";
			databaseManager.setData(Query,"Successfully Updated");
			setVisible(false);
			new manageRoom().setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Loi");
		}
	}
		
		
		
			
		

}
