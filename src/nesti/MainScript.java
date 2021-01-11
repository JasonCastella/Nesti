package nesti;

import java.awt.EventQueue;

public class MainScript {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection login = new Connection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
