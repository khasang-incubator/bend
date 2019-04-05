package io.khasang.bend.dto;

import io.khasang.bend.entity.Place;
import io.khasang.bend.entity.School;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceDto {
    private long id;
    private String name;
    private String description;
    private List<SchoolDto> schoolList = new ArrayList<>();

    public PlaceDto getPlaceDtoFromPlace(Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        placeDto.setDescription(place.getDescription());

        List<SchoolDto> schoolDtos = new ArrayList<>();
        for (School school : place.getSchoolList()) {
            SchoolDto schoolDto = new SchoolDto();
            schoolDto.setId(school.getId());
            schoolDto.setName(school.getName());
            schoolDto.setDescription(school.getDescription());
            schoolDto.setBannerSrc(school.getBannerSrc());
            schoolDto.setLogoSrc(school.getLogoSrc());
            schoolDto.setOriginDate(school.getOriginDate());
            schoolDto.setPriceList(school.getPriceList());
            schoolDto.setTimeTable(school.getTimeTable());
            schoolDtos.add(schoolDto);
        }
        placeDto.setSchoolList(schoolDtos);
        return placeDto;
    }

    public List<PlaceDto> getPlaceDtoListFromPlaces(List<Place> places) {
        List<PlaceDto> pointDtos = new ArrayList<>();
        for (Place place : places) {
            pointDtos.add(getPlaceDtoFromPlace(place));
        }
        return pointDtos;
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

    public List<SchoolDto> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<SchoolDto> schoolList) {
        this.schoolList = schoolList;
    }
}
