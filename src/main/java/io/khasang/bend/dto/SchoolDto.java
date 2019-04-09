package io.khasang.bend.dto;

import io.khasang.bend.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private List<DisciplineDto> disciplinesList = new ArrayList<>();

    private List<TrainerDto> trainersList = new ArrayList<>();

    private List<StudentDto> studentsList = new ArrayList<>();

    private List<PlaceDto> placesList = new ArrayList<>();

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

        List<PlaceDto> placeDtos = new ArrayList<>();
        for (Place place : school.getPlacesList()) {
            PlaceDto placeDto = new PlaceDto();
            placeDto.setId(place.getId());
            placeDto.setName(place.getName());
            placeDto.setDescription(place.getDescription());
            placeDtos.add(placeDto);
        }
        schoolDto.setPlacesList(placeDtos);
        return schoolDto;
    }

    public List<SchoolDto> getSchoolDtoListFromSchools(List<School> schools) {
        List<SchoolDto> schoolDtos = new ArrayList<>();
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

    public List<DisciplineDto> getDisciplinesList() {
        return disciplinesList;
    }

    public void setDisciplinesList(List<DisciplineDto> disciplinesList) {
        this.disciplinesList = disciplinesList;
    }

    public List<TrainerDto> getTrainersList() {
        return trainersList;
    }

    public void setTrainersList(List<TrainerDto> trainersList) {
        this.trainersList = trainersList;
    }

    public List<StudentDto> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<StudentDto> studentsList) {
        this.studentsList = studentsList;
    }

    public List<PlaceDto> getPlacesList() {
        return placesList;
    }

    public void setPlacesList(List<PlaceDto> placesList) {
        this.placesList = placesList;
    }
}
