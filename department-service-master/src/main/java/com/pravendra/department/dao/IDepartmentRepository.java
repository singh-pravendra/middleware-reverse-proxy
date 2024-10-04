package com.pravendra.department.dao;

import com.pravendra.department.bean.Department;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface IDepartmentRepository extends ReactiveMongoRepository<Department, String> {
}
