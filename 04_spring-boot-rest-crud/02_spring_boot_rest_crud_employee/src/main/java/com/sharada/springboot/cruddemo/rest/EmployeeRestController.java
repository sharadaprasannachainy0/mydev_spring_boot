package com.sharada.springboot.cruddemo.rest;

import com.sharada.springboot.cruddemo.entity.Employee;
import com.sharada.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

/*
    private EmployeeDAO employeeDAO;

    // quick and dirty: inject employee DAO
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    // expose gateway "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployeeslist() {
        return employeeDAO.findAll();
    }
*/

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // expose gateway "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployeeslist() {
        return employeeService.findAll();
    }


    // Read single Employee
    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null)  {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // Add a new Employee
    // add mapping for POST /employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // As this is for POST operation, we do this is to force save of new item ... instead of update, incase an id sent over POST request.

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null
        if(tempEmployee == null) {
            throw new RuntimeException("Employee id not found -" + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}
