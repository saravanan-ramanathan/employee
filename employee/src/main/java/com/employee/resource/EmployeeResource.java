package com.employee.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeResource {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}

	@PostMapping(path= "/update", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void updateEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}
	
	@PostMapping(path= "/delete", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable("id") Long id) {
		employeeRepository.deleteById(id);
	}
	
	@GetMapping(path="/employees")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@PostMapping(path="/updateLocation", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void updateDeptLocation(@RequestParam String department, String location) {
		List<Employee> employees = employeeRepository.findAll();
		
	}
}
