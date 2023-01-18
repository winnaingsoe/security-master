package com.pneumo.securitymaster.dao;

import com.pneumo.securitymaster.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
