import java.awt.EventQueue;
import views.View_Login;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					View_Login view_app = new View_Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
