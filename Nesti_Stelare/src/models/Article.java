package models;

//TODO : recup id depuis l'app, pas en dur, 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Article {
	private static ResultSet resultat = null;
	private static Double buy_price_article = 0.0;
	public static ArrayList<String[]> arrayRow;

	public static void main(String[] args) {

	}

	public static String[][] readAll() {

		ArrayList<String> articles = new ArrayList<String>();
		arrayRow = new ArrayList<String[]>();

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT a.name,a.weight,a.state,p.type,u.NAME, a.Id_articles FROM articles a INNER JOIN products p ON a.id_products=p.Id_products INNER JOIN unity u ON a.id_unity=u.Id_unity;";
			resultat = declaration.executeQuery(query);

			while (resultat.next()) {

				articles.add(resultat.getString("a.name") + "/" + resultat.getString("a.weight") + "/"
						+ resultat.getString("u.NAME") + "/" + resultat.getString("a.state") + "/"
						+ resultat.getString("p.type") + "/" + resultat.getInt("a.Id_articles"));

			}

			;

		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}

		for (int i = 0; i < articles.size(); i++) {
			arrayRow.add(articles.get(i).split("/", 6));
		}

		String[][] data = new String[arrayRow.size()][6];
		for (int i = 0; i < arrayRow.size(); i++) {
			data[i][0] = arrayRow.get(i)[0];
			data[i][1] = arrayRow.get(i)[4];
			data[i][2] = calculSellPrice(arrayRow.get(i)[0]);
			data[i][3] = arrayRow.get(i)[1] + arrayRow.get(i)[2];
			data[i][4] = arrayRow.get(i)[3];
			data[i][5] = calculNbItem(arrayRow.get(i)[0]);
		}

		return data;
	}

	public static String readOne(int id) {
		String oneArticle = null;
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT a.name,a.weight,a.state,p.type,u.NAME,a.Id_articles FROM articles a INNER JOIN products p ON a.id_products=p.Id_products INNER JOIN unity u ON a.id_unity=u.Id_unity WHERE id_articles ="
					+ id + ";";
			resultat = declaration.executeQuery(query);
			/* R�cup�ration des donn�es */
			while (resultat.next()) {
				oneArticle = resultat.getString("a.name") + " " + resultat.getString("a.weight") + " "
						+ resultat.getString("u.NAME") + " " + resultat.getString("a.state") + " "
						+ resultat.getString("p.type");
			}

		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}
		return oneArticle;

	}

	public static ArrayList<String> readSuppliersByArticle(int id) {
		ArrayList<String> suppliers = new ArrayList<String>();
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT su.company_name,se.buy_price_article FROM sell se INNER JOIN suppliers su ON se.Id_suppliers=su.id_suppliers WHERE se.Id_articles ="
					+ id + ";";
			ResultSet resultat = declaration.executeQuery(query);
			/* R�cup�ration des donn�es */
			while (resultat.next()) {
				suppliers.add(resultat.getString("su.company_name") + " " + resultat.getString("se.buy_price_article"));
			}

		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}

		return suppliers;
	}

	public static String calculSellPrice(String nameArticle) {

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT MAX(buy_price) FROM `is_contained` s  WHERE Id_articles = (SELECT Id_articles FROM articles WHERE name = '"
					+ nameArticle + "');";
			ResultSet resultat = declaration.executeQuery(query);

			while (resultat.next()) {
				buy_price_article = resultat.getDouble("MAX(buy_price)");
			}

		} catch (Exception e) {
			buy_price_article = (double) 0;
		}
		Double price_calculated = buy_price_article * 1.20;
		String test = String.valueOf(price_calculated);

		return test;
	}

	public static void createArticle(String articleName, Double articleWeight, String nameProduct, int idAdministrators,
			String nameUnity) {
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "INSERT INTO `articles` (`id_articles`,`name`,`weight`,`state`,`id_administrators`,`id_products`,`id_unity`) VALUES (NULL, '"
					+ articleName + "', '" + articleWeight + "', 'a', '" + idAdministrators
					+ "', (SELECT Id_products FROM products WHERE name = '" + nameProduct + "' )"
					+ ", (SELECT Id_unity FROM unity WHERE NAME = '" + nameUnity + "'))";
			declaration.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("erreur lors de la creation");
		}
	}

	public static void update(String name, Double weight, int id_article) {

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "UPDATE articles SET name='" + name + "', weight='" + weight + "' WHERE id_articles=" + id_article
					+ ";";
			declaration.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("erreur lors de la mise a jour");
		}

	}

	public static boolean deleteArticle(int idArticle) {

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "DELETE FROM `articles` WHERE `articles`.`id_articles` = " + idArticle + ";";
			declaration.executeUpdate(query);
			return true;
		} catch (SQLException e) {

			System.err.println("erreur update impossible");
			return false;
		}
	}

	public static String calculNbItem(String nameArticle) {
		int stock = 0;
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT SUM(quantity) FROM is_contained WHERE Id_articles = (SELECT id_articles FROM articles WHERE name = '"
					+ nameArticle + "');";
			ResultSet resultat = declaration.executeQuery(query);
			while (resultat.next()) {
				stock = resultat.getInt("SUM(quantity)");
			}

		} catch (Exception e) {
			stock = 0;
		}
		return String.valueOf(stock);
	}
}
