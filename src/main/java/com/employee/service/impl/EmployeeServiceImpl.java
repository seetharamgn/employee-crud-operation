package com.employee.service.impl;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.exception.InvalidPayloadException;
import com.employee.repository.EmpoyeeRepository;
import com.employee.service.EmployeeService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;



@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmpoyeeRepository empoyeeRepository;

    @Override
    public Employee addEmployee(Employee employee){
    if(employee.getName()!=null && employee.getAge()!=0 && employee.getProfession()!=null) {
            return empoyeeRepository.save(employee);
        }
        throw new InvalidPayloadException();
    }

    @Override
    public List<Employee> getEmployee(Integer id) {
        if(ObjectUtils.isEmpty(id)){
            return empoyeeRepository.findAll();
        }
        if(this.empoyeeRepository.existsById(id)){
            return Collections.singletonList(empoyeeRepository.findById(id).orElse(null));
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public Employee update(Employee employee) {
            System.out.println(employee);
        try {
            if(ObjectUtils.isNotEmpty(employee)) {
                Employee savedEmployee = this.findByid(employee.getId());
                savedEmployee.setAge(employee.getAge());
                savedEmployee.setName(employee.getName());
                savedEmployee.setProfession(employee.getProfession());
                savedEmployee = empoyeeRepository.save(savedEmployee);

                return savedEmployee;
            }
            throw new InvalidPayloadException();
        }
        catch (Exception exception) {
            throw exception;
        }
    }

    private Employee findByid(Integer id) {
        if(ObjectUtils.isNotEmpty(id)&&this.empoyeeRepository.existsById(id)){
            return this.empoyeeRepository.findById(id).orElse(null);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String delete(Integer id) {
        if(ObjectUtils.isNotEmpty(id)&&this.empoyeeRepository.existsById(id)){
            empoyeeRepository.deleteById(id);
            return "employee deleted id is "+id;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> findByIds(List<Integer> ids) {
        if(ObjectUtils.isEmpty(ids)){
            throw new InvalidPayloadException();
        }
       return empoyeeRepository.findByIds(ids);
    }

    @Override
    public String deleteByIds(List<Integer> ids) {
        if(ObjectUtils.isEmpty(ids)){
            throw new InvalidPayloadException();
        }
       ids.forEach(id->{
           if(this.empoyeeRepository.existsById(id)){
               this.empoyeeRepository.deleteById(id);
           }
           else {
               throw new EmployeeNotFoundException();
           }
       });
        return "deleted data is "+ids;
    }

}
