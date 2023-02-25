package com.springApi.springApi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springApi.springApi.Entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
