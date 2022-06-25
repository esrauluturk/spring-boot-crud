package com.projem.demo.service;


import com.projem.demo.entity.Employee;
import com.projem.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Service katmani,
Controller ve Repository arasindaki iletisimi saglar.
Controller a gelen requestler e gore -->
Repository deki database islemlerini yapmak icin gerekli olan methodlar burada tanimlanir.

*/


// Database islemlerinin gerceklesmesi icin --> Service katmanindan Repository e erismemiz gerekir.
// Service ve Repository arasindaki etkilesim "Spring Boot" da "Dependency Injection" ile saglanir.
// Spring Boot da bu etkilesim @Autowired anatosyonu kullanarak saglanir.
// @Autowired ile Service  katmaninda EmployeeRepository nin instance ini olusturmus ve
// bu instance uzerinden repository e erismis oluruz.
@Service // Service Katmani
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository; // repository instance

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    public Employee updateEmployee(Employee employee){
        return  employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

}
