package com.sharada.springboot.cruddemo.service;

import com.sharada.springboot.cruddemo.dao.EmployeeRepository;
import com.sharada.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // setup EmployeeRepository field and inject it through constructor injection
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    // N.B: "Optional" is a Different pattern instead of having to check for nulls.
    // we can make use of Optionals to see if the value is present.
    // this feature introduced in java 8. JPA Repository makes use of Optional.
    // A basic approach here for getting data without having to explicitly check for null.

    // Remove annotation @Transactional, since JpaRepository provides this functionality

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
