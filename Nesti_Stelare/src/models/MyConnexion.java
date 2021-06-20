package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnexion {
	static Connection accessDataBase = null;

	/**
	 * Testons la connexion
	 * 
	 * @param args
	 */

	public static void openConnection() {
		/* Parametres de connexion */

		String url = Config.URLBSD;
		// nesti = nom de ma bdd
		String utilisateur = Config.USERNAME;
		String motDePasse = Config.PASSWORD;
		try {
			// on ajoute nos param�tres
			accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (SQLException ex) {
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static boolean checkUser(String nickName) {

		boolean flag = false;

		try {

			openConnection();

			String query = "SELECT * FROM administrators WHERE nickName = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, nickName);

			ResultSet resultat = declaration.executeQuery();

			if (resultat.next() == true) {
				flag = true;
			}

		} catch (Exception e) {

			System.err.println("user display error: " + e.getMessage());
		}

		closeConnection();

		return flag;
	}

	public static boolean checkId(String nickName, String passWord) {

		boolean flag = false;

		try {

			openConnection();

			String query = "SELECT * FROM administrators WHERE nickName = ? AND passWord= ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, nickName);
			declaration.setString(2, passWord);

			ResultSet resultat = declaration.executeQuery();

			if (resultat.next() == true) {
				flag = true;
			}

		} catch (Exception e) {

			System.err.println("user display error: " + e.getMessage());
		}

		closeConnection();

		return flag;
	}

	public static void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				
			} catch (SQLException e) {
				System.err.println("Erreur fermreture: " + e.getMessage());
			}
		}
	}
}