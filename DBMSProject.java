import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import java.util.ArrayList;
import com.jdbc.Connectionprovider;

class RoundedButton extends JButton{
    private int arcWidth;
    private int arcHeight;

    public RoundedButton(String text, int arcWidth, int arcHeight) {
        super(text);
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setContentAreaFilled(false); // Make button transparent
        setFocusPainted(false); // Remove focus border
        setBorderPainted(false); // Remove border
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint the background with the button's background color
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));

        // Paint the text
        super.paintComponent(g2);
        g2.dispose();
    }
}
class RoundedPanel extends JPanel {
    private int arcWidth;
    private int arcHeight;

    public RoundedPanel(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        g2d.dispose();
    }
}

class RoundedTextField extends JTextField {
    private int arcWidth;
    private int arcHeight;

    public RoundedTextField(int columns, int arcWidth, int arcHeight) {
        super(columns);
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add some padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getForeground());
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
        g2d.dispose();
    }
}

class RoundedPasswordField extends JPasswordField{
    private int arcWidth;
    private int arcHeight;

    public RoundedPasswordField(int columns, int arcWidth, int arcHeight) {
        super(columns);
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add some padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getForeground());
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
        g2d.dispose();
    }
}

class DBMSLoginPage {
    private int yPos = -550;
    static  RoundedTextField jTextField;
    RoundedPasswordField jTextField1;
    String[] jobtype = {"Mechenic", "Conspector"};

    public static String getusername(){
        return jTextField.getText();
    }
    public DBMSLoginPage() {
        JFrame jFrame = new JFrame("DBMS Project Login Screen");
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("jumbo-jet-flying-sky.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jFrame.add(jPanel);
//        jPanel.setBackground(new Color(0,0,0,80));
        // Start the animation

        RoundedPanel panel = new RoundedPanel(200,200) ;
        panel.setBounds(jFrame.getWidth()/2 - 250, 150, 500, 550);
        panel.setLayout(null);
        panel.setBackground(new Color(255,255,255,80));
        jPanel.add(panel);

        Timer timer = new Timer(10, new ActionListener() {
            private int yPos = -550; // Initial y position
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yPos < 150) { // Change this condition based on how far you want to slide down
                    yPos += 18; // Increment y position
                    panel.setBounds(jFrame.getWidth()/2 - 250, yPos, panel.getWidth(), panel.getHeight()); // Set new panel position
                } else {
                    ((Timer) e.getSource()).stop(); // Stop the timer when the animation is complete
                }

            }
        });
        timer.start(); // Start the animation


        JLabel jLabel = new JLabel("Aircraft Maintenance Management System", SwingUtilities.CENTER);
        jLabel.setBounds(0, 20, jFrame.getWidth(), 45);
        jLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        jLabel.setForeground(Color.BLACK);
        jPanel.add(jLabel);

        JLabel heading = new JLabel("Login",SwingUtilities.CENTER);
        heading.setBounds(0, 30, panel.getWidth(), 40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 36));
        panel.add(heading);

        JLabel jLabel1 = new JLabel("Username", SwingUtilities.LEFT);
        jLabel1.setBounds(40, 120, 400, 30);
        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        jLabel1.setForeground(Color.BLACK);

        panel.add(jLabel1);

        jTextField = new RoundedTextField(15, 30, 30);
        jTextField.setBounds(40, 160, 320, 40);
        jTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(jTextField);
        jTextField.setForeground(Color.BLACK);


        JLabel jLabel2 = new JLabel("Password", SwingUtilities.LEFT);
        jLabel2.setBounds(40, 240, 300, 30);
        jLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        jLabel2.setForeground(Color.BLACK);
        panel.add(jLabel2);

        jTextField1 = new RoundedPasswordField(15, 30, 30);
        jTextField1.setBounds(40, 280, 320, 40);
        jTextField1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(jTextField1);
        jTextField1.setForeground(Color.BLACK);

        JLabel jLabel3 = new JLabel("Don't have an account?");
        jLabel3.setBounds(40, 330, 400, 30);
        jLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jLabel3.setForeground(Color.BLACK);
        panel.add(jLabel3);

        JLabel jLabel4 = new JLabel("<html><u>Sign Up</u></html>");
        jLabel4.setBounds(200, 328, 100, 30);
        jLabel4.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        jLabel4.setForeground(Color.BLACK);
        panel.add(jLabel4);



        jLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DBMSSignUpPage signUpPage = new DBMSSignUpPage();
                jFrame.dispose();
            }
        });

        RoundedButton jButton = new RoundedButton("Login",30,30);
        jButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(new Color(219, 120, 75));
        jButton.setBounds((panel.getWidth()/2)-100, 450, 200, 40);
        panel.add(jButton);



