package windows;

import javax.swing.*;

import commands_client.C_show;
import utils.Comand;
import utils.SpaceMarine;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Grid_beta {

    //private JTextArea b;
    private JScrollPane view;
    public static String[][] arr = new String[][]{};
    public static JFrame f = new JFrame();
    public static ObjectOutputStream out;
    public static ObjectInputStream in;
    public static ResourceBundle bundle;
    public static int color;
    public static int color2;
    public static long us;
    public static String login1;
    private int hexSize = 3;
    private int zoom = 80;
    public static GraphPane gp;

    public Grid_beta(ObjectOutputStream outToClient, ObjectInputStream inn, ResourceBundle bundleDef,Long us1) throws Exception {
	try {    	
	//        login1=log;
	//        color2=color1;
	        us=us1;
	        bundle=bundleDef;
	        out=outToClient;
	        in=inn;
	                try {
	                	outToClient.writeObject(Comand.showTable);
	                    String sb= (String) inn.readObject(); 
	                    arr = C_show.show(sb);
	                } catch (IOException | ClassNotFoundException ex) {
	                    ex.printStackTrace();
	                }              
	        gp = new GraphPane();
	                view = new JScrollPane(gp);
	                int sh=0;
	                int h=0;
	        for (int i = 0; i < arr.length; i++) {
	            int ac=Integer.parseInt(arr[i][2]);
	            int bc=Integer.parseInt(arr[i][3]);
	            if (ac>sh){sh=ac;}
	            if (bc>h){h=bc;}
	        }
	        if (sh<300&&h<300){gp.setPreferredSize(new Dimension(400, 300));}
	        gp.setPreferredSize(new Dimension(sh+200, h+200));
	        JPanel panel= new JPanel(new BorderLayout());
	        view.setPreferredSize(new Dimension(sh+200,h+200));
	        view.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        view.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        view.setPreferredSize(new Dimension(sh+200,h+200));
	        gp.addMouseWheelListener(this::mouseWheelMoved);
	        gp.addMouseListener(new MouseHandler());
	        panel.add(view, BorderLayout.CENTER);
	                JButton button = null;
	                try {
	                    button = new JButton("OK");
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	                assert button != null;
	                button.addActionListener(new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e1) {
	                        f.setVisible(false);
	                        try {
	                            //WindowClient.createGUI(outToClient,inn, us,bundleDef,log,color);
	                        } catch (Exception ex) {
	                            ex.printStackTrace();
	                        }
	                    }
	                });
	                panel.add(button, BorderLayout.SOUTH);
	                f.getContentPane().add(panel);
	               // f.add(button, BorderLayout.SOUTH);
	                f.pack();
	        f.setSize(new Dimension(1200,600));
	        f.setLocation(50,50);
	        f.setVisible(true);
	        f.setResizable(false);
    }catch(Exception exc) {
    	JOptionPane.showMessageDialog(f,
        	    "No data to view");
    	f.setVisible(false);
    }
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
            int locationX = f.getX();
            int locationY = f.getY();
            int x = mouseX - locationX - 30;
            int y = mouseY - locationY - 100;
            int k = -1;
            for (int i = 0; i < arr.length; i++) {
                if(x>Integer.parseInt(arr[i][2])&&(x<(Integer.parseInt(arr[i][2])+55))){
                    if(y>Integer.parseInt(arr[i][3])&&y<(Integer.parseInt(arr[i][3])+40)){
                       k=i;
                    }
                }
            }
            if (k!=-1) {
                try {
                	System.out.println("LENGH"+arr.length);
                    Object o = arr[k][1];
                    System.out.println(o);
                        out.writeObject(Comand.table);
                        out.writeObject(o);
                        out.writeObject(arr[k][10]);
                        System.out.println(arr[k][10]);
                        out.flush();
                        SpaceMarine sp = (SpaceMarine) in.readObject();
                        if(sp!=null){
                            long key = (long) in.readObject();
                            String sx=String.valueOf(sp.getCordinatesX());
                            String sy=String.valueOf(sp.getCordinatesY());
                            String shealth = String.valueOf(sp.getHealth());
                            String sheight = String.valueOf(sp.getHeight());
                            String sweapon = String.valueOf(sp.getWeapon());
                            String smweapon = String.valueOf(sp.getMeleeWeapon());
                            System.out.println("Trying");
//                            Update_table.createW2(out,in,bundle,key,sp.getName(),sx,sy,shealth,sheight,sweapon,smweapon,sp.getChapter().getLegion(),sp.getChapter().getSquad(),Controller.user_id);
                            Update_table_beta updt = new Update_table_beta(out,in,bundle,key,sp.getName(),sx,sy,shealth,sheight,sweapon,smweapon,sp.getChapter().getLegion(),sp.getChapter().getSquad(),Controller.user_id);
                            updt.setVisible(true);
                    }
                } catch (RuntimeException | IOException | ClassNotFoundException ignored) {
                	ignored.printStackTrace();
                }
            }
            }
        }
    public void mouseWheelMoved(MouseWheelEvent e) {
        zoom = 100 * -Integer.signum(e.getWheelRotation());
        if (hexSize - Integer.signum(e.getWheelRotation()) > 0) {
            hexSize -= Integer.signum(e.getWheelRotation());
        }
        Dimension targetSize = new Dimension(gp.getWidth() + zoom, gp.getHeight() + zoom);
        gp.setPreferredSize(targetSize);
        gp.setSize(targetSize);
        gp.revalidate();
        gp.repaint();
    }
    private static class GraphPane extends JComponent {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            super.paintComponent(g);
            int b2 = arr.length;
            g.setColor(Color.black);
            Font FONT = new Font("Serif", Font.PLAIN, 20);
            g.setFont(FONT);
            try {
//                g.drawString(new String(bundle.getString("ELIPS1").getBytes("ISO-8859-1"),"Cp1251"), 15, 15);
//                g.drawString(new String(bundle.getString("ELIPS2").getBytes("ISO-8859-1"),"Cp1251"), 15, 35);
//                g.drawString(new String(bundle.getString("ELIPS3").getBytes("ISO-8859-1"),"Cp1251"), 15, 55);
//            	g.drawString("Boop1",15,15);
//                g.drawString("Boop2",15,15);
//                g.drawString("Boop3",15,15);
//                g.drawString("x=100",125,73);
//                g.drawLine(125,75,125,1000000);
//                g.drawString("x=1000",1025,73);
//                g.drawLine(1025,75,1025,1000000);
//                g.drawString("x=10000",10025,73);
//                g.drawLine(10025,75,10025,1000000);
//                g.drawString("x=100000",100025,73);
//                g.drawLine(100025,75,100025,1000000);
//                g.drawString("y=100",10,180);
//                g.drawLine(15,180,1000000,180);
//                g.drawString("y=1000",10,1080);
//                g.drawLine(15,1080,1000000,1080);
//                g.drawString("y=10000",10,10080);
//                g.drawLine(15,10080,1000000,10080);
//                g.drawString("y=100000",10,10080);
//                g.drawLine(15,100080,1000000,100080);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            int x = -70;
            int y = 80;
            int ys = 100;
            int xs = -60;
            for (int i = 0; i < b2; i++) {
                Graphics2D g2d = ((Graphics2D) g);
                g2d.setStroke(new BasicStroke(3.5f));
                x=Integer.parseInt(arr[i][2])+25;
                y=Integer.parseInt(arr[i][3])+80;
                color=Integer.parseInt(arr[i][10]);//color
                Color color2 = new Color(color);
                g2d.setColor(color2);
                g2d.drawRoundRect(x, y, 55, 35, 10, 5);
                xs = x + 5;
                ys=y+25;
                String name = arr[i][0];
                if(name.length()>3){
                    String newString = name.substring (0,3);
                    newString = newString+"..";
                    g2d.drawString(newString, xs, ys);
                }else { g2d.drawString(name, xs, ys);}

            }
        }
    }
    }
