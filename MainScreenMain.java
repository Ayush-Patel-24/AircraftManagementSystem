import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

class MainScreen {
    public MainScreen() {
        JFrame jFrame = new JFrame("Main Screen");
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("mainscreen4.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0,0,0,80));
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jFrame.add(jPanel);

        JLabel title1;
        title1 = new JLabel("Aircraft Maintainance",SwingUtilities.LEFT);
        title1.setFont(new Font("Times New Roman ",Font.BOLD, 50));
        title1.setBounds(200, 140, jPanel.getWidth(), 80);
        jPanel.add(title1);
        title1.setForeground(Color.WHITE);

        JLabel title2;
        title2 = new JLabel("Management System",SwingUtilities.LEFT);
        title2.setFont(new Font("Times New Roman ",Font.BOLD, 50));
        title2.setBounds(390, 210, jPanel.getWidth(), 80);
        jPanel.add(title2);
        title2.setForeground(Color.WHITE);

//    JPanel overlay=new JPanel();
//    overlay.setBackground(new Color(255,255,255,80));
//    overlay.setBounds(0,0,jPanel.getWidth(),jPanel.getHeight());
//    jPanel.add(overlay);

        JPanel titlebar=new JPanel();
        titlebar.setBounds(0,20,jFrame.getWidth(),30);
        titlebar.setLayout(null);
        jPanel.add(titlebar);
        titlebar.setOpaque(false);

        JLabel home = new JLabel("Home");
        home.setFont(new Font("Star Jedi",Font.BOLD,17));
        home.setBounds(500, 5, 100, titlebar.getHeight());
        home.setForeground(Color.WHITE);
        titlebar.add(home);

        JLabel jnav1;
        jnav1 = new JLabel("Aircraft");
        jnav1.setFont(new Font("Star Jedi",Font.BOLD,17));
        jnav1.setBounds(650, 5, 100, titlebar.getHeight());
        titlebar.add(jnav1);
        jnav1.setForeground(Color.WHITE);

        JLabel jnav2;
        jnav2 = new JLabel("Maintainance");
        jnav2.setFont(new Font("Star Jedi",Font.BOLD,17));
        jnav2.setBounds(800, 5, 150, titlebar.getHeight());
        jnav2.setForeground(Color.WHITE);
        titlebar.add(jnav2);


        JLabel jnav3;
        jnav3 = new JLabel("User");
        jnav3.setFont(new Font("Star Jedi",Font.BOLD,17));
        jnav3.setBounds(980, 5, 100, titlebar.getHeight());
        titlebar.add(jnav3);
        jnav3.setForeground(Color.WHITE);


        JLabel jnav4;
        jnav4= new JLabel("Reports");
        jnav4.setFont(new Font("Star Jedi",Font.BOLD,17));
        jnav4.setBounds(1100, 5, 100, titlebar.getHeight());
        titlebar.add(jnav4);
        jnav4.setForeground(Color.WHITE);


        JButton diagram;
        diagram = new JButton("ER diagram");
        diagram.setBounds(80, 300, 100, titlebar.getHeight());
//        jPanel.add(diagram);

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setForeground(Color.BLACK);
                home.setText( "<html>Home</html>");
                home.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                home.setForeground(Color.WHITE);
                home.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                home.setText("Home");
            }
            public void mouseClicked(MouseEvent e) {
                MainScreen mainScreen = new MainScreen();
                jFrame.dispose();
            }
        });

        jnav1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jnav1.setForeground(Color.BLACK);
                jnav1.setText( "<html>Aircraft</html>");
                jnav1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jnav1.setForeground(Color.WHITE);
                jnav1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav1.setText("Aircraft");
            }
            public void mouseClicked(MouseEvent e) {
                Aircraft aircraft=new Aircraft();
                jFrame.dispose();
            }
        });

        jnav2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jnav2.setForeground(Color.BLACK);
                jnav2.setText( "<html>Maintainance</html>");
                jnav2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jnav2.setForeground(Color.WHITE);
                jnav2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav2.setText("Maintainance");
            }
            public void mouseClicked(MouseEvent e) {
                Maintenance maintenance = new Maintenance();
                jFrame.dispose();
            }
        });

        jnav3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jnav3.setForeground(Color.BLACK);
                jnav3.setText( "<html>User</html>");
                jnav3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jnav3.setForeground(Color.WHITE);
                jnav3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav3.setText("User");
            }
            public void mouseClicked(MouseEvent e) {
                try {
                    User user=new User();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                jFrame.dispose();
            }
        });

        jnav4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jnav4.setForeground(Color.BLACK);
                jnav4.setText( "<html>Reports</html>");
                jnav4.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jnav4.setForeground(Color.WHITE);
                jnav4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav4.setText("Reports");
            }
            public void mouseClicked(MouseEvent e) {
                Reports reports=new Reports();
                jFrame.dispose();
            }
        });

        String content=
                "Welcome to the Aircraft Maintenance Management System (AMMS), your comprehensive solution for organizing and managing aircraft maintenance tasks efficiently.This user-friendly interface serves as your gateway to streamlined aircraft maintenance processes,ensuring the safety and reliability of your fleet.\n" ;
        JTextArea text;
        text = new JTextArea(505, 505);
        text.setBounds(200,330,600,700);
//        text.setBounds(652 450, 545, 155);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Poppins",Font.PLAIN,17));
        text.setForeground(new Color(255, 255, 255, 255));
        jPanel.add(text);
//        text.setForeground(Color.WHITE);
        text.setText(content);
        text.setTabSize(0);
        text.setOpaque(false);

        jPanel.repaint();
        jPanel.revalidate();
        titlebar.repaint();
        titlebar.revalidate();
        jFrame.repaint();
        jFrame.revalidate();

    }
}

public class MainScreenMain {
    public static void main(String[] args) {
    }
}
