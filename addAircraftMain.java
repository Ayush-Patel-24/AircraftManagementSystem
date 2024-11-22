import com.jdbc.Connectionprovider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class addAircraft{
    String regNo;
    public addAircraft(){
        JFrame jframe=new JFrame("AddAircraft");
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setVisible(true);

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

        JLabel headingLabel = new JLabel("You can Order an Aircraft here.....");
        headingLabel.setBounds(70,20,jPanel.getWidth(),50);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,45));
        jPanel.add(headingLabel);

        JLabel jLabel = new JLabel("Select an aircraft you want to add: ");
        jLabel.setBounds(30,100,jPanel.getWidth(),30);
        jLabel.setFont(new Font("Times New Roman", Font.PLAIN,30));
        jLabel.setForeground(Color.WHITE);
        jPanel.add(jLabel);

        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.addItem("Boing737");
        jComboBox.addItem("AirbusA350");
        jComboBox.addItem("AirbusA380");
        jComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        jComboBox.setForeground(Color.WHITE);
        jComboBox.setBackground(Color.BLACK);
        jComboBox.setBounds(60,140,250,30);
        jPanel.add(jComboBox);

        RoundedButton jButton = new RoundedButton("Next",50,50);
        jButton.setBounds(100,300,120,40);
        jButton.setFont(new Font("Times New Roman",Font.PLAIN,24));
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(Color.BLACK);
        jPanel.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel jLabel1 = new JLabel("Adding a new "+jComboBox.getSelectedItem()+" aircraft to the fleet....");
                jLabel1.setBounds(30,350,jPanel.getWidth(),35);
                jLabel1.setForeground(Color.WHITE);
                jLabel1.setFont(new Font("Times New Roman", Font.BOLD,28));
                jPanel.add(jLabel1);

                JLabel jLabel2 = new JLabel("Now please provide the details of the new "+ jComboBox.getSelectedItem());
                jLabel2.setFont(new Font("Times New Roman", Font.PLAIN,25));
                jLabel2.setForeground(Color.WHITE);
                jLabel2.setBounds(40,400,jPanel.getWidth(),30);
                jPanel.add(jLabel2);

                JLabel jLabel3 = new JLabel("Enter the regestration number :");
                jLabel3.setBounds(40,440,350,30);
                jLabel3.setForeground(Color.WHITE);
                jLabel3.setFont(new Font("Times New Roman", Font.PLAIN,25));
                jPanel.add(jLabel3);

                RoundedTextField roundedTextField = new RoundedTextField(15,30,30);
                roundedTextField.setBounds(400,440,300,30);
                roundedTextField.setForeground(Color.WHITE);
                roundedTextField.setFont(new Font("Times New Roman", Font.PLAIN,25));
                roundedTextField.setOpaque(false);
                jPanel.add(roundedTextField);
                regNo = roundedTextField.getText();

                JLabel jLabel4 = new JLabel("Enter name of aircraft :");
                jLabel4.setBounds(40,480,350,30);
                jLabel4.setForeground(Color.WHITE);
                jLabel4.setFont(new Font("Times New Roman", Font.PLAIN,25));
                jPanel.add(jLabel4);

                RoundedTextField roundedTextField1 = new RoundedTextField(15,30,30);
                roundedTextField1.setBounds(400,480,300,30);
                roundedTextField1.setForeground(Color.WHITE);
                roundedTextField1.setFont(new Font("Times New Roman", Font.PLAIN,25));
                roundedTextField1.setOpaque(false);
                jPanel.add(roundedTextField1);

                JLabel jLabel5 = new JLabel("Enter seating capacity:");
                jLabel5.setBounds(40,520,350,30);
                jLabel5.setForeground(Color.WHITE);
                jLabel5.setFont(new Font("Times New Roman", Font.PLAIN,25));
                jPanel.add(jLabel5);

                RoundedTextField roundedTextField2 = new RoundedTextField(15,30,30);
                roundedTextField2.setBounds(400,520,300,30);
                roundedTextField2.setForeground(Color.WHITE);
                roundedTextField2.setFont(new Font("Times New Roman", Font.PLAIN,25));
                roundedTextField2.setOpaque(false);
                jPanel.add(roundedTextField2);

                RoundedButton jButton1 = new RoundedButton("Add Aircraft",50,50);
                jButton1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
                jButton1.setForeground(Color.WHITE);
                jButton1.setBackground(Color.BLACK);
                jButton1.setBounds(400,600,200,40);
                jPanel.add(jButton1);



                jButton1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String Reg_no= roundedTextField.getText();
                        String name=roundedTextField1.getText();
                        int capacity= Integer.parseInt(roundedTextField2.getText());
                        try{
                            Connection connection= Connectionprovider.getconnection();
                            String query1 = "INSERT INTO " +jComboBox.getSelectedItem()+" (regNumber, aircraftName, aircraftCapacity,aircraftStatus)VALUES ('" + Reg_no + "', '" + name + "', " + capacity + ", 'Maintenance required');";
                            Statement statement= connection.createStatement();
                            statement.executeUpdate(query1);
                            connection.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }

                        Aircraft aircraft = new Aircraft();
                    }
                });
                jPanel.repaint();
            }
        });

//        JScrollPane jScrollPane = new JScrollPane(jPanel);
//        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        jScrollPane.setBounds(0, 0, jframe.getWidth(), jframe.getHeight());
//        jframe.add(jScrollPane);
        jPanel.repaint();
    }
}
public class addAircraftMain {
    public static void main(String[] args) {
        addAircraft addAircraft = new addAircraft();
    }
}
