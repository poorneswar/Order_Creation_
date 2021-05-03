
package SandwichShop;

import java.awt.EventQueue;

//launches the application

public class MainStore {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(); // Instantiates the login class which takes care of the rest of the application
					frame.setVisible(true); //Sets the login class visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}