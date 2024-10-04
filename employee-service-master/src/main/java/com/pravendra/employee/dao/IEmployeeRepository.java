package com.pravendra.employee.dao;

import com.pravendra.employee.bean.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface IEmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
