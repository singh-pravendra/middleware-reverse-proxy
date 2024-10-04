package com.pravendra.employee.controller;

import com.pravendra.employee.bean.Employee;
import com.pravendra.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public Mono<Employee> createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public Flux<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Mono<?> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/fetch/employee")
    public Mono<?> getEmployeeId(@RequestParam String id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/{id}/with-departments")
    public Mono<?> getEmployeeWithDepartmentByEmpId(@PathVariable String id) {
        return employeeService.getEmployeeWithDepartmentByEmpId(id);
    }
}
