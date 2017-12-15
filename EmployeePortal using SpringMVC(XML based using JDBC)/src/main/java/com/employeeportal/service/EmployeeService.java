package com.employeeportal.service;

import com.employeeportal.model.Employee;

import java.util.List;

public interface EmployeeService {

    public int save(Employee employee) throws Exception;

    public List<Employee> getEmployees() throws Exception;

    public Employee getEmployeeById(int id) throws Exception;

    public int update(Employee employee) throws Exception;

    public int delete(int id) throws Exception;
}
