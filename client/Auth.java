package client;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Auth {
	
	public static Long user_id;	
	
	public static String new_password(String password) {
		String new_encrypted_password = ConnectToServer.encrypt_data(password);
		return new_encrypted_password;
	}
	

	
	
	
	
	
	
	
	public static final Font FONT = new Font("Verdana", Font.PLAIN, 16);

    public static void serverAuth(Socket socket, ResourceBundle bundleDef,int b) {
    	try {
    	DataOutputStream authOut = new DataOutputStream(socket.getOutputStream());
		DataInputStream authIn = new DataInputStream(socket.getInputStream());
		
    	System.out.println("[WARNING] Launching Auth tool");  
        JFrame frame = new JFrame("Авторизация");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		                JPanel contents = new JPanel();
		                JLabel label0 = null;
		                label0 = new JLabel(new String(bundleDef.getString("WAL").getBytes("ISO-8859-1"),"Cp1251"));
		                contents.add(label0);
		                JTextField user_login = new JTextField("", 20);
		                // Настройка шрифта
		                user_login.setFont(new Font("Dialog", Font.PLAIN, 15));
		                user_login.setHorizontalAlignment(JTextField.LEFT);
		                contents.add(user_login);
		                JLabel t = new JLabel("        ");
		                contents.add(t);
		                JLabel label1 = null;
		                label1 = new JLabel(new String(bundleDef.getString("WAP").getBytes("ISO-8859-1"),"Cp1251"));
		                contents.add(label1);
		                
		                JTextField user_password = new JTextField("", 20);
		                // Настройка шрифта
		                user_password.setFont(new Font("Dialog", Font.PLAIN, 15));
		                user_password.setHorizontalAlignment(JTextField.LEFT);
		                contents.add(user_password);
		                JLabel t2 = new JLabel("   ");
		                contents.add(t2);
		                JLabel label10 = new JLabel(new String(bundleDef.getString("WAPS").getBytes("ISO-8859-1"),"Cp1251"));
		                contents.add(label10);
		                JButton confirmationButton = new JButton(new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251"));//JButton создает активные клавиши
		                contents.add(confirmationButton);
		                confirmationButton.addActionListener(new ActionListener() {
	                
	                	//AUTHENTIFICATION
		                boolean isLoginCorrect=false;
		                int serverLoginAnswer=0;
		                	
		                @Override
		                public void actionPerformed(ActionEvent e) {		                	
	                        if(e.getSource()==confirmationButton) {	                        	
	                            if (!user_password.getText().equals("") && !user_login.getText().equals("")) {	                            	
	                                try {
	                                	if (isLoginCorrect==false) {
	                                		authOut.writeUTF(user_login.getText());
	                                		System.out.println(user_login.getText());
	                                		serverLoginAnswer = authIn.read();
	                                		}	                                		  	                                	
	                                	if (serverLoginAnswer == 1 || isLoginCorrect==true) {	
	                                		isLoginCorrect=true;
	                                		String encrypted_user_password = ConnectToServer.encrypt_data(user_password.getText());
	                                		authOut.writeUTF(encrypted_user_password);
	                                		System.out.println(user_password.getText());
	                                		int serverAuthAnswer = authIn.read();
	                                		if (serverAuthAnswer == 1) {	                                        	
	                                        	user_id=authIn.readLong();
	                                            System.out.println("[AUTH] You were authorized");
	                                            System.out.println("[AUTH] Your ID is ["+user_id+"]");
	                                            ObjectOutputStream actionOut = new ObjectOutputStream(socket.getOutputStream());
                                                ObjectInputStream actionIn = new ObjectInputStream(socket.getInputStream());
	                                            ConnectToServer.interactiveMode(actionOut,actionIn, user_id, bundleDef, user_login.getText());
	                                            frame.setVisible(false);
	                                            
	                                		}else {
	                                			System.out.println("[AUTH] Wrong password");
	                                			JOptionPane.showMessageDialog(frame,
	                                					new String(bundleDef.getString("INCORRECT_PASSWORD").getBytes("ISO-8859-1"),"Cp1251"),
	                                				    "Inane warning",
	                                				    JOptionPane.WARNING_MESSAGE);
	                                		}
	                                	}else {
	                                		System.out.println("[AUTH] Incorrect login");
                                			JOptionPane.showMessageDialog(frame,
                                					new String(bundleDef.getString("INCORRECT_LOGIN").getBytes("ISO-8859-1"),"Cp1251"),
                                				    "Inane warning",
                                				    JOptionPane.WARNING_MESSAGE);
	                                	}
	                                    
	                                } catch (Exception ex) {
	                                    ex.printStackTrace();
	                                }
	                            }
	                        }
	                    }
	                });
	                
	                frame.add(contents);
	                
        UIManager.put("Label.font", FONT);
        frame.setPreferredSize(new Dimension(510, 190));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
    	
    	}catch(Exception e) {}
    	
    }
}
