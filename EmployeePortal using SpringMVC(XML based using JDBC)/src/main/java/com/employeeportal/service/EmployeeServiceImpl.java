package com.employeeportal.service;

import com.employeeportal.dao.EmployeeDao;
import com.employeeportal.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int save(Employee employee) throws Exception {
        try{
            return employeeDao.saveEmployee(employee);
        } catch (Exception ex) {
            System.out.println("There are errors in saving employee details.....");
            throw ex;
        }
    }

    public int update(Employee employee) throws Exception {
        try{
            return employeeDao.updateEmployee(employee);
        } catch (Exception ex) {
            System.out.println("Failed to update employee details.....");
            throw ex;
        }
    }

    public int delete(int id) throws Exception {
        try{
            return employeeDao.deleteEmployee(id);
        } catch (Exception ex) {
            System.out.println("Failed to delete employee record.....");
            throw ex;
        }
    }

    public Employee getEmployeeById(int id) throws Exception{
        try{
            return employeeDao.getEmployeeById(id);
        } catch (Exception ex) {
            System.out.println("Failed to show employee records.....");
            throw ex;
        }
    }

    public List<Employee> getEmployees() throws Exception{
        try{
            return employeeDao.getEmployees();
        } catch (Exception ex) {
            System.out.println("Error while listing employees..");
            throw ex;
        }
    }
}
