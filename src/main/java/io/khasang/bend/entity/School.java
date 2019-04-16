package io.khasang.bend.entity;

import javax.persistence.*;
import java.util.*;

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
    private String bannerSrc;
    @Column(columnDefinition = "DATE", name = "origin_date")
    private Date originDate;
    @Column(columnDefinition = "TEXT", name = "price_list")
    private String priceList;
    @Column(columnDefinition = "TEXT", name = "time_table")
    private String timeTable;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private HomePagesUrl url;

//    MultipleBagFetchException: cannot simultaneously fetch multiple bags: невозможно получить несколько пакетов
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Discipline> disciplinesSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Place> placesSet = new HashSet<>();

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

    public Set<Discipline> getDisciplinesSet() {
        return disciplinesSet;
    }

    public void setDisciplinesSet(Set<Discipline> disciplinesList) {
        this.disciplinesSet = disciplinesSet;
    }

    public Set<Place> getPlacesSet() {
        return placesSet;
    }

    public void setPlacesSet(Set<Place> placesSet) {
        this.placesSet = placesSet;
    }

    public HomePagesUrl getUrl() {
        return url;
    }

    public void setUrl(HomePagesUrl url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        if (id != school.id) return false;
        if (name != null ? !name.equals(school.name) : school.name != null) return false;
        if (description != null ? !description.equals(school.description) : school.description != null) return false;
        return logoSrc != null ? logoSrc.equals(school.logoSrc) : school.logoSrc == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (logoSrc != null ? logoSrc.hashCode() : 0);
        return result;
    }
}