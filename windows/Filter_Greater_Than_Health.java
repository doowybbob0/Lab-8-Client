package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.CommandsManager;
import utils.Comand;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Filter_Greater_Than_Health extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Filter_Greater_Than_Health() {
		setBounds(100, 100, 440, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 341, 0, 0};
		gbl_contentPane.rowHeights = new int[]{49, 59, 324, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		

	    try {
	          
	          
	          JPanel panel_1 = new JPanel();
	          GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	          gbc_panel_1.insets = new Insets(0, 0, 5, 5);
	          gbc_panel_1.fill = GridBagConstraints.BOTH;
	          gbc_panel_1.gridx = 1;
	          gbc_panel_1.gridy = 0;
	          contentPane.add(panel_1, gbc_panel_1);
	          panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	          
	          JLabel lblNewLabel = new JLabel(new String(Controller.bundleDef.getString("VALUE").getBytes("ISO-8859-1"),"Cp1251"));
	          panel_1.add(lblNewLabel);
	          
	          textField = new JTextField();
	          panel_1.add(textField);
	          textField.setColumns(10);
	          
	          JTextPane txtpnGtg = new JTextPane();
	          
	          
	          
	          
	  		
	  		JPanel panel = new JPanel();
	  		GridBagConstraints gbc_panel = new GridBagConstraints();
	  		gbc_panel.insets = new Insets(0, 0, 5, 5);
	  		gbc_panel.fill = GridBagConstraints.BOTH;
	  		gbc_panel.gridx = 1;
	  		gbc_panel.gridy = 1;
	  		contentPane.add(panel, gbc_panel);
	  		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	  		
	  		JButton btnNewButton = new JButton("OK");
	  		btnNewButton.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mouseClicked(MouseEvent e) {
	  				try {
		  				int l = Integer.parseInt(textField.getText());
	
		  				Controller.actionOut.writeObject(Comand.filter_greater_than_health);
		  				Controller.actionOut.flush();
		  				Controller.actionOut.writeObject(l);
		  				Controller.actionOut.flush();
		  				Object remg = Controller.actionIn.readObject();
		  				String remg1=remg.toString();
		  				System.out.println(remg);
		  	          
			  	        txtpnGtg.setText(remg1);
				  		txtpnGtg.setBackground(Color.WHITE);
				  		GridBagConstraints gbc_txtpnGtg = new GridBagConstraints();
				  		gbc_txtpnGtg.insets = new Insets(0, 0, 0, 5);
				  		gbc_txtpnGtg.fill = GridBagConstraints.BOTH;
				  		gbc_txtpnGtg.gridx = 1;
				  		gbc_txtpnGtg.gridy = 2;
				  		contentPane.add(txtpnGtg, gbc_txtpnGtg);
	  				}catch(Exception ex) {ex.printStackTrace();}
	  			}
	  		});
	  		panel.add(btnNewButton);
	          
//	  		txtpnGtg.setText(remg1);
//	  		txtpnGtg.setBackground(Color.WHITE);
//	  		GridBagConstraints gbc_txtpnGtg = new GridBagConstraints();
//	  		gbc_txtpnGtg.insets = new Insets(0, 0, 0, 5);
//	  		gbc_txtpnGtg.fill = GridBagConstraints.BOTH;
//	  		gbc_txtpnGtg.gridx = 1;
//	  		gbc_txtpnGtg.gridy = 2;
//	  		contentPane.add(txtpnGtg, gbc_txtpnGtg);
	    } catch (Exception e) {
	      	e.printStackTrace();
	    }
		
		
		
		
		
		
//		bufferedCommand = Comand.filter_greater_than_health;
//        Scanner com3 = new Scanner(System.in);
//        try {
//            int l = Integer.parseInt(finalUserCommand[1]);
//            while (l<0) {
//                System.out.println("Invalid HP value. Can only be greater than 0. Try again");
//                l = com3.nextInt();
//            }
//            shipToServer.writeObject(new CommandsManager(bufferedCommand).getComand());
//            shipToServer.flush();
//            shipToServer.writeObject(new CommandsManager(bufferedCommand, l).getI());
//            shipToServer.flush();
//            Object remg = receiveFromServer.readObject();
//            System.out.println(remg);
//        } catch (RuntimeException e) {
//        	System.out.println("Invalid input");
//            System.out.println("Command execution terminated");
//        }
//        break;
	}

}
