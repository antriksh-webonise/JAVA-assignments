package com.employeeportal.dao;

import com.employeeportal.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {
    @Autowired
    JdbcTemplate template;

    public int saveEmployee(Employee employee) {
        String sql="INSERT INTO employees (name,contact,email_address,blood_group)" +
                "VALUES ('"+employee.getName()+"','"+employee.getContact()+"'," +
                "'"+employee.getEmail()+"','"+employee.getBloodGroup()+"')";
        return template.update(sql);
    }

    public List<Employee> getEmployees() {
        return template.query("select * from employees",new RowMapper<Employee>(){
            public Employee mapRow(ResultSet resultSet, int row) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setContact(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setBloodGroup(resultSet.getString(5));
                return employee;
            }
        });
    }

    public Employee getEmployeeById(int id) {
        String sql="SELECT * FROM employees where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public int updateEmployee(Employee employee) {
        String sql="UPDATE employees SET name='"+employee.getName()+"', contact='"+employee.getContact()+"', email_address='"+employee.getEmail()+"',blood_group='"+employee.getBloodGroup()+"' where id="+employee.getId()+"";
        return template.update(sql);
    }

    public int deleteEmployee(int id) {
        String sql="delete from employees where id="+id+"";
        return template.update(sql);
    }

}
