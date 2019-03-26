package io.khasang.bend.controller;

import io.khasang.bend.dto.PointDto;
import io.khasang.bend.entity.Point;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.junit.Assert.*;

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
        ResponseEntity<PointDto> responseEntity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                PointDto.class,
                point.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PointDto recievedPoint = responseEntity.getBody();
        assertNotNull(recievedPoint);
    }

    @Test
    public void checkGetAll() {
        RestTemplate template = new RestTemplate();
        createPoint();
        createPoint();

        ResponseEntity<List<PointDto>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PointDto>>() {
                }
        );

        List<PointDto> points = result.getBody();
        assertNotNull(points);
    }

    @Test
    public void checkGetByName() {
        RestTemplate template = new RestTemplate();
        Point point = createPoint();
        createPoint();

        ResponseEntity<List<PointDto>> result = template.exchange(
                ROOT + GET_BY_NAME,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PointDto>>() {
                },
                point.getName()
        );

        List<PointDto> points = result.getBody();
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
        assertEquals("Moscow", createdPoint.getName());
        return createdPoint;
    }

    private Point prefillPoint() {
        Point point = new Point();
        point.setName("Moscow");
        point.setCoordX(55.75222);
        point.setCoordY(37.61556);
        point.setDescription("capital of Russia");
        return point;
    }
}