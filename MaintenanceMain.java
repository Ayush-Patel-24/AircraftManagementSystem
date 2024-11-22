import com.jdbc.Connectionprovider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
class RoundedDialog extends JDialog {
    public RoundedDialog(JFrame parent, String title, String message) {
        super(parent, title, true);
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(message);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(messageLabel, BorderLayout.CENTER);

        setSize(330, 100);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int cornerRadius = 80;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        super.paint(g2d);

        g2d.dispose();
    }
}

class Maintenance{


    public String selectedAircraft;
    public static String regNumber;
    public Maintenance(){
        JFrame jframe=new JFrame("Maintainance Page");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setVisible(true);
        jframe.getContentPane().setBackground(Color.BLACK);

        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("AircraftBackground.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0,0,0,80));
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jframe.getWidth(), jframe.getHeight());
        jframe.add(jPanel);

        JPanel titlebar=new JPanel();
        titlebar.setBounds(0,20,jframe.getWidth(),30);
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
                jframe.dispose();
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
                AircraftMain aircraft=new AircraftMain();
                jframe.dispose();
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
                jframe.dispose();
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
                jframe.dispose();
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
                jframe.dispose();
            }
        });
        JLabel headingLabel = new JLabel("Maintenance Hanger",SwingUtilities.LEFT);
        headingLabel.setBounds(20,100,jPanel.getWidth(),50);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,50));
        headingLabel.setForeground(Color.WHITE);
        jPanel.add(headingLabel);

        JLabel jLabel = new JLabel("Which Aircraft type you wanted to maintain?");
        jLabel.setBounds(30,180,jPanel.getWidth(),40);
        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("Times New Roman", Font.PLAIN,26));
        jPanel.add(jLabel);


        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.addItem("Boing737");
        jComboBox.addItem("AirbusA350");
        jComboBox.addItem("AirbusA380");
        jComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jComboBox.setForeground(Color.WHITE);
        jComboBox.setBackground(Color.BLACK);
        jComboBox.setBounds(40,230,250,30);
        jPanel.add(jComboBox);

        JLabel jLabel1 = new JLabel("Enter the regestration number of the aircraft:");
        jLabel1.setBounds(30,300,jPanel.getWidth(),40);
        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN,24));
        jLabel1.setForeground(Color.WHITE);
        jPanel.add(jLabel1);

        RoundedTextField roundedTextField = new RoundedTextField(15,50,50);
        roundedTextField.setFont(new Font("Times New Roman", Font.PLAIN,24));
        roundedTextField.setOpaque(false);
        roundedTextField.setForeground(Color.WHITE);
        roundedTextField.setBounds(40,350,150,40);
        jPanel.add(roundedTextField);
        regNumber = roundedTextField.getText();

        JButton next = new JButton("Next");
        next.setBounds(60,400,150,40);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Times New Roman", Font.PLAIN,24));
        jPanel.add(next);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jComboBox.getSelectedItem().equals("Boing737")){
                    selectedAircraft = "Boing737";
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            Maintain737 maintain737 = new Maintain737();
                        }
                    });
                }else if (jComboBox.getSelectedItem().equals("AirbusA350")) {
                    selectedAircraft = "AirbusA350";
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            MaintainA350 maintainA350 = new MaintainA350();
                        }
                    });
                } else if(jComboBox.getSelectedItem().equals("AirbusA380")){
                    selectedAircraft = "AirbusA380";
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            MaintainA380 maintainA380 = new MaintainA380();
                        }
                    });
                }
            }
        });
    }



    public String getSelectedAircraft(){
        return selectedAircraft;
    }
    public static String getRegNumber(){
        return  regNumber;
    }
}

class Maintain737{
    public Maintain737(){
        JFrame jFrame = new JFrame("Maintain Boing 737");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setLayout(null);

        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("AircraftBackground.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jFrame.add(jPanel);

        JLabel headingLabel = new JLabel("Boing 737 Maintenance Hanger",SwingUtilities.CENTER);
        headingLabel.setBounds(0,20,jPanel.getWidth(),50);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,40));
        jPanel.add(headingLabel);

