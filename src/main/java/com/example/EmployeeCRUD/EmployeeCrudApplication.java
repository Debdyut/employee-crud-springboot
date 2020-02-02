package com.example.EmployeeCRUD;

import com.example.EmployeeCRUD.bo.EmployeeCRUDBoIfc;
import com.example.EmployeeCRUD.bo.EmployeeCRUDBoImpl;
import com.example.EmployeeCRUD.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeCrudApplication {

	private static Logger log = LoggerFactory.getLogger(EmployeeCrudApplication.class);

	public static void main(String[] args) {

		EmployeeCRUDBoIfc empBo = new EmployeeCRUDBoImpl();

		// Create a new Employee
		Employee e = new Employee("978465","MS Dhoni", "Ranchi");
		empBo.create(e);

		// Update employee details
		e.setCity("Kolkata");
		empBo.update(e);

		// Display employee details
		Employee emp = empBo.read("324561");
		log.info("Employee details: {}", emp);

		// Delete employee details
		empBo.delete("624513");

		SpringApplication.run(EmployeeCrudApplication.class, args);
	}
}
