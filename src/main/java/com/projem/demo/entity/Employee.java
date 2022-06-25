package com.projem.demo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.*;

// Entity Class
@Entity // Entity Class oldugunu belirtmek icin kullanilir.
@Table
@Getter
@Setter
public class Employee {

    @Id // Veritabaninda primary key olarak id kullanilacagindan bu anotasyon eklenir.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;
}
