package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.EmployeeDAO;
import com.example.demo.model.Employees;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value="Employee Details Resource")
@RestController
@RequestMapping("/rest")
public class EmployeeController {

	@Autowired
	EmployeeDAO dao;
	
	//@ApiOperation(value="Returns all the employees available")
	@GetMapping("/employees")
	public List<Employees> getEmployees()
	{
		return dao.findAll();
	}
	//@ApiOperation(value="Returns the employee based on the given employee id")
	@GetMapping("/employee/{eid}")
	public Optional<Employees> getEmployee(@PathVariable("eid") int EId)
	{
		return dao.findById(EId);
	}
	//accepts data only in json format
	//@ApiOperation(value="To add the Employee data to the database")
	@PostMapping(path="/employee",consumes={"application/json"})
	public Employees addEmployee(@RequestBody Employees employee)
	{
		dao.save(employee);
		return employee;
	}
	//@ApiOperation(value="Deletes the given employee for the database")
	@DeleteMapping("/employee/{eid}")
	public String deleteEmployee(@PathVariable("eid") int EId)
	{
		Employees emp=dao.getOne(EId);
		dao.delete(emp);
		return "Employee details deleted successfully";
	}
	//@ApiOperation(value="To edit the employee details")
	@PutMapping("/employee/{eid}")
	public Employees updateOrSaveEmployee(@PathVariable("eid") int eid, @RequestBody Employees employee)
	{
		Employees empOld=dao.getOne(eid);
		if(employee.getEname()!=null)
				empOld.setEname(employee.getEname());
		Double exp=employee.getExperience();
		if(exp!=null)
			empOld.setExperience(employee.getExperience());
		if(employee.getGrade()!=null)
			empOld.setGrade(employee.getGrade());
		if(employee.getTechnology()!=null)
			empOld.setTechnology(employee.getTechnology());
			
		dao.save(empOld);
		return empOld;
	}
	//To find employees whose experience is greater than the given input
	//@ApiOperation(value="Returns the list of employees whose experience is greater than the given employee from the database")
	@GetMapping("/employee/experience/{exp}")
	public List<Employees> getExperiencedEmployees(@PathVariable("exp") double exp)
	{
		return dao.findByexperienceGreaterThan(exp);
	}
	//@ApiOperation(value="Returns the list of employees based on the input technology ordered by their grade")
	@GetMapping("/employee/technology/{tech}")
	public List<Employees> getEmployeesByTech(@PathVariable("tech") String tech)
	{
		return dao.findBytechnology(tech);
	}
	
	
}
