import com.jdbc.Connectionprovider;
// import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

class Aircraft{

    int noOfB737;
    int noOfA350;
    int noOfA380;

    public Aircraft() {

        JFrame jframe = new JFrame("Aircraft Details");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setVisible(true);

        JPanel jPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("aircrafts.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0, 0, 0, 80));
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jframe.getWidth(), jframe.getHeight());
        jframe.add(jPanel);

        JPanel titlebar = new JPanel();
        titlebar.setBounds(0, 20, jframe.getWidth(), 30);
        titlebar.setLayout(null);
        jPanel.add(titlebar);
        titlebar.setOpaque(false);

        JLabel home = new JLabel("Home");
        home.setFont(new Font("Star Jedi", Font.BOLD, 17));
        home.setBounds(500, 5, 100, titlebar.getHeight());
        home.setForeground(Color.WHITE);
        titlebar.add(home);

        JLabel jnav1;
        jnav1 = new JLabel("Aircraft");
        jnav1.setFont(new Font("Star Jedi", Font.BOLD, 17));
        jnav1.setBounds(650, 5, 100, titlebar.getHeight());
        titlebar.add(jnav1);
        jnav1.setForeground(Color.WHITE);


        JLabel jnav2;
        jnav2 = new JLabel("Maintainance");
        jnav2.setFont(new Font("Star Jedi", Font.BOLD, 17));
        jnav2.setBounds(800, 5, 150, titlebar.getHeight());
        jnav2.setForeground(Color.WHITE);
        titlebar.add(jnav2);


        JLabel jnav3;
        jnav3 = new JLabel("User");
        jnav3.setFont(new Font("Star Jedi", Font.BOLD, 17));
        jnav3.setBounds(980, 5, 100, titlebar.getHeight());
        titlebar.add(jnav3);
        jnav3.setForeground(Color.WHITE);


        JLabel jnav4;
        jnav4 = new JLabel("Reports");
        jnav4.setFont(new Font("Star Jedi", Font.BOLD, 17));
        jnav4.setBounds(1100, 5, 100, titlebar.getHeight());
        titlebar.add(jnav4);
        jnav4.setForeground(Color.WHITE);

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setForeground(Color.BLACK);
                home.setText("<html>Home</html>");
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
                jframe.dispose();
            }
        });

        jnav1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jnav1.setForeground(Color.BLACK);
                jnav1.setText("<html>Aircraft</html>");
                jnav1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jnav1.setForeground(Color.WHITE);
                jnav1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav1.setText("Aircraft");
            }

            public void mouseClicked(MouseEvent e) {

              
                AircraftMain aircraft = new AircraftMain();

            }
        });

        jnav2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jnav2.setForeground(Color.BLACK);
                jnav2.setText("<html>Maintainance</html>");
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
                jframe.dispose();
            }
        });

        jnav3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jnav3.setForeground(Color.BLACK);
                jnav3.setText("<html>User</html>");
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
                    User user = new User();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                jframe.dispose();
            }
        });

        jnav4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jnav4.setForeground(Color.BLACK);
                jnav4.setText("<html>Reports</html>");
                jnav4.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jnav4.setForeground(Color.WHITE);
                jnav4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav4.setText("Reports");
            }

            public void mouseClicked(MouseEvent e) {
                Reports reports = new Reports();
                jframe.dispose();
            }
        });

        JLabel headingLabel = new JLabel("Our Fleet of Aircrafts", SwingUtilities.LEFT);
        headingLabel.setBounds(30, 57, jPanel.getWidth(), 40);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        headingLabel.setForeground(Color.WHITE);
        jPanel.add(headingLabel);

//        ImageIcon imageIcon = new ImageIcon("737.jpg");
//        Image image = imageIcon.getImage().getScaledInstance(320, 200, Image.SCALE_DEFAULT);
//        JLabel imageLabel = new JLabel(new ImageIcon(image));
//        imageLabel.setBounds(20, 170, 320, 200);
//        jPanel.add(imageLabel);
       

        JLabel B737 = new JLabel("Aircraft Name: Boing 737");
        B737.setBounds(80, 380, 300, 30);
        B737.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        B737.setForeground(Color.WHITE);
        jPanel.add(B737);

//        JLabel totalCount737 = new JLabel("Total Count: " );
//        totalCount737.setBounds(90, 420, 300, 30);
//        totalCount737.setForeground(Color.WHITE);
//        totalCount737.setFont(new Font("Times New Roman", Font.PLAIN, 24));
//        jPanel.add(totalCount737);

