package com.example.springboot.employeecrud.controller;

import com.example.springboot.employeecrud.model.Department;
import com.example.springboot.employeecrud.model.Employee;
import com.example.springboot.employeecrud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping("/departments")
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value="id") Long id) {
        Department department= departmentRepository.findOne(id);
        if(department == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(department);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value="id") Long id, @Valid @RequestBody Department departmentDetails) {
        Department department= departmentRepository.findOne(id);
        if(department == null) {
            return ResponseEntity.notFound().build();
        }
        department.setName(departmentDetails.getName());
        Department updatedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable(value="id") Long id) {
        Department department= departmentRepository.findOne(id);
        if(department == null) {
            return ResponseEntity.notFound().build();
        }
        departmentRepository.delete(department);
        return ResponseEntity.ok().build();
    }
}
