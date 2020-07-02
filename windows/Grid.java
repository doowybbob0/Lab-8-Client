package windows;
import javax.swing.*;

import commands_client.C_show;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;
import utils.*;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Grid {

    private JTextArea b;
    private JScrollPane view;
    public static String[][] arr = new String[][]{};
    public static JFrame f = new JFrame();
    public static ObjectOutputStream out;
    public static ObjectInputStream in;
    public static ResourceBundle bundle;
    public static int color;
    public static long us;

    public Grid(ObjectOutputStream outToClient, ObjectInputStream inn, ResourceBundle bundleDef,long us1) throws Exception {
        us=us1;
        bundle=bundleDef;
        out=outToClient;
        in=inn;
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowActivated(WindowEvent e) {
                try {
                    outToClient.writeObject(Comand.showTable);
                    String sb= (String) inn.readObject(); 
                    arr = C_show.show(sb);
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                b = new JTextArea() {
                    private static final long serialVersionUID = 1L;
                    @Override
                    public Dimension getPreferredSize() {
                        int w = 850;
                        System.out.println(arr.length);
                        System.out.println(arr);
                        if (arr.length > 7) {
                            w = ((arr.length-7)* 100)+850;
                        }
                        if(arr.length > 10){
                            w=1280;
                        }
                        return new Dimension(w, 300);
                    }

                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        int b2 = arr.length;
                        g.setColor(Color.black);
                        Font FONT = new Font("Serif", Font.PLAIN, 20);
                        g.setFont(FONT);
                        
                        int x = -70;
                        int y = 80;
                        int ys = 110;
                        int xs = -60;
                        for (int i = 0; i < b2; i++) {
                            Graphics2D g2d = ((Graphics2D) g);
                            g2d.setStroke(new BasicStroke(3.5f));
                            color=Integer.parseInt(arr[i][10]);
                            Color color2 = new Color(color);
                            g2d.setColor(color2);
                            x = x + 93;
                            if (x > 900) {
                                x = 23;
                                y = y + 50;
                                ys = ys + 50;
                                xs = -60;
                            }
                            //Paint2(c,g2d);
                            //g2d.setPaint(color);
                            g2d.drawRoundRect(x, y, 90, 50, 10, 5);
                            xs = xs + 93;
                            String name = arr[i][0];
                            if(name.length()>7){
                                String newString = name.substring (0,7);
                                newString = newString+"...";
                                g2d.drawString(newString, xs, ys);
                            }else { g2d.drawString(name, xs, ys);}

                        }
                    }
                };
                b.addMouseListener(new MouseHandler());
                b.setEditable(false);
                view = new JScrollPane(b);
                f.add(view, BorderLayout.CENTER);
                JButton button = null;
                try {
                    button = new JButton(new String(bundleDef.getString("GLAW").getBytes("ISO-8859-1"),"Cp1251"));
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                assert button != null;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        e.getWindow().setVisible(false);
//                        try {
//                            //WindowClient.createGUI(outToClient,inn, us,bundleDef,log,color);
//                        } catch (IOException | InterruptedException ex) {
//                            ex.printStackTrace();
//                        }
                    }
                });
                f.add(button, BorderLayout.SOUTH);
                f.pack();
            }

            @Override
            public void windowClosing(WindowEvent event) { }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        //f.setSize(new Dimension(500,400));
        f.setLocation(100,100);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        f.setVisible(true);
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
            int x = mouseX - locationX - 27;
            int y = mouseY - locationY - 110;
            System.out.println("y"+y);
            int max = locationX + 926;
            int k = 0;
            int ky = y / 50;
            System.out.println(ky);
            k = ky * 10;
            if (mouseX < max && y > 0) {
                while (x > 0) {
                    x = x - 92;
                    k++;
                }
                try {
                    Object o = arr[k][1];
                    System.out.println(o);
                        out.writeObject(Comand.table);
                        out.writeObject(o);
                        out.writeObject(arr[k-1][10]);
                        System.out.println(arr[k-1][10]);
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
                }catch (RuntimeException | IOException | ClassNotFoundException ignored) {ignored.printStackTrace();
                }
            }
        }
    }
    }
