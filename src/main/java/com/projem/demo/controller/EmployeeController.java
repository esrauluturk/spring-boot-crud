package com.projem.demo.controller;

import com.projem.demo.entity.Employee;
import com.projem.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
* Controller en dis katman
* Requestler ilk olarak Controller a gelir.
*
* */
@RestController // Controller sinifi oldugunu belirtmek icin eklenir.
@RequestMapping("/employee") // Controller a gelen requestleri ilgili REST Methodlari ile eslestirir.
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // HTTP Methodlari

    /*
    * POST : Post istegi ile requestte body icerisinde gonderilen veriler sunucuya iletilir
    * ve yeni bir kaynak olusturulur.
    * POST metodu ile yeni bir calisan kaydi olusturmak
    * */
    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

    /*
    * GET : Sunucudan veri almak icin kullandigimiz yontemdir.
    * Get istegi yapilirken request icerisinde body kullanilmaz.
    * Tum çalışan bilgilerini almak
    * */

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
    }

    // Belirli bir id ye sahip calisan bilgisini almak
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id")Long employeeId){ // !!!!
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    /*
    * PUT : Sunucudaki belirli bir kaynagi guncellemek icin kullanilir.
    * Belirli bir id ye sahip calisan bilgisini update etmek
    * */

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    /*
    * DELETE : Sunucudaki veriyi silmek için kullanilir.
    * Belirli bir id ye gore calisan bilgisini sunucudan silmek
    * */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable(name = "id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED); // !!!!
    }

    /*
    * ResponseEntity sınıfı HttpEntity sınıfına ek olarak
    * builder tasarım desenini kullanarak isteğe yanıt olarak header bilgisi,
    * HTTP durum kodu gibi bilgileri eklemeyi sağlar.
     * */

}