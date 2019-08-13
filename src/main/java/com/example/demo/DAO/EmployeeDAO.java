package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employees;
@Repository
//@RepositoryRestResource(collectionResourceRel = "REST",path = "REST")
public interface EmployeeDAO extends JpaRepository<Employees, Integer> {

	// Custom search operations based on different fields of an Employee
	List<Employees> findByename(String EName);

	/* List<Employee> findByGrade(String Grade); */
	// to find the list of employees whose experience is greater than the given
	// experience
	List<Employees> findByexperienceGreaterThan(double Experience);
	//to find the employees based on technology and order them by grade
	@Query("from Employees where Technology=?1 order by Grade")
	List<Employees> findBytechnology(String Technology);

	
}
