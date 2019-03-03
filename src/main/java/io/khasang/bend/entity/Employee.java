package io.khasang.bend.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long id;
    private String name;
//    private LocalDate years;
    //    @Column(columnDefinition = "DATE")


    public long getId() {
        return id;
    }

    private String position;

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public LocalDate getYears() {
//        return years;
//    }
//
//    public void setYears(LocalDate years) {
//        this.years = years;
//    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
