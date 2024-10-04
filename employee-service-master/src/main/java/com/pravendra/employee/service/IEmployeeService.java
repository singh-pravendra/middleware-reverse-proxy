package com.pravendra.employee.service;

import com.pravendra.employee.bean.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IEmployeeService {
    Mono<Employee> createEmployee(Employee employee);

    Mono<Employee> getEmployeeById(String id);

    Flux<Employee> getAllEmployees();

    Mono<?> getEmployeeWithDepartmentByEmpId(String id);
}
