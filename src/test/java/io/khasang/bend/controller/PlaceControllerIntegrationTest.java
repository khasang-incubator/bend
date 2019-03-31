package io.khasang.bend.controller;

import io.khasang.bend.entity.Place;
import io.khasang.bend.entity.Point;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlaceControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/place";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get/{id}";
    private static final String GET_BY_NAME = "/name/{name}";
    private static final String GET_ALL = "/all";

    @Test
    public void checkAddPlace() {
        Place place = createPlace();
        RestTemplate template = new RestTemplate();
        ResponseEntity<Place> entity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                Place.class,
                place.getId()
        );

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        Place receivedPlace = entity.getBody();
        assertNotNull(receivedPlace);
    }

    @Test
    public void checkGetByName() {
        RestTemplate template = new RestTemplate();
        Place place = createPlace();

        ResponseEntity<List<Place>> result = template.exchange(
                ROOT + GET_BY_NAME,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Place>>() {
                },
                place.getName()
        );

        List<Place> places = result.getBody();
        assertNotNull(places);
    }

    @Test
    public void checkGetAllPlaces() {
        RestTemplate template = new RestTemplate();
        createPlace();

        ResponseEntity<List<Place>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Place>>() {
                }
        );

        List<Place> employees = result.getBody();
        assertNotNull(employees);
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
        assertEquals("Moscow", createdPlace.getName());

        return createdPlace;
    }

    private Place prefillPlace() {
        Place place = new Place();
        place.setName("Moscow");
        place.setDescription("Red square");

        Point point = new Point();
        point.setCoordX(55.75222);
        point.setCoordY(37.61556);
        point.setName("Moscow");
        point.setDescription("The capital of Russia");

        place.setPoint(point);
        return place;
    }
}