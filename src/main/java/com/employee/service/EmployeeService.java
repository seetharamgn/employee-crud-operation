package com.employee.service;

import com.employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getEmployee(Integer id);

    Employee update(Employee employee);

    String delete(Integer id);

    List<Employee> findByIds(List<Integer> ids);

    String deleteByIds(List<Integer> ids);
}
