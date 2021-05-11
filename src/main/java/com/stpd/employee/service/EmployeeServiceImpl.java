package com.stpd.employee.service;

import com.stpd.employee.exception.UserNotFoundException;
import com.stpd.employee.model.Employee;
import com.stpd.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Optional<Employee> employeeById = employeeRepository.findEmployeeById(id);
        return employeeById.orElseGet(() -> employeeById.orElseThrow(() -> new UserNotFoundException("404: User id with [" + id + "] is not found")));
    }
}
