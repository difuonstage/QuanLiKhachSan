package Application;

import java.awt.EventQueue;

import view.signIn_View;

public class quanLiKhachSan_Application {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            
			public void run() {
                try {
                    
                	signIn_View window = new signIn_View();
                    
                    window.setVisible(true);
                
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	
}
