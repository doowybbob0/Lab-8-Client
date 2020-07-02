package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client.CommandsManager;
import utils.Comand;
import javax.swing.JComboBox;

public class Replace_If_Lower extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBoxType;

	public void Close() {
		super.setVisible(false);
	}
	
	public Replace_If_Lower() {
		try {
			setBounds(100, 100, 400, 179);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 11, 0};
			gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lblNewLabel_1 = new JLabel(new String(Controller.bundleDef.getString("SORTINGOPTION").getBytes("ISO-8859-1"),"Cp1251"));
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 1;
				contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				comboBoxType = new JComboBox();
				GridBagConstraints gbc_comboBoxType = new GridBagConstraints();
				gbc_comboBoxType.insets = new Insets(0, 0, 5, 5);
				gbc_comboBoxType.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxType.gridx = 2;
				gbc_comboBoxType.gridy = 1;
				contentPanel.add(comboBoxType, gbc_comboBoxType);
				
				comboBoxType.addItem("Name");
				//comboBoxType.addItem("Coordinates");
				comboBoxType.addItem("Health");
			}
			{
				JLabel lblKeyOfElement = new JLabel(new String(Controller.bundleDef.getString("KEYOFELEMENT").getBytes("ISO-8859-1"),"Cp1251"));
				lblKeyOfElement.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblKeyOfElement = new GridBagConstraints();
				gbc_lblKeyOfElement.anchor = GridBagConstraints.EAST;
				gbc_lblKeyOfElement.insets = new Insets(0, 0, 5, 5);
				gbc_lblKeyOfElement.gridx = 1;
				gbc_lblKeyOfElement.gridy = 2;
				contentPanel.add(lblKeyOfElement, gbc_lblKeyOfElement);
			}
			{
				textField_1 = new JTextField();
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 2;
				gbc_textField_1.gridy = 2;
				contentPanel.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
			}
			
				
			
			{
				JLabel lblNewLabel = new JLabel(new String(Controller.bundleDef.getString("NEWVALUE").getBytes("ISO-8859-1"),"Cp1251"));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 3;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				textField = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 2;
				gbc_textField.gridy = 3;
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
						@Override
						public void mouseClicked(MouseEvent e) {
							try {
	//				            Controller.actionOut.writeObject(new CommandsManager(Comand.replace_if_lower).getComand());
					            long ke = Long.parseLong(textField_1.getText());
					            try {
						            //Controller.actionOut.writeObject(new CommandsManager(Comand.replace_if_lower, ke).getL());
						            //Controller.actionOut.flush();
						            System.out.println("What would you like to change?:1-Name;2-HP");
						            int anInt = comboBoxType.getSelectedIndex();
						            System.out.println("=="+anInt);
						            
						            
						            //Controller.actionOut.writeObject(new CommandsManager(Comand.replace_if_lower, anInt).getI());
						            if (anInt == 0) {
						            	try {
							                System.out.println("Enter new name");
							                String name2 = textField.getText();
							                
							                Controller.actionOut.writeObject(Comand.replace_if_lower);
							                Thread.sleep(200);
							                Controller.actionOut.writeObject(ke);
								            Controller.actionOut.flush();
								            Thread.sleep(200);
								            Controller.actionOut.writeObject(anInt+1);
								            Thread.sleep(200);							            
							                Controller.actionOut.writeObject(name2);
								            Controller.actionOut.flush();
								            
								            Object repl = Controller.actionIn.readObject();	                                    
								            System.out.println(repl);
								            JOptionPane.showMessageDialog(contentPanel,repl);
							                
						            	}catch(Exception eName) {eName.printStackTrace();}
						            }
						            
						            if ((anInt == 1)) {
						            	try {
						                System.out.print("Enter new HP value:");
						                Integer hel = Integer.parseInt(textField.getText());
						                
						                Controller.actionOut.writeObject(Comand.replace_if_lower);
						                Thread.sleep(200);
						                Controller.actionOut.writeObject(ke);
							            Controller.actionOut.flush();
							            Thread.sleep(200);
							            Controller.actionOut.writeObject(anInt+1);
							            Thread.sleep(200);
						                Controller.actionOut.writeObject(hel);
						                Controller.actionOut.flush();
						                
						                Object repl = Controller.actionIn.readObject();	                                    
							            System.out.println(repl);
							            JOptionPane.showMessageDialog(contentPanel,repl);
							            
						            	}catch(Exception eHP) {JOptionPane.showMessageDialog(contentPanel,
											    "Health should be integer",
											    "Icorrect input",
											    JOptionPane.ERROR_MESSAGE);}
						            }
	//					            Controller.actionOut.writeObject(new CommandsManager(Comand.replace_if_lower, anInt).getI());
	//					            Controller.actionOut.flush();
	//					            Object repl = Controller.actionIn.readObject();	                                    
	//					            System.out.println(repl);
	//					            JOptionPane.showMessageDialog(contentPanel,repl);
					            }catch(Exception eType) {}
					        } catch (RuntimeException eKey) {
					        	JOptionPane.showMessageDialog(contentPanel,
									    "Key should be of Long",
									    "Icorrect input",
									    JOptionPane.ERROR_MESSAGE);
					            System.out.println("Invalid input");
					            System.out.println("Command execution terminated");
					        }
		                        
							
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
			}
		
//		try {
//            shipToServer.writeObject(new CommandsManager(bufferedCommand).getComand());
//            long ke = Long.parseLong(finalUserCommand[1]);
//            shipToServer.writeObject(new CommandsManager(bufferedCommand, ke).getL());
//            shipToServer.flush();
//            System.out.println("What would you like to change?:1-Name;2-Coords;3-HP");
//            int anInt = comp.nextInt();
//            while (anInt != 1 && anInt != 2 && anInt != 3) {
//                System.out.println("Invalid input");
//                System.out.println("What would you like to change?:1-Name;2-Coords;3-HP");
//                anInt = comp.nextInt();
//            }
//            shipToServer.writeObject(new CommandsManager(bufferedCommand, anInt).getI());
//            if (anInt == 1) {
//                System.out.println("Enter new name");
//                String name2 = comp.next();
//                shipToServer.writeObject(new CommandsManager(bufferedCommand, name2).getString());
//            }
//            if (anInt == 2) {
//                System.out.println("Enter new coords:");
//                System.out.print("x:");
//                int x2 = comp.nextInt();
//                shipToServer.writeObject(new CommandsManager(bufferedCommand, x2).getI());
//                System.out.print("y:");
//                int y2 = comp.nextInt();
//                shipToServer.writeObject(new CommandsManager(bufferedCommand, y2).getI());
//            }
//            if ((anInt == 3)) {
//                System.out.print("Enter new HP value:");
//                Integer hel = comp.nextInt();
//                while (hel<0) {
//                	System.out.println("Health Points can only be 0 or more than 0");
//                	System.out.println("Enter Health Points:");
//                	hel = comp.nextInt();
//                }
//                shipToServer.writeObject(new CommandsManager(bufferedCommand, hel).getI());
//            }
//            shipToServer.writeObject(new CommandsManager(bufferedCommand, anInt).getI());
//            shipToServer.flush();
//            Object repl = receiveFromServer.readObject();	                                    
//            System.out.println(repl);
//        } catch (RuntimeException e) {
//            System.out.println("Invalid input");
//            System.out.println("Command execution terminated");
//        }
		}catch(Exception ex) {ex.printStackTrace();}
		
	}
	

}
