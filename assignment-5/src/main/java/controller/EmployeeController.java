package main.java.controller;

import main.java.employeedao.EmployeeDao;
import main.java.model.EmployeeModel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

public class EmployeeController extends HttpServlet {
    private static String INSERT = "/insert.jsp";
    private static String Edit = "/edit.jsp";
    //private static String UserRecord = "/listUser.jsp";
    private EmployeeDao dao;

    public EmployeeController() {
        super();
        dao = new EmployeeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect="";
        String uId = request.getParameter("id");
        String action = request.getParameter("action");

        if(!((uId)== null) && action.equalsIgnoreCase("insert")) {
            int id = Integer.parseInt(uId);
            EmployeeModel employee = new EmployeeModel();
            employee.setId(id);
            employee.setName(request.getParameter("name"));
            employee.setContact(request.getParameter("contact"));
            employee.setEmail(request.getParameter("email_address"));
            employee.setEmail(request.getParameter("blood_group"));
            dao.addEmployee(employee);
            redirect = "list.jsp";
            request.setAttribute("employees", dao.getAllEmployees());
            System.out.println("Record Added Successfully");
        } else if ( action.equalsIgnoreCase("delete") ){
            String userId = request.getParameter("id");
            int uid = Integer.parseInt(userId);
            int confirmation = javax.swing.JOptionPane.showConfirmDialog(null, "ARE YOU SURE?");
            if(confirmation == JOptionPane.YES_OPTION) {
                dao.removeEmployee(uid);
            } else {
                redirect = "list.jsp";
            }
            redirect = "list.jsp";
            request.setAttribute("employees", dao.getAllEmployees());
            System.out.println("Record Deleted Successfully");
        } else if ( action.equalsIgnoreCase("editform") ) {
            redirect = "edit.jsp";
        } else if ( action.equalsIgnoreCase("edit") ){
            String userId = request.getParameter("id");
            int uid = Integer.parseInt(userId);
            EmployeeModel employee = new EmployeeModel();
            employee.setId(uid);
            employee.setName(request.getParameter("name"));
            employee.setContact(request.getParameter("contact"));
            employee.setEmail(request.getParameter("email_address"));
            employee.setBloodGroup(request.getParameter("blood_group"));
            dao.editEmployee(employee);
            request.setAttribute("employee", employee);
            redirect = "list.jsp";
            System.out.println("Record updated Successfully");
        } else if (action.equalsIgnoreCase("listUser")) {
            redirect = "list.jsp";
            request.setAttribute("employees", dao.getAllEmployees());
        } else {
            redirect = "insert.jsp";
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

