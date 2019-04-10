package io.khasang.bend.dto;

import io.khasang.bend.entity.Place;
import io.khasang.bend.entity.School;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PlaceDto {
    private long id;
    private String name;
    private String description;
    private Set<SchoolDto> schoolSet = new HashSet<>();

    public PlaceDto getPlaceDtoFromPlace(Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        placeDto.setDescription(place.getDescription());
        return placeDto;
    }

    public Set<PlaceDto> getPlaceDtoSetFromPlaces(Set<Place> places) {
        Set<PlaceDto> pointDtos = new HashSet<>();
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

    public Set<SchoolDto> getSchoolSet() {
        return schoolSet;
    }

    public void setSchoolSet(Set<SchoolDto> schoolSet) {
        this.schoolSet = schoolSet;
    }
}
