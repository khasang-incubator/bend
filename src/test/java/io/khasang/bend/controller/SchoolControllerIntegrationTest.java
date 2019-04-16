package io.khasang.bend.controller;

import io.khasang.bend.dto.SchoolDto;
import io.khasang.bend.entity.Place;
import io.khasang.bend.entity.Point;
import io.khasang.bend.entity.School;
import io.khasang.bend.entity.Url;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SchoolControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/school2";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get/{id}";
    private static final String GET_BY_NAME = "/name/{name}";
    private static final String GET_ALL = "/all";

    @Test
    public void checkAddSchool() {
        School school = createSchool();
        RestTemplate template = new RestTemplate();
        ResponseEntity<SchoolDto> entity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                SchoolDto.class,
                school.getId()
        );

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        SchoolDto receivedPlace = entity.getBody();
        assertNotNull(receivedPlace);
    }

    @Test
    public void checkGetByName() {
        RestTemplate template = new RestTemplate();
        School school = createSchool();

        ResponseEntity<Set<SchoolDto>> result = template.exchange(
                ROOT + GET_BY_NAME,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<SchoolDto>>() {
                },
                school.getName()
        );

        Set<SchoolDto> schools = result.getBody();
        assertNotNull(schools);
    }

    @Test
    public void checkGetAllSchools() {
        RestTemplate template = new RestTemplate();
        createSchool();

        ResponseEntity<Set<SchoolDto>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<SchoolDto>>() {
                }
        );

        Set<SchoolDto> schools = result.getBody();
        assertNotNull(schools);
    }

    private School createSchool() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        School school = prefillSchool();

        HttpEntity<School> entity = new HttpEntity<>(school, headers);
        RestTemplate template = new RestTemplate();
        School createdSchool = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                School.class
        ).getBody();

        assertNotNull(createdSchool);
        assertEquals("SchoolName", createdSchool.getName());

        return createdSchool;
    }

    private Url createUrl(){
        Url url = new Url();
        url.setUrl(String.valueOf(url.hashCode()));
        return url;
    }

    private School prefillSchool() {
        School school = new School();
        //school.setId(1);
        school.setName("SchoolName");
        school.setDescription("SchoolDescription");
        school.setLogoSrc("logosrc");
        school.setBannerSrc("bannersrc");
        school.setOriginDate(new Date());
        school.setPriceList("priceList");
        school.setTimeTable("timeTable");

        Point point = new Point();
        point.setCoordN(22.222);
        point.setCoordW(33.333);

        Place place1 = new Place();
        place1.setName("Place1Name");
        place1.setDescription("Place1Description");
        place1.setPoint(point);

        Place place2 = new Place();
        place2.setName("Place2Name");
        place2.setDescription("Place2Description");
        place2.setPoint(point);

        Set<Place> set = new HashSet<>();
        set.add(place1);
        set.add(place2);

        school.setPlacesSet(set);

        school.setUrl(createUrl());

        return school;
    }
}