package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.AdminEntity;

public class Administrators {
	
	public static ArrayList<String[]> arrayRow;

	public static void main(String[] args) {
		readAll();
		//readDataTableModel();
		
	}

	/**
	 * Read all administrators from database
	 * @return String[][] data
	 */
	public static String[][] readAll() {
		
		ArrayList<String> row = new ArrayList<String>();
		arrayRow = new ArrayList<String[]>();
		
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT * FROM administrators;";
			ResultSet resultat = declaration.executeQuery(query);
			// Get data from database
			while (resultat.next()) {
				row.add(resultat.getInt("Id_administrators") + " " + resultat.getInt("is_super_admin") + " "
						+ resultat.getString("nickName") + " " + resultat.getString("passWord"));
			}
		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation");
		}
		
		for (int i = 0; i < row.size(); i++) {
			arrayRow.add(row.get(i).split(" ", 4));
		}
		
		String[][] data = new String[arrayRow.size()][3];
		for (int i = 0; i < arrayRow.size(); i++) {
			data[i][0] =  arrayRow.get(i)[2];
			data[i][1] =  arrayRow.get(i)[1];
			data[i][2] =  arrayRow.get(i)[3];
		}

		return data;
	}
		

	/**
	 * Read one administrator by id
	 * @param id
	 * @return String row
	 */
	public static String readOne(int id) {
		String row = null;
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT * FROM administrators WHERE Id_administrators =" + id + ";";
			ResultSet resultat = declaration.executeQuery(query);
			// Get data from database
			while (resultat.next()) {
				row = resultat.getInt("Id_administrators") + " " + resultat.getInt("is_super_admin") + " "
						+ resultat.getString("nickName") + " " + resultat.getString("passWord");
			}
		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation");
		}
		return row;
	}
	
	/**
	 * Read one administrator by id
	 * @param id
	 * @return String row
	 */
	public static AdminEntity readOne(String pseudo) {
		
		AdminEntity user = new AdminEntity();
		
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT * FROM administrators WHERE nickName ='"+pseudo+"';";
			ResultSet rs = declaration.executeQuery(query);
			if (rs.next()) {
				
				try {
					user.setSuperAdmin(rs.getBoolean("is_super_admin"));
					user.setId(rs.getInt("id_administrators"));
					user.setPseudo(rs.getString("nickName"));
					user.setPassword(rs.getString("password"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			System.err.println("Erreur lors de la recuperation");
		}
		
		return user;
	}

}
