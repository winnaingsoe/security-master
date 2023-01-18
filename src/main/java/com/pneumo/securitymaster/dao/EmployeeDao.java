package com.pneumo.securitymaster.dao;

import com.pneumo.securitymaster.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
