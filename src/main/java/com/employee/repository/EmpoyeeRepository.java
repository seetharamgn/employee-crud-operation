package com.employee.repository;

import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmpoyeeRepository extends JpaRepository<Employee,Integer> {
    @Modifying
    @Query("select e from Employee e where e.id in :ids")
    List<Employee> findByIds(List<Integer> ids);
}
