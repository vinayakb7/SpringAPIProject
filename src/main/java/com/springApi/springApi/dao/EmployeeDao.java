package com.springApi.springApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springApi.springApi.Entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
