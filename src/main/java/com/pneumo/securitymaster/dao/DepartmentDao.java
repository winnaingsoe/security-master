package com.pneumo.securitymaster.dao;

import com.pneumo.securitymaster.ds.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDao extends CrudRepository<Department, Integer> {
}
