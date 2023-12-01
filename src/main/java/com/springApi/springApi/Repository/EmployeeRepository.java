package com.springApi.springApi.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springApi.springApi.Entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
