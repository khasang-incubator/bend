package io.khasang.bend.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barsuki")
public class Barsuk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "barsuk_id")
    private long id;
    private String name;
    private String description;
    @Column(columnDefinition = "DATE")
    private LocalDate year;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BarsukWoman> barsukWomans = new ArrayList<>();

    public List<BarsukWoman> getBarsukWomans() {
        return barsukWomans;
    }

    public void setBarsukWomans(List<BarsukWoman> barsukWomans) {
        this.barsukWomans = barsukWomans;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