//        ImageIcon imageIcon1 = new ImageIcon("A350Image.jpg");
//        Image image1 = imageIcon1.getImage().getScaledInstance(320, 200, Image.SCALE_DEFAULT);
//        JLabel imageLabel1 = new JLabel(new ImageIcon(image1));
//        imageLabel1.setBounds(470, 170, 320, 200);
//        jPanel.add(imageLabel1);

        JLabel A350 = new JLabel("Aircraft Name: Airbus A350");
        A350.setBounds(500, 380, 300, 30);
        A350.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        A350.setForeground(Color.WHITE);
        jPanel.add(A350);

////        int maxCount = 0;
////        try {
////            Connection connection = Connectionprovider.getconnection();
////            String query2 = "SELECT COUNT(*) AS entryCount FROM MaintenanceA350";
////            Statement statement = connection.createStatement();
////            ResultSet resultSet = statement.executeQuery(query2);
////            if (resultSet.next()) {
////                maxCount = resultSet.getInt("entryCount");
////
////            }
//
//
//
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        } catch (ClassNotFoundException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        JLabel totalCount350 = new JLabel("Total Count: " );
//        totalCount350.setBounds(510, 420, 200, 30);
//        totalCount350.setForeground(Color.WHITE);
//        totalCount350.setFont(new Font("Times New Roman", Font.PLAIN, 24));
//        jPanel.add(totalCount350);

//        ImageIcon imageIcon2 = new ImageIcon("A380Image.jpg");
//        Image image2 = imageIcon2.getImage().getScaledInstance(320, 200, Image.SCALE_DEFAULT);
//        JLabel imageLabel2 = new JLabel(new ImageIcon(image2));
//        imageLabel2.setBounds(870, 170, 320, 200);
//        jPanel.add(imageLabel2);

        JLabel A380 = new JLabel("Aircraft Name: Airbus A380");
        A380.setBounds(890, 380, 300, 30);
        A380.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        A380.setForeground(Color.WHITE);
        jPanel.add(A380);

//
//        JLabel totalCount380 = new JLabel("Total Count: " );
//        totalCount380.setBounds(900, 420, 200, 30);
//        totalCount380.setForeground(Color.WHITE);
//        totalCount380.setFont(new Font("Times New Roman", Font.PLAIN, 24));
//        jPanel.add(totalCount380);

//
//        Connection connection = null;
//        try {
//            connection = Connectionprovider.getconnection();
//
//            // Query for B737 count
//            String query1 = "SELECT COUNT(*) AS entryCount FROM MaintenanceB737";
//            Statement statement1 = connection.createStatement();
//            ResultSet resultSet1 = statement1.executeQuery(query1);
//            if (resultSet1.next()) {
//                int maxCount2 = resultSet1.getInt("entryCount");
//                totalCount737.setText("total count : "+maxCount2);
//            }
//
//            // Query for A350 count
//            String query2 = "SELECT COUNT(*) AS entryCount FROM MaintenanceA350";
//            Statement statement2 = connection.createStatement();
//            ResultSet resultSet2 = statement2.executeQuery(query2);
//            if (resultSet2.next()) {
//                int maxCount = resultSet2.getInt("entryCount");
//                totalCount350.setText("total count : "+maxCount);
//            }
//
//            // Query for A380 count
//            String query3 = "SELECT COUNT(*) AS entryCount FROM MaintenanceA380";
//            Statement statement3 = connection.createStatement();
//            ResultSet resultSet3 = statement3.executeQuery(query3);
//            if (resultSet3.next()) {
//                int maxCount1 = resultSet3.getInt("entryCount");
//                totalCount380.setText("total count : "+maxCount1);
//
//            }
//
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        } catch (ClassNotFoundException ex) {
//            throw new RuntimeException(ex);
//        } finally {
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        }

//        int maxCount1 = 0;
//        try {
//            Connection connection = Connectionprovider.getconnection();
//            String query3 = "SELECT COUNT(*) AS entryCount FROM MaintenanceA380";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query3);
//            if (resultSet.next()) {
//                maxCount1 = resultSet.getInt("entryCount");
//
//            }
//
//
//            connection.close();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        } catch (ClassNotFoundException ex) {
//            throw new RuntimeException(ex);
//        }



        JLabel jLabel = new JLabel("To add an aircraft to the fleet: ");
        jLabel.setBounds(50, 500, 400, 40);
        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        jPanel.add(jLabel);

        RoundedButton roundedButton = new RoundedButton("Click Here", 50, 50);
        roundedButton.setBounds(450, 500, 140, 40);
        roundedButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        roundedButton.setForeground(Color.WHITE);
        roundedButton.setBackground(Color.BLACK);
        jPanel.add(roundedButton);

        roundedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        addAircraft aircraft = new addAircraft();
                        jframe.dispose();
                    }
                });

            }
        });

        jPanel.repaint();
    }
}


public class AircraftMain {
    public static void main(String[] args) {

    }
}
