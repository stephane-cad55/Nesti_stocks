package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Products {

	public static ArrayList<String[]> arrayIng;
	public static ArrayList<String[]> arrayUte;

	private static ResultSet resultat = null;

	public static void main(String[] args) {

	}

	// read ingredients.
	public static String[][] readIngredients() {

		ArrayList<String> products = new ArrayList<String>();
		arrayIng = new ArrayList<String[]>();

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT name, p.Id_products, expiration_time_limit FROM products p INNER JOIN ingredients i ON p.id_products = i.id_ingredients";

			resultat = declaration.executeQuery(query);

			while (resultat.next()) {

				products.add(resultat.getString("name") + " " + resultat.getString("Id_products") + " "
						+ resultat.getInt("expiration_time_limit"));
			}

			;

		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}

		for (int i = 0; i < products.size(); i++) {
			arrayIng.add(products.get(i).split(" ", 3));
		}

		String[][] data = new String[arrayIng.size()][3];
		for (int i = 0; i < arrayIng.size(); i++) {
			data[i][0] = arrayIng.get(i)[0];
			data[i][1] = arrayIng.get(i)[2];
			data[i][2] = calculQuantity(arrayIng.get(i)[1]);

		}

		return data;
	}

	// read kitchen utensils.
	public static String[][] readKitchenUtensils() {

		ArrayList<String> products = new ArrayList<String>();
		arrayUte = new ArrayList<String[]>();

		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT p.name, p.Id_products FROM products p INNER JOIN kitchen_utensils k ON p.id_products = k.Id_products";

			resultat = declaration.executeQuery(query);

			while (resultat.next()) {

				products.add(resultat.getString("name") + " " + resultat.getString("Id_products"));
			}

			;

		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}

		for (int i = 0; i < products.size(); i++) {
			arrayUte.add(products.get(i).split(" ", 2));
		}

		String[][] data = new String[arrayUte.size()][2];
		for (int i = 0; i < arrayUte.size(); i++) {
			data[i][0] = arrayUte.get(i)[0];
			data[i][1] = calculQuantity(arrayUte.get(i)[1]);

		}

		return data;
	}

	// create products.
	public static void createProducts(String name, String type, int expiration_time_limit, int id_administrators) {
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "INSERT INTO `products` (`Id_products`, `name`, `Id_administrators`, `type`) VALUES (NULL,'"
					+ name + "', '" + id_administrators + "', '" + type + "');";
			declaration.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("erreur lors de la creation");
		}

		if (type == "ing") {
			createIngredients(name, expiration_time_limit);

		} else if (type == "ute") {
			createKitchenUtensils(name);
		}
	}

	// create kitchen utensils.
	public static void createKitchenUtensils(String name) {
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "INSERT INTO `kitchen_utensils` (`Id_products`) SELECT id_products FROM products WHERE name = '"
					+ name + "';";
			declaration.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("erreur lors de la creation");
		}

	}

	// create ingredients.
	public static void createIngredients(String name, int expiration_time_limit) {
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "INSERT INTO `ingredients` (`id_ingredients`, `expiration_time_limit`) VALUES ((SELECT id_products FROM products WHERE name = '"
					+ name + "') , '" + expiration_time_limit + "');";
			declaration.executeUpdate(query);

		} catch (Exception e) {
			System.err.println("erreur lors de la creation");
		}
	}

	// update products.
	public static void updateProducts(String name, String type, int expiration_time_limit, int id_products) {
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "UPDATE products SET name='" + name + "' WHERE id_products=" + id_products + ";";

			declaration.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("erreur lors de la mise a jour");
		}

		if (type == "ing") {
			updateIngredients(expiration_time_limit, id_products);
		}
	}

	// delete products.
	public static boolean deleteProducts(int idProducts) {
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "DELETE FROM `products` WHERE `products`.`Id_products` = " + idProducts + ";";
			
			declaration.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("erreur lors de la mise a jour");
			return false;
		}
	}

	// update ingredients.
	public static void updateIngredients(int expiration_time_limit, int id_products) {
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "UPDATE `ingredients` SET `expiration_time_limit` = '" + expiration_time_limit
					+ "' WHERE `ingredients`.`id_ingredients` = '" + id_products + "'; ";
		
			declaration.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("erreur lors de la mise a jour");
		}

	}

	// count quantity.
	public static String calculQuantity(String id_products) {
		String stock = "";
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT COUNT(*) FROM articles WHERE id_products =" + id_products;
			ResultSet resultat = declaration.executeQuery(query);
			while (resultat.next()) {
				stock = resultat.getString("COUNT(*)");
			}

		} catch (Exception e) {
			System.err.println("erreur lors de la r�cup�ration");
		}
		return stock;
	}

	public static ArrayList<String> readNamesProducts() {
		ArrayList<String> names = new ArrayList<String>();
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT name FROM products";

			resultat = declaration.executeQuery(query);

			while (resultat.next()) {

				names.add(resultat.getString("name"));

			}

		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}
		return names;
	}

	public static ArrayList<String> readNamesUnity() {
		ArrayList<String> namesUnity = new ArrayList<String>();
		try {
			MyConnexion.openConnection();
			java.sql.Statement declaration = MyConnexion.accessDataBase.createStatement();
			String query = "SELECT NAME FROM unity";

			resultat = declaration.executeQuery(query);

			while (resultat.next()) {

				namesUnity.add(resultat.getString("NAME"));
			}

		} catch (Exception e) {
			System.err.println("erreur lors de la recuperation");
		}
		return namesUnity;
	}

}
