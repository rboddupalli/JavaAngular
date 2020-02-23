package com.angulardemo.EmployeeApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angulardemo.EmployeeApplication.Model.*;
import com.angulardemo.EmployeeApplication.repositroy.*;
import com.angulardemo.EmployeeApplication.exception.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			 throws ResourceNotFoundException {
		/*
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
		*/
		Employee employee = null;
		try{
			employee = employeeRepository.findById(employeeId).get();
		}catch(Exception e){
			throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		}
		
		
		return ResponseEntity.ok().body(employee); 
	}
	
	@GetMapping("/employees/department")
	public ResponseEntity<List<Employee>> getEmployeeByDept(@RequestHeader(value = "dept") String department)
			 throws ResourceNotFoundException {
		List<Employee> employees = null;
		try{
			employees = employeeRepository.findByDepartment(department);
		}catch(Exception e){
			throw new ResourceNotFoundException("Employee not found for this id :: " + department);
		}
		return ResponseEntity.ok(employees); 
	}
	
	
	@GetMapping("/employees/ByName")
	public ResponseEntity<List<Employee>> getEmployeeByFrstNM_OR_LastNM(@RequestHeader(value = "frst_nm") String first_nm,
			@RequestHeader(value = "last_nm") String last_nm)
			 throws ResourceNotFoundException {
		List<Employee> employees = null;
		try{
			employees = employeeRepository.findByFirstNameOrLastName(first_nm,last_nm);
		}catch(Exception e){
			throw new ResourceNotFoundException("Employee not found for this FirstName :: " + first_nm + "OR LastName ::" + last_nm );
		}
		return ResponseEntity.ok(employees); 
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = null;
		try{
			employee = employeeRepository.findById(employeeId).get();
		}catch(Exception e){
			throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		}

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setDepartment(employeeDetails.getDepartment());
		employee.setDoj(employeeDetails.getDoj());
		employee.setGender(employeeDetails.getGender());
		
		
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = null;
		try{
			employee = employeeRepository.findById(employeeId).get();
		}catch(Exception e){
			throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
		}

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
