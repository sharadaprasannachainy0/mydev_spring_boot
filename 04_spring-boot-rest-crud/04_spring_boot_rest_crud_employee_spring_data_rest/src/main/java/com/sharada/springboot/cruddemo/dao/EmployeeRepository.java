package com.sharada.springboot.cruddemo.dao;

import com.sharada.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code for DAO implementation class
}
