package com.projem.demo.repository;

import com.projem.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Tum veritabani islemlerimizi gerceklestirdigimiz katmandir.
// JpaRepository den extend ediyoruz.
// JpaRepositoryde tanimli database islemlerini dogrudan kullanabiliyoruz.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
