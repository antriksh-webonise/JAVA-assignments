package crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Operations {
    public ResultSet selectResultSet;
    public Statement selectStatement;
    public PreparedStatement preparedStatement;
    public Connection connection;

    public Operations() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_application", "root", "Spacex@123");
    }

    public void insertMessages(String userType, String message) throws SQLException {
        String insertQuery;
        if ( userType.equals("server") ) {
            insertQuery = "INSERT INTO server (message) VALUES (?)";
        } else {
            insertQuery = "INSERT INTO clients (message) VALUES (?)";
        }
        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1,message);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void displayTable(String userType) throws SQLException {
        String displayQuery;
        if ( userType.equals("clients") ) {
            displayQuery = "SELECT * FROM clients";
        } else {
            displayQuery = "SELECT * FROM server";
        }
        selectStatement = connection.createStatement();
        selectResultSet = selectStatement.executeQuery(displayQuery);
        while (selectResultSet.next()) {
            int messageId = selectResultSet.getInt(1);
            String displayMessage = selectResultSet.getString(2);
            System.out.println("MESSAGE ID: " + messageId + " MESSAGE: " + displayMessage);
        }
    }

    public void deleteMessages(String userType) throws SQLException {
        String deleteQuery;
        displayTable(userType);
        System.out.println("Enter the ID of the messages you want to delete");
        Scanner reader = new Scanner(System.in);
        int id = reader.nextInt();
        if ( userType.equals("clients") ) {
            deleteQuery = "DELETE FROM clients WHERE id =?";
        } else {
            deleteQuery = "DELETE FROM server WHERE id = ?";
        }
        preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        System.out.println("Message successfully deleted");
        preparedStatement.close();
    }

    public void editMessage(String userType) throws SQLException, IOException {
        String editQuery;
        String message = null;

        displayTable(userType);
        System.out.println("Enter the ID of the messages you want to edit");
        Scanner reader = new Scanner(System.in);
        int id = reader.nextInt();
        System.out.println("Enter the new message");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        message = input.readLine();
        if ( userType.equals("clients") ) {
            editQuery = "UPDATE clients SET message = ? where id = ?";
        } else {
            editQuery = "UPDATE server SET message = ? where id = ?";
        }
        preparedStatement = connection.prepareStatement(editQuery);
        preparedStatement.setString(1,message);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();
        System.out.println("Message successfully edited");
        preparedStatement.close();
    }
}
