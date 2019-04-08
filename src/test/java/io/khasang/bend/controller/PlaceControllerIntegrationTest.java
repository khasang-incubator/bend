package io.khasang.bend.controller;

import io.khasang.bend.dto.PlaceDto;
import io.khasang.bend.entity.Place;
import io.khasang.bend.entity.Point;
import io.khasang.bend.entity.School;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlaceControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/place2";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get/{id}";
    private static final String GET_BY_NAME = "/name/{name}";
    private static final String GET_ALL = "/all";

    @Test
    public void checkAddPlace() {
        Place place = createPlace();
        RestTemplate template = new RestTemplate();
        ResponseEntity<PlaceDto> entity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                PlaceDto.class,
                place.getId()
        );

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        PlaceDto receivedPlace = entity.getBody();
        assertNotNull(receivedPlace);
    }



    @Test
    public void checkGetByName() {
        RestTemplate template = new RestTemplate();
        Place place = createPlace();

        ResponseEntity<List<PlaceDto>> result = template.exchange(
                ROOT + GET_BY_NAME,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PlaceDto>>() {
                },
                place.getName()
        );

        List<PlaceDto> places = result.getBody();
        assertNotNull(places);
    }

    @Test
    public void checkGetAllPlaces() {
        RestTemplate template = new RestTemplate();
        createPlace();

        ResponseEntity<List<PlaceDto>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PlaceDto>>() {
                }
        );

        List<PlaceDto> places = result.getBody();
        assertNotNull(places);
    }

    private Place createPlace() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Place place = prefillPlace();

        HttpEntity<Place> entity = new HttpEntity<>(place, headers);
        RestTemplate template = new RestTemplate();
        Place createdPlace = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Place.class
        ).getBody();

        assertNotNull(createdPlace);
        assertEquals("Malibu", createdPlace.getName());

        return createdPlace;
    }

    private Place prefillPlace() {
        Place place = new Place();
        place.setName("Malibu");
        place.setDescription("California");

        School school1 = new School();
        school1.setName("SchoolName1");
        school1.setDescription("Description1");

        School school2 = new School();
        school2.setName("SchoolName2");
        school2.setDescription("Description2");

        List<School> schools = new ArrayList<>();
        schools.add(school1);
        schools.add(school2);

        Point point = new Point();
        point.setCoordN(34.00501);
        point.setCoordW(118.81009);

        place.setPoint(point);
        place.setSchoolList(schools);
        return place;
    }
}