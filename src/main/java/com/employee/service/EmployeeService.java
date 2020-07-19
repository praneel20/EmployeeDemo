package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;
import com.employee.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;

	public List geAllEmployees() {
		
		List<EmployeeEntity> empList= employeeRepo.findAll();
		
		List<EmployeeDTO> empDtoList = new ArrayList<EmployeeDTO>();
		
		for(EmployeeEntity emp:empList)
		{
			EmployeeDTO empdto=new EmployeeDTO();
			empdto.setEmpId(emp.getEmpId());
			empdto.setEmpFirstName(emp.getEmpFirstName());
			empdto.setEmpLastName(emp.getEmpLastName());
			empdto.setEmpDesignation(emp.getEmpDesignation());
			empdto.setEmpLocation(emp.getEmpLocation());
			empDtoList.add(empdto);
			
		}
	
		return empDtoList;
	}

	public EmployeeEntity addEmployee(EmployeeEntity emp) {
		return employeeRepo.save(emp);
	}

	public EmployeeDTO deleteEmployeeById(int id) {
		Optional<EmployeeEntity> emp=employeeRepo.findById(id);
		if(emp.isPresent()) {
			employeeRepo.deleteById(id);
		}
		else {
			System.out.println("Employee not found");
		}
		
		return null;
		
	}

	public EmployeeDTO getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> emp=employeeRepo.findById(id);
		
		EmployeeDTO empdto=new EmployeeDTO();
		
		if(emp.isPresent())
		{
			empdto.setEmpId(emp.get().getEmpId());
			empdto.setEmpFirstName(emp.get().getEmpFirstName());
			empdto.setEmpLastName(emp.get().getEmpLastName());
			empdto.setEmpDesignation(emp.get().getEmpDesignation());
			empdto.setEmpLocation(emp.get().getEmpLocation());
		}else
		{
			System.out.println("Emp id not found"+id);
		}
		
		return empdto;
	}
	
	

}
