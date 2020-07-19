package com.employee.controller;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.EmployeeService;


@Controller
//@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	
	@GetMapping("/test")
	public String msg() {
		return "Hello";
	}
	
	@GetMapping("/all")
	public List<EmployeeDTO> getAllEmployees(){
		return empService.geAllEmployees();
		
	}
	
	@PostMapping("/add")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity emp) {
		return empService.addEmployee(emp);
	}
	
	@GetMapping("/getById/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable ("id") int id) {
		return empService.getEmployeeById(id);
	}
	
	
	@DeleteMapping("/deleteByID")
	public EmployeeDTO deleteEmployeeById(@PathVariable ("id") int id) {
		return empService.deleteEmployeeById(id);
	}
	
}
