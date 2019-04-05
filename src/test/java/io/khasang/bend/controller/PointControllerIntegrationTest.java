package io.khasang.bend.controller;

import io.khasang.bend.entity.Point;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PointControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/point";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get/{id}";
    private static final String GET_BY_NAME = "/name/{name}";
    private static final String GET_ALL = "/all";

    @Test
    public void checkAddPoint() {
        Point point = createPoint();
        RestTemplate template = new RestTemplate();
        ResponseEntity<Point> responseEntity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                Point.class,
                point.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Point recievedPoint = responseEntity.getBody();
        assertNotNull(recievedPoint);
    }

    @Test
    public void checkGetAll() {
        RestTemplate template = new RestTemplate();
        createPoint();

        ResponseEntity<List<Point>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Point>>() {
                }
        );

        List<Point> points = result.getBody();
        assertNotNull(points);
    }

    private Point createPoint() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Point point = prefillPoint();
        HttpEntity<Point> entity = new HttpEntity<>(point, headers);
        RestTemplate template = new RestTemplate();
        Point createdPoint = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Point.class
        ).getBody();

        assertNotNull(createdPoint);
        assertEquals(55.75222, createdPoint.getCoordN(), 0.00001);
        return createdPoint;
    }

    private Point prefillPoint() {
        Point point = new Point();
        point.setCoordN(55.75222);
        point.setCoordW(37.61556);
        return point;
    }
}