        JLabel jLabel = new JLabel("Here's the Check List For the maintenance of Boing 737 aircraft: ",SwingUtilities.LEFT);
        jLabel.setFont(new Font("Times New Roman", Font.PLAIN,26));
        jLabel.setForeground(Color.WHITE);
        jLabel.setBounds(30,75,jPanel.getWidth(),30);
        jPanel.add(jLabel);

        JCheckBox jCheckBox = new JCheckBox("See the Tech Log of the Aircraft and resolve any issues if reported.");
        jCheckBox.setBounds(30,120,jPanel.getWidth(),30);
        jCheckBox.setOpaque(false);
        jCheckBox.setForeground(Color.WHITE);
        jCheckBox.setFont(new Font("Times New Roman",Font.PLAIN, 24));
        jPanel.add(jCheckBox);

        JCheckBox jCheckBox1 = new JCheckBox("Perform a regular inspection of Aircraft by going around the aircraft and check for any visible damage. If spoted than fix it.");
        jCheckBox1.setBounds(30,170,jPanel.getWidth(),30);
        jCheckBox1.setForeground(Color.WHITE);
        jCheckBox1.setOpaque(false);
        jCheckBox1.setFont(new Font("Times New Roman",Font.PLAIN,24));
        jPanel.add(jCheckBox1);

        JCheckBox jCheckBox2 = new JCheckBox("Then inspect landing gears of the aircraft change the tires if needed");
        jCheckBox2.setOpaque(false);
        jCheckBox2.setBounds(30,220,jPanel.getWidth(),30);
        jCheckBox2.setForeground(Color.WHITE);
        jCheckBox2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jCheckBox2);

        JCheckBox jCheckBox3 = new JCheckBox("Check every tudes like pitot tudes and static probes on both the sides of the aircraft ");
        jCheckBox3.setFont(new Font("Times New Roman", Font.PLAIN,24));
        jCheckBox3.setOpaque(false);
        jCheckBox3.setForeground(Color.WHITE);
        jCheckBox3.setBounds(30,270,jPanel.getWidth(),30);
        jPanel.add(jCheckBox3);

        JCheckBox jCheckBox4 = new JCheckBox("Inspect both aircraft jet engines closely for cracks in the blades; if found, fix them immediately to prevent potential danger.");
        jCheckBox4.setBounds(30,320,jPanel.getWidth(),30);
        jCheckBox4.setForeground(Color.WHITE);
        jCheckBox4.setOpaque(false);
        jCheckBox4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jCheckBox4);

        JCheckBox jCheckBox5 = new JCheckBox("Then check the hydrolic fluides inside the aircraft if found less, refill it.");
        jCheckBox5.setFont(new Font("Times New Roman", Font.PLAIN,24));
        jCheckBox5.setOpaque(false);
        jCheckBox5.setForeground(Color.WHITE);
        jCheckBox5.setBounds(30,370,jPanel.getWidth(),24);
        jPanel.add(jCheckBox5);

        RoundedButton roundedButton = new RoundedButton("Complete Maintenance",20,20);
        roundedButton.setBounds((jPanel.getWidth())/2 - 150,470,300,40);
        roundedButton.setFont(new Font("Times New Roman", Font.PLAIN,24));
        roundedButton.setForeground(Color.WHITE);
        roundedButton.setBackground(Color.BLACK);
        jPanel.add(roundedButton);

        JLabel jLabel1 = new JLabel("Maintainance cost");
        jLabel1.setBounds(10,440,200,40);
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN,20));
        jPanel.add(jLabel1);

        RoundedTextField roundedTextField = new RoundedTextField(15,30,30);
        roundedTextField.setBounds(200,440,300,30);
        roundedTextField.setForeground(Color.WHITE);
        roundedTextField.setFont(new Font("Times New Roman", Font.PLAIN,25));
        roundedTextField.setOpaque(false);
        jPanel.add(roundedTextField);


        roundedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jCheckBox.isSelected()&&jCheckBox1.isSelected()&&jCheckBox2.isSelected()&&jCheckBox3.isSelected()&&jCheckBox4.isSelected()&&jCheckBox5.isSelected()){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            MainScreen mainScreen = new MainScreen();
                            jFrame.dispose();
                        }
                    });
                }else{
                    RoundedDialog roundedDialog = new RoundedDialog(jFrame,"Alert","Please complete all the things in the Check List.");
                }
                String RegNO=Maintenance.getRegNumber();
                int cost=Integer.parseInt(roundedTextField.getText());
                String name=DBMSLoginPage.getusername();
                try{
                    Connection connection= Connectionprovider.getconnection();
                    String query1 = "INSERT INTO  maintenanceB737(maintenanceCost,MaintenanceDate,username) VALUES("+cost+",CURDATE(),'"+name+"');";
                    Statement statement= connection.createStatement();
                    statement.executeUpdate(query1);
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jPanel.repaint();
    }
}
class MaintainA350{
    int i=1;

