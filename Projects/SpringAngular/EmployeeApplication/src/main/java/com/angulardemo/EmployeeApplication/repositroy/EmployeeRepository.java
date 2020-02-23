package com.angulardemo.EmployeeApplication.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angulardemo.EmployeeApplication.Model.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByDepartment(String department);  
	List<Employee> findByFirstNameOrLastName(String firstName, String lastname);
}