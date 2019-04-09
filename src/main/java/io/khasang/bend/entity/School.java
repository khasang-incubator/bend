package io.khasang.bend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "logo_src")
    private String logoSrc;
    @Column(name = "banner_src")
    private String bannerSrc;
    @Column(columnDefinition = "DATE", name = "origin_date")
    private Date originDate;
    @Column(columnDefinition = "TEXT", name = "price_list")
    private String priceList;
    @Column(columnDefinition = "TEXT", name = "time_table")
    private String timeTable;

//    MultipleBagFetchException: cannot simultaneously fetch multiple bags: невозможно получить несколько пакетов
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Discipline> disciplinesList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Trainer> trainersList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> studentsList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Place> placesList = new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoSrc() {
        return logoSrc;
    }

    public void setLogoSrc(String logoSrc) {
        this.logoSrc = logoSrc;
    }

    public String getBannerSrc() {
        return bannerSrc;
    }

    public void setBannerSrc(String bannerSrc) {
        this.bannerSrc = bannerSrc;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public String getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(String timeTable) {
        this.timeTable = timeTable;
    }

    public Date getOriginDate() {
        return originDate;
    }

    public void setOriginDate(Date originDate) {
        this.originDate = originDate;
    }

    public List<Discipline> getDisciplinesList() {
        return disciplinesList;
    }

    public void setDisciplinesList(List<Discipline> disciplinesList) {
        this.disciplinesList = disciplinesList;
    }

    public List<Trainer> getTrainersList() {
        return trainersList;
    }

    public void setTrainersList(List<Trainer> trainersList) {
        this.trainersList = trainersList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Place> getPlacesList() {
        return placesList;
    }

    public void setPlacesList(List<Place> placesList) {
        this.placesList = placesList;
    }
}