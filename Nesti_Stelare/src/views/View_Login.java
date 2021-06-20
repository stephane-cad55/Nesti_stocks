package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import entity.AdminEntity;
import models.Administrators;
import models.MyConnexion;
import tools.MD5;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Login {

	private static final String CENTER = null;
	private JFrame frame;
	private JTextField name;
	private JPasswordField passWord;
	static AdminEntity userConnected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					View_Login window = new View_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View_Login() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(46, 22, 14));
		frame.setBounds(100, 100, 496, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel img = new JLabel(new ImageIcon(View_Login.class.getResource("/img/connect-image.png")));
		img.setBounds(0, 0, 480, 127);
		frame.getContentPane().add(img);

		JLabel name_user = new JLabel("Nom utilisateur");
		name_user.setBounds(-12, 170, 157, 14);
		name_user.setForeground(new Color(230, 167, 86));
		name_user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name_user.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(name_user);

		JLabel passWord_user = new JLabel("Mot de passe");
		passWord_user.setBounds(-12, 248, 146, 14);
		passWord_user.setForeground(new Color(230, 167, 86));
		passWord_user.setHorizontalAlignment(SwingConstants.CENTER);
		passWord_user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(passWord_user);

		/**
		 * Fields to fill for connection.
		 */
		name = new JTextField();
		name.setBounds(124, 163, 346, 33);
		frame.getContentPane().add(name);
		name.setColumns(10);

		passWord = new JPasswordField();
		passWord.setBounds(124, 241, 346, 33);
		frame.getContentPane().add(passWord);
		passWord.setColumns(10);

		JLabel lbl_Msg_Name_Error = new JLabel("Aucun compte n'est li\u00E9 \u00E0 ce nom d'utilisateur");
		lbl_Msg_Name_Error.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Msg_Name_Error.setForeground(Color.RED);
		lbl_Msg_Name_Error.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Msg_Name_Error.setBounds(124, 203, 346, 14);
		frame.getContentPane().add(lbl_Msg_Name_Error);
		lbl_Msg_Name_Error.setVisible(false);

		JLabel lbl_Msg_PassWord_Error = new JLabel("Mot de passe incorrect");
		lbl_Msg_PassWord_Error.setForeground(Color.RED);
		lbl_Msg_PassWord_Error.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Msg_PassWord_Error.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Msg_PassWord_Error.setBounds(124, 280, 346, 14);
		frame.getContentPane().add(lbl_Msg_PassWord_Error);
		lbl_Msg_PassWord_Error.setVisible(false);

		/**
		 * Button to connect.
		 */
		JButton btn_connection = new JButton("SE CONNECTER");
		btn_connection.setBounds(172, 306, 157, 33);
		btn_connection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String user = name.getText();
				String userPassword = MD5.main(new String(passWord.getPassword()));
				
				if (MyConnexion.checkUser(user) == true) {
					
					if (MyConnexion.checkId(user, userPassword) == true) {
						
						userConnected = Administrators.readOne(user);
						
						new View_App();
				

					} else {
						
						lbl_Msg_PassWord_Error.setVisible(true);
					}

				} else {
					
					lbl_Msg_Name_Error.setVisible(true);
				}
			}

		});
		btn_connection.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_connection.setForeground(Color.WHITE);
		btn_connection.setBackground(new Color(88, 55, 30));
		frame.getContentPane().add(btn_connection);

	}
}