//        panel.setBackground(new Color(0,0,0,0));


        JLabel errorLB = new JLabel();
        errorLB.setBounds((panel.getWidth()/2)-100, 380, 300, 30);
        errorLB.setForeground(Color.red);
        panel.add(errorLB);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = jTextField.getText();
                String pass = jTextField1.getText();
                boolean errorDisplayed = false;

                try {
                    Connection connection = Connectionprovider.getconnection();
                    String quary1 = "select username,pass from userdata";
                    Statement st = connection.createStatement();

                    ResultSet set = st.executeQuery(quary1);


                    while (set.next()) {
                        String username = set.getString("username");
                        String password = set.getString("pass");
                        int empty = isEmpty(user,pass);

                        errorLB.setText("");


                        if (empty == 3) {

                            errorLB.setText("please enter password and username");

                        } else if (empty == 1) {
                            errorLB.setText("please enter username ");


                        } else if (empty == 2) {

                            errorLB.setText("please enter password ");

                        } else {
                            if (user.equals(username)) {
                                if (pass.equals(password)) {

                                    MainScreen mainScreen = new MainScreen();
                                    break;
                                }

                            } else  {
                                errorLB.setText(" please enter correct username and password ");

                            }
                        }


                    }
                    connection.close();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jFrame.repaint();
        jFrame.revalidate();
    }

    int isEmpty(String username, String password) {
        if(username.isEmpty() && password.isEmpty()){
            return 3;
        }
        else if (username.isEmpty()) {
            return 1;
        }
        else if (password.isEmpty()) {
            return 2;
        }
        return 0;
    }
}

class DBMSSignUpPage {
    public DBMSSignUpPage() {
        JFrame jFrame = new JFrame("jumbo-jet-flying-sky.jpg");
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("jumbo-jet-flying-sky.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jFrame.add(jPanel);

        RoundedPanel panel = new RoundedPanel(200, 200);
        panel.setBounds(jFrame.getWidth() / 2 - 250, 130, 530, 600);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255, 80));
        jPanel.add(panel);

