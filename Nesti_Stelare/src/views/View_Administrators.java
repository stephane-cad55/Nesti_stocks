package views;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import entity.AdminEntity;
import models.Administrators;
import models.SuperAdmin;
import tools.MyRendererAndEditor;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;

public class View_Administrators extends BaseView {
	
	JPanel panel_administrators = new JPanel();
	private JTextField textField_update_username = new JTextField();
	private JTextField textField_update_password = new JTextField();
	private JLabel lbl_name_delete = new JLabel();
	
	public View_Administrators() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		
		panel_administrators.setBackground(Color.WHITE);
		View_App.tabbedPane.addTab("Administrateurs", null, panel_administrators, null);
		panel_administrators.setLayout(null);
		panel_update.setVisible(false);
		panel_delete.setVisible(false);
		
		/**
		 * Panel_update
		 */
		
		/**
		 *  Panel update
		 */		
		panel_delete.setVisible(false);
		
		panel_delete.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel_delete.setBackground(Color.LIGHT_GRAY);
		panel_delete.setBounds(320, 200, 400, 159);
		panel_delete.setLayout(null);
		panel_administrators.add(panel_delete);
		
		JLabel lbl_title_delete_admin = new JLabel("Supprimer un administrateur");
		lbl_title_delete_admin.setBounds(115, 23, 182, 15);
		lbl_title_delete_admin.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_delete.add(lbl_title_delete_admin);
		
