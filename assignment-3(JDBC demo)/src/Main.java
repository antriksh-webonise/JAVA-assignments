import java.sql.*;

public class Main {

    public static ResultSet selectResultSet;
    public static Statement selectStatement;

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Spacex@123");
            connection.setAutoCommit(false);
            selectStatement = connection.createStatement();
            //Select all query
            String selectString = "SELECT * FROM users";
            displayTable(selectString);

            //Insertion query
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES(?,?,?)");
            preparedStatement.setInt(1,6);
            preparedStatement.setString(2,"Akanchha");
            preparedStatement.setString(3,"4545345");
            int i = preparedStatement.executeUpdate();
            System.out.println("----" + i + " records inserted----");
            displayTable(selectString);
            preparedStatement.close();

            //update query
            preparedStatement = connection.prepareStatement("UPDATE users SET name=? WHERE ID=?");
            preparedStatement.setString(1,"Kamal");
            preparedStatement.setInt(2,3);
            int x = preparedStatement.executeUpdate();
            System.out.println("----" + x + " records updated----");
            displayTable(selectString);
            preparedStatement.close();

            //delete query
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            preparedStatement.setInt(1,5);
            int z = preparedStatement.executeUpdate();
            System.out.println("----" + z + " records deleted----");
            displayTable(selectString);

            connection.commit();
            selectStatement.close();
            selectResultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    private static void displayTable(String query) throws SQLException {
        selectResultSet = selectStatement.executeQuery(query);
        while (selectResultSet.next()) {
            int userId = selectResultSet.getInt(1);
            String name = selectResultSet.getString(2);
            String mobileNumber = selectResultSet.getString(3);
            System.out.println("User ID is " + userId);
            System.out.println("User name is " + name);
            System.out.println("Mobile number is " + mobileNumber);
        }
    }
}
