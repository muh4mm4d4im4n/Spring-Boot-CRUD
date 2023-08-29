package com.demo.spring.demospring.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.spring.demospring.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

    Optional<Employee> findById(String id);
    
}
