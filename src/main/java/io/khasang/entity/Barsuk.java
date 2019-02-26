package io.khasang.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "barsuki")
public class Barsuk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(columnDefinition = "Date")
    private LocalDate year;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
