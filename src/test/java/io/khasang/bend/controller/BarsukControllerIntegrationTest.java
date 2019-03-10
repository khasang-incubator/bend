package io.khasang.bend.controller;

import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.entity.BarsukWoman;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BarsukControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/barsuk";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get";
    private static final String GET_ALL = "/all";

    @Test
    public void checkBarsukAdding() {
        Barsuk barsuk = createBarsuk();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Barsuk> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Barsuk.class,
                barsuk.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Barsuk receivedBarsuk = responseEntity.getBody();
        assertNotNull(receivedBarsuk);
    }

    private Barsuk createBarsuk() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Barsuk barsuk = prefillBarsuk();
        HttpEntity<Barsuk> entity = new HttpEntity<>(barsuk, headers);
        RestTemplate template = new RestTemplate();
        Barsuk createdBarsuk = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Barsuk.class
        ).getBody();

        assertNotNull(createdBarsuk);
        assertEquals("Jack", createdBarsuk.getName());

        return createdBarsuk;
    }

    private Barsuk prefillBarsuk() {
        Barsuk barsuk = new Barsuk();
        barsuk.setDescription("strong");
        barsuk.setName("Jack");
        barsuk.setYear(LocalDate.of(2017, 11, 21));

        BarsukWoman woman1 = new BarsukWoman();
        woman1.setName("Janna");
        woman1.setDescription("modern");

        BarsukWoman woman2 = new BarsukWoman();
        woman2.setName("Betty");
        woman2.setDescription("beauty");

        List<BarsukWoman> list = new ArrayList<>();
        list.add(woman1);
        list.add(woman2);

        barsuk.setBarsukWomans(list);
        return barsuk;
    }
}
