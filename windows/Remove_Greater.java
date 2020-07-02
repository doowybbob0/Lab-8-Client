package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client.CommandsManager;
import utils.Comand;


public class Remove_Greater extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	public void Close() {
		super.setVisible(false);
	}
	
	public Remove_Greater() {
		
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
		                        	
		                        	try {
		                              
		                              Controller.actionOut.writeObject(Comand.remove_greater_key);
		                              Controller.actionOut.flush();
		                              Controller.actionOut.writeObject(key);
		                              Controller.actionOut.flush();
		                              Object reml = Controller.actionIn.readObject();
		                              System.out.println(reml);
		                              try {
				    	                	JOptionPane.showMessageDialog(contentPanel,reml);
				                    	}catch(Exception infoException) {JOptionPane.showMessageDialog(contentPanel,
				                    		    "An error has occured",
				                    		    "Error",
				                    		    JOptionPane.ERROR_MESSAGE);}
		                          } catch (RuntimeException ex) {
		                          	System.out.println("Invalid input");
		                              System.out.println("Command execution terminated");
		                          }
			                        		                        
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
	//			bufferedCommand = Comand.remove_greater_key;
	//            Scanner com4 = new Scanner(System.in);
	//            try {
	//                long kk = Long.parseLong(finalUserCommand[1]);
	//                shipToServer.writeObject(new CommandsManager(bufferedCommand, kk).getComand());
	//                shipToServer.flush();
	//                shipToServer.writeObject(new CommandsManager(bufferedCommand, kk).getL());
	//                shipToServer.flush();
	//                Object reml = receiveFromServer.readObject();
	//                System.out.println(reml);
	//            } catch (RuntimeException e) {
	//            	System.out.println("Invalid input");
	//                System.out.println("Command execution terminated");
	//            }
	//            break;
			}
		}catch(Exception exc) {exc.printStackTrace();}
	}
}
