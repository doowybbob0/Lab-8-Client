package client;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.net.ConnectException;
import java.net.InetAddress;

import commands_client.*;
import utils.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ResourceBundle;




public class Main {
	
	
	    public static final Font FONT = new Font("Serif", Font.PLAIN, 20);
	    public static final Font FONTb = new Font("Serif", Font.PLAIN, 18);
	    public static void main(String[] arg) {

	        JFrame frame2 = new JFrame("Start");
	        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	                JPanel panel = new JPanel();
	                JLabel label11 = new JLabel("Язык/Language");

	                panel.add(label11);

	                JComboBox comboBox = new JComboBox();
	                comboBox.addItem("Русский");
	                comboBox.addItem("English");
	                comboBox.addItem("Bolgarian");
	                comboBox.addItem("Icelandic");
	                panel.add(comboBox);
	                JButton button = new JButton("ВВОД");
	                button.addActionListener(e -> {
	                    if(e.getSource()==button){
	                        String a="";
	                        int b=19;
	                        if (comboBox.getSelectedIndex()==0){a="lang_ru";b=18;}
	                        if (comboBox.getSelectedIndex()==1){a="lang_en";b=20;}
	                        if (comboBox.getSelectedIndex()==3){a="lang_bg";b=20;}
	                        if (comboBox.getSelectedIndex()==2){a="lang_is";b=20;}
	                        ResourceBundle bundleDef = ResourceBundle.getBundle(a);
	                        try {
	                        	System.out.println("[CLIENT-VERSION] [LOCALHOST]");	                			
	                	        Socket outcoming = new Socket(InetAddress.getLocalHost(), 28553);
	                	        Auth.serverAuth(outcoming,bundleDef,b);
	                            //Socket socket = new Socket("localhost", 28571);
	                            //DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
	                            //DataInputStream ois = new DataInputStream(socket.getInputStream());
	                            //WindowStart.createGUI(b,socket,oos,ois,bundleDef);
	                        } catch (Exception ex) {
	                        	JOptionPane.showMessageDialog(frame2,
	        						    "Cannot reach server",
	        						    "Error",
	        						    JOptionPane.ERROR_MESSAGE);
	                            //WindEx.createWO(bundleDef);
	                        }
	                        frame2.setVisible(false);
	                    }
	                });
	                panel.add(button);
	                frame2.add(panel);



	        UIManager.put("Button.font", FONTb);
	        UIManager.put("Label.font", FONT);
	        frame2.setPreferredSize(new Dimension(490, 130));
	        frame2.pack();
	        frame2.setLocationRelativeTo(null);
	        frame2.setResizable(false);
	        frame2.setVisible(true);
	    }
	

	
	
		/**
		public static void main(String[] args) {
			System.out.println("[CLIENT-VERSION] [LOCALHOST]");
			ConnectToServer connection = new ConnectToServer();
	        connection.server_tunnel();
	        System.out.println("That's it  (¬‿¬)");
		}
	    **/
}



