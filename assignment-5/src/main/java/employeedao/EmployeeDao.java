package main.java.employeedao;

import main.java.connection.ConnectionProvider;
import main.java.model.EmployeeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public Connection connection;

    public EmployeeDao() {
        connection = ConnectionProvider.getConnection();
    }

    public void addEmployee(EmployeeModel employee) {
        try {
            String sql = "INSERT INTO employees(id,name,contact,email_address,blood_group)" + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getContact());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getBloodGroup());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEmployee(int employeeId) {
        try {
            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editEmployee(EmployeeModel employee) {
        try {
            String sql = "UPDATE employees SET name=?, contact=?, email_address=?, blood_group=? " + " WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getContact());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getBloodGroup());
            preparedStatement.setInt(5, employee.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAllEmployees() {
        List employees = new ArrayList();
        try {
            String sql = "SELECT * FROM employees";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EmployeeModel employee = new EmployeeModel();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setContact(resultSet.getString("contact"));
                employee.setEmail(resultSet.getString("email_address"));
                employee.setBloodGroup(resultSet.getString("blood_group"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public EmployeeModel getEmployeeById(int userId) {
        EmployeeModel employee = new EmployeeModel();
        try {
            String sql = "SELECT * FROM employees WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setContact(resultSet.getString("contact"));
                employee.setEmail(resultSet.getString("email_address"));
                employee.setBloodGroup(resultSet.getString("blood_group"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
