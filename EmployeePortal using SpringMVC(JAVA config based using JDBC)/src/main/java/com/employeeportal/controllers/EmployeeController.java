package com.employeeportal.controllers;

import com.employeeportal.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.employeeportal.service.EmployeeServiceImpl;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = "/form")
    public ModelAndView showForm() throws Exception {
        return new ModelAndView("/form","command",new Employee());
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("employee") Employee employee) throws Exception {
        employeeService.save(employee);
        return new ModelAndView("redirect:/view");
    }

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public ModelAndView view() throws Exception {
        List<Employee> list = employeeService.getEmployees();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}")
    public ModelAndView edit(@PathVariable int id) throws Exception {
        Employee employee = employeeService.getEmployeeById(id);
        return new ModelAndView("/edit","command",employee);
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("employee") Employee employee) throws Exception {
        employeeService.update(employee);
        return new ModelAndView("redirect:/view");
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) throws Exception {
        employeeService.delete(id);
        return new ModelAndView("redirect:/view");
    }
}
