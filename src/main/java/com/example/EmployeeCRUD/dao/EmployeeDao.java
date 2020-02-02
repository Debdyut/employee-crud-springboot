package com.example.EmployeeCRUD.dao;

import com.example.EmployeeCRUD.model.Employee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeDao {

    private List<Employee> employeeList;

    public EmployeeDao() {
        this.employeeList = populate();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    private List<Employee> populate() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("123456", "Rohit Sharma", "Mumbai"));
        employeeList.add(new Employee("324561", "Virat Kohli", "Delhi"));
        employeeList.add(new Employee("624513", "Ravindra Jadeja", "Chennai"));

        return employeeList;
    }
}
