package com.example.EmployeeCRUD;

import com.example.EmployeeCRUD.bo.EmployeeCRUDBoIfc;
import com.example.EmployeeCRUD.bo.EmployeeCRUDBoImpl;
import com.example.EmployeeCRUD.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class EmployeeCrudApplication {

	private static Logger log = LoggerFactory.getLogger(EmployeeCrudApplication.class);

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(EmployeeCrudApplication.class, args);

		EmployeeCRUDBoIfc empBo1 = applicationContext.getBean(EmployeeCRUDBoImpl.class);

		EmployeeCRUDBoIfc empBo2 = applicationContext.getBean(EmployeeCRUDBoImpl.class);

		log.info("Employee details: {}", empBo1);
		log.info("Employee details: {}", empBo2);
	}
}
