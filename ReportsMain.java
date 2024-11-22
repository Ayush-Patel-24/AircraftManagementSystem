import com.jdbc.Connectionprovider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


class Reports{
    String Reg_no;
    String nameofuser;
    String date;
    int cost;
    public Reports(){
        JFrame jFrame=new JFrame();
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);
//        jframe.getContentPane().setBackground(Color.YELLOW);
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

        JLabel headingLabel = new JLabel("Report Section", SwingUtilities.CENTER);
        headingLabel.setBounds(0,20,jPanel.getWidth(),50);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,40));
        jPanel.add(headingLabel);

        JLabel jLabel = new JLabel("Enter the Maintanence ID whose report you want to generate:");
        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("Times New Roman",Font.PLAIN,26));
        jLabel.setBounds(30,120,jPanel.getWidth(),30);
        jPanel.add(jLabel);

        RoundedTextField roundedTextField = new RoundedTextField(15, 50,50);
        roundedTextField.setBounds(40,160,200,40);
        roundedTextField.setForeground(Color.WHITE);
        roundedTextField.setFont(new Font("Times New Roman", Font.PLAIN,25));
        jPanel.add(roundedTextField);

        RoundedButton roundedButton = new RoundedButton("Get Report",20,20);
        roundedButton.setBounds(40,250,300,40);
        roundedButton.setFont(new Font("Times New Roman", Font.PLAIN,24));
        roundedButton.setForeground(Color.WHITE);
        roundedButton.setBackground(Color.BLACK);
        jPanel.add(roundedButton);


        roundedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Connection connection=Connectionprovider.getconnection();
                    String query1="select * from MaintenanceA380 where MaintenanceID="+Integer.parseInt(roundedTextField.getText());
                    Statement st=connection.createStatement();
                    ResultSet set= st.executeQuery(query1);
                    while(set.next()){
                        Reg_no =set.getString(2);
                        nameofuser=set.getString(3);
                        cost=set.getInt(4);
                        date= String.valueOf(set.getDate(5));
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                JLabel jLabel1 = new JLabel("The Regestration number of the aircraft is:"+ Reg_no);
                jLabel1.setBounds(30,300,jPanel.getWidth(),30);
                jPanel.add(jLabel1);

                JLabel jLabel2 = new JLabel("The Name of the User that did the maintenance is "+ nameofuser);
                jLabel2.setBounds(30,350,jPanel.getWidth(),30);
                jPanel.add(jLabel2);

                JLabel jLabel3 = new JLabel("The total cost of maintenance is Rs."+ cost);
                jLabel3.setBounds(30,400,jPanel.getWidth(),30);
                jPanel.add(jLabel3);

                JLabel jLabel4 = new JLabel("The date of maintenance is "+ date);
                jLabel4.setBounds(30,450,jPanel.getWidth(),30);

                jPanel.add(jLabel4);

                jLabel1.setFont(new Font("Times New Roman", Font.PLAIN,26));
                jLabel4.setFont(new Font("Times New Roman", Font.PLAIN,26));
                jLabel2.setFont(new Font("Times New Roman", Font.PLAIN,26));
                jLabel3.setFont(new Font("Times New Roman", Font.PLAIN,26));

                jLabel1.setForeground(Color.WHITE);
                jLabel2.setForeground(Color.WHITE);
                jLabel3.setForeground(Color.WHITE);
                jLabel4.setForeground(Color.WHITE);

                jPanel.repaint();
            }
        });

        RoundedButton home = new RoundedButton("Home",50,50);
        home.setFont(new Font("Times New Roman",Font.PLAIN,25));
        home.setForeground(Color.WHITE);
        home.setBackground(Color.BLACK);
        home.setBounds(40,600,150,40);
        jPanel.add(home);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        MainScreen mainScreen = new MainScreen();
                    }
                });
            }
        });
    }
}
public class ReportsMain {
    public static void main(String[] args) {
        Reports reports = new Reports();
    }
}
