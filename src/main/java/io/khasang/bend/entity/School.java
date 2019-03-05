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
    private Date originDate;//TODO????
    @Column(name = "album_id")
    private int albumId;
    @Column(name = "leader_id")
    private int leaderId;//user leader of school maybe NULL
    @Column(columnDefinition = "TEXT", name = "price_list")
    private String priceList;//TODO???? может здесь лучше использовать StringBuilder?- попробовал, но что-то не то он мне в базу записал
    @Column(columnDefinition = "TEXT", name = "time_table")
    private String timeTable;//TODO???? может здесь лучше использовать StringBuilder? - попробовал, но что-то не то он мне в базу записал

    //Что тут делать? Какой-то другой подход должен быть? Критерии?
    //Что тут делать? Какой-то другой подход должен быть? Критерии?
    @Column(name = "disciplines_list")
    private String disciplinesList;//TODO пока сделал так но чувствую что лучше это поместить в отдельную таблицу, а новая таблица - это уже получается - другая сущность?
    @Column(name = "trainers_list")
    private String trainersList;//TODO пока сделал так но чувствую что лучше это поместить в отдельную таблицу, а новая таблица - это уже получается - другая сущность?
    @Column(name = "students_list")
    private String studentsList;//TODO пока сделал так но чувствую что лучше это поместить в отдельную таблицу, а новая таблица - это уже получается - другая сущность?
//    private int[] trainersList;//(массивы и листы тоже не подошли так как не BasicType)
//    private int[] studentsList;//(массивы и листы тоже не подошли так как не BasicType)

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

//    public Date getOriginDate() {
//        return originDate;
//    }
//
//    public void setOriginDate(Date originDate) {
//        this.originDate = originDate;
//    }

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
/*
{
"name":"gdfgdfg",
"description":"gdfgdfg",
"logoSrc":"gdfgdfg",
"bannerSrc":"gdfgdfg",
"originDate":"11111111",
"albumId":"1",
"leaderId":"1",
"priceList":"gdfgdfg",
"timeTable":"gdfgdfg",
"disciplinesList":"asdasdas"
"trainersList":"gdfgdfg",
"studentsList":"gdfgdfg"
}

CREATE TABLE public.schools
(
  id integer,
  name character varying(255),
  description text,
  logo_src character varying(255),
  banner_src character varying(255),
  album_id integer,
  leader_id integer,
  price_list text,
  time_table text,
  trainers_list text,
  students_list text
)
 */