		JButton btn_delete_cancel = new JButton("Annuler");
		btn_delete_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_delete.setVisible(false);
			}
		});
		btn_delete_cancel.setBounds(100, 125, 89, 23);
		panel_delete.add(btn_delete_cancel);
		
		
		
		btn_confirm_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_delete.setVisible(false);
			}
		});
		btn_confirm_delete.setBounds(221, 125, 110, 23);
		panel_delete.add(btn_confirm_delete);
		
		JLabel lblNewLabel = new JLabel("Souhaitez vous vraiment supprimer l'administrateur  :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 61, 400, 14);
		panel_delete.add(lblNewLabel);
		
		JLabel lblToto = new JLabel("Toto ?");
		lblToto.setHorizontalAlignment(SwingConstants.CENTER);
		lblToto.setBounds(0, 86, 400, 14);
		panel_delete.add(lblToto);
		
		panel_update.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel_update.setBackground(Color.LIGHT_GRAY);
		panel_update.setBounds(362, 200, 313, 212);
		panel_update.setLayout(null);
		panel_administrators.add(panel_update);
		
		JLabel lbl_title_update_admin = new JLabel("Modifier un administrateur");
		lbl_title_update_admin.setBounds(68, 22, 182, 15);
		lbl_title_update_admin.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_update.add(lbl_title_update_admin);
		
		textField_update_username.setBounds(56, 73, 194, 20);
		panel_update.add(textField_update_username);
		textField_update_username.setColumns(10);
		
		
		textField_update_password.setColumns(10);
		textField_update_password.setBounds(56, 125, 194, 20);
		panel_update.add(textField_update_password);
		
		JLabel lbl_update_username = new JLabel("Nom d'utilisateur :");
		lbl_update_username.setBounds(56, 48, 114, 14);
		panel_update.add(lbl_update_username);
		
		JLabel lbl_update_password = new JLabel("Mot de passe :");
		lbl_update_password.setBounds(56, 104, 86, 14);
		panel_update.add(lbl_update_password);
		
		JButton btn_update_cancel = new JButton("Annuler");
		btn_update_cancel.setBounds(51, 170, 89, 23);
		panel_update.add(btn_update_cancel);
		
		btn_update_cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	panel_update.setVisible(false);
            }
            
        });
		
		JButton btn_update_update = new JButton("Modifier");
		btn_update_update.setBounds(171, 170, 89, 23);
		panel_update.add(btn_update_update);
		
		btn_update_update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	panel_update.setVisible(false);
            }
            
        });
		
		/**
		 * Panel_delete
		 */
		panel_delete.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel_delete.setBackground(Color.LIGHT_GRAY);
		panel_delete.setBounds(320, 200, 400, 159);
		panel_delete.setLayout(null);
		panel_administrators.add(panel_delete);
		
		JLabel lbl_delete_admin = new JLabel("Supprimer un administrateur");
		lbl_delete_admin.setBounds(115, 23, 182, 15);
		lbl_delete_admin.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_delete.add(lbl_delete_admin);
		
		btn_delete_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_delete.setVisible(false);
			}
		});
		
		JLabel lbl_confirm_delete = new JLabel("Souhaitez vous vraiment supprimer l'administrateur :");
		lbl_confirm_delete.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_confirm_delete.setBounds(0, 61, 400, 14);
		panel_delete.add(lbl_confirm_delete);
		
		lbl_name_delete.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_name_delete.setBounds(0, 86, 400, 14);
		panel_delete.add(lbl_name_delete);
		
		JButton btn_delete_confirm = new JButton("Confirmer");
		btn_delete_confirm.setBounds(221, 125, 110, 23);
		panel_delete.add(btn_delete_confirm);
		btn_delete_confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmDelete = true;
				panel_delete.setVisible(false);
			}
		});
		
		/**
		 * Create scrollPane_administrators
		 */

		JScrollPane scrollPane_administrators = new JScrollPane();
		scrollPane_administrators.setBounds(0, 0, 888, 585);
		// Add scrollPane_administrators to panel_administrators
		panel_administrators.add(scrollPane_administrators);
		
		/**
		 * Create table_admin
		 */
		
		JTable table_admin = new JTable();
		String[] nameColumn =  {"Pseudo","IsSuperAdmin","Mot de passe"," ", "-"};
		table_admin.setModel(new DefaultTableModel(Administrators.readAll(),nameColumn) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		// Columns Properties
		int columnCount = table_admin.getColumnModel().getColumnCount();
		for (int i = 0; i < columnCount; i++ ) {
			table_admin.getColumnModel().getColumn(i).setResizable(false);
		}
	    // Add btn upload
		table_admin.getColumn(" ").setCellRenderer(new MyRendererAndEditor(table_admin, "Modifier", this));
		table_admin.getColumn(" ").setCellEditor(new MyRendererAndEditor(table_admin, "Modifier", this));
	    // Add btn delete
		table_admin.getColumn("-").setCellRenderer(new MyRendererAndEditor(table_admin, "Supprimer", this));
		table_admin.getColumn("-").setCellEditor(new MyRendererAndEditor(table_admin, "Supprimer", this));
		// Get table_admin visible in the scrollPane
		scrollPane_administrators.setViewportView(table_admin);
        scrollPane_administrators.setColumnHeaderView(table_admin.getTableHeader());
        
        /**
         *  Panel create admin
         */
     
        JPanel panel_create_admin = new JPanel();
        panel_create_admin.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_create_admin.setBounds(898, 11, 328, 204);
        panel_create_admin.setBackground(Color.WHITE);
        panel_administrators.add(panel_create_admin);
        panel_create_admin.setLayout(null);
        
        JLabel lbl_user_name = new JLabel("Nom d'utilisateur");
        lbl_user_name.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_user_name.setBounds(20, 43, 102, 14);
        panel_create_admin.add(lbl_user_name);
        
        JLabel lbl_add_administrator = new JLabel("Ajouter un administrateur");
        lbl_add_administrator.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl_add_administrator.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_add_administrator.setBounds(70, 11, 198, 14);
        panel_create_admin.add(lbl_add_administrator);
        
        JTextField textField_user_name = new JTextField();
        textField_user_name.setHorizontalAlignment(SwingConstants.CENTER);
        textField_user_name.setBounds(20, 68, 287, 20);
        panel_create_admin.add(textField_user_name);
        textField_user_name.setColumns(10);
        
        JLabel lbl_passWord = new JLabel("Mot de passe");
        lbl_passWord.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_passWord.setBounds(10, 99, 102, 14);
        panel_create_admin.add(lbl_passWord);
        
        JTextField textField_passWord = new JTextField();
        textField_passWord.setHorizontalAlignment(SwingConstants.CENTER);
        textField_passWord.setBounds(20, 124, 287, 20);
        panel_create_admin.add(textField_passWord);
        textField_passWord.setColumns(10);
        
        JButton btn_create_administrator = new JButton("Créer un administrateur");
        btn_create_administrator.setBounds(70, 163, 198, 23);
        panel_create_admin.add(btn_create_administrator);
        
        btn_create_administrator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperAdmin.addAdmin(textField_user_name.getText(),textField_passWord.getText());
                uploadTable(table_admin);
            }  
        });
        
	}
	
	/**
	 * Upload Table after changement
	 * @param oldTable
	 */
	@SuppressWarnings("serial")
	public void uploadTable(JTable oldTable) {
		String[] nameColumn =  {"Pseudo","IsSuperAdmin","Mot de passe"," ", "-"};
		oldTable.setModel(new DefaultTableModel(Administrators.readAll(),nameColumn) {
				boolean[] columnEditables = new boolean[] {
						false, false, false, true, true
				};
				@Override
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		
		for (int i = 0  ; i < oldTable.getRowCount() ; i++ ) {
			AdminEntity admin = new AdminEntity();
			admin.setPseudo(oldTable.getModel().getValueAt(i, 0).toString());
			admin.setSuperAdmin(oldTable.getModel().getValueAt(i, 1).equals("1"));
			admin.setPassword(oldTable.getModel().getValueAt(i, 2).toString());
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

	/**
	 * Load data in panel update
	 */
	@Override
	public void loadDataInPanelUpdate(JTable table, int row) {
		AdminEntity admin = new AdminEntity();
		admin.setPseudo(table.getModel().getValueAt(row, 0).toString());
		admin.setSuperAdmin(table.getModel().getValueAt(row, 1).equals("1"));
//		admin.setPassword(table.getModel().getValueAt(row, 2).toString());
		this.textField_update_username.setText(admin.getPseudo());
//		this.textField_update_password.setText(admin.getPassword());
		
	}
	
}
