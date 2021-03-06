package windows;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import commands_client.C_show;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import utils.*;

public class Controller extends JFrame {

	
	private TableModelListener tableModelListener;
	public static JPanel contentPane;
	public static Controller frame;
	public static ObjectOutputStream actionOut;
	public static ObjectInputStream actionIn;
	public static Long user_id;
	public static ResourceBundle bundleDef;
	static String matrix[][];
	static JTable table1;
	public static String login;
	public static JButton btnChngpass;
	public static JButton btnNewButton;
	public static JMenuBar menuBar;
	
	public static  String[] columnNames = {
			"ID",
            "Name",
            "X coordinate",
            "Y coordinate",
            "Health",
            "Height",
            "Weapon",
            "MeleeWeapon",
            "Legion",
            "Squad",
            "Author ID"
    };
	
	
	
	public static void updateLocale() {
		try {
		btnChngpass.setText(new String(bundleDef.getString("NEWPASSWORD").getBytes("ISO-8859-1"),"Cp1251"));
		btnNewButton.setText(new String(bundleDef.getString("LANG").getBytes("ISO-8859-1"),"Cp1251"));
		frame.validate();
		frame.repaint();
		frame.setVisible(false);
		frame.setVisible(true);
		}catch(Exception updlocalex) {updlocalex.printStackTrace();}
	}
	
	
	public static void initialize(ObjectOutputStream actionOutb,ObjectInputStream actionInb, Long user_idb,String loginb, ResourceBundle bundleDefb) {
		
		actionIn=actionInb;
		actionOut=actionOutb;
		user_id=user_idb;
		bundleDef=bundleDefb;
		login=loginb;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new Controller();
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
	public Controller() {
		
		repaint();
		
		setTitle("Controller");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnHelp = new JButton("Help");
		menuBar.add(btnHelp);
		btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnHelp) {
                	Help help = new Help();
                	help.setVisible(true);
//                	
                	
                }
            }
        });
		
		JButton btnInfo = new JButton("Info");
		menuBar.add(btnInfo); 
		btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnInfo) {
                	try {
	                    actionOut.writeObject(Comand.info);
	                    actionOut.flush();
	                    Object inf = actionIn.readObject();
	                    System.out.println(inf);
	                  
	                	JOptionPane.showMessageDialog(frame,
	                		    inf);
                	}catch(Exception infoException) {JOptionPane.showMessageDialog(frame,
                		    "An error has occured",
                		    "Error",
                		    JOptionPane.ERROR_MESSAGE);}
                	
                }
            }
        });
		try {
		btnChngpass = new JButton(new String(bundleDef.getString("NEWPASSWORD").getBytes("ISO-8859-1"),"Cp1251"));
		btnChngpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Change_Password chngpass = new Change_Password();
            	chngpass.setVisible(true);
			}
		});
		menuBar.add(btnChngpass);
		}catch(Exception newpassex) {newpassex.printStackTrace();}
		
		try {
		JLabel lblUserID = new JLabel("   ID: "+user_id);
		
		lblUserID.setAlignmentX(0.5f);
		lblUserID.setBounds(new Rectangle(5, 0, 5, 0));
		menuBar.add(lblUserID);
		}catch(Exception eIDlbl) {}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel table_panel = new JPanel();
		table_panel.setBounds(10, 231, 972, 254);
		contentPane.add(table_panel);
		
		JPanel commands_panel = new JPanel();
		commands_panel.setBounds(10, 11, 972, 107);
		contentPane.add(commands_panel);
		commands_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnInsertKey = new JButton("Insert Key");
		btnInsertKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InsertKey insertKey = new InsertKey(actionOut);
				insertKey.setVisible(true);
				
			}
		});
		commands_panel.add(btnInsertKey);
		
		JButton btnRemoveKey = new JButton("Remove Key");
		btnRemoveKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Remove_Key remkey = new Remove_Key();
            	remkey.setVisible(true);
			}
		});
		commands_panel.add(btnRemoveKey);
		
		JButton btnRemoveGreaterKey = new JButton("Remove Greater Key");
		btnRemoveGreaterKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Remove_Greater rg = new Remove_Greater();
				rg.setVisible(true);
			}
		});
		commands_panel.add(btnRemoveGreaterKey);
		
		JButton btnReplaceIL = new JButton("Replace If Lower");
		btnReplaceIL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Replace_If_Lower ril = new Replace_If_Lower();
            	ril.setVisible(true);
			}
		});
		commands_panel.add(btnReplaceIL);
		
		JButton btnViewGrid = new JButton("Show Grid");
		btnViewGrid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					Grid_beta gr = new windows.Grid_beta(actionOut, actionIn, bundleDef, user_id);
				}catch (Exception eGrid) {eGrid.printStackTrace();}
			}
		});
		commands_panel.add(btnViewGrid);
		
		try {
		btnNewButton = new JButton(new String(bundleDef.getString("LANG").getBytes("ISO-8859-1"),"Cp1251"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Language lng = new Language();
            	lng.setVisible(true);
			}
		});
		commands_panel.add(btnNewButton);
		}catch(Exception langex) {langex.printStackTrace();}
		
		JPanel sorting_panel = new JPanel();
		sorting_panel.setBounds(10, 173, 972, 47);
		contentPane.add(sorting_panel);
		sorting_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSortFilterGreaterThanHealth = new JButton("Filter Greater Than Health");
		btnSortFilterGreaterThanHealth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Filter_Greater_Than_Health fgth = new Filter_Greater_Than_Health();
            	fgth.setVisible(true);
			}
		});
		sorting_panel.add(btnSortFilterGreaterThanHealth);
		
		
		try {
//		JLabel lblNewLabel = new JLabel(new String(bundleDef.getString("TABLESORTOPTIONS").getBytes("ISO-8859-1"),"Cp1251"));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(250, 128, 181, 33);
//		contentPane.add(lblNewLabel);	
//		JLabel label = new JLabel(new String(bundleDef.getString("TABLE").getBytes("ISO-8859-1"),"Cp1251"));
//		table_panel.add(label);
//        JLabel jLabel = new JLabel(new String(bundleDef.getString("WT1").getBytes("ISO-8859-1"),"Cp1251"));
//        table_panel.add(jLabel);
        
//        Timer timer = new Timer();

//        timer.schedule( new TimerTask() {
//            public void run() {
//            	try {
//               // do your work
//            	Tab(table_panel,scrollPane,actionIn,actionOut,bundleDef,user_id);
////		        JLabel labelv = new JLabel(new String(bundleDef.getString("WT2").getBytes("ISO-8859-1"),"Cp1251"));
////		        table_panel.add(labelv);
//		        //table_panel.add(button);
//		        frame.getContentPane().add(table_panel);
//            	}catch(Exception et) {}
//            }
//         }, 0, 15*1000);
        
        
        Tab(table_panel,scrollPane,actionIn,actionOut,bundleDef,user_id);
	//    JLabel labelv = new JLabel(new String(bundleDef.getString("WT2").getBytes("ISO-8859-1"),"Cp1251"));
	//    table_panel.add(labelv);
	    //table_panel.add(button);
	    //frame.getContentPane().add(table_panel);
	    
        
        
		}catch(Exception e) {
			JOptionPane.showMessageDialog(contentPane,
				    "Cannot reach server",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception in Controller");e.printStackTrace();}
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	

	
	
	
	public void Tab(JPanel panel,JScrollPane scrollPane2,ObjectInputStream inn,ObjectOutputStream outToClient,ResourceBundle bundleDef,long us) throws IOException, ClassNotFoundException {
		
        Comand s = Comand.showTable;
        outToClient.writeObject(s);          
        String sb= (String) inn.readObject(); 
        matrix = C_show.show(sb);
        
        DefaultTableModel model = new DefaultTableModel(matrix, columnNames) {
        	public boolean isCellEditable(int row, int col){
            return false;
          }
        };
        
        table1 = new JTable(model);
        	
        //String data2[][]= (String[][]) inn.readObject();
        //System.out.println(data2);
//        table1 = new JTable(matrix,columnNames){
//            public boolean isCellEditable(int row, int col){
//                return false;
//            }
//        };
        
        
        
        
        
        
        Timer timer = new Timer();
        timer.schedule( new TimerTask() {
            public void run() {
            	try {
            		Comand s = Comand.showTable;
                    outToClient.writeObject(s);          
                    String sb= (String) inn.readObject(); 
                    String[][] safeMatrix = new String[1][1];                    
                    matrix = C_show.show(sb);
                    System.out.println("Updating");
                    
//                    table1 = new JTable(matrix,columnNames){
//                        public boolean isCellEditable(int row, int col){
//                            return false;
//                        }
//                    };
                    DefaultTableModel model = new DefaultTableModel(matrix, columnNames) {
                    	public boolean isCellEditable(int row, int col){
                        return false;
                      }
                    };
                    table1.setModel(model);
                    
                    table1.repaint();

                    
                    table1.setAutoCreateRowSorter(true);
                    table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                    
//                    scrollPane2.setViewportView(table1);
//                    scrollPane2.getVerticalScrollBar();
//                    scrollPane2.setPreferredSize(new Dimension(830,130));
//                    panel.add(scrollPane2,BorderLayout.CENTER);
                    //setTableModelListener();
		       
            	}catch(Exception et) {et.printStackTrace();}
            }
         }, 0, 15*1000);
        
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();
                if (evt.getClickCount() > 1) {
                    Object  o = table1.getValueAt(row,1);                    
                    Object  o2 = matrix[row][10];
                    try {
                        outToClient.writeObject(Comand.table);
                        outToClient.writeObject(o);
                        outToClient.writeObject(o2);
                        outToClient.flush();
                        SpaceMarine sp =(SpaceMarine) inn.readObject();
                        if(sp!=null){
                        	System.out.println("Authorized to edit element");
                            long key = (long) inn.readObject();
                            String sx=String.valueOf(sp.getCordinatesX());
                            String sy=String.valueOf(sp.getCordinatesY());
                            String shealth = String.valueOf(sp.getHealth());
                            String sheight = String.valueOf(sp.getHeight());
                            String sweapon = String.valueOf(sp.getWeapon());
                            String smweapon = String.valueOf(sp.getMeleeWeapon());                           
//                            Update_table.createW2(outToClient,inn,bundleDef,key,sp.getName(),sx,sy,shealth,sheight,sweapon,smweapon,sp.getChapter().getLegion(),sp.getChapter().getSquad(),user_id);
                            Update_table_beta updt = new Update_table_beta(outToClient,inn,bundleDef,key,sp.getName(),sx,sy,shealth,sheight,sweapon,smweapon,sp.getChapter().getLegion(),sp.getChapter().getSquad(),user_id);
                            updt.setVisible(true);
                        }else {System.out.println("Not authorized");}
                    } catch (IOException | ClassNotFoundException e) {
                    	
                        e.printStackTrace();
                    }
                }
            }
        });
        
        scrollPane2.setViewportView(table1);
        scrollPane2.getVerticalScrollBar();
        scrollPane2.setPreferredSize(new Dimension(830,130));
        panel.add(scrollPane2,BorderLayout.CENTER);
        
        
        
    }
}
