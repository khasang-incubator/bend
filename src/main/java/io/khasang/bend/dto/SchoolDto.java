package io.khasang.bend.dto;

import io.khasang.bend.entity.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SchoolDto {
    private long id;
    private String name;
    private String description;
    private String logoSrc;
    private String bannerSrc;//большое изображение для заглавной страницы школы(по ширине экрана)
    private Date originDate;
    private String priceList;
    private String timeTable;

    private Set<DisciplineDto> disciplinesSet = new HashSet<>();

    private Set<PlaceDto> placesSet = new HashSet<>();

    public SchoolDto getSchoolDtoFromSchool(School school) {
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(school.getId());
        schoolDto.setName(school.getName());
        schoolDto.setBannerSrc(school.getBannerSrc());
        schoolDto.setLogoSrc(school.getLogoSrc());
        schoolDto.setTimeTable(school.getTimeTable());
        schoolDto.setOriginDate(school.getOriginDate());
        schoolDto.setPriceList(school.getPriceList());
        schoolDto.setDescription(school.getDescription());

        Set<PlaceDto> placeDtos = new HashSet<>();
        for (Place place : school.getPlacesSet()) {
            PlaceDto placeDto = new PlaceDto();
            placeDto.setId(place.getId());
            placeDto.setName(place.getName());
            placeDto.setDescription(place.getDescription());
            placeDtos.add(placeDto);
        }
        schoolDto.setPlacesSet(placeDtos);
        return schoolDto;
    }

    public Set<SchoolDto> getSchoolDtoSetFromSchools(Set<School> schools) {
        Set<SchoolDto> schoolDtos = new HashSet<>();
        for (School school : schools) {
            schoolDtos.add(getSchoolDtoFromSchool(school));
        }
        return schoolDtos;
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

    public Date getOriginDate() {
        return originDate;
    }

    public void setOriginDate(Date originDate) {
        this.originDate = originDate;
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

    public Set<DisciplineDto> getDisciplinesSet() {
        return disciplinesSet;
    }

    public void setDisciplinesSet(Set<DisciplineDto> disciplinesSet) {
        this.disciplinesSet = disciplinesSet;
    }

    public Set<PlaceDto> getPlacesSet() {
        return placesSet;
    }

    public void setPlacesSet(Set<PlaceDto> placesSet) {
        this.placesSet = placesSet;
    }
}
