import com.jdbc.Connectionprovider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

class User{
    public User() throws SQLException, ClassNotFoundException {
        JFrame jFrame = new JFrame();
        jFrame.getContentPane().setBackground(Color.BLACK);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);


        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("mainscreen2.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jFrame.add(jPanel);

        JPanel titlebar=new JPanel();
        titlebar.setBounds(0,20,jFrame.getWidth(),30);
        titlebar.setLayout(null);
        jPanel.add(titlebar);
        titlebar.setOpaque(false);

        JLabel home = new JLabel("Home");
        home.setFont(new Font("Star Jedi",Font.BOLD,17));
        home.setBounds(700, 5, 100, titlebar.getHeight());
        titlebar.add(home);
        home.setForeground(Color.BLACK);

        JLabel jnav1;
        jnav1 = new JLabel("Aircraft");
        jnav1.setFont(new Font("Star Jedi",Font.BOLD,17));
        jnav1.setBounds(850, 5, 100, titlebar.getHeight());
        titlebar.add(jnav1);
        jnav1.setForeground(Color.BLACK);


        JLabel jnav2;
        jnav2 = new JLabel("Maintainance");
        jnav2.setFont(new Font("Star Jedi",Font.BOLD,17));
        jnav2.setBounds(1000, 5, 150, titlebar.getHeight());
        jnav2.setForeground(Color.BLACK);
        titlebar.add(jnav2);


        JLabel jnav3;
        jnav3 = new JLabel("User");
        jnav3.setFont(new Font("Star Jedi",Font.BOLD,17));
        jnav3.setBounds(1180, 5, 100, titlebar.getHeight());
        titlebar.add(jnav3);
        jnav3.setForeground(Color.BLACK);


        JLabel jnav4;
        jnav4= new JLabel("Reports");
        jnav4.setFont(new Font("Star Jedi",Font.BOLD,17));
        jnav4.setBounds(1300, 5, 100, titlebar.getHeight());
        titlebar.add(jnav4);
        jnav4.setForeground(Color.BLACK);


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
                // Restore original color or animation when mouse exits
                home.setForeground(Color.WHITE);
                home.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                home.setText("Home");// Restore default cursor
            }
            public void mouseClicked(MouseEvent e) {
                MainScreen mainScreen = new MainScreen();
                jFrame.dispose();
            }
        });

        jnav1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change color or trigger animation when mouse enters
                jnav1.setForeground(Color.BLACK);
                jnav1.setText( "<html>Aircraft</html>");
                jnav1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore original color or animation when mouse exits
                jnav1.setForeground(Color.BLACK);
                jnav1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav1.setText("Aircraft");// Restore default cursor
            }
            public void mouseClicked(MouseEvent e) {
                Aircraft aircraft=new Aircraft();
                jFrame.dispose();
            }
        });

        jnav2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change color or trigger animation when mouse enters
                jnav2.setForeground(Color.BLACK);
                jnav2.setText( "<html>Maintainance</html>");
                jnav2.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to indicate interaction
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore original color or animation when mouse exits
                jnav2.setForeground(Color.BLACK);
                jnav2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav2.setText("Maintainance");// Restore default cursor
            }
            public void mouseClicked(MouseEvent e) {
                Maintenance maintainance=new Maintenance();
                jFrame.dispose();
            }
        });


        jnav3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change color or trigger animation when mouse enters
                jnav3.setForeground(Color.BLACK);
                jnav3.setText( "<html>User</html>");

                jnav3.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore original color or animation when mouse exits
                jnav3.setForeground(Color.BLACK);
                jnav3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav3.setText("User");

            }
            public void mouseClicked(MouseEvent e) {
                try {
                    User user=new User();
                    jFrame.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jnav4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change color or trigger animation when mouse enters
                jnav4.setForeground(Color.BLACK);
                jnav4.setText( "<html>Reports</html>");
                jnav4.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to indicate interaction
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restore original color or animation when mouse exits
                jnav4.setForeground(Color.BLACK);
                jnav4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jnav4.setText("Reports");// Restore default cursor
            }
            public void mouseClicked(MouseEvent e) {
                ReportsMain reports=new ReportsMain();
                jFrame.dispose();
            }
        });




        JLabel jLabel = new JLabel("User profile", SwingUtilities.LEFT);
        jLabel.setBounds(40, 80, jFrame.getWidth(), 45);
        jLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        jLabel.setForeground(Color.BLACK);
        jPanel.add(jLabel);


        JLabel jLabel1 = new JLabel("Full Name:");
        jLabel1.setBounds(40, 140, 400, 40);
        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jLabel1.setForeground(Color.BLACK);
        jPanel.add(jLabel1);



        JLabel fullname1 = new JLabel();
        fullname1.setBounds(160, 140, 320, 40);
        fullname1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        fullname1.setForeground(Color.BLACK);
        jPanel.add(fullname1);



        JLabel jLabel2 = new JLabel("EMail ID:");
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setBounds(40, 190, 400, 40);
        jLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jLabel2);


        JLabel emailid1 = new JLabel();
        emailid1.setBounds(160, 190, 320, 40);
        emailid1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        emailid1.setForeground(Color.BLACK);
        jPanel.add(emailid1);

        JLabel jLabel3 = new JLabel("Mobile No:");
        jLabel3.setForeground(Color.BLACK);
        jLabel3.setBounds(40, 240, 400, 40);
        jLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jLabel3);


        JLabel phoneno1 = new JLabel();
        phoneno1.setBounds(160, 240, 320, 40);
        phoneno1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        phoneno1.setForeground(Color.BLACK);
        jPanel.add(phoneno1);


        JLabel jLabel4 = new JLabel("Username: ");
        jLabel4.setBounds(40, 290, 400, 40);
        jLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jLabel4.setForeground(Color.BLACK);
        jPanel.add(jLabel4);


        JLabel usernam = new JLabel();
        usernam.setBounds(160, 290, 320, 40);
        usernam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        usernam.setForeground(Color.BLACK);
        jPanel.add(usernam);


        RoundedButton jButton = new RoundedButton("Logout",30,30);
        jButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jButton.setForeground(Color.BLACK);
        jButton.setBackground(new Color(219, 120, 75));
        jButton.setBounds(jFrame.getWidth()/4 - 100 + 100, 400, 140, 40);
        jPanel.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBMSLoginPage new1=new DBMSLoginPage();
            }
        });

        
        String username1 = DBMSLoginPage.getusername();
        ResultSet set = null;

        try {
            Connection connection = Connectionprovider.getconnection();
            String quary1 = "select * from userdata where username='" + username1+"'";
            Statement st = connection.createStatement();

            set = st.executeQuery(quary1);
            while (set.next()) {
                String fullname = set.getString(1);
                String emailid = set.getString(2);
                String phoneno = set.getString(3);
                String username=set.getString(4);

                fullname1.setText(fullname);
                emailid1.setText(emailid);
                phoneno1.setText(phoneno);
                usernam.setText(username);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        RoundedButton jButton2 = new RoundedButton("Update Info ", 30, 30);
        jButton2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jButton2.setForeground(Color.BLACK);
        jButton2.setBackground(new Color(219, 120, 75));
        jButton2.setBounds(((jFrame.getWidth()) / 8) - 100, 400, 180, 40);
        jPanel.add(jButton2);



        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updatinginfo update=new updatinginfo();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}


class updatinginfo {
    public updatinginfo()  throws SQLException, ClassNotFoundException {

        JFrame jFrame = new JFrame();
        jFrame.getContentPane().setBackground(Color.BLACK);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);


        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("mainscreen2.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jFrame.add(jPanel);


        JLabel jLabel = new JLabel("User profile", SwingUtilities.CENTER);
        jLabel.setBounds(0, 20, jFrame.getWidth(), 45);
        jLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        jLabel.setForeground(Color.BLACK);
        jPanel.add(jLabel);


        JLabel jLabel1 = new JLabel("Username:");
        jLabel1.setBounds(40, 120, 400, 40);
        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jLabel1.setForeground(Color.BLACK);
        jPanel.add(jLabel1);


        JLabel fullname1 = new JLabel();
        fullname1.setBounds(210, 120, 320, 40);
        fullname1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        fullname1.setForeground(Color.BLACK);
        jPanel.add(fullname1);


        JLabel jLabel2 = new JLabel(" new EMail ID:");
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setBounds(40, 190, 400, 40);
        jLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jLabel2);



        JTextField textField1 = new RoundedTextField(15, 20, 20);
        textField1.setBounds(210, 190, 320, 40);
        textField1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField1.setForeground(Color.BLACK);
        jPanel.add(textField1);

        JLabel jLabel3 = new JLabel(" new Mobile No:");
        jLabel3.setForeground(Color.BLACK);
        jLabel3.setBounds(40, 270, 400, 40);
        jLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jLabel3);


        JTextField  textField2 = new RoundedTextField(15, 20, 20);
        textField2.setBounds(210, 270, 320, 40);
        textField2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField2.setForeground(Color.BLACK);
        jPanel.add(textField2);

        JLabel jLabel4 = new JLabel(" Full Name: ");
        jLabel4.setBounds(40, 340, 400, 40);
        jLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jLabel4.setForeground(Color.BLACK);
        jPanel.add(jLabel4);


        JLabel usernam = new JLabel();
        usernam.setBounds(210, 340, 320, 40);
        usernam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        usernam.setForeground(Color.BLACK);
        jPanel.add(usernam);

        RoundedTextField textField3 =  new RoundedTextField(15, 20, 20);
        textField3.setBounds(210, 340, 320, 40);
        textField3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField3.setForeground(Color.BLACK);
        jPanel.add(textField3);

        JLabel jLabel5 = new JLabel(" new Password:");
        jLabel5.setBounds(40, 410, 400, 40);
        jLabel5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jLabel5.setForeground(Color.BLACK);
        jPanel.add(jLabel5);

        RoundedTextField textField4 =  new RoundedTextField(15, 20, 20);
        textField4.setBounds(210, 410, 320, 40);
        textField4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField4.setForeground(Color.BLACK);
        jPanel.add(textField4);

        RoundedButton jButton = new RoundedButton("Confirm ", 30, 30);
        jButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jButton.setForeground(Color.BLACK);
        jButton.setBackground(new Color(219, 120, 75));
        jButton.setBounds((jPanel.getWidth() / 2) - 100, 520, 180, 40);
        jPanel.add(jButton);

        String username1 = DBMSLoginPage.getusername();
        ResultSet set = null;

        try {
            Connection connection = Connectionprovider.getconnection();
            String quary1 = "select * from userdata where username='" + username1 + "'";
            Statement st = connection.createStatement();

            set = st.executeQuery(quary1);
            while (set.next()) {
                String fullname = set.getString(1);
                String username = set.getString(4);
                fullname1.setText(username);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String emailid=textField1.getText();
                String phoneno=textField2.getText();
                String fullname=textField3.getText();
                String password=textField4.getText();
                try {
                    Connection connection = Connectionprovider.getconnection();
                    String quary1 = "Update userdata set emailid=?,mobile_no=?,fullname=?,pass=?  where  username='"+username1+"'";

                    PreparedStatement ps = connection.prepareStatement(quary1);
                    ps.setString(1, emailid);
                    ps.setString(2, phoneno);
                    ps.setString(3, fullname);
                    ps.setString(4, password);
                    ps.executeUpdate();
                    connection.close();

                } catch (Exception ne) {
                    ne.printStackTrace();
                }
                DBMSLoginPage new1=new DBMSLoginPage();
            }
        });
    }
}
public class UserMain {
    public static void main(String[] args) {

    }
}
