package windows;
import javax.swing.*;

import client.Auth;
import utils.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class Update_table {
        public static final Font FONT = new Font("Verdana", Font.PLAIN, 16);
        public static int k;
        public static void createW2(ObjectOutputStream outToClient, ObjectInputStream inn, ResourceBundle bundleDef,long id,String name0,String x0,String y0,String health0,String height0,String weapon0,String meleeweapon0,String chapterLegion0,String chapterSquad0,Long k1) {
            k=k1.intValue();
            JFrame frame2 = new JFrame("Объект");
            frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame2.addWindowListener(new WindowListener() {

                public void windowActivated(WindowEvent event) {// все время пока окно активно
//                    JLabel lab1 = null;
                    try {
//                        
                        String s = new String("       ");
//                        JScrollPane scroll = new JScrollPane(textArea);
//                        scroll.getVerticalScrollBar();
                        
                        JPanel panel = new JPanel();
//                   

                        JLabel label00 = new JLabel("    ");
                        JLabel label000 = new JLabel("    ");
                        JLabel label2 = new JLabel(s+new String(bundleDef.getString("NAME01").getBytes("ISO-8859-1"),"Cp1251")); //name
                        JTextField name = new JTextField(name0,10); 
                        panel.add(label2);
                        panel.add(name);
                        panel.add(label000);
                        JLabel label3 = new JLabel(new String(bundleDef.getString("X").getBytes("ISO-8859-1"),"Cp1251"));	//x
                        JTextField x = new JTextField(x0,10);
                        panel.add(label3);
                        panel.add(x);
                        JLabel label4 = new JLabel(new String(bundleDef.getString("Y").getBytes("ISO-8859-1"),"Cp1251"));	//y
                        JTextField y = new JTextField(y0,10);
                        panel.add(label4);
                        panel.add(y);
                        JLabel label5 = new JLabel(new String(bundleDef.getString("HEALTH01").getBytes("ISO-8859-1"),"Cp1251"));	//health
                        JTextField health = new JTextField(health0,10);
                        panel.add(label5);
                        panel.add(health);
                        JLabel label6 = new JLabel("   "+new String(bundleDef.getString("HEIGHT01").getBytes("ISO-8859-1"),"Cp1251"));	//height
                        JTextField h = new JTextField(height0,10);
                        panel.add(label6);
                        panel.add(h);
                        JLabel label18 = new JLabel(s+new String(bundleDef.getString("WEAPON01").getBytes("ISO-8859-1"),"Cp1251")); 	//weapon
                        panel.add(label18);
                        JComboBox comboBox = new JComboBox();
                        comboBox.addItem("PLASM");
                        comboBox.addItem("FLAMER");
                        comboBox.addItem("GRAV");
                        comboBox.addItem("GRENADE");
                        comboBox.addItem("MULTI");
                        panel.add(comboBox);
                        
                        JLabel label19 = new JLabel(s+new String(bundleDef.getString("MELEE01").getBytes("ISO-8859-1"),"Cp1251"));	//melee
                        panel.add(label19);
                        JComboBox comboBox1 = new JComboBox();
                        comboBox1.addItem("CHAIN_SWORD");
                        comboBox1.addItem("MANREAPER");
                        comboBox1.addItem("POWER_BLADE");
                        panel.add(comboBox1);
                        
                        JLabel label7 = new JLabel(s+"     "+new String(bundleDef.getString("LEGION01").getBytes("ISO-8859-1"),"Cp1251"));	//legion
                        JTextField name2 = new JTextField(chapterLegion0,10);
                        panel.add(label7);
                        panel.add(name2);
                        JLabel label8 = new JLabel(s+new String(bundleDef.getString("SQUAD01").getBytes("ISO-8859-1"),"Cp1251"));	//squad
                        JTextField name3 = new JTextField(chapterSquad0,10);
                        panel.add(label8);
                        panel.add(name3);

                        
                        
                        JButton button = new JButton(new String(bundleDef.getString("VOD").getBytes("ISO-8859-1"),"Cp1251"));
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(e.getSource()==button){
                                    if (!name.getText().equals("") && !x.getText().equals("") && !y.getText().equals("") && health.getText()!=null && !h.getText().equals("") && !name2.getText().equals("") && !name3.getText().equals("")){
                                        int x1 = Integer.parseInt(x.getText());
                                        int y1 = Integer.parseInt(y.getText());
                                        //int r1 = Integer.parseInt(r.getText());
                                        String name22 = String.valueOf(name2.getText());
                                        String name33 = String.valueOf(name3.getText());
                                        String name1 = String.valueOf(name.getText());
                                        Integer health1 = Integer.parseInt(health.getText());                                     
                                        Integer height1 = Integer.parseInt(h.getText());
                                        Weapon categ = null;
                                        if (comboBox.getSelectedIndex()  == 0) { categ = Weapon.PLASMA_GUN; }
                                        if (comboBox.getSelectedIndex()  == 1) { categ = Weapon.FLAMER; }
                                        if (comboBox.getSelectedIndex()  == 2) { categ = Weapon.GRAV_GUN; }
                                        if (comboBox.getSelectedIndex()  == 3) { categ = Weapon.GRENADE_LAUNCHER; }
                                        if (comboBox.getSelectedIndex()  == 4) { categ = Weapon.MULTI_MELTA; }
                                        
                                        MeleeWeapon mwcateg = null;
                                        if (comboBox1.getSelectedIndex() == 1) {  mwcateg = MeleeWeapon.CHAIN_SWORD; }
                                        if (comboBox1.getSelectedIndex() == 2) { mwcateg = MeleeWeapon.MANREAPER; }
                                        if (comboBox1.getSelectedIndex() == 3) { mwcateg = MeleeWeapon.POWER_BLADE; }
                                        MeleeWeapon categ2 = mwcateg;
                                        SpaceMarine sp = spaceMarine(name1,x1, y1, health1, height1, categ,mwcateg,name22, name33,k1,k1);
                                        //SpaceMarine finalSpaceMarine = new SpaceMarine(name, new Coordinates(x, y), healthInt, heightInt, categ1,categ2, new Chapter(legion, squad),Auth.user_id,Auth.user_id);
                                        try {
                                            long kup = 1;
                                            Comand comand = Comand.update_id;
                                            outToClient.writeObject(comand);
                                            outToClient.writeObject(id);
                                            outToClient.flush();
                                            outToClient.writeObject(sp);
                                            outToClient.flush();
                                            Object insert = null;
                                            insert = inn.readObject();
                                            //ComWindow.createWO(insert,570,170,15,5,33,bundleDef);
                                        } catch (IOException | ClassNotFoundException ex) {
                                            System.out.println("Что-то пошло не так");
                                            ex.printStackTrace();
                                        }
                                        event.getWindow().setVisible(false);
                                    }
                                }
                            }
                        });
                        panel.add(button);
                        frame2.add(panel);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                public void windowClosed(WindowEvent event) {
                }

                public void windowClosing(WindowEvent event) {
                  
                        event.getWindow().setVisible(false);
                    
                }

                public void windowDeactivated(WindowEvent event) {//когда окно свернуто
                }

                public void windowDeiconified(WindowEvent event) {//когда мы только только развернули окно
                }

                public void windowIconified(WindowEvent event) {
                }

                public void windowOpened(WindowEvent event) {//когда окно только появляется
                }
            });
            frame2.setPreferredSize(new Dimension(450, 410));
            frame2.pack();
            frame2.setLocationRelativeTo(null);
            frame2.setResizable(false);
            frame2.setVisible(true);
            UIManager.put("Button.font", FONT);
            UIManager.put("Label.font", FONT);
        }
        public static SpaceMarine spaceMarine(String name1,int x1,int y1,int health1, int height1,Weapon categ,MeleeWeapon mwcateg, String legion,String squad,Long k1,Long k2){
            SpaceMarine abc = new SpaceMarine(name1, new Coordinates(x1, y1), health1, height1, categ,mwcateg, new Chapter(legion, squad),k1,k2);
            return abc;
        }
    }
