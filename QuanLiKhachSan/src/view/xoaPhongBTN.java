package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.databaseManager;

import java.awt.Window.Type;

public class xoaPhongBTN extends JFrame {
		private JTextField tf_roomNum;

		public xoaPhongBTN() {
			setType(Type.POPUP);
			this.init();
		}
		
		public void init() {
			this.setLocationRelativeTo(null);
			this.setSize(431,145);
			
			GridLayout grid_main = new GridLayout(3,1,5,5);
			getContentPane().setLayout(grid_main);
			
			JLabel roomNum = new JLabel("Room Number: ");
			tf_roomNum = new JTextField(1);
			tf_roomNum.setToolTipText("Nhap phong can xoa");
			
			JPanel n1 = new JPanel();
			GridLayout grid_n1 = new GridLayout(1,2,10,10);
			JButton del = new JButton("Delete");
			del.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					delete();
					
				}
			});
			
			JButton canc = new JButton("Cancel");
			canc.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					cancel();	
				}
			});
			n1.setLayout(grid_n1);
			n1.add(del);
			n1.add(canc);
			
			getContentPane().add(roomNum);
			getContentPane().add(tf_roomNum);
			getContentPane().add(n1);
					
		 }
		
		public void cancel() {
			setVisible(false);
		}
		
		public void delete() {
			String roomNum = tf_roomNum.getText();
			
			if(roomNum.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui long nhap so phong");
			} else  {
			
			
			try {
				String Query="DELETE FROM room WHERE roomNo='"+roomNum+"'";
				databaseManager.setData(Query, "Xoa phong thanh cong!!");
				setVisible(false);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Co loi xay ra!!");
			}
		 }
		}
		
		
		
		
}
