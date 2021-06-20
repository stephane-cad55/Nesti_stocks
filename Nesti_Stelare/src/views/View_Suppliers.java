package views;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Suppliers;
import tools.MyRendererAndEditor;

public class View_Suppliers extends BaseView{
	
	public View_Suppliers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/**
		 * Panel_suppliers
		 */

		// Create panel_suppliers (TabbedPane)
		JPanel panel_suppliers = new JPanel();
		panel_suppliers.setBackground(Color.WHITE);
		View_App.tabbedPane.addTab("Fournisseurs", null, panel_suppliers, null);
		panel_suppliers.setLayout(null);

		/**
		 * Table suppliers
		 */

		// Create scrollPane_suppliers
		JScrollPane scrollPane_suppliers = new JScrollPane();
		scrollPane_suppliers.setBounds(0, 0, 888, 285);
		// Add scrollPane_suppliers to panel_suppliers
		panel_suppliers.add(scrollPane_suppliers);

		// Create table_suppliers
		JTable table_suppliers = new JTable();
		table_suppliers.setModel(new DefaultTableModel(Suppliers.readAll(),

				new String[] { "Entreprise", "Adresse", "Ville", "CP", "Nom contact", "Prenom contact", "Tel", " ",
						"-" }) {
			private static final long serialVersionUID = -6423566302786445456L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, true, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		// Columns Properties
		int columnCount = table_suppliers.getColumnModel().getColumnCount();
		for (int i = 0; i < columnCount; i++ ) {
			table_suppliers.getColumnModel().getColumn(i).setResizable(false);
		}
		// Add btn upload
		table_suppliers.getColumn(" ").setCellRenderer(new MyRendererAndEditor(table_suppliers, "Modifier", this));
		table_suppliers.getColumn(" ").setCellEditor(new MyRendererAndEditor(table_suppliers, "Modifier", this));
		// Add btn delete
		table_suppliers.getColumn("-").setCellRenderer(new MyRendererAndEditor(table_suppliers, "Supprimer", this));
		table_suppliers.getColumn("-").setCellEditor(new MyRendererAndEditor(table_suppliers, "Supprimer", this));
		// Get table_suppliers visible in scrollPane_suppliers
		scrollPane_suppliers.setViewportView(table_suppliers);
		scrollPane_suppliers.setColumnHeaderView(table_suppliers.getTableHeader());

		/**
		 * Table articles by suppliers
		 */

		// Create scrollPane_suppliers_articles
		JScrollPane scrollPane_suppliers_articles = new JScrollPane();
		scrollPane_suppliers_articles.setBounds(0, 296, 888, 289);
		panel_suppliers.add(scrollPane_suppliers_articles);

		// Create table_suppliers_articles
		JTable table_suppliers_articles = new JTable();
		table_suppliers_articles.setModel(new DefaultTableModel(
				new Object[][] { { "Boite de 6 oeufs", "Ingr\u00E9dient", 2.52 + "�", "800g", "En stock", " ", "-" },
						{ "Paquet de farine", "Ingr\u00E9dient", 1.45 + "�", "430g", "En stock", " ", "-" },
						{ "Lot de 2 fourchette", "Ustensile", 4.24 + "�", "100g", "En stock", " ", "-" }, },
				new String[] { "Nom de l'article", "Type", "Prix", "Poids", "Stock", " ", "-" }) {
			private static final long serialVersionUID = 6230086957304435761L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		// Columns Properties
		table_suppliers_articles.getColumnModel().getColumn(0).setResizable(false);
		table_suppliers_articles.getColumnModel().getColumn(1).setResizable(false);
		table_suppliers_articles.getColumnModel().getColumn(2).setResizable(false);
		table_suppliers_articles.getColumnModel().getColumn(3).setResizable(false);
		table_suppliers_articles.getColumnModel().getColumn(4).setResizable(false);
		table_suppliers_articles.getColumnModel().getColumn(5).setResizable(false);
		table_suppliers_articles.getColumnModel().getColumn(6).setResizable(false);
		// Add btn upload
		table_suppliers_articles.getColumn(" ").setCellRenderer(new MyRendererAndEditor(table_suppliers_articles, "Modifier", this));
		table_suppliers_articles.getColumn(" ").setCellEditor(new MyRendererAndEditor(table_suppliers_articles, "Modifier", this));
		// Add btn delete
		table_suppliers_articles.getColumn("-").setCellRenderer(new MyRendererAndEditor(table_suppliers_articles, "Supprimer", this));
		table_suppliers_articles.getColumn("-").setCellEditor(new MyRendererAndEditor(table_suppliers_articles, "Supprimer", this));
		// Get table_suppliers_articles visible in scrollPane_suppliers_articles
		scrollPane_suppliers_articles.setViewportView(table_suppliers_articles);
		scrollPane_suppliers_articles.setColumnHeaderView(table_suppliers_articles.getTableHeader());

		/**
		 * Add new order
		 */

		JPanel panel_add_order = new JPanel();
		panel_add_order.setBounds(898, 11, 328, 273);
		panel_add_order.setBackground(Color.RED);
		panel_suppliers.add(panel_add_order);
		panel_add_order.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		/**
		 * Add article to an order
		 */

		JPanel panel_add_article = new JPanel();
		panel_add_article.setBackground(Color.RED);
		panel_add_article.setBounds(898, 295, 328, 279);
		panel_suppliers.add(panel_add_article);
		panel_add_article.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
	}

	@Override
	public void loadDataInPanelUpdate(JTable table, int row) {
		// TODO Auto-generated method stub
		
	}

}
