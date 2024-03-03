package view;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ClientController;
import dto.ClientDTO;
import exception.ClientNotFoundException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Form_Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JPanel panel;
	private JPanel panel_1;

	public void effacerText() {
	textField_3.setText("");
	textField.setText("");
	textField_1.setText("");
	textField_2.setText("");
	}
	public void activerText() {
		
		textField.setEnabled(true);
		textField_1.setEnabled(true);
		textField_2.setEnabled(true);
		
		
	}
	public boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	public boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
public void desactiverText() {
		
		textField.setEnabled(false);
		textField_1.setEnabled(false);
		textField_2.setEnabled(false);
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Client frame = new Form_Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form_Client() {
		setResizable(false);
		setTitle("Gestion des clients");
		setBounds(100, 100, 610, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(47, 10, 510, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setBounds(20, 30, 25, 13);
		panel.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(55, 27, 96, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton_3 = new JButton("Chercher");
		btnNewButton_3.setBounds(181, 26, 116, 21);
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Nouveau");
		btnNewButton_4.setBounds(335, 26, 85, 21);
		panel.add(btnNewButton_4);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(46, 103, 510, 151);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 10, 45, 13);
		panel_1.add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(86, 7, 328, 19);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Capital");
		lblNewLabel.setBounds(10, 35, 45, 13);
		panel_1.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 32, 328, 19);
		panel_1.add(textField_1);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Adresse");
		lblNewLabel_1.setBounds(10, 68, 73, 13);
		panel_1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 65, 328, 19);
		panel_1.add(textField_2);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(10, 120, 85, 21);
		panel_1.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		 btnNewButton_1 = new JButton("Modifier");
		 btnNewButton_1.setBounds(154, 120, 105, 21);
		 panel_1.add(btnNewButton_1);
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(isDouble(textField_1.getText())) {
		 		new ClientController().modifierClient(
		 				new ClientDTO(textField.getText(),Double.valueOf(textField_1.getText()),textField_2.getText())
		 				, Integer.valueOf(textField_3.getText()));
		 		JOptionPane.showMessageDialog(null, "Client modifié...","Succés",1);
		 		effacerText();
		 		btnNewButton_1.setEnabled(false);
		 		btnNewButton_2.setEnabled(false);
		 		desactiverText();
		 		}
				else {
					JOptionPane.showMessageDialog(null, "Saisie invalide! capital doit être un nombre réel","Echec",0);
				}

		 	}
		 });
		 btnNewButton_1.setEnabled(false);
		 btnNewButton_2 = new JButton("Supprimer");
		 btnNewButton_2.setBounds(336, 120, 94, 21);
		 panel_1.add(btnNewButton_2);
		 
		 
		 btnNewButton_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		int i=JOptionPane.showConfirmDialog(null, "Etes vous sûr de supprmer ce client?","Attention",JOptionPane.YES_NO_OPTION);
		 		if(i==JOptionPane.YES_OPTION) {
		 			boolean res=new ClientController().supprimerClient(Integer.valueOf(textField_3.getText()));
		 			if(res) {
		 			effacerText();
		 			btnNewButton_1.setEnabled(false);
		 			btnNewButton_2.setEnabled(false);
		 			desactiverText();
		 			}
		 			else
		 				JOptionPane.showMessageDialog(null, "Impossible de supprimer un client qui a déjà passé des commandes","Echec",0);
		 		}
		 		
		 	}
		 });
		 btnNewButton_2.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isDouble(textField_1.getText())) {
				new ClientController().ajouterClient(new ClientDTO(textField.getText(),Double.valueOf(textField_1.getText()),textField_2.getText()));
				JOptionPane.showMessageDialog(null, "Client ajouté...","Succés",1);
				effacerText();
				textField_3.setEnabled(true);
				btnNewButton_3.setEnabled(true);
				desactiverText();
				btnNewButton.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Saisie invalide! capital doit être un nombre réel","Echec",0);
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activerText();
				btnNewButton.setEnabled(true);
				textField_3.setText("");
				textField_3.setEnabled(false);
				btnNewButton_3.setEnabled(false);
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(isInteger(textField_3.getText()))
				{activerText();
				btnNewButton.setEnabled(false);
				try{ClientDTO dto=new ClientController().getClientDTO(Integer.valueOf(textField_3.getText()));
				 textField.setText(dto.getNom()); textField_1.setText(String.valueOf(dto.getCapital())); textField_2.setText(dto.getAdresse());btnNewButton_1.setEnabled(true);btnNewButton_2.setEnabled(true);}
				catch(ClientNotFoundException ex) {
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					desactiverText();
					btnNewButton_1.setEnabled(false);
					btnNewButton_2.setEnabled(false);
					JOptionPane.showMessageDialog(null, ex.getMessage().toString(),"Echec",0);
					
				}
				}
				else
					JOptionPane.showMessageDialog(null, "Insérer un ID de client valide!","Echec",0);
			}
			
		});
		
	}
}
