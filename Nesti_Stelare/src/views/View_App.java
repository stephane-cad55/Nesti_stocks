package views;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class View_App {


	static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	/**
	 * Create the application.
	 */
	public View_App() {
		initialize();
	}

	private void initialize() {
		
		// Principal Frame
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(46, 22, 14));
		frame.setBounds(100, 100, 1280, 720);	
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Panel log
		JPanel panel_log = new JPanel();
		panel_log.setBackground(new Color(230, 167, 86));
		panel_log.setBounds(0, 0, 1274, 46);
		panel_log.setLayout(null);
		
		// Btn disconnect
		JButton btn_disconnect = new JButton("Deconnexion");
		btn_disconnect.setBounds(1124, 14, 124, 23);
		
		// Label nickname
		JLabel lbl_nickname = new JLabel();
		lbl_nickname.setText(View_Login.userConnected.getPseudo());
		lbl_nickname.setBounds(910, 11, 204, 29);
		lbl_nickname.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_nickname.setForeground(Color.BLACK);
		
		panel_log.add(btn_disconnect);
		panel_log.add(lbl_nickname);
		
		frame.getContentPane().add(panel_log);
		
		// TabbedPane
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(10, 57, 1241, 613);
		
		// Add tabbedPane to principal frame
		frame.getContentPane().add(tabbedPane);
		
		// Initialisations des views (tabbedPane)
		View_Articles view_articles = new View_Articles();
		View_Suppliers view_suppliers = new View_Suppliers();
		View_Orders view_orders = new View_Orders();
		View_Products view_products = new View_Products();
		View_MyAccount view_myAccount = new View_MyAccount();
		View_Administrators view_administrators = new View_Administrators();
		
	}
}
