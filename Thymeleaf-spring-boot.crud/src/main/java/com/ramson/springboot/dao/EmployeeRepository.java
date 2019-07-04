package com.ramson.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramson.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
