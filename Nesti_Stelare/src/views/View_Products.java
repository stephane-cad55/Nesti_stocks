package views;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.table.DefaultTableModel;

import models.Products;
import tools.MyRendererAndEditor;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class View_Products extends BaseView {
	private JTextField textField_name_product;
	private JTextField textField_day_peremption;

	public View_Products() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/**
		 * Panels_products
		 */

		// Create panel_products (TabbedPane)
		JPanel panel_products = new JPanel();
		panel_products.setBackground(Color.WHITE);
		View_App.tabbedPane.addTab("Produits", null, panel_products, null);
		panel_products.setLayout(null);

		/**
		 * Table article
		 */

		// Create scrollPane_products_ingredients
		JScrollPane scrollPane_products_ingredients = new JScrollPane();
		scrollPane_products_ingredients.setBounds(0, 0, 888, 284);
		// Add scrollPane_products_ingredients to panel_articles
		panel_products.add(scrollPane_products_ingredients);
		// Create table_products_ingredients
		JTable table_products_ingredients = new JTable();
		table_products_ingredients.setModel(new DefaultTableModel(Products.readIngredients(), new String[] {
				"Nom ingredient", "Jour avant péremption", "Nombre d'articles correspondant", " ", "-" }) {
			private static final long serialVersionUID = 6100160127192405992L;
			boolean[] columnEditables = new boolean[] { false, false, false, true, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		// Columns Properties
		int columnCount = table_products_ingredients.getColumnModel().getColumnCount();
        for (int i = 0; i < columnCount; i++ ) {
            table_products_ingredients.getColumnModel().getColumn(i).setResizable(false);
        }

		// Add btn upload
		table_products_ingredients.getColumn(" ")
				.setCellRenderer(new MyRendererAndEditor(table_products_ingredients, "Modifier", this));
		table_products_ingredients.getColumn(" ")
				.setCellEditor(new MyRendererAndEditor(table_products_ingredients, "Modifier", this));
		// Add btn delete
		table_products_ingredients.getColumn("-")
				.setCellRenderer(new MyRendererAndEditor(table_products_ingredients, "Supprimer", this));
		table_products_ingredients.getColumn("-")
				.setCellEditor(new MyRendererAndEditor(table_products_ingredients, "Supprimer", this));
		// Get table_article visible in the scrollPane_articles
		scrollPane_products_ingredients.setViewportView(table_products_ingredients);
		scrollPane_products_ingredients.setColumnHeaderView(table_products_ingredients.getTableHeader());

		/**
		 * Table article
		 */

		// Create scrollPane_products_utensils
		JScrollPane scrollPane_products_utensils = new JScrollPane();
		scrollPane_products_utensils.setBounds(0, 295, 888, 290);
		panel_products.add(scrollPane_products_utensils);

		// Create table_products_utensils
		JTable table_products_utensils = new JTable();
		table_products_utensils.setModel(new DefaultTableModel(Products.readKitchenUtensils(),
				new String[] { "Nom ustensile", "Nombre d'articles correspondant", " ", "-" }) {
			private static final long serialVersionUID = -1698236882141505675L;
			boolean[] columnEditables = new boolean[] { false, false, true, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		// Columns Properties
				int columnCount2 = table_products_utensils.getColumnModel().getColumnCount();
		        for (int i = 0; i < columnCount2; i++ ) {
		        	table_products_utensils.getColumnModel().getColumn(i).setResizable(false);
		        }
		// Add btn upload
		table_products_utensils.getColumn(" ")
				.setCellRenderer(new MyRendererAndEditor(table_products_utensils, "Modifier", this));
		table_products_utensils.getColumn(" ")
				.setCellEditor(new MyRendererAndEditor(table_products_utensils, "Modifier", this));
		// Add btn delete
		table_products_utensils.getColumn("-")
				.setCellRenderer(new MyRendererAndEditor(table_products_utensils, "Supprimer", this));
		table_products_utensils.getColumn("-")
				.setCellEditor(new MyRendererAndEditor(table_products_utensils, "Supprimer", this));
		// Get table_products_utensils visible in the scrollPane_products_utensils
		scrollPane_products_utensils.setViewportView(table_products_utensils);
		scrollPane_products_utensils.setColumnHeaderView(table_products_utensils.getTableHeader());

		/**
		 * Panel create new product
		 */

		// Create panel_create_product
		JPanel panel_create_product = new JPanel();
		panel_create_product.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_create_product.setBounds(899, 11, 328, 240);
		panel_create_product.setBackground(Color.WHITE);
		panel_products.add(panel_create_product);
		panel_create_product.setLayout(null);

		JLabel lbl_product = new JLabel("Ajouter un produit");
		lbl_product.setBounds(105, 6, 117, 15);
		lbl_product.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_product.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_create_product.add(lbl_product);

		JLabel lbl_name_product = new JLabel("Nom du produit : ");
		lbl_name_product.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_name_product.setBounds(0, 32, 128, 14);
		panel_create_product.add(lbl_name_product);

		textField_name_product = new JTextField();
		textField_name_product.setBounds(20, 57, 287, 20);
		panel_create_product.add(textField_name_product);
		textField_name_product.setColumns(10);

		JLabel lbl_type_product = new JLabel("Type du produit : ");
		lbl_type_product.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_type_product.setBounds(0, 88, 128, 14);
		panel_create_product.add(lbl_type_product);

		JLabel lbl_day_peremption = new JLabel("Jour avant p\u00E9remption :");
		lbl_day_peremption.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_day_peremption.setBounds(0, 138, 153, 14);
		panel_create_product.add(lbl_day_peremption);

		textField_day_peremption = new JTextField();
		textField_day_peremption.setHorizontalAlignment(SwingConstants.CENTER);
		textField_day_peremption.setBounds(20, 163, 56, 20);
		panel_create_product.add(textField_day_peremption);
		textField_day_peremption.setColumns(10);

		JButton btn_add_product = new JButton("Ajouter le produit");
		btn_add_product.setBounds(105, 204, 131, 23);
		panel_create_product.add(btn_add_product);

		String[] comboBoxItem = { "ingrédient", "ustensile" };
		JComboBox comboBox = new JComboBox(comboBoxItem);

		comboBox.setBounds(123, 84, 99, 22);
		panel_create_product.add(comboBox);
		btn_add_product.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int day_peremption = 0;
				String typeProduct = null;

				if (!textField_day_peremption.getText().equals("")) {
					day_peremption = Integer.parseInt(textField_day_peremption.getText());
				}
				if (comboBox.getSelectedItem() == "ingrédient") {
					typeProduct = "ing";
				} else if (comboBox.getSelectedItem() == "ustensile") {
					typeProduct = "ute";
				}
				Products.createProducts(textField_name_product.getText(), typeProduct, day_peremption, 6);

			}

			private void uploadTable(JTable table_products_ingredients) {
				// TODO Auto-generated method stub

			}

		});

	}

	@Override
	public void loadDataInPanelUpdate(JTable table, int row) {
		// TODO Auto-generated method stub
		
	}
}
