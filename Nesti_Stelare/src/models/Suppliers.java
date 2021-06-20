package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//rajouter le type , le poids et le en stock dans readarticlebysuppliers
public class Suppliers {
	public static ArrayList<String[]> arrayRow;


	public static String[][] readAll() {

		ArrayList<String> suppliers = new ArrayList<String>();
		arrayRow = new ArrayList<String[]>();

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT * FROM suppliers;";
			ResultSet resultat = declaration.executeQuery(query);
			/* Récupération des données */
			while (resultat.next()) {
				suppliers.add(resultat.getInt("id_suppliers") + "/" + resultat.getString("company_name") + "/"
						+ resultat.getString("company_street") + "/" + resultat.getString("company_city") + "/"
						+ resultat.getInt("company_cp") + "/" + resultat.getString("contact_name") + "/"
						+ resultat.getString("contact_firstName") + "/" + resultat.getInt("tel_number") + "/"
						+ resultat.getString("state") + "/" + resultat.getInt("id_administrators"));

			}
		} catch (

		Exception e) {
			System.err.println("erreur lors de la recuperation");
		}

		for (int i = 0; i < suppliers.size(); i++) {
			arrayRow.add(suppliers.get(i).split("/", 10));
		}

		String[][] data = new String[arrayRow.size()][7];
		for (int i = 0; i < arrayRow.size(); i++) {
			data[i][0] = arrayRow.get(i)[1];
			data[i][1] = arrayRow.get(i)[2];
			data[i][2] = arrayRow.get(i)[3];
			data[i][3] = arrayRow.get(i)[4];
			data[i][4] = arrayRow.get(i)[5];
			data[i][5] = arrayRow.get(i)[6];
			data[i][6] = arrayRow.get(i)[7];
			
		}

		return data;
	}

	public static String readOne(int id) {
		String oneSuppliers = null;
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT * FROM suppliers WHERE id_suppliers =" + id + ";";
			ResultSet resultat = declaration.executeQuery(query);
			/* R�cup�ration des donn�es */
			while (resultat.next()) {
				oneSuppliers = resultat.getInt("id_suppliers") + " " + resultat.getString("company_name") + " "
						+ resultat.getString("company_street") + " " + resultat.getString("company_city") + " "
						+ resultat.getInt("company_cp") + " " + resultat.getString("contact_name") + " "
						+ resultat.getString("contact_firstName") + " " + resultat.getInt("tel_number") + " "
						+ resultat.getString("state") + " " + resultat.getInt("id_administrators");

			}
		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}
		System.out.println(oneSuppliers);
		return oneSuppliers;
	}

	public static ArrayList<String> readArticleBySuppliers(int id) {
		ArrayList<String> article = new ArrayList<String>();
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT DISTINCT a.name, se.buy_price_article  FROM suppliers su INNER JOIN sell se ON su.id_suppliers=se.id_suppliers INNER JOIN articles a ON a.id_articles=se.Id_articles WHERE su.id_suppliers ="
					+ id + ";";
			ResultSet resultat = declaration.executeQuery(query);
			/* R�cup�ration des donn�es */
			while (resultat.next()) {
				article.add(resultat.getString("name") + " " + resultat.getInt("buy_price_article"));

			}
		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}

		return article;
	}

	public static void createSuppliers(String company_name, String company_street, String company_city, int company_cp,
			String contact_name, String contact_firstName, String tel_number, int id_administrators) {
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "INSERT INTO `suppliers`(`id_suppliers`, `company_name`, `company_street`, `company_city`, `company_cp`, `contact_name`, `contact_firstName`, `tel_number`, `state`, `id_administrators`) VALUES (NULL, '"
					+ company_name + "', '" + company_street + "','" + company_city + "', '" + company_cp + "', '"
					+ contact_name + "', '" + contact_firstName + "', '" + tel_number + "','a' ,'" + id_administrators
					+ "' )";
			declaration.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("erreur lors de la creation");
		}
	}

	public static void update(String company_name, String company_street, String company_city, int company_cp,
			String contact_name, String contact_firstName, String tel_number, int id_suppliers) {

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "UPDATE suppliers SET company_name='" + company_name + "', company_street='" + company_street
					+ "', company_city='" + company_city + "', company_cp='" + company_cp + "', contact_name='"
					+ contact_name + "', contact_firstName='" + contact_firstName + "', tel_number='" + tel_number
					+ "' WHERE id_suppliers=" + id_suppliers + ";";
			declaration.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("erreur lors de la mise a jour");
		}

	}
	public static boolean deleteSuppliers(int idSupplier) {

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "DELETE FROM `suppliers` WHERE `suppliers`.`id_suppliers` = " + idSupplier + ";";
			declaration.executeUpdate(query);
			return true;
		} catch (SQLException e) {

			System.err.println("erreur update impossible");
			return false;
		}
	}

}