    public MaintainA350(){
        JFrame jFrame = new JFrame("Maintain Airbus A350");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setLayout(null);

        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("AircraftBackground.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jFrame.add(jPanel);

        // jPanel.setBorder(null);

        JLabel headingLabel = new JLabel("Airbus A350 Maintenance Hanger",SwingUtilities.CENTER);
        headingLabel.setBounds(0,20,jPanel.getWidth(),50);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,40));
        jPanel.add(headingLabel);

        JLabel jLabel = new JLabel("Here's the Check List For the maintenance of Airbus A350 aircraft: ",SwingUtilities.LEFT);
        jLabel.setFont(new Font("Times New Roman", Font.PLAIN,26));
        jLabel.setForeground(Color.WHITE);
        jLabel.setBounds(30,75,jPanel.getWidth(),30);
        jPanel.add(jLabel);

        JCheckBox jCheckBox = new JCheckBox("See the Tech Log of the Aircraft and resolve any issues if reported.");
        jCheckBox.setBounds(30,120,jPanel.getWidth(),30);
        jCheckBox.setOpaque(false);
        jCheckBox.setForeground(Color.WHITE);
        jCheckBox.setFont(new Font("Times New Roman",Font.PLAIN, 24));
        jPanel.add(jCheckBox);

        JCheckBox jCheckBox1 = new JCheckBox("Perform a regular inspection of Aircraft by going around the aircraft and check for any visible damage. If spoted than fix it.");
        jCheckBox1.setBounds(30,170,jPanel.getWidth(),30);
        jCheckBox1.setForeground(Color.WHITE);
        jCheckBox1.setOpaque(false);
        jCheckBox1.setFont(new Font("Times New Roman",Font.PLAIN,24));
        jPanel.add(jCheckBox1);

