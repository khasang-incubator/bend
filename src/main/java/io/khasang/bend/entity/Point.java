package io.khasang.bend.entity;

import javax.persistence.*;

@Entity
@Table(name = "points")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "coordn")
    private Double coordN;
    @Column(name = "coordw")
    private Double coordW;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getCoordN() {
        return coordN;
    }

    public void setCoordN(Double coordN) {
        this.coordN = coordN;
    }

    public Double getCoordW() {
        return coordW;
    }

    public void setCoordW(Double coordW) {
        this.coordW = coordW;
    }
}
