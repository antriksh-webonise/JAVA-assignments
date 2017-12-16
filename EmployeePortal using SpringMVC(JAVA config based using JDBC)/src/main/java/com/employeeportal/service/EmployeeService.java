package com.employeeportal.service;

import com.employeeportal.model.Employee;

import java.util.List;

public interface EmployeeService {

    /*
        Method declaration for saving employee details
    */
    public int save(Employee employee) throws Exception;


    /*
        Method declaration for showing employee details
    */
    public List<Employee> getEmployees() throws Exception;


    /*
        Method declaration for getting employee details by id
    */
    public Employee getEmployeeById(int id) throws Exception;


    /*
        Method declaration for updating employee details
    */
    public int update(Employee employee) throws Exception;


    /*
        Method declaration for deleting employee details
    */
    public int delete(int id) throws Exception;
}
