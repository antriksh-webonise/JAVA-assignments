package main.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

        public static Connection connection = null;

        public static Connection getConnection() {
            if (connection != null)
                return connection;
            else {
                try {

                   // String driver = "com.mysql.jdbc.Driver";
                    Class.forName("com.mysql.jdbc.Driver");
                    //String url = "jdbc:mysql://localhost:3306/Organization";
                    //String user = "root";
                    //String password = "Spacex@123";
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Organization", "root", "Spacex@123");
                } catch (SQLException sqe) {
                    System.out.println(sqe);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return connection;
            }
        }
    }

