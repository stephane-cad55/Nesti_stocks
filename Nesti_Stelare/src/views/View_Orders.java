package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import models.Orders;
import tools.MyRendererAndEditor;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class View_Orders extends BaseView {
	private JTextField textField;
	private JTextField textField_Price;

	public View_Orders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/**
		 * Panels_orders
		 */

		// Create panel_orders (TabbedPane)
		JPanel panel_orders = new JPanel();
		panel_orders.setBackground(Color.WHITE);
		View_App.tabbedPane.addTab("Commandes", null, panel_orders, null);
		panel_orders.setLayout(null);

		/**
		 * Table orders
		 */

		// Create scrollPane_orders
		JScrollPane scrollPane_orders = new JScrollPane();
		scrollPane_orders.setBounds(0, 0, 888, 286);

		// Add scrollPane_orders tp panel_orders
		panel_orders.add(scrollPane_orders);

		// Create table_orders
		JTable table_orders = new JTable();
		table_orders.setModel(new DefaultTableModel(
				Orders.readAll(),
				new String[] { "Date de la commande", "Date de réception", "Prix Total", "Etat", "Fournisseur",
						"Administrateur", " ", "-" }) {
			private static final long serialVersionUID = -779283527594587689L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		// Columns Properties
		table_orders.getColumnModel().getColumn(0).setResizable(false);
		table_orders.getColumnModel().getColumn(1).setResizable(false);
		table_orders.getColumnModel().getColumn(2).setResizable(false);
		table_orders.getColumnModel().getColumn(3).setResizable(false);
		table_orders.getColumnModel().getColumn(4).setResizable(false);
		table_orders.getColumnModel().getColumn(5).setResizable(false);
		table_orders.getColumnModel().getColumn(6).setResizable(false);
		table_orders.getColumnModel().getColumn(7).setResizable(false);
		// Add btn upload
		table_orders.getColumn(" ").setCellRenderer(new MyRendererAndEditor(table_orders, "Modifier", this));
		table_orders.getColumn(" ").setCellEditor(new MyRendererAndEditor(table_orders, "Modifier", this));
		// Add btn delete
		table_orders.getColumn("-").setCellRenderer(new MyRendererAndEditor(table_orders, "Supprimer", this));
		table_orders.getColumn("-").setCellEditor(new MyRendererAndEditor(table_orders, "Supprimer", this));
		// Get table_orders visible in the scrollPane_orders
		scrollPane_orders.setViewportView(table_orders);
		scrollPane_orders.setColumnHeaderView(table_orders.getTableHeader());

		/**
		 * Table articles by order
		 */
        
        JScrollPane scrollPane_orders_articles = new JScrollPane();
        scrollPane_orders_articles.setBounds(0, 297, 888, 288);
        panel_orders.add(scrollPane_orders_articles);
        
        // Create table_suppliers
 		JTable table_orders_articles = new JTable();
 	    table_orders_articles.setModel(new DefaultTableModel(
 	    		new Object[][] {
 					{"Boite de 6 oeufs", "Ingr�dient", 2.52+"�", "800g","25/03/21", "2", " ","-"},
 					{"Paquet de farine", "Ingr�dient", 1.45+"�", "430g","25/03/21", "4", " ","-"},
 					{"Lot de 2 fourchette", "Ustensile", 4.24+"�", "100g",null, "1", " ","-"},
 				},
 				new String[] {
 					"Nom", "Type", "Prix", "Poids", "DLC", "Etat", "Quantit�", " ","-"}
 		) {
			private static final long serialVersionUID = -8814775745908591959L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		// Columns Properties
		table_orders_articles.getColumnModel().getColumn(0).setResizable(false);
		table_orders_articles.getColumnModel().getColumn(1).setResizable(false);
		table_orders_articles.getColumnModel().getColumn(2).setResizable(false);
		table_orders_articles.getColumnModel().getColumn(3).setResizable(false);
		table_orders_articles.getColumnModel().getColumn(4).setResizable(false);
		table_orders_articles.getColumnModel().getColumn(5).setResizable(false);
		table_orders_articles.getColumnModel().getColumn(6).setResizable(false);
		table_orders_articles.getColumnModel().getColumn(7).setResizable(false);
		table_orders_articles.getColumnModel().getColumn(8).setResizable(false);
		// Add btn upload
		table_orders_articles.getColumn(" ").setCellRenderer(new MyRendererAndEditor(table_orders, "Modifier", this));
		table_orders_articles.getColumn(" ").setCellEditor(new MyRendererAndEditor(table_orders, "Modifier", this));
		// Add btn delete
		table_orders_articles.getColumn("-").setCellRenderer(new MyRendererAndEditor(table_orders, "Supprimer", this));
		table_orders_articles.getColumn("-").setCellEditor(new MyRendererAndEditor(table_orders, "Supprimer", this));
		// Get table_orders_articles visible in the scrollPane_orders_articles
		scrollPane_orders_articles.setViewportView(table_orders_articles);
		scrollPane_orders_articles.setColumnHeaderView(table_orders_articles.getTableHeader());

		/**
		 * Panel add new order
		 */

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(898, 0, 328, 332);
		panel.setBackground(Color.WHITE);
		panel_orders.add(panel);
		panel.setLayout(null);

		// Labels
		JLabel lbl_Order_Date = new JLabel("Date de la commande : ");
		lbl_Order_Date.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Order_Date.setBounds(10, 54, 136, 14);
		panel.add(lbl_Order_Date);

		JLabel lbl_Orders = new JLabel("Ajouter un article \u00E0 la commande");
		lbl_Orders.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Orders.setBounds(59, 23, 216, 14);
		lbl_Orders.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_Orders);

		JLabel lbl_Day = new JLabel("Jour: ");
		lbl_Day.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Day.setBounds(0, 83, 46, 14);
		panel.add(lbl_Day);

		JLabel lbl_Month = new JLabel("Mois:");
		lbl_Month.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Month.setBounds(110, 83, 46, 14);
		panel.add(lbl_Month);

		JLabel lbl_Year = new JLabel("Ann\u00E9e:");
		lbl_Year.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Year.setBounds(215, 83, 46, 14);
		panel.add(lbl_Year);

		JLabel lbl_Select_Suppliers = new JLabel("S\u00E9lectionner un fournisseur :");
		lbl_Select_Suppliers.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Select_Suppliers.setBounds(10, 113, 169, 14);
		panel.add(lbl_Select_Suppliers);

		JLabel lbl_Select_Articles = new JLabel("S\u00E9lectionner un article : ");
		lbl_Select_Articles.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Select_Articles.setBounds(10, 171, 146, 14);
		panel.add(lbl_Select_Articles);

		JLabel lbl_Quantity = new JLabel("Quantit\u00E9:");
		lbl_Quantity.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Quantity.setBounds(159, 198, 77, 18);
		panel.add(lbl_Quantity);

		// TextField
		textField = new JTextField();
		textField.setBounds(232, 197, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		// ComboBox
		JComboBox comboBox_Day = new JComboBox();
		comboBox_Day.setBounds(42, 79, 52, 22);
		panel.add(comboBox_Day);

		JComboBox comboBox_Month = new JComboBox();
		comboBox_Month.setBounds(153, 79, 52, 22);
		panel.add(comboBox_Month);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(266, 79, 52, 22);
		panel.add(comboBox);

		JComboBox comboBox_Suppliers = new JComboBox();
		comboBox_Suppliers.setBounds(10, 138, 216, 22);
		panel.add(comboBox_Suppliers);

		JComboBox comboBox_Articles = new JComboBox();
		comboBox_Articles.setBounds(10, 196, 115, 22);
		panel.add(comboBox_Articles);

		JLabel lbl_Price = new JLabel("Prix (\u00E0 l'unit\u00E9) : ");
		lbl_Price.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Price.setBounds(10, 229, 101, 14);
		panel.add(lbl_Price);

		textField_Price = new JTextField();
		textField_Price.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Price.setBounds(10, 254, 101, 20);
		panel.add(textField_Price);
		textField_Price.setColumns(10);

		JButton btn_Add_Articles = new JButton("Ajouter l'article \u00E0 la commande");
		btn_Add_Articles.setBounds(59, 285, 226, 23);
		panel.add(btn_Add_Articles);

		/**
		 * Panel list articles order
		 */

		JPanel panel_list_articles_orders = new JPanel();
		panel_list_articles_orders.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_list_articles_orders.setBackground(Color.WHITE);
		panel_list_articles_orders.setBounds(898, 343, 328, 231);
		panel_orders.add(panel_list_articles_orders);
		panel_list_articles_orders.setLayout(null);

		JLabel lbl_List_Articles = new JLabel("Liste des articles de la commande");
		lbl_List_Articles.setBounds(70, 11, 204, 15);
		lbl_List_Articles.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_List_Articles.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_list_articles_orders.add(lbl_List_Articles);

		// Create scrollPane_list__orders
		JScrollPane scrollPane_list_orders = new JScrollPane();
		scrollPane_list_orders.setBounds(0, 34, 328, 129);
		panel_list_articles_orders.add(scrollPane_list_orders);

		// Create table_article_orders
		JTable table_article_orders = new JTable();
		table_article_orders.setModel(new DefaultTableModel(
			new Object[][] { 
				{ "Boite d'oeuf", 6, 6 } },

			new String[] { "Nom de l'article", "Quantit�", "Prix (� l'unitit�)" }) {

			private static final long serialVersionUID = 4046897769807276788L;
			boolean[] columnEditables = new boolean[] { false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		// Get table_article_orders visible in the scrollPane
		scrollPane_list_orders.setColumnHeaderView(table_article_orders);
		scrollPane_list_orders.setViewportView(table_article_orders);

		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.setBounds(30, 197, 89, 23);
		panel_list_articles_orders.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Ajouter la commande");
		btnNewButton_1.setBounds(129, 197, 178, 23);
		panel_list_articles_orders.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Total :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 174, 46, 14);
		panel_list_articles_orders.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("36\u20AC");
		lblNewLabel_1.setBounds(50, 174, 65, 14);
		panel_list_articles_orders.add(lblNewLabel_1);

	}

	@Override
	public void loadDataInPanelUpdate(JTable table, int row) {
		// TODO Auto-generated method stub
		
	}

}
