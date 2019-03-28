package io.khasang.bend.controller;

import io.khasang.bend.entity.Place;
import io.khasang.bend.entity.Point;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class PlaceControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/place";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get/{id}";
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

        assertNotNull(createdPlace );
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