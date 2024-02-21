package com.sharada.cruddemo.dao;

import com.sharada.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    int updateAll();

    void delete(Integer id);

    int deleteAll();

}
