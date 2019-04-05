package io.khasang.bend.entity;

import javax.persistence.*;

@Entity
@Table(name = "points")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "coordn")
    private double coordN;
    @Column(name = "coordw")
    private double coordW;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCoordN() {
        return coordN;
    }

    public void setCoordN(double coordN) {
        this.coordN = coordN;
    }

    public double getCoordW() {
        return coordW;
    }

    public void setCoordW(double coordW) {
        this.coordW = coordW;
    }
}
