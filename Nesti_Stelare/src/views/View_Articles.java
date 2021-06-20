package views;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import entity.ArticleEntity;
import models.Article;
import models.Products;
import tools.MyRendererAndEditor;

public class View_Articles extends BaseView {
	
	private JTextField textField_update_name = new JTextField();
	private JTextField textField_update_password = new JTextField();
	private JLabel lbl_name_delete = new JLabel();

	public View_Articles() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/**
		 * Panels_articles
		 */

		// Create panels_articles (TabbedPane)
		JPanel panel_articles = new JPanel();
		panel_articles.setBackground(Color.WHITE);
		View_App.tabbedPane.addTab("Articles", null, panel_articles, null);
		panel_update.setVisible(false);
		panel_articles.setLayout(null);

		/**
		 * Table article
		 */

		// Create scrollPane_articles
		JScrollPane scrollPane_articles = new JScrollPane();
		scrollPane_articles.setBounds(0, 0, 888, 585);
		// Add scrollPane_articles to panel_articles
		panel_articles.add(scrollPane_articles);

		// Create table_article
		JTable table_article = new JTable();
		table_article.setModel(new DefaultTableModel(Article.readAll(),
				new String[] { "Nom", "Type", "Prix", "Poids", "Etat", "Stock", " ", "-" }) {
			private static final long serialVersionUID = 546831570763595984L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, true, true, };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		// Columns Properties
		int columnCount = table_article.getColumnModel().getColumnCount();
		for (int i = 0; i < columnCount; i++) {
			table_article.getColumnModel().getColumn(i).setResizable(false);
		}
		// Add btn upload
		table_article.getColumn(" ").setCellRenderer(new MyRendererAndEditor(table_article, "Modifier", this));
		table_article.getColumn(" ").setCellEditor(new MyRendererAndEditor(table_article, "Modifier", this));
		// Add btn delete
		table_article.getColumn("-").setCellRenderer(new MyRendererAndEditor(table_article, "Supprimer", this));
		table_article.getColumn("-").setCellEditor(new MyRendererAndEditor(table_article, "Supprimer", this));
		
		scrollPane_articles.setViewportView(table_article);
		scrollPane_articles.setColumnHeaderView(table_article.getTableHeader());

		/**
		 * Panel create new article
		 */

		// Create panel_create_article
		JPanel panel_create_article = new JPanel();
		panel_create_article.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_create_article.setBounds(898, 11, 328, 238);
		panel_create_article.setBackground(Color.WHITE);
		panel_articles.add(panel_create_article);
		panel_create_article.setLayout(null);

		// Labels
		JLabel lbl_article_title = new JLabel("Créer un nouvel article");
		lbl_article_title.setForeground(Color.BLACK);
		lbl_article_title.setBackground(Color.LIGHT_GRAY);
		lbl_article_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_article_title.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_article_title.setBounds(0, 0, 328, 35);
		panel_create_article.add(lbl_article_title);

		JLabel lbl_article_name = new JLabel("Nom de l'article :");
		lbl_article_name.setBounds(23, 44, 277, 14);
		panel_create_article.add(lbl_article_name);

		JLabel lbl_article_poids = new JLabel("Poids :");
		lbl_article_poids.setBounds(23, 140, 46, 14);
		panel_create_article.add(lbl_article_poids);

		JLabel lbl_article_select_product = new JLabel("Sélection du produit :");
		lbl_article_select_product.setBounds(23, 90, 277, 20);
		panel_create_article.add(lbl_article_select_product);

		// TextField
		JTextField textField_article_name = new JTextField();
		textField_article_name.setBounds(23, 59, 277, 20);
		panel_create_article.add(textField_article_name);
		textField_article_name.setColumns(10);

		JTextField textField_article_poids = new JTextField();
		textField_article_poids.setBounds(23, 156, 143, 20);
		panel_create_article.add(textField_article_poids);
		textField_article_poids.setColumns(10);

		// ComboBox
		String[] nameProducts = new String[Products.readNamesProducts().size()];
		for (int i = 0; i < nameProducts.length; i++) {
			nameProducts[i] = Products.readNamesProducts().get(i);
		}
		JComboBox comboBox_article_product = new JComboBox(nameProducts);
		comboBox_article_product.setBounds(23, 109, 277, 20);
		panel_create_article.add(comboBox_article_product);

		String[] nameUnity = new String[Products.readNamesUnity().size()];
		for (int i = 0; i < nameUnity.length; i++) {
			nameUnity[i] = Products.readNamesUnity().get(i);
		}
		JComboBox comboBox_article_poids = new JComboBox(nameUnity);
		comboBox_article_poids.setBounds(176, 156, 124, 20);
		panel_create_article.add(comboBox_article_poids);

		// Btn create article
		JButton btn_article_create = new JButton("Créer l'article");
		btn_article_create.setBounds(101, 198, 136, 23);
		panel_create_article.add(btn_article_create);
		btn_article_create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Article.createArticle(textField_article_name.getText(),
						Double.parseDouble(textField_article_poids.getText()),
						comboBox_article_product.getSelectedItem().toString(), 6,
						comboBox_article_poids.getSelectedItem().toString());
						uploadTable(table_article);
			}
		});

		/**
		 * Panel table suppliers by article
		 */

		// Create panel_list_suppliers
		JPanel panel_list_suppliers = new JPanel();
		panel_list_suppliers.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_list_suppliers.setBackground(Color.WHITE);
		panel_list_suppliers.setBounds(898, 295, 328, 279);
		panel_articles.add(panel_list_suppliers);
		panel_list_suppliers.setLayout(null);

		// Label Title table
		JLabel lbl_title_list_suppliers = new JLabel("Liste des fournisseurs de l'article sélectionné");
		lbl_title_list_suppliers.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_title_list_suppliers.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title_list_suppliers.setBounds(0, 0, 328, 34);
		panel_list_suppliers.add(lbl_title_list_suppliers);

		// Create scrollPane_list_suppliers
		JScrollPane scrollPane_list_suppliers = new JScrollPane();
		scrollPane_list_suppliers.setBounds(0, 34, 328, 245);
		panel_list_suppliers.add(scrollPane_list_suppliers);

		// Create table_article_suppliers
		JTable table_article_suppliers = new JTable();
		table_article_suppliers.setModel(new DefaultTableModel(new Object[][] { { "Labo&Gato", 2.85 + "€" },
				{ "Kitchenware", 2.82 + "€" }, { "Sugarcraft", 2.54 + "€" }, { "Wenny's Store", 2.45 + "€" },
				{ "Hypmark Kitchen", 2.95 + "€" } }, new String[] { "Fournisseur", "Prix" }) {
			private static final long serialVersionUID = -8222166176512458254L;
			boolean[] columnEditables = new boolean[] { false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		// Get table_article_suppliers visible in the scrollPane
		scrollPane_list_suppliers.setColumnHeaderView(table_article_suppliers);
		scrollPane_list_suppliers.setViewportView(table_article_suppliers);

	}

	@SuppressWarnings("serial")
	public void uploadTable(JTable oldTable) {
		String[] nameColumn = { "Nom", "Type", "Prix", "Poids", "Etat", "Stock", " ", "-" };
		oldTable.setModel(new DefaultTableModel(Article.readAll(), nameColumn) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, true, true, };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		for (int i = 0; i < oldTable.getRowCount(); i++) {
			ArticleEntity article = new ArticleEntity();
			article.setName(oldTable.getModel().getValueAt(i, 0).toString());

			// oldTable.getColumn("").getCellEditor().s
		}

		MyRendererAndEditor btn_update = new MyRendererAndEditor(oldTable, "Modifier", this);

		MyRendererAndEditor btn_delete = new MyRendererAndEditor(oldTable, "Supprimer", this);
		// Add btn upload
		oldTable.getColumn(" ").setCellRenderer(btn_update);
		oldTable.getColumn(" ").setCellEditor(btn_update);
		// Add btn delete
		oldTable.getColumn("-").setCellRenderer(btn_delete);
		oldTable.getColumn("-").setCellEditor(btn_delete);
	}

	@Override
	public void loadDataInPanelUpdate(JTable table, int row) {
		// TODO Auto-generated method stub

	}
	
}
