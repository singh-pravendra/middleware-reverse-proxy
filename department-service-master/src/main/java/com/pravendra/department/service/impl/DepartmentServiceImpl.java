package com.pravendra.department.service.impl;

import com.pravendra.department.bean.Department;
import com.pravendra.department.dao.IDepartmentRepository;
import com.pravendra.department.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository iDepartmentRepository;

    @Override
    public Mono<Department> createDepartment(Department department) {
        return iDepartmentRepository.save(department);
    }

    @Override
    public Mono<Department> getDepartmentById(String id) {
        return iDepartmentRepository.findById(id);
    }

    @Override
    public Flux<Department> getAllDepartment() {
        return iDepartmentRepository.findAll();
    }
}