        JCheckBox jCheckBox2 = new JCheckBox("Then inspect landing gears of the aircraft change the tires if needed");
        jCheckBox2.setOpaque(false);
        jCheckBox2.setBounds(30,220,jPanel.getWidth(),30);
        jCheckBox2.setForeground(Color.WHITE);
        jCheckBox2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jCheckBox2);

        JCheckBox jCheckBox3 = new JCheckBox("Check every tudes like pitot tudes and static probes on both the sides of the aircraft ");
        jCheckBox3.setFont(new Font("Times New Roman", Font.PLAIN,24));
        jCheckBox3.setOpaque(false);
        jCheckBox3.setForeground(Color.WHITE);
        jCheckBox3.setBounds(30,270,jPanel.getWidth(),30);
        jPanel.add(jCheckBox3);

        JCheckBox jCheckBox4 = new JCheckBox("Inspect both aircraft jet engines closely for cracks in the blades; if found, fix them immediately to prevent potential danger.");
        jCheckBox4.setBounds(30,320,jPanel.getWidth(),30);
        jCheckBox4.setForeground(Color.WHITE);
        jCheckBox4.setOpaque(false);
        jCheckBox4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jCheckBox4);
        
        JCheckBox jCheckBox5 = new JCheckBox("Then check the hydrolic fluides inside the aircraft if found less, refill it.");
        jCheckBox5.setFont(new Font("Times New Roman", Font.PLAIN,24));
        jCheckBox5.setOpaque(false);
        jCheckBox5.setForeground(Color.WHITE);
        jCheckBox5.setBounds(30,370,jPanel.getWidth(),24);
        jPanel.add(jCheckBox5);


        JLabel jLabel1 = new JLabel("Maintainance cost");
        jLabel1.setBounds(10,440,200,40);
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN,20));
        jPanel.add(jLabel1);

        RoundedTextField roundedTextField = new RoundedTextField(15,30,30);
        roundedTextField.setBounds(200,440,300,30);
        roundedTextField.setForeground(Color.WHITE);
        roundedTextField.setFont(new Font("Times New Roman", Font.PLAIN,25));
        roundedTextField.setOpaque(false);
        jPanel.add(roundedTextField);

        RoundedButton roundedButton = new RoundedButton("Complete Maintenance",20,20);
        roundedButton.setBounds((jPanel.getWidth())/2 - 150,470,300,40);
        roundedButton.setFont(new Font("Times New Roman", Font.PLAIN,24));
        roundedButton.setForeground(Color.WHITE);
        roundedButton.setBackground(Color.BLACK);
        jPanel.add(roundedButton);

        roundedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jCheckBox.isSelected()&&jCheckBox1.isSelected()&&jCheckBox2.isSelected()&&jCheckBox3.isSelected()&&jCheckBox4.isSelected()&&jCheckBox5.isSelected()&&!(roundedTextField.getText()).equals("")){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            MainScreen mainScreen = new MainScreen();
                            jFrame.dispose();

                        }
                    });
                }else{
                    RoundedDialog roundedDialog = new RoundedDialog(jFrame,"Alert","Please complete all the things in the Check List.");
                }

                String RegNO=Maintenance.getRegNumber();
                int cost=Integer.parseInt(roundedTextField.getText());
                String name=DBMSLoginPage.getusername();

                try{
                    Connection connection= Connectionprovider.getconnection();
                    String query1 = "INSERT INTO  maintenancea350(maintenanceCost,MaintenanceDate,username) VALUES("+cost+",CURDATE(),'"+name+"');";
                    Statement statement= connection.createStatement();
                    statement.executeUpdate(query1);
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        jPanel.repaint();
    }
}


class MaintainA380{
    public MaintainA380(){
        JFrame jFrame = new JFrame("Maintain Airbus A380");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setLayout(null);

        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("AircraftBackground.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jFrame.add(jPanel);

        JLabel headingLabel = new JLabel("Airbus A380 Maintenance Hanger",SwingUtilities.CENTER);
        headingLabel.setBounds(0,20,jPanel.getWidth(),50);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,40));
        jPanel.add(headingLabel);

        JLabel jLabel = new JLabel("Here's the Check List For the maintenance of Airbus A380 aircraft: ",SwingUtilities.LEFT);
        jLabel.setFont(new Font("Times New Roman", Font.PLAIN,26));
        jLabel.setForeground(Color.WHITE);
        jLabel.setBounds(30,75,jPanel.getWidth(),30);
        jPanel.add(jLabel);

        JCheckBox jCheckBox = new JCheckBox("See the Tech Log of the Aircraft and resolve any issues if reported.");
        jCheckBox.setBounds(30,120,jPanel.getWidth(),30);
        jCheckBox.setOpaque(false);
        jCheckBox.setForeground(Color.WHITE);
        jCheckBox.setFont(new Font("Times New Roman",Font.PLAIN, 24));
        jPanel.add(jCheckBox);

