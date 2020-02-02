package com.example.EmployeeCRUD.bo;

import com.example.EmployeeCRUD.dao.EmployeeDao;
import com.example.EmployeeCRUD.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.function.Predicate;

@Component
public class EmployeeCRUDBoImpl implements EmployeeCRUDBoIfc {

    private static Logger log = LoggerFactory.getLogger(EmployeeCRUDBoImpl.class);

    @Autowired
    private EmployeeDao empDao;

    @Override
    public boolean create(Employee e) {
        try {
            Employee emp = new Employee(e.getEmployeeId(), e.getName(), e.getCity());
            this.empDao.getEmployeeList().add(emp);
            log.info("Employee with id {} inserted succesfully", e.getEmployeeId());
            return true;
        } catch (Exception ex) {
            log.error("Error creating new employee: {}", ex);
            return false;
        }
    }

    @Override
    public Employee read(String employeeId) {
        try {
            Predicate<Employee> hasEmployee = new Predicate<Employee>() {
                @Override
                public boolean test(Employee e) {
                    return e.getEmployeeId().equalsIgnoreCase(employeeId);
                }
            };
            Employee e = this.empDao.getEmployeeList().stream().filter(hasEmployee::test)
                    .findFirst().orElse(null);
            if(!ObjectUtils.isEmpty(e)) {
                log.info("Employee with id {} found succesfully", employeeId);
            } else {
                log.info("Employee with id {} not found", employeeId);
            }
            return e;
        } catch (Exception ex) {
            log.error("Error retrieving employee with id {} : {}", employeeId, ex);
            return null;
        }
    }

    @Override
    public boolean update(Employee emp) {
        try {
            Predicate<Employee> hasEmployee = new Predicate<Employee>() {
                @Override
                public boolean test(Employee e) {
                    return e.getEmployeeId().equalsIgnoreCase(emp.getEmployeeId());
                }
            };
            Employee e = this.empDao.getEmployeeList().stream().filter(hasEmployee::test)
                    .findFirst().orElse(null);
            if(!ObjectUtils.isEmpty(e)) {
                log.info("Employee with id {} found succesfully", emp.getEmployeeId());
                e.setCity(emp.getCity());
                e.setName(emp.getName());
                log.info("Employee with id {} updated succesfully", emp.getEmployeeId());
                return true;
            } else {
                log.info("Employee with id {} not found", emp.getEmployeeId());
                return false;
            }
        } catch (Exception ex) {
            log.error("Error retrieving employee with id {} : {}", emp.getEmployeeId(), ex);
            return false;
        }
    }

    @Override
    public boolean delete(String employeeId) {
        try {
            Predicate<Employee> hasEmployee = new Predicate<Employee>() {
                @Override
                public boolean test(Employee e) {
                    return e.getEmployeeId().equalsIgnoreCase(employeeId);
                }
            };
            Employee e = this.empDao.getEmployeeList().stream().filter(hasEmployee::test)
                    .findFirst().orElse(null);
            if(!ObjectUtils.isEmpty(e)) {
                log.info("Employee with id {} found succesfully", employeeId);
                this.empDao.getEmployeeList().remove(e);
                log.info("Employee with id {} deleted succesfully", employeeId);
                return true;
            } else {
                log.info("Employee with id {} not found", employeeId);
                return false;
            }
        } catch (Exception ex) {
            log.error("Error retrieving employee with id {} : {}", employeeId, ex);
            return false;
        }
    }

}
