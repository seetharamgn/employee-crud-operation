package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping(value = {"/employee/{id}","/employee"})
    public List<Employee> getEmployee(@PathVariable(required = false) Integer id){
        return employeeService.getEmployee(id);
    }
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable Integer id){
        return employeeService.delete(id);
    }
    @GetMapping("/employees")
    public List<Employee> list(@RequestParam("ids")List<Integer> ids){
        return employeeService.findByIds(ids);
    }
    @DeleteMapping("/employee")
    public String bulkdelete(@RequestParam("ids")List<Integer> ids){
        return employeeService.deleteByIds(ids);
    }
}
