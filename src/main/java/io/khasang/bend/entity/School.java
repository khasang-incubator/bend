package io.khasang.bend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "logo_src")
    private String logoSrc;
    @Column(name = "banner_src")
    private String bannerSrc;//большое изображение для заглавной страницы школы(по ширине экрана)
    @Column(columnDefinition = "DATE", name = "origin_date")
    //TODO 04.03.2019
    private Date originDate;
    @Column(name = "album_id")
    private int albumId;
    @Column(name = "leader_id")
    private int leaderId;//user leader of school maybe NULL
    @Column(columnDefinition = "TEXT", name = "price_list")
    private String priceList;
    @Column(columnDefinition = "TEXT", name = "time_table")
    private String timeTable;

    //TODO cross-table query instead of list imitation(arrays and lists are not BasicTypes) 04.03.2019
    @Column(name = "disciplines_list")
    private String disciplinesList;
    @Column(name = "trainers_list")
    private String trainersList;
    @Column(name = "students_list")
    private String studentsList;

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

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
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

    public String getTrainersList() {
        return trainersList;
    }

    public void setTrainersList(String trainersList) {
        this.trainersList = trainersList;
    }

    public String getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(String studentsList) {
        this.studentsList = studentsList;
    }

    public String getDisciplinesList() {
        return disciplinesList;
    }

    public void setDisciplinesList(String disciplinesList) {
        this.disciplinesList = disciplinesList;
    }
}