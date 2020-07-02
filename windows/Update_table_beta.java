package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commands_client.C_insert_key;
import utils.Comand;
import utils.Weapon;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ResourceBundle;

public class Update_table_beta extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textX;
	private JTextField textY;
	private JTextField textHealth;
	private JTextField textHeight;
	private JTextField textLegion;
	private JTextField textSquad;

	public Update_table_beta(ObjectOutputStream actionOut, ObjectInputStream inn, ResourceBundle bundleDef,long id,String name0,String x0,String y0,String health0,String height0,String weapon0,String meleeweapon0,String chapterLegion0,String chapterSquad0,Long k1) {
		setBounds(100, 100, 415, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 91, 179, 52, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		try {
			JLabel lblName = new JLabel(new String(Controller.bundleDef.getString("NAME01").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			contentPane.add(lblName, gbc_lblName);
			
			textName = new JTextField();
			textName.setText(name0);
			GridBagConstraints gbc_textName = new GridBagConstraints();
			gbc_textName.insets = new Insets(0, 0, 5, 5);
			gbc_textName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textName.gridx = 2;
			gbc_textName.gridy = 1;
			contentPane.add(textName, gbc_textName);
			textName.setColumns(10);
			
			JLabel lblX = new JLabel(new String(Controller.bundleDef.getString("X").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 2;
			contentPane.add(lblX, gbc_lblX);
			
			textX = new JTextField();
			textX.setText(x0);
			GridBagConstraints gbc_textX = new GridBagConstraints();
			gbc_textX.anchor = GridBagConstraints.NORTH;
			gbc_textX.insets = new Insets(0, 0, 5, 5);
			gbc_textX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textX.gridx = 2;
			gbc_textX.gridy = 2;
			contentPane.add(textX, gbc_textX);
			textX.setColumns(10);
			
			JLabel lblY = new JLabel(new String(Controller.bundleDef.getString("Y").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 3;
			contentPane.add(lblY, gbc_lblY);
			
			textY = new JTextField();
			textY.setText(y0);
			GridBagConstraints gbc_textY = new GridBagConstraints();
			gbc_textY.insets = new Insets(0, 0, 5, 5);
			gbc_textY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textY.gridx = 2;
			gbc_textY.gridy = 3;
			contentPane.add(textY, gbc_textY);
			textY.setColumns(10);
			
			JLabel lblHealth = new JLabel(new String(Controller.bundleDef.getString("HEALTH01").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblHealth = new GridBagConstraints();
			gbc_lblHealth.anchor = GridBagConstraints.EAST;
			gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
			gbc_lblHealth.gridx = 1;
			gbc_lblHealth.gridy = 4;
			contentPane.add(lblHealth, gbc_lblHealth);
			
			textHealth = new JTextField();
			textHealth.setText(health0);
			GridBagConstraints gbc_textHealth = new GridBagConstraints();
			gbc_textHealth.insets = new Insets(0, 0, 5, 5);
			gbc_textHealth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textHealth.gridx = 2;
			gbc_textHealth.gridy = 4;
			contentPane.add(textHealth, gbc_textHealth);
			textHealth.setColumns(10);
			
			JLabel lblHeight = new JLabel(new String(Controller.bundleDef.getString("HEIGHT01").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 5;
			contentPane.add(lblHeight, gbc_lblHeight);
			
			textHeight = new JTextField();
			textHeight.setText(height0);
			GridBagConstraints gbc_textHeight = new GridBagConstraints();
			gbc_textHeight.insets = new Insets(0, 0, 5, 5);
			gbc_textHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textHeight.gridx = 2;
			gbc_textHeight.gridy = 5;
			contentPane.add(textHeight, gbc_textHeight);
			textHeight.setColumns(10);
			
			JLabel lblWeapon = new JLabel(new String(Controller.bundleDef.getString("WEAPON01").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblWeapon = new GridBagConstraints();
			gbc_lblWeapon.anchor = GridBagConstraints.EAST;
			gbc_lblWeapon.insets = new Insets(0, 0, 5, 5);
			gbc_lblWeapon.gridx = 1;
			gbc_lblWeapon.gridy = 6;
			contentPane.add(lblWeapon, gbc_lblWeapon);
			
			JComboBox comboBoxWeapon = new JComboBox();
			GridBagConstraints gbc_comboBoxWeapon = new GridBagConstraints();
			gbc_comboBoxWeapon.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxWeapon.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxWeapon.gridx = 2;
			gbc_comboBoxWeapon.gridy = 6;
			contentPane.add(comboBoxWeapon, gbc_comboBoxWeapon);
			
			comboBoxWeapon.addItem("PLASMA_GUN");
			comboBoxWeapon.addItem("FLAMER");
			comboBoxWeapon.addItem("GRAV_GUN");
			comboBoxWeapon.addItem("GRENADE_LAUNCHER");
			comboBoxWeapon.addItem("MULTI_MELTA");
			
			JLabel lblMeleeWeapon = new JLabel(new String(Controller.bundleDef.getString("MELEE01").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblMeleeWeapon = new GridBagConstraints();
			gbc_lblMeleeWeapon.anchor = GridBagConstraints.EAST;
			gbc_lblMeleeWeapon.insets = new Insets(0, 0, 5, 5);
			gbc_lblMeleeWeapon.gridx = 1;
			gbc_lblMeleeWeapon.gridy = 7;
			contentPane.add(lblMeleeWeapon, gbc_lblMeleeWeapon);
			
			JComboBox comboBoxMeleeWeapon = new JComboBox();
			GridBagConstraints gbc_comboBoxMeleeWeapon = new GridBagConstraints();
			gbc_comboBoxMeleeWeapon.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxMeleeWeapon.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxMeleeWeapon.gridx = 2;
			gbc_comboBoxMeleeWeapon.gridy = 7;
			contentPane.add(comboBoxMeleeWeapon, gbc_comboBoxMeleeWeapon);
			
			comboBoxMeleeWeapon.addItem("CHAIN_SWORD");
			comboBoxMeleeWeapon.addItem("MANREAPER");
			comboBoxMeleeWeapon.addItem("POWER_BLADE");
			
			JLabel lblLegion = new JLabel(new String(Controller.bundleDef.getString("LEGION01").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblLegion = new GridBagConstraints();
			gbc_lblLegion.anchor = GridBagConstraints.EAST;
			gbc_lblLegion.insets = new Insets(0, 0, 5, 5);
			gbc_lblLegion.gridx = 1;
			gbc_lblLegion.gridy = 8;
			contentPane.add(lblLegion, gbc_lblLegion);
			
			textLegion = new JTextField();
			textLegion.setText(chapterLegion0);
			GridBagConstraints gbc_textLegion = new GridBagConstraints();
			gbc_textLegion.insets = new Insets(0, 0, 5, 5);
			gbc_textLegion.fill = GridBagConstraints.HORIZONTAL;
			gbc_textLegion.gridx = 2;
			gbc_textLegion.gridy = 8;
			contentPane.add(textLegion, gbc_textLegion);
			textLegion.setColumns(10);
			
			JLabel lblSquad = new JLabel(new String(Controller.bundleDef.getString("SQUAD01").getBytes("ISO-8859-1"),"Cp1251"));
			GridBagConstraints gbc_lblSquad = new GridBagConstraints();
			gbc_lblSquad.anchor = GridBagConstraints.EAST;
			gbc_lblSquad.insets = new Insets(0, 0, 5, 5);
			gbc_lblSquad.gridx = 1;
			gbc_lblSquad.gridy = 9;
			contentPane.add(lblSquad, gbc_lblSquad);
			
			textSquad = new JTextField();
			textSquad.setText(chapterSquad0);
			GridBagConstraints gbc_textSquad = new GridBagConstraints();
			gbc_textSquad.insets = new Insets(0, 0, 5, 5);
			gbc_textSquad.fill = GridBagConstraints.HORIZONTAL;
			gbc_textSquad.gridx = 2;
			gbc_textSquad.gridy = 9;
			contentPane.add(textSquad, gbc_textSquad);
			textSquad.setColumns(10);
		
		
			JButton btnConfirm = new JButton("OK");
			btnConfirm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Object spacemarine=null;
					Boolean isSpaceMarineReady=false;
					String name = textName.getText();				
					
					try {
						Integer x = Integer.parseInt(textX.getText());
						try {
							Integer y = Integer.parseInt(textY.getText());
							try {
								Integer health = Integer.parseInt(textHealth.getText());
									try {
									Integer height = Integer.parseInt(textHeight.getText());
									String weapon = comboBoxWeapon.getSelectedItem().toString();
									String meleeWeapon = comboBoxMeleeWeapon.getSelectedItem().toString();
									String legion = textLegion.getText();
									String squad = textSquad.getText();
									System.out.println(name+x+y+health+height+weapon+meleeWeapon+legion+squad);
									spacemarine = client.Adding.ScanGUI(name, x, y, health, height, weapon, meleeWeapon, legion, squad);
									isSpaceMarineReady=true;
									}catch(Exception eHeight) {JOptionPane.showMessageDialog(contentPane,
										    "Height should be integer",
										    "Icorrect input",
										    JOptionPane.ERROR_MESSAGE);}
							}catch(Exception eHealth) {JOptionPane.showMessageDialog(contentPane,
								    "Health should be integer",
								    "Icorrect input",
								    JOptionPane.ERROR_MESSAGE);}
						}catch(Exception eY) {JOptionPane.showMessageDialog(contentPane,
							    "Y should be integer",
							    "Icorrect input",
							    JOptionPane.ERROR_MESSAGE);}
					}catch(Exception eX) {JOptionPane.showMessageDialog(contentPane,
						    "X should be integer",
						    "Icorrect input",
						    JOptionPane.ERROR_MESSAGE);}
					if (isSpaceMarineReady==true) {
						try {
							Comand comand = Comand.update_id;
                            actionOut.writeObject(comand);
                            actionOut.writeObject(id);
                            actionOut.flush();
                            actionOut.writeObject(spacemarine);
                            actionOut.flush();
                            Object insert = null;
                            insert = inn.readObject();
//			                actionOut.writeObject(Comand.insert_key);
//			                actionOut.flush();
//			                //Thread.sleep(500);
//			                actionOut.writeObject(spacemarine);
			                JOptionPane.showMessageDialog(contentPane,
			                	    "Element inserted successfully");
						}catch(Exception eInsertKey) {eInsertKey.printStackTrace();}
		                System.out.println("Element insert finished");
		                //contentPane.setVisible(false);
					}				
				}
			});
			GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
			gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
			gbc_btnConfirm.gridx = 2;
			gbc_btnConfirm.gridy = 10;
			contentPane.add(btnConfirm, gbc_btnConfirm);
		}catch(Exception exc) {exc.printStackTrace();}
		
		
		
		//comboBoxWeapon.getSelectedItem();

	}

}
