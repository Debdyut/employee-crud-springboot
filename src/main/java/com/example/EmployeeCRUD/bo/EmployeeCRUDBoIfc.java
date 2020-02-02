package com.example.EmployeeCRUD.bo;

import com.example.EmployeeCRUD.dao.EmployeeDao;
import com.example.EmployeeCRUD.model.Employee;

public interface EmployeeCRUDBoIfc {

    boolean create(Employee e);

    Employee read(String employeeId);

    boolean update(Employee e);

    boolean delete(String employeeId);

}
