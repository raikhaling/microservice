package com.amnil.microservicedepartmentservice.service;

import com.amnil.microservicedepartmentservice.entity.Department;



public interface DepartmentService {
    Department saveDepartment(Department department);
    Department getDepartmentById(Long departmentId);
}
