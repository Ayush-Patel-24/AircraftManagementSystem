import java.sql.*;

public class InsertJDBC{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/aircraftManagement";
            String username = "root";
            String password = "12345";
            Connection connection = DriverManager.getConnection(url,username,password);

            String query = "insert into table1(tName , tCity) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Ayush");
            preparedStatement.setString(2,"Mumbai");

            preparedStatement.executeUpdate();
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(query);
            System.out.println("inserted....");
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}