package tools;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import entity.AdminEntity;
import entity.ArticleEntity;
import entity.ProductsEntity;
import models.Administrators;
import models.Article;
import models.Products;
import models.SuperAdmin;
import models.Suppliers;
import views.BaseView;
import javax.swing.event.CellEditorListener;
import java.awt.event.*;
import java.util.EventObject;

public class MyRendererAndEditor implements TableCellRenderer, TableCellEditor {

	private JButton btn;
	private int row;

	public MyRendererAndEditor(JTable table, String nomBtn, BaseView baseview) {
		btn = new JButton(nomBtn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (nomBtn.equals("Supprimer")) {
					String elementAsupprimer = table.getModel().getValueAt(row, 0).toString();
					int confirmationValue = JOptionPane.showConfirmDialog(null,
							"Voulez vous vraiment supprimer " + elementAsupprimer, "suppression",
							JOptionPane.WARNING_MESSAGE);

					if (confirmationValue == 0) {

						if (baseview.getClass().getName() == "views.View_Administrators") {
							int idAdmin = Integer.parseInt(Administrators.arrayRow.get(row)[0]);
							if (SuperAdmin.deleteAdmin(elementAsupprimer)) {
								model.removeRow(row);
							} else {
								JOptionPane.showMessageDialog(null,
										"Suppression impossible, l'administrateur est lié à un autre élément");
							}
						} else if (baseview.getClass().getName() == "views.View_Products") {
							int idProducts = Integer.parseInt(Products.arrayIng.get(row)[2]);
							if (Products.deleteProducts(idProducts)) {
								model.removeRow(row);
							} else {
								JOptionPane.showMessageDialog(null,
										"Suppression impossible, le produit est lié à un autre élément");
							}
						} else if (baseview.getClass().getName() == "views.View_Articles") {
							int idArticles = Integer.parseInt(Article.arrayRow.get(row)[5]);
							if (Article.deleteArticle(idArticles)) {
								model.removeRow(row);
							} else {
								JOptionPane.showMessageDialog(null,
										"Suppression impossible, l'article est lié à un autre élément");
							}

						} else if (baseview.getClass().getName() == "views.View_Suppliers") {
							int idSuppliers = Integer.parseInt(Suppliers.arrayRow.get(row)[0]);

							if (Suppliers.deleteSuppliers(idSuppliers)) {
								model.removeRow(row);
							} else {
								JOptionPane.showMessageDialog(null,
										"Suppression impossible, le fournisseur est lié à un autre élément");
							}
						}

					}

				} else if (nomBtn.equals("Modifier")) {
					if (baseview.getClass().getName().equals("views.View_Administrators")) {
						int idAdmin = Integer.parseInt(Administrators.arrayRow.get(row)[0]);
						AdminEntity admin = new AdminEntity();
						admin.setPseudo(table.getModel().getValueAt(row, 0).toString());
						admin.setSuperAdmin(table.getModel().getValueAt(row, 1).equals("1"));
//						admin.setPassword(table.getModel().getValueAt(row, 2).toString());
						JTextField textField1 = new JTextField();
						textField1.setText(admin.getPseudo());
						JTextField textField2 = new JTextField();
						textField2.setText(admin.getPassword());
						Object[] inputFields = { "Nom d'utilisateur", textField1,

								"Mot de passe ", textField2 };
						int test = JOptionPane.showConfirmDialog(null, inputFields, "Modifier un administrateur",
								JOptionPane.WARNING_MESSAGE);
						if (test == 0) {
							SuperAdmin.updateAdmin(idAdmin, textField1.getText(), textField2.getText());
							model.setValueAt(textField1.getText(), row, 0);
						}
					} else if (baseview.getClass().getName().equals("views.View_Products")) {
						ProductsEntity product = new ProductsEntity();
						product.setName(table.getModel().getValueAt(row, 0).toString());
						JTextField textField1 = new JTextField();
						textField1.setText(product.getName());
						if (table.getColumnCount() == 5) {
							JTextField textField2 = new JTextField();
							textField2.setText(table.getModel().getValueAt(row, 1).toString());
							Object[] inputFields = { "Nom du produit", textField1, "Jour avant péremption",
									textField2 };
							int test = JOptionPane.showConfirmDialog(null, inputFields, "Modifier un ingrédient",
									JOptionPane.WARNING_MESSAGE);
							if (test == 0) {
								int idProducts = Integer.parseInt(Products.arrayIng.get(row)[1]);
								Products.updateProducts(textField1.getText(), "ing",
										Integer.parseInt(textField2.getText()), idProducts);
								model.setValueAt(textField1.getText(), row, 0);
								model.setValueAt(textField2.getText(), row, 1);
							}
						} else {
							int test2 = JOptionPane.showConfirmDialog(null, textField1, "Modifier un ustensile",
									JOptionPane.WARNING_MESSAGE);
							if (test2 == 0) {
								int idProducts = Integer.parseInt(Products.arrayUte.get(row)[1]);
								Products.updateProducts(textField1.getText(), "ute", 0, idProducts);
								model.setValueAt(textField1.getText(), row, 0);
							}
						}
					} else if (baseview.getClass().getName().equals("views.View_Articles")) {

						int idArticles = Integer.parseInt(Article.arrayRow.get(row)[5]);

						ArticleEntity article = new ArticleEntity();
						article.setName(table.getModel().getValueAt(row, 0).toString());

						article.setWeight(Double.parseDouble(Article.arrayRow.get(row)[1]));

						JTextField textField1 = new JTextField();
						textField1.setText(article.getName());
						JTextField textField2 = new JTextField();
						textField2.setText(String.valueOf(article.getWeight()));
						Object[] inputFields = { "Nom", textField1, "Poids", textField2 };

						int test = JOptionPane.showConfirmDialog(null, inputFields, "Modifier un article",
								JOptionPane.WARNING_MESSAGE);

						if (test == 0) {
							Article.update(textField1.getText(), Double.parseDouble(textField2.getText()), idArticles);
							model.setValueAt(textField1.getText(), row, 0);
							model.setValueAt(textField2.getText() + Article.arrayRow.get(row)[2], row, 3);
						}
					}
				}
			}
		});
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return btn;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.row = row;
		return btn;
	}

	@Override
	public Object getCellEditorValue() {
		return true;
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		return true;
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		return true;
	}

	@Override
	public void cancelCellEditing() {
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
	}
}