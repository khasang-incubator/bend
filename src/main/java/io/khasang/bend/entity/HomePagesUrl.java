package io.khasang.bend.entity;

import javax.persistence.*;

@Entity
@Table(name = "urls")
public class HomePagesUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "location")
    String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return location;
    }

    public void setUrl(String url) {
        this.location = location;
    }
}