        JCheckBox jCheckBox1 = new JCheckBox("Perform a regular inspection of Aircraft by going around the aircraft and check for any visible damage. If spoted than fix it.");
        jCheckBox1.setBounds(30,170,jPanel.getWidth(),30);
        jCheckBox1.setForeground(Color.WHITE);
        jCheckBox1.setOpaque(false);
        jCheckBox1.setFont(new Font("Times New Roman",Font.PLAIN,24));
        jPanel.add(jCheckBox1);

        JCheckBox jCheckBox2 = new JCheckBox("Then inspect landing gears of the aircraft change the tires if needed");
        jCheckBox2.setOpaque(false);
        jCheckBox2.setBounds(30,220,jPanel.getWidth(),30);
        jCheckBox2.setForeground(Color.WHITE);
        jCheckBox2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jCheckBox2);

        JCheckBox jCheckBox3 = new JCheckBox("Check every tudes like pitot tudes and static probes on both the sides of the aircraft ");
        jCheckBox3.setFont(new Font("Times New Roman", Font.PLAIN,24));
        jCheckBox3.setOpaque(false);
        jCheckBox3.setForeground(Color.WHITE);
        jCheckBox3.setBounds(30,270,jPanel.getWidth(),30);
        jPanel.add(jCheckBox3);

        JCheckBox jCheckBox4 = new JCheckBox("Inspect all four aircraft jet engines closely for cracks in the blades; if found, fix them immediately to prevent potential danger.");
        jCheckBox4.setBounds(30,320,jPanel.getWidth(),30);
        jCheckBox4.setForeground(Color.WHITE);
        jCheckBox4.setOpaque(false);
        jCheckBox4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jPanel.add(jCheckBox4);

        JCheckBox jCheckBox5 = new JCheckBox("Then check the hydrolic fluides inside the aircraft if found less, refill it.");
        jCheckBox5.setFont(new Font("Times New Roman", Font.PLAIN,24));
        jCheckBox5.setOpaque(false);
        jCheckBox5.setForeground(Color.WHITE);
        jCheckBox5.setBounds(30,370,jPanel.getWidth(),24);
        jPanel.add(jCheckBox5);
        JLabel jLabel1 = new JLabel("Maintainance cost");
        jLabel1.setBounds(10,440,200,40);
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN,20));
        jPanel.add(jLabel1);

        RoundedTextField roundedTextField = new RoundedTextField(15,30,30);
        roundedTextField.setBounds(200,440,300,30);
        roundedTextField.setForeground(Color.WHITE);
        roundedTextField.setFont(new Font("Times New Roman", Font.PLAIN,25));
        roundedTextField.setOpaque(false);
        jPanel.add(roundedTextField);

        RoundedButton roundedButton = new RoundedButton("Complete Maintenance",20,20);
        roundedButton.setBounds((jPanel.getWidth())/2 - 150,470,300,40);
        roundedButton.setFont(new Font("Times New Roman", Font.PLAIN,24));
        roundedButton.setForeground(Color.WHITE);
        roundedButton.setBackground(Color.BLACK);
        jPanel.add(roundedButton);

        roundedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jCheckBox.isSelected()&&jCheckBox1.isSelected()&&jCheckBox2.isSelected()&&jCheckBox3.isSelected()&&jCheckBox4.isSelected()&&jCheckBox5.isSelected()){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            MainScreen mainScreen = new MainScreen();
                            jFrame.dispose();

                        }
                    });
                }else{
                    RoundedDialog roundedDialog = new RoundedDialog(jFrame,"Alert","Please complete all the things in the Check List.");
                }
                String RegNO=Maintenance.getRegNumber();
                int cost=Integer.parseInt(roundedTextField.getText());
                String name=DBMSLoginPage.getusername();

                try{
                    Connection connection= Connectionprovider.getconnection();
                    String query1 = "INSERT INTO  maintenancea380(maintenanceCost,MaintenanceDate,username) VALUES("+cost+",CURDATE(),'"+name+"');";
                    Statement statement= connection.createStatement();
                    statement.executeUpdate(query1);
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        jPanel.repaint();
    }
}

public class MaintenanceMain {
    public static void main(String[] args) {

    }
}
