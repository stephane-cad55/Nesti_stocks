package models;

import java.sql.SQLException;

import tools.MD5;

public class SuperAdmin extends Administrators {
	public static void main(String[] args) {

	}

	public static void addAdmin(String nickName, String passWord) {
		try {
			passWord = MD5.main(passWord);
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "INSERT INTO `administrators` (`Id_administrators`, `is_super_admin`, `nickName`, `passWord`) VALUES (NULL, '0',  '"
					+ nickName + "'  ,   '" + passWord + "'  )";
			declaration.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("erreur lors de la creation");
		}
	}

	public static void updateAdmin(int id_admin, String nickName, String passWord) {

		try {
			String query;
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			if(!passWord.equals("")) {
				passWord = MD5.main(passWord);
				 query = "UPDATE administrators SET nickName='" + nickName + "', passWord='" + passWord + "' WHERE Id_administrators=" + id_admin + ";";
			}else {
				 query = "UPDATE administrators SET nickName='" + nickName + "' WHERE Id_administrators=" + id_admin + ";";
			}
			
			declaration.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("erreur lors de la mise a jour");
		}

	}

	public static boolean deleteAdmin(String nickName) {

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "DELETE FROM `administrators` WHERE `administrators`.`nickName` = '" + nickName + "';";
			declaration.executeUpdate(query);
			return true;
		} catch (SQLException e) {

			System.err.println("erreur update impossible");
			return false;
		}

	}

}
