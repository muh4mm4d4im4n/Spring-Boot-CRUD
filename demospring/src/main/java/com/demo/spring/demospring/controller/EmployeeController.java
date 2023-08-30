package com.demo.spring.demospring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.spring.demospring.model.Employee;
import com.demo.spring.demospring.repository.EmployeeRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeerepo;
    
    //http://localhost:port/emp/add
    @PostMapping("/add")
    Employee addEmployee(@RequestBody Employee employee){
        
        employeerepo.save(employee);
        return employee;
    }

    @GetMapping("/getAll")
    List<Employee> getEmployee() {
        
        List<Employee> employee = employeerepo.findAll();
        return employee;
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        Employee updateEmployee = employeerepo.findById((long) id).get();
        updateEmployee.setName(employee.getName());
        updateEmployee.setAge(employee.getAge());
        updateEmployee.setRole(employee.getRole());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setPhone(employee.getPhone());
        employeerepo.save(updateEmployee);
        return ("Updated...");
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id){
        Employee deleteEmployee = employeerepo.findById((long) id).get();
        employeerepo.delete(deleteEmployee);
        return "Delete user with the id " +id;
    }
}