        Timer timer = new Timer(10, new ActionListener() {
            private int yPos = -550; // Initial y position
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yPos < 150) { // Change this condition based on how far you want to slide down
                    yPos += 18; // Increment y position
                    panel.setBounds(jFrame.getWidth()/2 - 250, yPos, panel.getWidth(), panel.getHeight()); // Set new panel position
                } else {
                    ((Timer) e.getSource()).stop(); // Stop the timer when the animation is complete
                }

            }
        });
        timer.start(); // Start the animation


        JLabel jLabel = new JLabel("Aircraft Maintenance Management System", SwingUtilities.CENTER);
        jLabel.setBounds(0, 20, jFrame.getWidth(), 45);
        jLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        jLabel.setForeground(Color.BLACK);
        jPanel.add(jLabel);

        JLabel heading = new JLabel("Sign Up");
        heading.setBounds(190, 30, panel.getWidth(), 45);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 36));
        panel.add(heading);

        JLabel jLabel1 = new JLabel("Full Name:");
        jLabel1.setBounds(40, 120, 400, 40);
        jLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jLabel1.setForeground(Color.BLACK);
        panel.add(jLabel1);

        RoundedTextField textField = new RoundedTextField(15, 20, 20);
        textField.setBounds(160, 120, 320, 40);
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField.setForeground(Color.BLACK);
        panel.add(textField);

        JLabel jLabel2 = new JLabel("EMail ID:");
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setBounds(40, 190, 400, 40);
        jLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        panel.add(jLabel2);

        RoundedTextField textField1 = new RoundedTextField(15, 20, 20);
        textField1.setBounds(160, 190, 320, 40);
        textField1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField1.setForeground(Color.BLACK);
        panel.add(textField1);

        JLabel jLabel3 = new JLabel("Mobile No:");
        jLabel3.setForeground(Color.BLACK);
        jLabel3.setBounds(40, 270, 400, 40);
        jLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        panel.add(jLabel3);

        RoundedTextField textField2 = new RoundedTextField(15, 20, 20);
        textField2.setBounds(160, 270, 320, 40);
        textField2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField2.setForeground(Color.BLACK);
        panel.add(textField2);

        JLabel jLabel4 = new JLabel("Username: ");
        jLabel4.setBounds(40, 340, 400, 40);
        jLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jLabel4.setForeground(Color.BLACK);
        panel.add(jLabel4);

        RoundedTextField textField3 = new RoundedTextField(15, 20, 20);
        textField3.setBounds(160, 340, 320, 40);
        textField3.setForeground(Color.BLACK);
        textField3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        panel.add(textField3);


        JLabel jLabel5 = new JLabel("Password:");
        jLabel5.setBounds(40, 410, 400, 40);
        jLabel5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jLabel5.setForeground(Color.BLACK);
        panel.add(jLabel5);

        RoundedPasswordField textField4 = new RoundedPasswordField(15, 20, 20);
        textField4.setBounds(160, 410, 320, 40);
        textField4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        textField4.setForeground(Color.BLACK);
        panel.add(textField4);

        RoundedButton jButton = new RoundedButton("Sign up", 30, 30);
        jButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(new Color(219, 120, 75));
        jButton.setBounds((panel.getWidth() / 2) - 100, 520, 180, 40);
        panel.add(jButton);

        JLabel errorLB = new JLabel("");
        errorLB.setBounds((panel.getWidth() / 2) - 100, 450, 300, 30);
        errorLB.setForeground(Color.red);
        panel.add(errorLB);


        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullname = textField.getText();
                String emailid = textField1.getText();
                String mobile_no = textField2.getText();
                String username = textField3.getText();
                String pass = textField4.getText();
                int empty = isEmpty(fullname, username, pass);

                if (empty == 0) {
                    try {
                        Connection connection = Connectionprovider.getconnection();
                        String query1 = "insert into userdata values(?,?,?,?,?)";
                        PreparedStatement ps = connection.prepareStatement(query1);
                        ps.setString(1, fullname);
                        ps.setString(2, emailid);
                        ps.setString(3, mobile_no);
                        ps.setString(4, username);
                        ps.setString(5, pass);
                        ps.executeUpdate();
                        connection.close();
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    DBMSLoginPage dbmsLoginPage = new DBMSLoginPage();
                    jFrame.dispose();
                    jFrame.repaint();
                } else if (empty == 3) {
                    errorLB.setText("Fullname, username, and password are mandatory");
                } else if (empty == 4) {
                    errorLB.setText("Please enter fullname");
                } else if (empty == 1) {
                    errorLB.setText("Please enter username");
                } else if (empty == 2) {
                    errorLB.setText("Please enter password");
                }

            }
        });
    }

    int isEmpty(String fullname,String username,String pass) {
        if(username.isEmpty() && pass.isEmpty() && fullname.isEmpty()){
            return 3;
        }else if (fullname.isEmpty()) {
            return 4;
        }
        else if (username.isEmpty()) {
            return 1;
        }
        else if (pass.isEmpty()) {
            return 2;
        }
        return 0;
    }
}


public class DBMSProject {
    public static void main(String[] args) {
//        DBMSSignUpPage dbms = new DBMSSignUpPage();
        DBMSLoginPage dbmsLoginPage = new DBMSLoginPage();
//        MainScreen mainScreen=new MainScreen();
//        Aircraft aircraft = new Aircraft();
    }
}