package com.sharada.springboot.cruddemo.dao;

import com.sharada.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get the Employee
            // passing the entity class & primary key as method parameters in entitymanager.find(...)
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return the Employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save Employee
            // entitymanager.merge(...) method to do insert or update depending on the actual Id of the entity
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the dbEmployee - updated employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        // find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(theEmployee);
    }
}
