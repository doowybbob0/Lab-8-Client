package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Auth;
import utils.Comand;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Insets;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Remove_Key extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Action action = new SwingAction();
	private JTextField textField;
	
//	public void initialize() {
//		chngpass = new Change_Password();
//    	chngpass.setVisible(true);
//	}
	public void Close() {
		super.setVisible(false);
	}
	
	public Remove_Key() {
		try {
			setBounds(100, 100, 400, 150);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 11, 0};
			gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lblNewLabel = new JLabel(new String(Controller.bundleDef.getString("KEYOFELEMENT").getBytes("ISO-8859-1"),"Cp1251"));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 1;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				textField = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 2;
				gbc_textField.gridy = 1;
				contentPanel.add(textField, gbc_textField);
				textField.setColumns(10);
			}
			{
				JPanel buttonPane = new JPanel();
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					JButton okButton = new JButton("OK");
					okButton.addMouseListener(new MouseAdapter() {
						@SuppressWarnings("deprecation")
						@Override
						public void mouseClicked(MouseEvent e) {
							try {		
								Long key=Long.parseLong(textField.getText());
		                        try {
		                        	
		                        	Controller.actionOut.writeObject(Comand.remove_key);
			                        Controller.actionOut.flush();
			                        Controller.actionOut.writeObject(key);
			                        Controller.actionOut.flush();
			                        Thread.sleep(500);
			                        Object rem = Controller.actionIn.readObject();
			                        try {
			    	                    System.out.println(rem);
			    	                	JOptionPane.showMessageDialog(contentPanel,rem);
			                    	}catch(Exception infoException) {JOptionPane.showMessageDialog(contentPanel,
			                    		    "An error has occured",
			                    		    "Error",
			                    		    JOptionPane.ERROR_MESSAGE);}		                        
									Close();
								}catch(Exception eC) {eC.printStackTrace();}
		                        	
		                     }catch(Exception eKey) {
		                        	JOptionPane.showMessageDialog(contentPanel,"Key should be a number","Icorrect input",JOptionPane.ERROR_MESSAGE);
		                      }
		                        
							
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
